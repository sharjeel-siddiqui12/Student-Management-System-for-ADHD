/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parent;

import common.code.Auth;
import common.code.UserProfile;
import common.gui.LoginNewGui;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import notice.GlassPanePopup;

/**
 *
 * @author user
 */
public class ParentDashboard extends javax.swing.JFrame  {

    
    UserProfile loggedUser = Auth.getLoggedUser();  
    String name = loggedUser.getUsername();
    int pid = loggedUser.getId();
   
    
    private GlassPanePopup glassPanePopup;
    private JPanel contentPane;
    
    public ParentDashboard() {
        initComponents();
        pname.setText(name);
        System.out.println(pid);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        course3 = new javax.swing.JLabel();
        lecturers_count7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        notification = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pname = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        lecturers_count19 = new javax.swing.JLabel();
        lecturers_count20 = new javax.swing.JLabel();
        course11 = new javax.swing.JLabel();

        course3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/reading.png"))); // NOI18N
        course3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                course3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                course3MouseExited(evt);
            }
        });

        lecturers_count7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lecturers_count7.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count7.setText("STUDENTS");
        lecturers_count7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count7MouseEntered(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel18.setText("PARENT DASHBOARD");

        pname.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        pname.setForeground(new java.awt.Color(255, 255, 255));
        pname.setText("PNAME");
        pname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnameMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notification, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(278, 278, 278))
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
                    .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 100));

        jPanel2.setBackground(new java.awt.Color(251, 255, 239));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_logout.setBackground(new java.awt.Color(11, 83, 148));
        btn_logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setText("LOGOUT");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        jPanel2.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, 160, 50));

        jPanel14.setBackground(new java.awt.Color(251, 255, 239));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lecturers_count19.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lecturers_count19.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecturers_count19.setText("MEDICAL");
        lecturers_count19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count19MouseEntered(evt);
            }
        });
        jPanel14.add(lecturers_count19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 240, 30));

        lecturers_count20.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lecturers_count20.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecturers_count20.setText("REPORT");
        lecturers_count20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count20MouseEntered(evt);
            }
        });
        jPanel14.add(lecturers_count20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 240, 30));

        course11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/prescription.png"))); // NOI18N
        course11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                course11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                course11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                course11MouseExited(evt);
            }
        });
        jPanel14.add(course11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 280));

        jPanel2.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 880, 450));

        setSize(new java.awt.Dimension(892, 558));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseClicked
//        if (glassPanePopup == null || !glassPanePopup.isVisible()) {
//            glassPanePopup = new GlassPanePopup();
//            setGlassPane(glassPanePopup);
//            glassPanePopup.showPopup(NoticeDatabase.getNotices());
//            getGlassPane().setVisible(true);
//        }
    }//GEN-LAST:event_notificationMouseClicked

    private void course3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_course3MouseEntered

    private void course3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_course3MouseExited

    private void lecturers_count7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count7MouseEntered

    private void pnameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pnameMouseEntered

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
            LoginNewGui l = new LoginNewGui();
            l.setVisible(true);

        }
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void lecturers_count19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count19MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count19MouseEntered

    private void lecturers_count20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count20MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count20MouseEntered

    private void course11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course11MouseClicked
       ViewStudentMedicalReportsParent vsmr = new ViewStudentMedicalReportsParent(pid);
       this.dispose();
       vsmr.setVisible(true);
    }//GEN-LAST:event_course11MouseClicked

    private void course11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_course11MouseEntered

    private void course11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_course11MouseExited

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logout;
    private javax.swing.JLabel course11;
    private javax.swing.JLabel course3;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lecturers_count19;
    private javax.swing.JLabel lecturers_count20;
    private javax.swing.JLabel lecturers_count7;
    private javax.swing.JLabel notification;
    private javax.swing.JLabel pname;
    // End of variables declaration//GEN-END:variables
}
