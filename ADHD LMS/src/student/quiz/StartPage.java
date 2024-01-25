/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaquizapp;

import common.code.Auth;
import common.code.MyDbConnector;
import common.code.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import student.TakeQuiz;
import student.quiz.Quiz;

/**
 *
 * @author ABC
 */
public class StartPage extends javax.swing.JFrame {

    
     UserProfile loggedUser = Auth.getLoggedUser();  
    String name = loggedUser.getUsername();
    int slevel = loggedUser.getSLevel();
    
    private MyDbConnector dbConnector;
    Connection connection = null;
    
    String cname;
    int cid;
    public StartPage(String cname) {
        
         dbConnector = new MyDbConnector();
         connection = dbConnector.getMyConnection();
        initComponents();
        this.cname = cname;
        coursename.setText(cname.toUpperCase());
         studname.setText(name.toUpperCase());
         cid = getCID(cname);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        coursename = new javax.swing.JLabel();
        studname = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 153, 255));
        jButton1.setText("START QUIZ ");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255), 2));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/quiz/quiz.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("STUDENT QUIZ");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 500, 120));

        coursename.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        coursename.setForeground(new java.awt.Color(255, 255, 255));
        coursename.setText("COURSE NAME HERE");
        coursename.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        coursename.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                coursenameMouseEntered(evt);
            }
        });
        jPanel6.add(coursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, -1, 30));

        studname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        studname.setForeground(new java.awt.Color(255, 255, 255));
        studname.setText("STUDENT NAME HERE");
        studname.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studnameMouseEntered(evt);
            }
        });
        jPanel6.add(studname, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
public int getCID(String cname) {
    int cid = 0; // Initialize to a default value

    try (Connection connection = dbConnector.getMyConnection();
         PreparedStatement pstmt = connection.prepareStatement("SELECT c_id FROM courses WHERE c_name = ? AND std_level = ?")) {
        
        pstmt.setString(1, cname);
        pstmt.setInt(2, slevel);

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                cid = rs.getInt(1);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    return cid;
}

    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
   
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:\
        this.setVisible(false);
        new Quiz(cid,cname).setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void coursenameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coursenameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_coursenameMouseEntered

    private void studnameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studnameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_studnameMouseEntered

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coursename;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel studname;
    // End of variables declaration//GEN-END:variables
}
