/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import common.code.MyDbConnector;
import common.code.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javaquizapp.StartPage;

/**
 *
 * @author Kavindu_Dilhara
 */
public class TakeQuiz extends javax.swing.JFrame {
    
    
    public int c_ID;
    private MyDbConnector dbConnector;
    Connection connection = null;
    
     PreparedStatement preparedStatement ;
     List<String> cNames = new ArrayList<>();

    int id;
        List<Integer> course_idslist = new ArrayList<Integer>();

    public TakeQuiz (int id, List<Integer> course_idslist) {
        
        
        dbConnector = new MyDbConnector();
        connection = dbConnector.getMyConnection();
        initComponents();
        this.course_idslist = course_idslist;
        this.id = id;
        checkStudentId();

    }
    
    
   public void checkStudentId() {
    try {

        // Use a set to store unique values across all iterations
        Set<String> uniqueStudentNames = new HashSet<>();

        for (Integer courseId : course_idslist) {
            System.out.println(courseId);
           String sql = "SELECT c_name from courses c , stdcourse s where s.c_id = c.c_id and s.s_id = ?  and c.c_id = ?";
             preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, courseId);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    
                    System.out.println(rs.getString(1));
                    uniqueStudentNames.add(rs.getString(1));
                }
            }
        

        // Update GUI components after all iterations
        updateGUI(new ArrayList<>(uniqueStudentNames));
    } catch (SQLException ex) {
        // Handle the exception appropriately
        ex.printStackTrace();
    }
}

private void updateGUI(List<String> cNames) {
    // Assuming cnames is a JComboBox component

    // Clear existing items before adding new ones
    cnames.removeAllItems();

    // Add new items to the combo box
    for (String studentName : cNames) {
        cnames.addItem(studentName);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        view_ass_btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_Bck1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbl_StdID2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        view_asss_btn = new javax.swing.JButton();
        cnames = new javax.swing.JComboBox<>();

        view_ass_btn.setBackground(new java.awt.Color(51, 153, 255));
        view_ass_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        view_ass_btn.setForeground(new java.awt.Color(255, 255, 255));
        view_ass_btn.setText("VIEW ASSIGNMENT FILE");
        view_ass_btn.setBorder(null);
        view_ass_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_ass_btnActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(390, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Bck1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/backbtn.png"))); // NOI18N
        btn_Bck1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_BckMouseClicked(evt);
            }
        });
        jPanel1.add(btn_Bck1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, 60));

        jLabel18.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("TAKE QUIZ");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 310, 80));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QUIZZES LEFT: 2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 140, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 100));

        jPanel2.setBackground(new java.awt.Color(248, 248, 241));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(248, 248, 241));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_StdID2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_StdID2.setText("Course Name :");
        jPanel3.add(lbl_StdID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 40));

        jPanel6.setBackground(new java.awt.Color(248, 248, 241));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/courseIcon.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 320, 190));

        view_asss_btn.setBackground(new java.awt.Color(51, 153, 255));
        view_asss_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view_asss_btn.setForeground(new java.awt.Color(255, 255, 255));
        view_asss_btn.setText("TAKE QUIZ NOW");
        view_asss_btn.setBorder(null);
        view_asss_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_asss_btnActionPerformed(evt);
            }
        });
        jPanel3.add(view_asss_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 380, 50));

        cnames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COURSE 1", "COURSE 2" }));
        jPanel3.add(cnames, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 270, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 280));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 750, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BckMouseClicked
         StudentDashboard sd = new StudentDashboard();
        sd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_BckMouseClicked

   
    
    private void view_ass_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_ass_btnActionPerformed
       
    }//GEN-LAST:event_view_ass_btnActionPerformed

    private void view_asss_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_asss_btnActionPerformed
        String cname = (String) cnames.getSelectedItem();

// Check if the selected item is null or empty
if (cname == null || cname.isEmpty()) {
    // If null or empty, set the selected item to the default item (the first item)
    cnames.setSelectedIndex(0);
    cname = (String) cnames.getSelectedItem();
}

StartPage sp = new StartPage(cname);
this.dispose();
sp.setVisible(true);

    }//GEN-LAST:event_view_asss_btnActionPerformed
  
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_Bck1;
    private javax.swing.JComboBox<String> cnames;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_StdID2;
    private javax.swing.JButton view_ass_btn;
    private javax.swing.JButton view_asss_btn;
    // End of variables declaration//GEN-END:variables
}
