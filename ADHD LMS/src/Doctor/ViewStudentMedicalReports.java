/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Kavindu_Dilhara
 */
public class ViewStudentMedicalReports extends javax.swing.JFrame {
    
    
    private MyDbConnector dbConnector;
    Connection connection = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    UserProfile loggedUser = Auth.getLoggedUser();
    String name = loggedUser.getUsername();
    
  
   
     
    public ViewStudentMedicalReports() {
        dbConnector = new MyDbConnector();
        initComponents();
        showMedRecord();
        doctorname.setText(name);
        
        tbl_med.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Check if there was a single click
            if (e.getClickCount() == 1) {
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();
                int column = target.getSelectedColumn();
                // Check if the clicked column is the fourth column
                if (column == 3) {
                    // Retrieve the PDF data from the table
                    byte[] pdfData = (byte[]) tbl_med.getValueAt(row, column);
                    try {
                        // Create a temporary PDF file
                        File pdfFile = new File("Medicle.pdf");
                        Files.write(pdfFile.toPath(), pdfData);
                        Desktop.getDesktop().browse(pdfFile.toURI());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    });
    }

    /**
     * Retrieves and displays medical records in a table for the specified student ID.
     */
    public void showMedRecord() {
        try {
            dbConnector = new MyDbConnector();
            try {
                String sql;
                connection = dbConnector.getMyConnection();
                
                   sql = "SELECT s.s_id as studid, s.name as `Student Name`, s.gender as Gender, p.name as `Parent Name`, p.relation as `Parent Relation`, \n" +
"       s.adhd_type as `ADHD Type`, s.s_level as `Severity Level`, m.hyperactive as `Hyperactive Count`, \n" +
"       m.impulsive as `Impulsive Count`, m.inattention as `Inattention Count`, \n" +
"       sp.medicine as `Prescription Medicine`, sp.prescription_date as `Prescription Date`\n" +
"FROM medical_report m\n" +
"JOIN student s ON m.s_id = s.s_id\n" +
"JOIN parent p ON p.p_id = s.p_id\n" +
"LEFT JOIN student_prescription sp ON sp.s_id = s.s_id;";

               
                        
                PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                
                 List<String> columnNames = new ArrayList<>(Arrays.asList("SID","Student Name", "Gender", "Parent Name", "Relation", 
                "ADHD Type", "Level", "Hyperactive", "Impulsive", "Inattention", 
                "Severity", "Prescription Medicine", "Prescription Date"));
                // Create a DefaultTableModel with dynamic column names
                DefaultTableModel cmodel = new DefaultTableModel(columnNames.toArray(), 0);


                String severity = ""; int totaladhdscore = 0;
                while (rs.next()) {
                    int  sid = rs.getInt("studid");
                    String sname = rs.getString("Student Name");
                    String gender = rs.getString("Gender");
                    String pname = rs.getString("Parent Name");
                    String relation = rs.getString("Parent Relation");
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

                    cmodel.addRow(new Object[]{sid,sname,gender, pname,relation, adhdtype, slevel,hypercount,impulcount,inattcount,severity,medicineValue,dateValue});
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_view = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_med = new javax.swing.JTable();
        prescribebtn = new javax.swing.JButton();
        btn_view2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        doctorname = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

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
        jPanel3.add(btn_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, 600, 50));

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
            tbl_med.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbl_med.getColumnModel().getColumn(1).setMaxWidth(80);
            tbl_med.getColumnModel().getColumn(2).setPreferredWidth(180);
            tbl_med.getColumnModel().getColumn(2).setMaxWidth(180);
            tbl_med.getColumnModel().getColumn(5).setPreferredWidth(180);
            tbl_med.getColumnModel().getColumn(5).setMaxWidth(180);
            tbl_med.getColumnModel().getColumn(6).setPreferredWidth(160);
            tbl_med.getColumnModel().getColumn(6).setMaxWidth(160);
            tbl_med.getColumnModel().getColumn(7).setPreferredWidth(90);
            tbl_med.getColumnModel().getColumn(7).setMaxWidth(90);
            tbl_med.getColumnModel().getColumn(8).setPreferredWidth(160);
            tbl_med.getColumnModel().getColumn(8).setMaxWidth(160);
            tbl_med.getColumnModel().getColumn(9).setPreferredWidth(190);
            tbl_med.getColumnModel().getColumn(9).setMaxWidth(190);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1180, 370));

        prescribebtn.setBackground(new java.awt.Color(51, 153, 255));
        prescribebtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prescribebtn.setForeground(new java.awt.Color(255, 255, 255));
        prescribebtn.setText("PRESCRIBE NOW");
        prescribebtn.setBorder(null);
        prescribebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prescribebtnActionPerformed(evt);
            }
        });
        jPanel3.add(prescribebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 230, 40));

        btn_view2.setBackground(new java.awt.Color(51, 153, 255));
        btn_view2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_view2.setForeground(new java.awt.Color(255, 255, 255));
        btn_view2.setText("PRINT REPORT");
        btn_view2.setBorder(null);
        btn_view2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view2ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_view2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 560, 50));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1180, 490));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1200, 500));

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));

        jLabel19.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("VIEW MEDICAL REPORTS");

        doctorname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doctorname.setForeground(new java.awt.Color(255, 255, 255));
        doctorname.setText("PARENT/DOCTOR  NAME HERE");
        doctorname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                doctornameMouseEntered(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/backbtn.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addGap(82, 82, 82)
                .addComponent(doctorname)
                .addGap(38, 38, 38))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(doctorname, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 100));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewActionPerformed
        // TODO add your handling code here:
       try {
            connection = dbConnector.getMyConnection();

              String query = "SELECT s.s_id as studid, s.name as `Student Name`, s.gender as Gender, " +
    "s.adhd_type as `ADHD Type`, s.s_level as `Severity Level`, m.hyperactive as `Hyperactive Count`, " +
    "m.impulsive as `Impulsive Count`, m.inattention as `Inattention Count`, " +
    "sp.medicine as `Prescription Medicine`, sp.prescription_date as `Prescription Date` " +
    "FROM medical_report m " +
    "JOIN student s ON m.s_id = s.s_id " +
    "JOIN parent p ON p.p_id = s.p_id " +
    "LEFT JOIN student_prescription sp ON sp.s_id = s.s_id ";
              
            PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery();
                
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Medical Report");

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
        
//        showMedRecord();
    }//GEN-LAST:event_btn_viewActionPerformed

    private void doctornameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctornameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_doctornameMouseEntered

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        try {
            DoctorDashboard dd = new DoctorDashboard();
            this.dispose();
            dd.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ViewStudentMedicalReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void prescribebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prescribebtnActionPerformed
         int selectedRow = tbl_med.getSelectedRow();

    if (selectedRow == -1) {
        // No row is selected, show a message dialog
        JOptionPane.showMessageDialog(null, "Please select any student from the table before clicking the button", "No Row Selected", JOptionPane.WARNING_MESSAGE);
    } else {
        // Get the current date
          // A row is selected, get the data from the selected row
        DefaultTableModel model = (DefaultTableModel) tbl_med.getModel();

        java.util.Date currentDate = Calendar.getInstance().getTime();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
       int s_id = Integer.valueOf(model.getValueAt(selectedRow, 0).toString());
         String name = (String) model.getValueAt(selectedRow, 1);
        String adhd_type = (String) model.getValueAt(selectedRow, 5);
        String  severity = (String) model.getValueAt(selectedRow, 10); 
        String  medicineValue = (String) model.getValueAt(selectedRow, 11);
        
        try {
        if(medicineValue.equals("Not Done Yet")){
            Prescription_Details  pd = new Prescription_Details(s_id, name, adhd_type,severity);
            pd.setVisible(true);
            this.dispose();
        }
        else{
             String checkRecentPrescription = "SELECT MAX(prescription_date) AS recent_date FROM student_prescription WHERE s_id = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkRecentPrescription);
            checkStmt.setInt(1, s_id);

            ResultSet resultSet = checkStmt.executeQuery();

            if (resultSet.next()) {
                java.sql.Date recentDate = resultSet.getDate("recent_date");
            // Check if the difference is less than 3 days
                if (recentDate != null && (sqlDate.getTime() - recentDate.getTime()) < (3 * 24 * 60 * 60 * 1000)) {
                    // Show a message dialog that the student has been prescribed recently
                    JOptionPane.showMessageDialog(null,name +" has been prescribed recently.", "Warning", JOptionPane.WARNING_MESSAGE);
                }else{

                        Prescription_Details  pd = new Prescription_Details(s_id, name, adhd_type,severity);
                         pd.setVisible(true);
                         this.dispose();
                }
            }
        }
       
        } catch (SQLException ex) {
                     Logger.getLogger(DoctorDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    }//GEN-LAST:event_prescribebtnActionPerformed

    private void btn_view2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view2ActionPerformed
        // TODO add your handling code here:
          MessageFormat header = new MessageFormat("MEDICAL REPORTS");
          MessageFormat footer = new MessageFormat("STUDENTS");
        try{
             PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
             set.add(OrientationRequested.PORTRAIT);
             tbl_med.print(JTable.PrintMode.FIT_WIDTH, header, footer, true,set, true);
             JOptionPane.showMessageDialog(null, "Printed");
          }
        
        catch (java.awt.print.PrinterException e){
              JOptionPane.showMessageDialog(null, e);
          }
       
       
    
    }//GEN-LAST:event_btn_view2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_view;
    private javax.swing.JButton btn_view2;
    private javax.swing.JLabel doctorname;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton prescribebtn;
    private javax.swing.JTable tbl_med;
    // End of variables declaration//GEN-END:variables
}
