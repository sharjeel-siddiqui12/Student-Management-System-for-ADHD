package admin.gui;

import common.code.MyDbConnector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class ApproveTeacherStatus extends javax.swing.JFrame  {

    private MyDbConnector dbConnector; 
    Connection connection = null;
    
     
    public ApproveTeacherStatus() {
        initComponents();
        dbConnector = new MyDbConnector();
        showTable();
        
       teacher_ids.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
           String selectedTeacherId = teacher_ids.getSelectedItem().toString();

            // Set the selected index of teacher_names based on the selected id
            int index = getIndexForTeacherId(selectedTeacherId);
           
            // Set the retrieved name to the text field
            teachername.setText( teacher_names.getItemAt(index));
       
    }
});
       
        course_name.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
           String selectedTeacherId = course_name.getSelectedItem().toString();

            // Set the selected index of teacher_names based on the selected id
            int index = getIndexForCourseId(selectedTeacherId);
            System.out.println(index);
           
            course_id.setText(course_ids.getItemAt(index).toString());
       
    }
});

    }

    
     private javax.swing.JComboBox<String> teacher_names = new javax.swing.JComboBox<>();;
    private javax.swing.JComboBox<Integer> course_ids = new javax.swing.JComboBox<>();;
    
    public void update() {
    
        try {
            connection = dbConnector.getMyConnection();
            String sql = "UPDATE teacher SET t_status='approved',c_id=? WHERE t_id =? ";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, course_id.getText());
            pstmt.setString(2, teacher_ids.getSelectedItem().toString());
            
            pstmt.executeUpdate();
            
             sql = "UPDATE courses SET status='assigned' WHERE c_id =? ";
             pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, course_id.getText());
                        pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Succesfully Updated...");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Close....");
                } catch (SQLException e) {
                    System.out.println("Error in closing the connection: " + e.getMessage());
                }
            }
        } 
        
        clear();
    }
    
    public void clear(){
        teachername.setText("");
        course_id.setText("");
    }

    public void delete() {
	int confirm = JOptionPane.showConfirmDialog(null, "Want to delete?");
	if(confirm == 0){
		String uid = teacher_ids.getSelectedItem().toString();
                try {
                    connection = dbConnector.getMyConnection();
                    String sql = "DELETE FROM teacher WHERE t_id='"+uid+"' ";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.execute();
                    JOptionPane.showMessageDialog(null, "Deleted...");
                    showTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                } finally {
                    if (connection != null) {
                        try {
                            connection.close();
                            System.out.println("Close....");
                        } catch (SQLException e) {
                            System.out.println("Error in closing the connection: " + e.getMessage());
                        }
                    }
                }
	}    
         clear();
    }


 public void showTable() {
    try {
        DefaultComboBoxModel<String> teacherModel = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> teacherModel2 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> courseModel = new DefaultComboBoxModel<>();
DefaultComboBoxModel<Integer> courseModel2 = new DefaultComboBoxModel<>();

        connection = dbConnector.getMyConnection();

        // Fetch teacher data
        String teacherSql = "SELECT t_id, name, gender, email, qualification, t_status FROM teacher WHERE t_status = 'not approve'";
        PreparedStatement teacherStmt = connection.prepareStatement(teacherSql);
        ResultSet teacherRs = teacherStmt.executeQuery();
        String teacherSql2 = "SELECT t_id, name, gender, email, qualification, t_status FROM teacher WHERE t_status = 'not approve'";
        PreparedStatement teacherStmt2 = connection.prepareStatement(teacherSql2);
        ResultSet teacherRs2 = teacherStmt2.executeQuery();

        while (teacherRs.next()) {
            int teacherId = teacherRs.getInt("t_id");
            String teacherNames = teacherRs.getString("name");
            String teacherIdString = String.valueOf(teacherId);
            teacherModel.addElement(teacherIdString);
            teacherModel2.addElement(teacherNames);
        }

        // Set the teacherModel to the teacher_ids JComboBox
        teacher_ids.setModel(teacherModel);
        teacher_names.setModel(teacherModel2);
        // Set the model for the userTable
        userTable.setModel(DbUtils.resultSetToTableModel(teacherRs2));

        // Fetch course data
        String courseSql = "SELECT c_id, c_name FROM courses WHERE status = 'not assigned'";
        PreparedStatement courseStmt = connection.prepareStatement(courseSql);
        ResultSet courseRs = courseStmt.executeQuery();

        while (courseRs.next()) {
            
            int courseids = courseRs.getInt("c_id");
            String courseName = courseRs.getString("c_name");
            courseModel.addElement(courseName + " ("+courseids+")");
            courseModel2.addElement(courseids);
        }

        // Set the courseModel to the course_name JComboBox
        course_name.setModel(courseModel);
        course_ids.setModel(courseModel2);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    } finally {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Close....");
            } catch (SQLException e) {
                System.out.println("Error in closing the connection: " + e.getMessage());
            }
        }
    }
}

  
private int getIndexForTeacherId(String teacherId) {
    // Assuming teacher_ids and teacher_names have the same order
    for (int i = 0; i < teacher_ids.getItemCount(); i++) {
        if (teacher_ids.getItemAt(i).equals(teacherId)) {
            return i;
        }
    }
    return -1; // Return -1 if not found
}

private int getIndexForCourseId(String teacherId) {
    // Assuming teacher_ids and teacher_names have the same order
    for (int i = 0; i < course_name.getItemCount(); i++) {
        if (course_name.getItemAt(i).equals(teacherId)) {
            return i;
        }
    }
    return -1; // Return -1 if not found
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        teacher_ids = new javax.swing.JComboBox<>();
        btn_update = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        course_name = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        teachername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        course_id = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(251, 255, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "TID", "Name", "Gender", "Qualification", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(userTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 540, 520));

        jPanel4.setBackground(new java.awt.Color(248, 248, 241));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        teacher_ids.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        teacher_ids.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacher_idsActionPerformed(evt);
            }
        });
        jPanel4.add(teacher_ids, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 280, 40));

        btn_update.setBackground(new java.awt.Color(51, 153, 255));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("UPDATE");
        btn_update.setBorder(null);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel4.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 200, 40));

        btn_remove.setBackground(new java.awt.Color(51, 153, 255));
        btn_remove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_remove.setForeground(new java.awt.Color(255, 255, 255));
        btn_remove.setText("REMOVE");
        btn_remove.setBorder(null);
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });
        jPanel4.add(btn_remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 190, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("TEACHER NAME:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("COURSE NAME:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 110, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/teacherApprove.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 310, 490));

        course_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        course_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_nameActionPerformed(evt);
            }
        });
        jPanel4.add(course_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 280, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("TEACHER ID:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, 40));

        teachername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        teachername.setText("Teacher name");
        teachername.setEnabled(false);
        jPanel4.add(teachername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 280, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("COURSE ID:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 110, 40));

        course_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        course_id.setText("Course ID");
        course_id.setEnabled(false);
        jPanel4.add(course_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 280, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1250, -1));

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("APPROVE TEACHER");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 1110, 130));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/backbtn.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 130));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 130));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        update();
        showTable();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        delete();
    }//GEN-LAST:event_btn_removeActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        
    }//GEN-LAST:event_userTableMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
    
    }//GEN-LAST:event_jLabel10MouseClicked

    private void teacher_idsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacher_idsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacher_idsActionPerformed

    private void course_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course_nameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_update;
    private javax.swing.JTextField course_id;
    private javax.swing.JComboBox<String> course_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> teacher_ids;
    private javax.swing.JTextField teachername;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables

  
 
}
