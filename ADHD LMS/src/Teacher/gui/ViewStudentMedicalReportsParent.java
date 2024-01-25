/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher.gui;

import Parent.*;
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
    int tid;
    private MyDbConnector dbConnector;
    Connection connection = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    UserProfile loggedUser = Auth.getLoggedUser();
    String name = loggedUser.getUsername();
   
    
    public ViewStudentMedicalReportsParent(int t_id) {
        dbConnector = new MyDbConnector();
        initComponents();
      this.tid = t_id;
        
        showAcadRecord(t_id);
        parname1.setText(name);
       
  
    }

   
    
     public void showAcadRecord(int tid) {
        try {
            dbConnector = new MyDbConnector();
            try {
                String sql;
                connection = dbConnector.getMyConnection();
                
                  sql = "SELECT DISTINCT s.s_id as studid, c.c_name as coursename, s.name as StudentName, "
                   + "s.s_level as studlevel, l.id as lectid,  s.adhd_type as type, qm.marks as quizmarks, l.status as l_status "
                   + "FROM student s "
                   + "JOIN stdcourse sc ON sc.s_id = s.s_id "
                   + "JOIN teacher t ON t.c_id = sc.c_id "
                   + "JOIN courses c ON c.c_id = sc.c_id "
                   + "JOIN lecture l ON l.c_id = t.c_id "
                   + "LEFT JOIN quiz_marks qm ON qm.c_id = t.c_id "
                   + "WHERE t.t_id = ?";

               
                        
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1,tid);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_med1 = new javax.swing.JTable();
        btn_view3 = new javax.swing.JButton();
        btn_view1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        parname1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1240, 310));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1260, 820));

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("VIEW ACADEMIC REPORT");
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

    private void btn_view3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view3ActionPerformed
        // TODO add your handling code here:\
          MessageFormat header = new MessageFormat("MEDICAL REPORT");
          MessageFormat footer = new MessageFormat(sname);
        try{
             PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
             set.add(OrientationRequested.LANDSCAPE);
             tbl_med1.print(JTable.PrintMode.FIT_WIDTH, header, footer, true,set, true);
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
                   + "JOIN teacher t ON t.c_id = sc.c_id "
                   + "JOIN courses c ON c.c_id = sc.c_id "
                   + "JOIN lecture l ON l.c_id = t.c_id "
                   + "LEFT JOIN quiz_marks qm ON qm.c_id = t.c_id "
                   + "WHERE t.t_id = ?";
              
            PreparedStatement preparedStatement = connection.prepareStatement(query);
                   preparedStatement.setInt(1, tid);
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

    private void parname1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parname1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_parname1MouseEntered

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
       this.dispose();
        LecturerDashboard ll = null;
        try {
            ll = new LecturerDashboard();
        } catch (SQLException ex) {
            Logger.getLogger(ViewStudentMedicalReportsParent.class.getName()).log(Level.SEVERE, null, ex);
        }
       ll.setVisible(true);
       
        
    }//GEN-LAST:event_jLabel11MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_view1;
    private javax.swing.JButton btn_view3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel parname1;
    private javax.swing.JTable tbl_med1;
    // End of variables declaration//GEN-END:variables
}
