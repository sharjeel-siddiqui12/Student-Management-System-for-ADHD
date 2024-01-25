/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parent;

import Doctor.*;
import common.code.Auth;
import common.code.MyDbConnector;
import common.code.UserProfile;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Kavindu_Dilhara
 */
public class ViewStudentMedicalReportsParent extends javax.swing.JFrame {
    
    String sname ;
    int pid;
    private MyDbConnector dbConnector;
    Connection connection = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    UserProfile loggedUser = Auth.getLoggedUser();
    String name = loggedUser.getUsername();
   
    
    public ViewStudentMedicalReportsParent(int p_id) {
        dbConnector = new MyDbConnector();
        initComponents();
      this.pid = p_id;
        showMedRecord(p_id);
        showAcadRecord(p_id);
        parname1.setText(name);
       
  
    }

    public void showMedRecord(int pid) {
        try {
            dbConnector = new MyDbConnector();
            try {
                String sql;
                connection = dbConnector.getMyConnection();
                
                 sql = "SELECT s.s_id as studid, s.name as `Student Name`, s.gender as Gender, " +
    "s.adhd_type as `ADHD Type`, s.s_level as `Severity Level`, m.hyperactive as `Hyperactive Count`, " +
    "m.impulsive as `Impulsive Count`, m.inattention as `Inattention Count`, " +
    "sp.medicine as `Prescription Medicine`, sp.prescription_date as `Prescription Date` " +
    "FROM medical_report m " +
    "JOIN student s ON m.s_id = s.s_id " +
    "JOIN parent p ON p.p_id = s.p_id " +
    "LEFT JOIN student_prescription sp ON sp.s_id = s.s_id " +
    "WHERE p.p_id = ?";

               
                        
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1,pid);
                ResultSet rs = pstmt.executeQuery();
                
                 List<String> columnNames = new ArrayList<>(Arrays.asList("SID","Student Name", "Gender", 
                "ADHD Type", "Level", "Hyperactive", "Impulsive", "Inattention", 
                "Severity", "Prescription Medicine", "Prescription Date"));
                // Create a DefaultTableModel with dynamic column names
                DefaultTableModel cmodel = new DefaultTableModel(columnNames.toArray(), 0);


                String severity = ""; int totaladhdscore = 0;
                while (rs.next()) {
                    int  sid = rs.getInt("studid");
                    sname = rs.getString("Student Name");
                    String gender = rs.getString("Gender");
                    String adhdtype = rs.getString("ADHD Type");
                    int  slevel = rs.getInt("Severity Level");
                    int  hypercount = rs.getInt("Hyperactive Count");
                    int  impulcount = rs.getInt("Impulsive Count");
                    int  inattcount = rs.getInt("Inattention Count");
                    String medicine = rs.getString("Prescription Medicine");
                    Date predate = rs.getDate("Prescription Date");
                    totaladhdscore = hypercount + impulcount + inattcount;
                     String medicineValue = (medicine != null) ? medicine : "Not Done Yet";
                    String dateValue = (predate != null) ? predate.toString() : "Not Done Yet";

                   

        if (totaladhdscore > 30) {
            severity = "High Severity";
        } else if (totaladhdscore > 20) {
            severity = "Moderate Severity";
        } else {
            severity = "Low Severity";
        }

                    cmodel.addRow(new Object[]{sid,sname,gender, adhdtype, slevel,hypercount,impulcount,inattcount,severity,medicineValue,dateValue});
                }

                tbl_med.setModel(cmodel);
                                // Center align all values in the table
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                for (int i = 0; i < tbl_med.getColumnCount(); i++) {
                    tbl_med.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                   

                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("dbConnector not assigned: " + e.getMessage());
        } 
    }
    
     public void showAcadRecord(int pid) {
        try {
            dbConnector = new MyDbConnector();
            try {
                String sql;
                connection = dbConnector.getMyConnection();
                
                  sql = "SELECT DISTINCT s.s_id as studid, c.c_name as coursename, s.name as StudentName, "
                   + "s.s_level as studlevel, l.id as lectid,  s.adhd_type as type, qm.marks as quizmarks, l.status as l_status "
                   + "FROM student s "
                   + "JOIN stdcourse sc ON sc.s_id = s.s_id "
                   + "JOIN courses c ON c.c_id = sc.c_id "
                   + "JOIN lecture l ON l.s_id = s.s_id "
                   + "JOIN parent p ON s.p_id = p.p_id "
                   + "LEFT JOIN quiz_marks qm ON qm.s_id = s.s_id "
                   + "WHERE p.p_id = ?";

               
                        
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1,pid);
                ResultSet rs = pstmt.executeQuery();
                
                 List<String> columnNames = new ArrayList<>(Arrays.asList("SID","Student Name",  
                  "ADHD Type", "Level", "Course Name", 
                "Quiz Marks", "Lecture ID", "Lecture Status"));
                // Create a DefaultTableModel with dynamic column names
                DefaultTableModel cmodel = new DefaultTableModel(columnNames.toArray(), 0);


                String severity = ""; int totaladhdscore = 0;
                while (rs.next()) {
                    int  sid = rs.getInt("studid");
                    sname = rs.getString("StudentName");
                    String adhdtype = rs.getString("type");
                    int  slevel = rs.getInt("studlevel");
                    int  lid = rs.getInt("lectid");
                    String status = rs.getString("l_status");
                    int marks = rs.getInt("quizmarks");
                    String cname = rs.getString("coursename");
                   
                     String quizMarks = (String.valueOf(marks) != null) ? String.valueOf(marks) : "Not Done Yet";
                   

                   


                    cmodel.addRow(new Object[]{sid,sname, adhdtype, slevel ,cname, quizMarks,lid,status});
                }

                tbl_med1.setModel(cmodel);
                                // Center align all values in the table
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                for (int i = 0; i < tbl_med1.getColumnCount(); i++) {
                    tbl_med1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                   

                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("dbConnector not assigned: " + e.getMessage());
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_view = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_med = new javax.swing.JTable();
        btn_view2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_med1 = new javax.swing.JTable();
        btn_view3 = new javax.swing.JButton();
        btn_view1 = new javax.swing.JButton();
        btn_view4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_med2 = new javax.swing.JTable();
        btn_view5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        parname1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_view.setBackground(new java.awt.Color(0, 102, 51));
        btn_view.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_view.setForeground(new java.awt.Color(255, 255, 255));
        btn_view.setText("DOWNLOAD REPORT IN EXCEL FORMAT");
        btn_view.setBorder(null);
        btn_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewActionPerformed(evt);
            }
        });
        jPanel3.add(btn_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 630, 50));

