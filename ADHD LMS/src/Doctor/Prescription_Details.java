/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Doctor;

import common.code.Auth;
import common.code.MyDbConnector;
import common.code.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Prescription_Details extends javax.swing.JFrame {
    DoctorDashboard dd = new DoctorDashboard();
int s_id;int p_id;
String name; 
String severity;
 private MyDbConnector dbConnector;
    Connection connection = null;
    
     UserProfile loggedUser = Auth.getLoggedUser();   
    String doctorname = loggedUser.getUsername();
    

    public int getS_id() {
        return s_id;
    }
 public int getPID() {
        return p_id;
    }
    public void setS_id(int s_id) {
        this.s_id = s_id;
    }
 public void setPID(int p_id) {
        this.p_id = p_id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }


    public Prescription_Details(int s_id, String name, String adhd_type,String severity) throws SQLException {
       dbConnector = new MyDbConnector();
        initComponents();
        this.s_id = s_id;
        this.name = name;
        this.severity = severity;
        docname.setText(doctorname);
        viewstds();
        updateMedicineComboBox(adhd_type);
    }

    public void viewstds() throws SQLException {
     connection = dbConnector.getMyConnection();
   
    StringBuilder sql = new StringBuilder("SELECT s.* , p.p_id as `parent id`,p.name as `parent name`  FROM student s , parent p where p.p_id = s.p_id and s.s_id = " + getS_id());
    PreparedStatement stmt = connection.prepareStatement(sql.toString());
    
    ResultSet rs = stmt.executeQuery();

   while (rs.next()) {
    int s_id = rs.getInt("s_id");
    String name = rs.getString("name");
    String gender = rs.getString("gender");
    String parentName = rs.getString("parent name");
    String adhd_type = rs.getString("adhd_type");
    String stud_level1 = rs.getString("s_level");
    int p_id = rs.getInt("parent id");
    setPID(p_id);
    
    id_text.setText(String.valueOf(s_id)); 
    name_text.setText(name);
    gender_text.setText(gender);
    parent_text.setText(parentName);
    type_adhd.setText(adhd_type);
    level_student.setText(severity);
}


    // Close resources
    rs.close();
}
    private void updateMedicineComboBox(String adhdType) {
    // Get the valid medicines for the selected ADHD type
    List<String> validMedicines = getValidMedicines(adhdType);

    // Update the combo box with the valid medicines
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(validMedicines.toArray(new String[0]));
    medicine_combo.setModel(model);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbl_stdID = new javax.swing.JLabel();
        level_student = new javax.swing.JTextField();
        add_medicine_btn = new javax.swing.JButton();
        lbl_courseID = new javax.swing.JLabel();
        lbl_fTheory2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        medicine_combo = new javax.swing.JComboBox<>();
        lbl_fTheory3 = new javax.swing.JLabel();
        id_text = new javax.swing.JTextField();
        lbl_courseID1 = new javax.swing.JLabel();
        type_adhd = new javax.swing.JTextField();
        parent_text = new javax.swing.JTextField();
        gender_text = new javax.swing.JTextField();
        lbl_fTheory4 = new javax.swing.JLabel();
        lbl_stdID1 = new javax.swing.JLabel();
        name_text = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        docname = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(248, 248, 241));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

        jPanel4.setBackground(new java.awt.Color(248, 248, 241));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_stdID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_stdID.setText("Student ID :");
        jPanel4.add(lbl_stdID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 110, 40));

        level_student.setEnabled(false);
        jPanel4.add(level_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 220, 40));

        add_medicine_btn.setBackground(new java.awt.Color(51, 153, 255));
        add_medicine_btn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        add_medicine_btn.setForeground(new java.awt.Color(255, 255, 255));
        add_medicine_btn.setText("ADD");
        add_medicine_btn.setBorder(null);
        add_medicine_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_medicine_btnActionPerformed(evt);
            }
        });
        jPanel4.add(add_medicine_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 330, 40));

        lbl_courseID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_courseID.setText("Parent Name :");
        jPanel4.add(lbl_courseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 110, 40));

        lbl_fTheory2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_fTheory2.setText("Select Medicine:");
        jPanel4.add(lbl_fTheory2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 110, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/prescription2.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 380, 490));

        medicine_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicine 1", " " }));
        medicine_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicine_comboActionPerformed(evt);
            }
        });
        jPanel4.add(medicine_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 220, 40));

        lbl_fTheory3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_fTheory3.setText("Strudent Level:");
        jPanel4.add(lbl_fTheory3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 110, 40));

        id_text.setEnabled(false);
        id_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_textActionPerformed(evt);
            }
        });
        jPanel4.add(id_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 220, 40));

        lbl_courseID1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_courseID1.setText("Type of ADHD :");
        jPanel4.add(lbl_courseID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 110, 40));

        type_adhd.setEnabled(false);
        jPanel4.add(type_adhd, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 220, 40));

        parent_text.setEnabled(false);
        parent_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parent_textActionPerformed(evt);
            }
        });
        jPanel4.add(parent_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 220, 40));

        gender_text.setEnabled(false);
        jPanel4.add(gender_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 220, 40));

        lbl_fTheory4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_fTheory4.setText("Gender:");
        jPanel4.add(lbl_fTheory4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 110, 40));

        lbl_stdID1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_stdID1.setText("Student Name:");
        jPanel4.add(lbl_stdID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 110, 40));

        name_text.setEnabled(false);
        name_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_textActionPerformed(evt);
            }
        });
        jPanel4.add(name_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 220, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 990, 490));

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));

        jLabel19.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("PRESCRIPTION DETAILS");

        docname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        docname.setForeground(new java.awt.Color(255, 255, 255));
        docname.setText("DOCTOR NAME HERE");
        docname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                docnameMouseEntered(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/backbtn.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(docname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(docname, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1000, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents
private List<String> getValidMedicines(String adhdType) {
    // Map ADHD types to their corresponding medicines
    Map<String, List<String>> adhdMedicineMap = new HashMap<>();
    adhdMedicineMap.put("inattention", Arrays.asList("Medicine1", "Medicine2", "Medicine3"));
    adhdMedicineMap.put("impulsive", Arrays.asList("Medicine4", "Medicine5", "Medicine6"));
    adhdMedicineMap.put("hyperactive", Arrays.asList("Medicine7", "Medicine8", "Medicine9"));

    // Check if the selected ADHD type is valid
    if (!adhdMedicineMap.containsKey(adhdType.toLowerCase())) {
        JOptionPane.showMessageDialog(null, "Invalid ADHD type selected.", "Error", JOptionPane.ERROR_MESSAGE);
        return Collections.emptyList(); // Return an empty list for an invalid ADHD type
    }

    return adhdMedicineMap.get(adhdType);
}
    private void add_medicine_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_medicine_btnActionPerformed
                                       
    try {
        // Get the selected medicine from the combo box
        String selectedMedicine = (String) medicine_combo.getSelectedItem();
        
        // Get the current date
        java.util.Date currentDate = Calendar.getInstance().getTime();
        Date sqlDate = new Date(currentDate.getTime());

         // Get the valid medicines for the selected ADHD type
        List<String> validMedicines = getValidMedicines(type_adhd.getText());

        // Check if the selected medicine is valid for the selected ADHD type
        if (!validMedicines.contains(selectedMedicine)) {
            JOptionPane.showMessageDialog(null, "Invalid medicine selected for the ADHD type.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Assuming you have a PreparedStatement prepared earlier
        String checkRecentPrescription = "SELECT MAX(prescription_date) AS recent_date FROM student_prescription WHERE s_id = ?";
        PreparedStatement checkStmt = connection.prepareStatement(checkRecentPrescription);
        checkStmt.setInt(1, getS_id());

        ResultSet resultSet = checkStmt.executeQuery();

        if (resultSet.next()) {
            Date recentDate = resultSet.getDate("recent_date");

            // Check if the difference is less than 3 days
            if (recentDate != null && (sqlDate.getTime() - recentDate.getTime()) < (3 * 24 * 60 * 60 * 1000)) {
                // Show a message dialog that the student has been prescribed recently
                JOptionPane.showMessageDialog(null, "This student has been prescribed recently.", "Warning", JOptionPane.WARNING_MESSAGE);
                this.dispose();
                
                dd.setVisible(true);
            } else {
                // Insert the new prescription
                String insertPrescription = "INSERT INTO student_prescription (s_id, adhd_type, medicine, prescription_date) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = connection.prepareStatement(insertPrescription);
                pstmt.setInt(1, getS_id());
                pstmt.setString(2, type_adhd.getText());
                pstmt.setString(3, selectedMedicine);
                pstmt.setDate(4, sqlDate);

                // Execute the update
                pstmt.executeUpdate();

                // Show a message dialog indicating success
                JOptionPane.showMessageDialog(null, "Student Prescribed Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                 // Insert notice into notice table
            String insertNotice = "INSERT INTO notice (title, content, date, userID, category) VALUES (?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(insertNotice);
                // You can customize the notice content based on the prescription
                String noticeTitle = "New Prescription Added For " + getName();
                String noticeContent = "A new prescription has been added for the student.";
                pstmt.setString(1, noticeTitle);
                pstmt.setString(2, noticeContent);
                pstmt.setDate(3, new java.sql.Date(currentDate.getTime()));
                pstmt.setInt(4,getPID() ); // You need to implement this method
                pstmt.setString(5, "Doctor's Prescription");
                pstmt.executeUpdate();
            

                pstmt.close();
            }
        }

        checkStmt.close();
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately
    }

    }//GEN-LAST:event_add_medicine_btnActionPerformed

    private void docnameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docnameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_docnameMouseEntered

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        //        admin.back(admin);
               this.dispose();
               dd.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void medicine_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicine_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicine_comboActionPerformed

    private void id_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_textActionPerformed

    private void parent_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parent_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parent_textActionPerformed

    private void name_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_textActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_medicine_btn;
    private javax.swing.JLabel docname;
    private javax.swing.JTextField gender_text;
    private javax.swing.JTextField id_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_courseID;
    private javax.swing.JLabel lbl_courseID1;
    private javax.swing.JLabel lbl_fTheory2;
    private javax.swing.JLabel lbl_fTheory3;
    private javax.swing.JLabel lbl_fTheory4;
    private javax.swing.JLabel lbl_stdID;
    private javax.swing.JLabel lbl_stdID1;
    private javax.swing.JTextField level_student;
    private javax.swing.JComboBox<String> medicine_combo;
    private javax.swing.JTextField name_text;
    private javax.swing.JTextField parent_text;
    private javax.swing.JTextField type_adhd;
    // End of variables declaration//GEN-END:variables
}
