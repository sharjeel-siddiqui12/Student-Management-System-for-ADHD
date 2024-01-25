/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import common.code.Auth;
import common.code.MyDbConnector;
import common.code.UserProfile;
import common.gui.LoginNewGui;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class DoctorDashboard extends javax.swing.JFrame  {

    UserProfile loggedUser = Auth.getLoggedUser();   
    String doctorname = loggedUser.getUsername();
    
     private MyDbConnector dbConnector;
    Connection connection = null;
    
    public DoctorDashboard() throws SQLException {
        dbConnector = new MyDbConnector();
        initComponents();
        viewstds();
       docname.setText(doctorname);
    }


public void viewstds() throws SQLException {
    DefaultTableModel model = (DefaultTableModel) viewStd.getModel();
    model.setRowCount(0);
    
    connection = dbConnector.getMyConnection();
    
    StringBuilder sql = new StringBuilder("SELECT s.s_id as sid, name, s_level,s.adhd_type as  adtype,medicine FROM student s left join student_prescription sp  on s.s_id = sp.s_id");
    PreparedStatement stmt = connection.prepareStatement(sql.toString());
    
    // Retrieve the marks for the student from the database
    ResultSet rs = stmt.executeQuery();
  
    while (rs.next()) {
        
                    String medicine = rs.getString("medicine");
                     String medicineValue = (medicine != null) ? medicine : "Not Done Yet";
       
        model.addRow(new Object[]{rs.getInt("sid"), rs.getString("name"), rs.getString("adtype"),medicineValue});
    }

    // Close resources
    rs.close();
    stmt.close();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        course3 = new javax.swing.JLabel();
        lecturers_count7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lecturers_count8 = new javax.swing.JLabel();
        course4 = new javax.swing.JLabel();
        lecturers_count12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        notification = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        docname = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewStd = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        lecturers_count11 = new javax.swing.JLabel();
        lecturers_count14 = new javax.swing.JLabel();
        view_report_btn = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        STUDENT = new javax.swing.JLabel();
        lecturers_count15 = new javax.swing.JLabel();
        prescribebtn = new javax.swing.JLabel();
        btn_logout1 = new javax.swing.JButton();

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

        jPanel8.setBackground(new java.awt.Color(251, 255, 239));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lecturers_count8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lecturers_count8.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count8.setText("VIEW PROGRESS");
        lecturers_count8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count8MouseEntered(evt);
            }
        });
        jPanel8.add(lecturers_count8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 200, 30));

        course4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/reading.png"))); // NOI18N
        course4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                course4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                course4MouseExited(evt);
            }
        });
        jPanel8.add(course4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 260, 270));

        lecturers_count12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lecturers_count12.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count12.setText("STUDENT NAME HERE");
        lecturers_count12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count12MouseEntered(evt);
            }
        });
        jPanel8.add(lecturers_count12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 190, 30));

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
        jLabel18.setText("DOCTOR DASHBOARD");

        docname.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        docname.setForeground(new java.awt.Color(255, 255, 255));
        docname.setText("DOCTOR NAME HERE");
        docname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                docnameMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(docname, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(notification, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
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
                    .addComponent(docname, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 100));

        jPanel2.setBackground(new java.awt.Color(251, 255, 239));

        viewStd.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        viewStd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "TYPE OF ADHD", "PRESCRIPTION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(viewStd);

        jPanel9.setBackground(new java.awt.Color(251, 255, 239));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lecturers_count11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lecturers_count11.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count11.setText("REPORT");
        lecturers_count11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count11MouseEntered(evt);
            }
        });
        jPanel9.add(lecturers_count11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 150, 30));

        lecturers_count14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lecturers_count14.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count14.setText("VIEW");
        lecturers_count14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count14MouseEntered(evt);
            }
        });
        jPanel9.add(lecturers_count14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 100, 30));

        view_report_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/reading.png"))); // NOI18N
        view_report_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_report_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view_report_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view_report_btnMouseExited(evt);
            }
        });
        jPanel9.add(view_report_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 260, 270));

        jPanel10.setBackground(new java.awt.Color(251, 255, 239));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        STUDENT.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        STUDENT.setForeground(new java.awt.Color(255, 255, 255));
        STUDENT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        STUDENT.setText("STUDENT");
        STUDENT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                STUDENTMouseEntered(evt);
            }
        });
        jPanel10.add(STUDENT, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 200, 30));

        lecturers_count15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lecturers_count15.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecturers_count15.setText("PRESCRIBE");
        lecturers_count15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count15MouseEntered(evt);
            }
        });
        jPanel10.add(lecturers_count15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 240, 30));

        prescribebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/reports(doctor).png"))); // NOI18N
        prescribebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prescribebtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                prescribebtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prescribebtnMouseExited(evt);
            }
        });
        jPanel10.add(prescribebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 260, 270));

        btn_logout1.setBackground(new java.awt.Color(11, 83, 148));
        btn_logout1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_logout1.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout1.setText("LOGOUT");
        btn_logout1.setBorder(null);
        btn_logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btn_logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1060, 440));

        setSize(new java.awt.Dimension(1073, 542));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseClicked
      
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

    private void docnameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docnameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_docnameMouseEntered

    private void lecturers_count8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count8MouseEntered

    private void course4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_course4MouseEntered

    private void course4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_course4MouseExited

    private void lecturers_count12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count12MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count12MouseEntered

    private void lecturers_count11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count11MouseEntered

    private void view_report_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_report_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_view_report_btnMouseEntered

    private void view_report_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_report_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_view_report_btnMouseExited

    private void lecturers_count14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count14MouseEntered

    private void view_report_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_report_btnMouseClicked
    
        // A row is selected, get the data from the selected row
        DefaultTableModel model = (DefaultTableModel) viewStd.getModel();
        Prescription_Details pd;
        ViewStudentMedicalReports vtmr = new ViewStudentMedicalReports();
        vtmr.setVisible(true);
        this.dispose();
        
     
    }//GEN-LAST:event_view_report_btnMouseClicked

    private void STUDENTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STUDENTMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_STUDENTMouseEntered

    private void lecturers_count15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count15MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count15MouseEntered

    private void prescribebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prescribebtnMouseClicked
       int selectedRow = viewStd.getSelectedRow();

    if (selectedRow == -1) {
        // No row is selected, show a message dialog
        JOptionPane.showMessageDialog(null, "Please select any student from the table before clicking the button", "No Row Selected", JOptionPane.WARNING_MESSAGE);
    } else {
        // A row is selected, get the data from the selected row
        DefaultTableModel model = (DefaultTableModel) viewStd.getModel();

        int s_id = (int) model.getValueAt(selectedRow, 0);
        String name = (String) model.getValueAt(selectedRow, 1);
        String adhd_type = (String) model.getValueAt(selectedRow, 2);
        String  severity = (String) model.getValueAt(selectedRow, 3);
        
        Prescription_Details pd;
        try {
            pd = new Prescription_Details(s_id, name, adhd_type,severity);
            pd.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        
     }
    }//GEN-LAST:event_prescribebtnMouseClicked

    private void prescribebtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prescribebtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_prescribebtnMouseEntered

    private void prescribebtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prescribebtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_prescribebtnMouseExited

    private void btn_logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout1ActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
            LoginNewGui l = new LoginNewGui();
            l.setVisible(true);
        }
    }//GEN-LAST:event_btn_logout1ActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DoctorDashboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel STUDENT;
    private javax.swing.JButton btn_logout1;
    private javax.swing.JLabel course3;
    private javax.swing.JLabel course4;
    private javax.swing.JLabel docname;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lecturers_count11;
    private javax.swing.JLabel lecturers_count12;
    private javax.swing.JLabel lecturers_count14;
    private javax.swing.JLabel lecturers_count15;
    private javax.swing.JLabel lecturers_count7;
    private javax.swing.JLabel lecturers_count8;
    private javax.swing.JLabel notification;
    private javax.swing.JLabel prescribebtn;
    private javax.swing.JTable viewStd;
    private javax.swing.JLabel view_report_btn;
    // End of variables declaration//GEN-END:variables
}
