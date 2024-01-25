/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student;

import common.code.Auth;
import common.code.MyDbConnector;
import common.code.UserProfile;
import common.gui.LoginNewGui;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaquizapp.StartPage;
import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDashboard extends javax.swing.JFrame {

     UserProfile loggedUser = Auth.getLoggedUser();  
    String name = loggedUser.getUsername();
    int id = loggedUser.getId();
    int cid = loggedUser.getCourseId();
    boolean quizcheck;
     PreparedStatement preparedStatement;
     List<Integer> course_idslist = new ArrayList<Integer>();
     
 private MyDbConnector dbConnector;
    Connection connection = null;
     
     
    public StudentDashboard() {
         dbConnector = new MyDbConnector();
        connection = dbConnector.getMyConnection();
        initComponents();
        course_ids.setVisible(false);
        studname.setText(name.toUpperCase());
        checkQuiz();
    }
    
    public void checkQuiz(){
         try {
             String sql="";
             ResultSet rs,rs2;
             sql = "select c_id from stdcourse where s_id = ?";
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setInt(1,  id);
             rs = preparedStatement.executeQuery();
              while(rs.next()) {
                    sql = "select c_id from lecture where s_id = ? and c_id = ? and watch_time >= 3";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1,  id);
                    preparedStatement.setInt(2,  rs.getInt(1));
                    rs2 = preparedStatement.executeQuery();
                     if (rs2.next()) {
                         quizcheck = true;
                         System.out.println(rs2.getInt("c_id"));
                           course_idslist.add(rs2.getInt("c_id"));
                       }
                }
              
            
             
             
         } catch (SQLException ex) {
             Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        notification = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        studname = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        lecturers_count17 = new javax.swing.JLabel();
        stories = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lecturers_count9 = new javax.swing.JLabel();
        quiz = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lecturers_count11 = new javax.swing.JLabel();
        lectures = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lecturers_count13 = new javax.swing.JLabel();
        games = new javax.swing.JLabel();
        course_ids = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        notification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/notification.png"))); // NOI18N
        notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("STUDENT DASHBOARD");

        studname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        studname.setForeground(new java.awt.Color(255, 255, 255));
        studname.setText("STUDENT NAME HERE");
        studname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studnameMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(studname, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(98, 98, 98)
                .addComponent(notification, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(notification, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studname, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(251, 255, 239));

        btn_logout.setBackground(new java.awt.Color(11, 83, 148));
        btn_logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setText("LOGOUT");
        btn_logout.setBorder(null);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(251, 255, 239));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lecturers_count17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lecturers_count17.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecturers_count17.setText("STORIES");
        lecturers_count17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count17MouseEntered(evt);
            }
        });
        jPanel14.add(lecturers_count17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 180, 30));

        stories.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Stories.png"))); // NOI18N
        stories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                storiesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                storiesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                storiesMouseExited(evt);
            }
        });
        jPanel14.add(stories, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 200, 210));

        jPanel9.setBackground(new java.awt.Color(251, 255, 239));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lecturers_count9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lecturers_count9.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecturers_count9.setText("TAKE QUIZ");
        lecturers_count9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count9MouseEntered(evt);
            }
        });
        jPanel9.add(lecturers_count9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 160, 30));

        quiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/quiz.png"))); // NOI18N
        quiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quizMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                quizMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                quizMouseExited(evt);
            }
        });
        jPanel9.add(quiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 210, 210));

        jPanel10.setBackground(new java.awt.Color(251, 255, 239));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lecturers_count11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lecturers_count11.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecturers_count11.setText("LECTURES");
        lecturers_count11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count11MouseEntered(evt);
            }
        });
        jPanel10.add(lecturers_count11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 140, 30));

        lectures.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lecture.png"))); // NOI18N
        lectures.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lecturesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lecturesMouseExited(evt);
            }
        });
        jPanel10.add(lectures, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 200, 210));

        jPanel12.setBackground(new java.awt.Color(251, 255, 239));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lecturers_count13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lecturers_count13.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecturers_count13.setText("GAMES");
        lecturers_count13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count13MouseEntered(evt);
            }
        });
        jPanel12.add(lecturers_count13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 180, 30));

        games.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/game.png"))); // NOI18N
        games.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gamesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gamesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gamesMouseExited(evt);
            }
        });
        jPanel12.add(games, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 200, 210));

        course_ids.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(course_ids, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(course_ids, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseClicked
        //        if (glassPanePopup == null || !glassPanePopup.isVisible()) {
            //            glassPanePopup = new GlassPanePopup();
            //            setGlassPane(glassPanePopup);
            //            glassPanePopup.showPopup(NoticeDatabase.getNotices());
            //            getGlassPane().setVisible(true);
            //  }
    }//GEN-LAST:event_notificationMouseClicked

    private void studnameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studnameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_studnameMouseEntered

    private void storiesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storiesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_storiesMouseExited

    private void storiesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storiesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_storiesMouseEntered

    private void storiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storiesMouseClicked
//         SelectGames sp = new SelectGames();
//        this.dispose();
//        sp.setVisible(true);
    }//GEN-LAST:event_storiesMouseClicked

    private void lecturers_count17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count17MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count17MouseEntered

    private void gamesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gamesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_gamesMouseExited

    private void gamesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gamesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_gamesMouseEntered

    private void gamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gamesMouseClicked
        SelectGames sp = new SelectGames();
        this.dispose();
        sp.setVisible(true);
    }//GEN-LAST:event_gamesMouseClicked

    private void lecturers_count13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count13MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count13MouseEntered

    private void lecturesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturesMouseExited

    private void lecturesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturesMouseEntered

    private void lecturesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturesMouseClicked
        TakeLectures tl = new TakeLectures(id);
        this.dispose();
        tl.setVisible(true);
        
    }//GEN-LAST:event_lecturesMouseClicked

    private void lecturers_count11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count11MouseEntered

    private void quizMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quizMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_quizMouseExited

    private void quizMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quizMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_quizMouseEntered

    private void quizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quizMouseClicked
        if(quizcheck){
           TakeQuiz tq = new TakeQuiz(id,course_idslist);
            
            tq.setVisible(true);
            this.dispose();
        }else{
             int result = JOptionPane.showConfirmDialog(this, "You have not seen the lectures yet do you want to see the lectures?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                
                TakeLectures tl = new TakeLectures(id);
                tl.setVisible(true);
                this.dispose();
            }
        }
        
    }//GEN-LAST:event_quizMouseClicked

    private void lecturers_count9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count9MouseEntered

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
            LoginNewGui l = new LoginNewGui();
            l.setVisible(true);

        }
    }//GEN-LAST:event_btn_logoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logout;
    private javax.swing.JComboBox<String> course_ids;
    private javax.swing.JLabel games;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lecturers_count11;
    private javax.swing.JLabel lecturers_count13;
    private javax.swing.JLabel lecturers_count17;
    private javax.swing.JLabel lecturers_count9;
    private javax.swing.JLabel lectures;
    private javax.swing.JLabel notification;
    private javax.swing.JLabel quiz;
    private javax.swing.JLabel stories;
    private javax.swing.JLabel studname;
    // End of variables declaration//GEN-END:variables
}