        tbl_med.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medical ID", "Student ID", "Student Name", "Gender", "Age", "Parent Name", "Parent Relation", "Student Level", "Disabilities", "Type of ADHD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_med);
        if (tbl_med.getColumnModel().getColumnCount() > 0) {
            tbl_med.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbl_med.getColumnModel().getColumn(0).setMaxWidth(80);
            tbl_med.getColumnModel().getColumn(0).setHeaderValue("Medical ID");
            tbl_med.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbl_med.getColumnModel().getColumn(1).setMaxWidth(80);
            tbl_med.getColumnModel().getColumn(2).setPreferredWidth(180);
            tbl_med.getColumnModel().getColumn(2).setMaxWidth(180);
            tbl_med.getColumnModel().getColumn(3).setHeaderValue("Gender");
            tbl_med.getColumnModel().getColumn(4).setHeaderValue("Age");
            tbl_med.getColumnModel().getColumn(5).setPreferredWidth(180);
            tbl_med.getColumnModel().getColumn(5).setMaxWidth(180);
            tbl_med.getColumnModel().getColumn(5).setHeaderValue("Parent Name");
            tbl_med.getColumnModel().getColumn(6).setPreferredWidth(160);
            tbl_med.getColumnModel().getColumn(6).setMaxWidth(160);
            tbl_med.getColumnModel().getColumn(6).setHeaderValue("Parent Relation");
            tbl_med.getColumnModel().getColumn(7).setPreferredWidth(90);
            tbl_med.getColumnModel().getColumn(7).setMaxWidth(90);
            tbl_med.getColumnModel().getColumn(8).setPreferredWidth(160);
            tbl_med.getColumnModel().getColumn(8).setMaxWidth(160);
            tbl_med.getColumnModel().getColumn(8).setHeaderValue("Disabilities");
            tbl_med.getColumnModel().getColumn(9).setPreferredWidth(190);
            tbl_med.getColumnModel().getColumn(9).setMaxWidth(190);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1250, 90));

        btn_view2.setBackground(new java.awt.Color(51, 153, 255));
        btn_view2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_view2.setForeground(new java.awt.Color(255, 255, 255));
        btn_view2.setText("DOWNLOAD REPORT IN PDF FORMAT");
        btn_view2.setBorder(null);
        btn_view2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view2ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_view2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 580, 50));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1260, 170));

        tbl_med1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Student Level", "Type of ADHD", "QUIZ 1 MARKS", "QUIZ 2 MARKS", "Q1 COMPLETION", "Q2 COMPLETION", "Q1 FEEDBACK", "Q2 FEEDBACK", "LECTURE 1 STATUS", "LECTURE 2 STATUS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_med1);
        if (tbl_med1.getColumnModel().getColumnCount() > 0) {
            tbl_med1.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbl_med1.getColumnModel().getColumn(0).setMaxWidth(80);
            tbl_med1.getColumnModel().getColumn(1).setPreferredWidth(180);
            tbl_med1.getColumnModel().getColumn(1).setMaxWidth(180);
            tbl_med1.getColumnModel().getColumn(2).setPreferredWidth(90);
            tbl_med1.getColumnModel().getColumn(2).setMaxWidth(90);
            tbl_med1.getColumnModel().getColumn(3).setPreferredWidth(190);
            tbl_med1.getColumnModel().getColumn(3).setMaxWidth(190);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 1240, 100));

        btn_view3.setBackground(new java.awt.Color(51, 153, 255));
        btn_view3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_view3.setForeground(new java.awt.Color(255, 255, 255));
        btn_view3.setText("DOWNLOAD REPORT IN PDF FORMAT");
        btn_view3.setBorder(null);
        btn_view3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_view3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 580, 50));

        btn_view1.setBackground(new java.awt.Color(0, 102, 51));
        btn_view1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_view1.setForeground(new java.awt.Color(255, 255, 255));
        btn_view1.setText("DOWNLOAD REPORT IN EXCEL FORMAT");
        btn_view1.setBorder(null);
        btn_view1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_view1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 630, 50));

        btn_view4.setBackground(new java.awt.Color(51, 153, 255));
        btn_view4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_view4.setForeground(new java.awt.Color(255, 255, 255));
        btn_view4.setText("DOWNLOAD REPORT IN PDF FORMAT");
        btn_view4.setBorder(null);
        btn_view4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view4ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_view4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 590, 50));

        tbl_med2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medical ID", "Student ID", "Student Name", "Gender", "Age", "Parent Name", "Parent Relation", "Student Level", "Disabilities", "Type of ADHD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_med2);
        if (tbl_med2.getColumnModel().getColumnCount() > 0) {
            tbl_med2.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbl_med2.getColumnModel().getColumn(0).setMaxWidth(80);
            tbl_med2.getColumnModel().getColumn(0).setHeaderValue("Medical ID");
            tbl_med2.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbl_med2.getColumnModel().getColumn(1).setMaxWidth(80);
            tbl_med2.getColumnModel().getColumn(2).setPreferredWidth(180);
            tbl_med2.getColumnModel().getColumn(2).setMaxWidth(180);
            tbl_med2.getColumnModel().getColumn(3).setHeaderValue("Gender");
            tbl_med2.getColumnModel().getColumn(4).setHeaderValue("Age");
            tbl_med2.getColumnModel().getColumn(5).setPreferredWidth(180);
            tbl_med2.getColumnModel().getColumn(5).setMaxWidth(180);
            tbl_med2.getColumnModel().getColumn(5).setHeaderValue("Parent Name");
            tbl_med2.getColumnModel().getColumn(6).setPreferredWidth(160);
            tbl_med2.getColumnModel().getColumn(6).setMaxWidth(160);
            tbl_med2.getColumnModel().getColumn(6).setHeaderValue("Parent Relation");
            tbl_med2.getColumnModel().getColumn(7).setPreferredWidth(90);
            tbl_med2.getColumnModel().getColumn(7).setMaxWidth(90);
            tbl_med2.getColumnModel().getColumn(8).setPreferredWidth(160);
            tbl_med2.getColumnModel().getColumn(8).setMaxWidth(160);
            tbl_med2.getColumnModel().getColumn(8).setHeaderValue("Disabilities");
            tbl_med2.getColumnModel().getColumn(9).setPreferredWidth(190);
            tbl_med2.getColumnModel().getColumn(9).setMaxWidth(190);
        }

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 1450, 110));

        btn_view5.setBackground(new java.awt.Color(0, 102, 51));
        btn_view5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_view5.setForeground(new java.awt.Color(255, 255, 255));
        btn_view5.setText("DOWNLOAD REPORT IN EXCEL FORMAT");
        btn_view5.setBorder(null);
        btn_view5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view5ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_view5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, 630, 50));

        jPanel7.setBackground(new java.awt.Color(51, 153, 255));

        jLabel21.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("ACADEMIC REPORT");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 1189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 1250, 40));

        jPanel8.setBackground(new java.awt.Color(51, 153, 255));

        jLabel22.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("LEISURE TIME ACTIVITY REPORT");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 1142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 1270, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1260, 820));

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("VIEW MEDICAL REPORT");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 850, 80));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/backbtn.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, 50, 60));

        parname1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        parname1.setForeground(new java.awt.Color(255, 255, 255));
        parname1.setText("PARENT/DOCTOR  NAME HERE");
        parname1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                parname1MouseEntered(evt);
            }
        });
        jPanel6.add(parname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, 240, 38));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 1270, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 80));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewActionPerformed
       try {
            connection = dbConnector.getMyConnection();

              String query = "SELECT s.s_id as studid, s.name as `Student Name`, s.gender as Gender, " +
    "s.adhd_type as `ADHD Type`, s.s_level as `Severity Level`, m.hyperactive as `Hyperactive Count`, " +
    "m.impulsive as `Impulsive Count`, m.inattention as `Inattention Count`, " +
    "sp.medicine as `Prescription Medicine`, sp.prescription_date as `Prescription Date` " +
    "FROM medical_report m " +
    "JOIN student s ON m.s_id = s.s_id " +
    "JOIN parent p ON p.p_id = s.p_id " +
    "LEFT JOIN student_prescription sp ON sp.s_id = s.s_id " +
    "WHERE p.p_id = ?";
              
            PreparedStatement preparedStatement = connection.prepareStatement(query);
                   preparedStatement.setInt(1, pid);
                 ResultSet resultSet = preparedStatement.executeQuery();
                
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Student Data");

                int rowNum = 0;
                Row headerRow = sheet.createRow(rowNum++);
                headerRow.createCell(0).setCellValue("studid");
                headerRow.createCell(1).setCellValue("Student Name");
                headerRow.createCell(2).setCellValue("Gender");
                headerRow.createCell(3).setCellValue("ADHD Type");
                headerRow.createCell(4).setCellValue("Severity Level");
                headerRow.createCell(5).setCellValue("Hyperactive Count");
                headerRow.createCell(6).setCellValue("Impulsive Count");
                headerRow.createCell(7).setCellValue("Inattention Count");
                headerRow.createCell(8).setCellValue("Prescription Medicine");
                headerRow.createCell(9).setCellValue("Prescription Date");
               
                while (resultSet.next()) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(resultSet.getInt("studid"));
                    row.createCell(1).setCellValue(resultSet.getString("Student Name"));
                    row.createCell(2).setCellValue(resultSet.getString("Gender"));
                    row.createCell(4).setCellValue(resultSet.getString("ADHD Type"));
                    row.createCell(3).setCellValue(resultSet.getInt("Severity Level"));
                    row.createCell(5).setCellValue(resultSet.getInt("Hyperactive Count"));
                    row.createCell(6).setCellValue(resultSet.getInt("Impulsive Count"));
                    row.createCell(7).setCellValue(resultSet.getInt("Inattention Count"));
                    row.createCell(8).setCellValue(resultSet.getString("Prescription Medicine"));
                    row.createCell(9).setCellValue(resultSet.getDate("Prescription Date"));
                }

                try (FileOutputStream fileOut = new FileOutputStream("StudentDataReport.xlsx")) {
                    workbook.write(fileOut);
                }

                java.awt.Desktop.getDesktop().open(new java.io.File("StudentDataReport.xlsx"));

            } catch (SQLException | IOException e) {
                e.printStackTrace();
            } 
    
        
    }//GEN-LAST:event_btn_viewActionPerformed

    private void btn_view2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view2ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("ACADEMIC REPORT");
          MessageFormat footer = new MessageFormat(sname);
        try{
             PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
             set.add(OrientationRequested.LANDSCAPE);
             tbl_med.print(JTable.PrintMode.FIT_WIDTH, header, footer, true,set, true);
             JOptionPane.showMessageDialog(null, "Printed");
          }
        
        catch (java.awt.print.PrinterException e){
              JOptionPane.showMessageDialog(null, e);
          }
    }//GEN-LAST:event_btn_view2ActionPerformed

    private void btn_view3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view3ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("ACADEMIC REPORT");
          MessageFormat footer = new MessageFormat(sname);
        try{
             PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
             set.add(OrientationRequested.LANDSCAPE);
             tbl_med.print(JTable.PrintMode.FIT_WIDTH, header, footer, true,set, true);
             JOptionPane.showMessageDialog(null, "Printed");
          }
        
        catch (java.awt.print.PrinterException e){
              JOptionPane.showMessageDialog(null, e);
          }
    }//GEN-LAST:event_btn_view3ActionPerformed

    private void btn_view1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view1ActionPerformed
        // TODO add your handling code here:
        
          try {
            connection = dbConnector.getMyConnection();

              String query = "SELECT DISTINCT s.s_id as studid, c.c_name as coursename, s.name as StudentName, "
                   + "s.s_level as studlevel, l.id as lectid,  s.adhd_type as type, qm.marks as quizmarks, l.status as l_status "
                   + "FROM student s "
                   + "JOIN stdcourse sc ON sc.s_id = s.s_id "
                   + "JOIN courses c ON c.c_id = sc.c_id "
                   + "JOIN lecture l ON l.s_id = s.s_id "
                   + "JOIN parent p ON s.p_id = p.p_id "
                   + "LEFT JOIN quiz_marks qm ON qm.s_id = s.s_id "
                   + "WHERE p.p_id = ?";
              
            PreparedStatement preparedStatement = connection.prepareStatement(query);
                   preparedStatement.setInt(1, pid);
                 ResultSet resultSet = preparedStatement.executeQuery();
                
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Student Data");

                int rowNum = 0;
                Row headerRow = sheet.createRow(rowNum++);
                headerRow.createCell(0).setCellValue("studid");
                headerRow.createCell(1).setCellValue("coursename");
                headerRow.createCell(2).setCellValue("StudentName");
                headerRow.createCell(3).setCellValue("studlevel");
                headerRow.createCell(4).setCellValue("lectid");
                headerRow.createCell(5).setCellValue("type");
                headerRow.createCell(6).setCellValue("quizmarks");
                headerRow.createCell(7).setCellValue("l_status");
                
               
               while (resultSet.next()) {
    Row row = sheet.createRow(rowNum++);
    row.createCell(0).setCellValue(resultSet.getInt("studid"));
    row.createCell(1).setCellValue(resultSet.getString("coursename"));
    row.createCell(2).setCellValue(resultSet.getString("StudentName"));
    row.createCell(3).setCellValue(resultSet.getInt("studlevel"));
    row.createCell(4).setCellValue(resultSet.getInt("lectid"));
    row.createCell(5).setCellValue(resultSet.getString("type"));

    // Check for NULL before retrieving the value
    int quizmarks = resultSet.getInt("quizmarks");
    if (!resultSet.wasNull()) {
        row.createCell(6).setCellValue(quizmarks);
    } else {
        // Handle NULL case, for example, set a default value or leave the cell blank
        row.createCell(6).setCellValue("N/A");
    }

    // Check for NULL before retrieving the value
    String lStatus = resultSet.getString("l_status");
    if (lStatus != null) {
        row.createCell(7).setCellValue(lStatus);
    } else {
        // Handle NULL case, for example, set a default value or leave the cell blank
        row.createCell(7).setCellValue("N/A");
    }
}



                try (FileOutputStream fileOut = new FileOutputStream("StudentDataReport.xlsx")) {
                    workbook.write(fileOut);
                }

                java.awt.Desktop.getDesktop().open(new java.io.File("StudentDataReport.xlsx"));

            } catch (SQLException | IOException e) {
                e.printStackTrace();
            } 
    }//GEN-LAST:event_btn_view1ActionPerformed

    private void btn_view4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view4ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("LEISURE TIME ACTIVITIES REPORT");
          MessageFormat footer = new MessageFormat(sname);
        try{
             PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
             set.add(OrientationRequested.LANDSCAPE);
             tbl_med.print(JTable.PrintMode.FIT_WIDTH, header, footer, true,set, true);
             JOptionPane.showMessageDialog(null, "Printed");
          }
        
        catch (java.awt.print.PrinterException e){
              JOptionPane.showMessageDialog(null, e);
          }
    }//GEN-LAST:event_btn_view4ActionPerformed

    private void btn_view5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_view5ActionPerformed

    private void parname1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parname1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_parname1MouseEntered

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
       ParentDashboard pp = new ParentDashboard();
        pp.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jLabel11MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_view;
    private javax.swing.JButton btn_view1;
    private javax.swing.JButton btn_view2;
    private javax.swing.JButton btn_view3;
    private javax.swing.JButton btn_view4;
    private javax.swing.JButton btn_view5;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel parname1;
    private javax.swing.JTable tbl_med;
    private javax.swing.JTable tbl_med1;
    private javax.swing.JTable tbl_med2;
    // End of variables declaration//GEN-END:variables
}
