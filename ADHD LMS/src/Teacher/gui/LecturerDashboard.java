/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher.gui;

import common.code.Auth;
import common.code.MyDbConnector;
import common.code.UserProfile;
import common.gui.LoginNewGui;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import notice.GlassPanePopup;
import notice.NoticeDatabase;

/**
 *
 * @author kavin
 */
public class LecturerDashboard extends javax.swing.JFrame  {
    
    UserProfile loggedUser = Auth.getLoggedUser();
String name = loggedUser.getUsername();
int courseID = loggedUser.getCourseId();
   private String courseName;
    private int standardLevel;
    int tID = loggedUser.getId();
   
    
   public LecturerDashboard(String courseName, int standardLevel) {
        this.courseName = courseName;
        this.standardLevel = standardLevel;
    }
  public String getCourseName() {
        return courseName;
    }

    public int getStandardLevel() {
        return standardLevel;
    }
   
    private String student_count;
    private String courses_count;
    
    private MyDbConnector dbConnector;
    Connection connection = null;
    
    
    private GlassPanePopup glassPanePopup;
    private JPanel contentPane;

    /**
     * Creates new form LecturerDashboard
     */
    public LecturerDashboard() throws SQLException {
        dbConnector = new MyDbConnector();
        connection = dbConnector.getMyConnection();
        initComponents();
          
    LecturerDashboard courseInfo = getCourseInfo(courseID);
    int stdLevel = courseInfo.getStandardLevel();
    this.standardLevel = stdLevel;
    this.courseName = courseName;
    viewstds();
        
    }
    
 public LecturerDashboard getCourseInfo(int courseId) throws SQLException {
    // Assuming you have a database connection
    MyDbConnector dbConnector = new MyDbConnector();
    Connection connection = dbConnector.getMyConnection();

    String courseName = null;
    int stdLevel = 0;
    String query = "SELECT c_name, std_level FROM courses WHERE c_id = ?";

    try (PreparedStatement preStmt = connection.prepareStatement(query)) {
        preStmt.setInt(1, courseId);

        try (ResultSet resultSet = preStmt.executeQuery()) {
            if (resultSet.next()) {
                courseName = resultSet.getString("c_name");
                stdLevel = resultSet.getInt("std_level");
            }
        }
    }

    return new LecturerDashboard(courseName, stdLevel);
}
 
 
public void viewstds() throws SQLException {
    DefaultTableModel model = (DefaultTableModel) viewStd.getModel();
    model.setRowCount(0);
    
    connection = dbConnector.getMyConnection();
    
    StringBuilder sql = new StringBuilder("SELECT s.s_id, s.name as studname, p.name as parentname,s.adhd_type FROM student s,parent p,stdcourse sc where s.p_id = p.p_id and sc.s_id = s.s_id and sc.c_id = ?");
    PreparedStatement stmt = connection.prepareStatement(sql.toString());
    stmt.setInt(1, courseID);
    
    // Retrieve the marks for the student from the database
    ResultSet rs = stmt.executeQuery();
   
    while (rs.next()) {
        
        model.addRow(new Object[]{rs.getInt("s_id"), rs.getString("studname"), rs.getString("parentname"),rs.getString("adhd_type")});
    }

    // Close resources
    rs.close();
    stmt.close();
}
 
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_StdID = new javax.swing.JLabel();
        stdid = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewStd = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        lecturers_count7 = new javax.swing.JLabel();
        lecturers_count8 = new javax.swing.JLabel();
        course3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lecturers_count10 = new javax.swing.JLabel();
        course1 = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        notification = new javax.swing.JLabel();
        lecturers_count13 = new javax.swing.JLabel();

        lbl_StdID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_StdID.setText("Student ID :");

        stdid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdidActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(251, 255, 239));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewStd.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        viewStd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PARENT NAME", "ADHD TYPE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(viewStd);
        if (viewStd.getColumnModel().getColumnCount() > 0) {
            viewStd.getColumnModel().getColumn(0).setPreferredWidth(30);
            viewStd.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 330, 490));

        jPanel8.setBackground(new java.awt.Color(251, 255, 239));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lecturers_count7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lecturers_count7.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecturers_count7.setText("PROGRESS");
        lecturers_count7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count7MouseEntered(evt);
            }
        });
        jPanel8.add(lecturers_count7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 220, 30));

        lecturers_count8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lecturers_count8.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecturers_count8.setText("VIEW ");
        lecturers_count8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count8MouseEntered(evt);
            }
        });
        jPanel8.add(lecturers_count8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 220, 30));

        course3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/reading.png"))); // NOI18N
        course3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                course3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                course3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                course3MouseExited(evt);
            }
        });
        jPanel8.add(course3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 260, 270));

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 300, 270));

        jPanel9.setBackground(new java.awt.Color(251, 255, 239));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lecturers_count10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lecturers_count10.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count10.setText("MARKS");
        lecturers_count10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count10MouseEntered(evt);
            }
        });
        jPanel9.add(lecturers_count10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 140, 30));

        course1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/quality-control.png"))); // NOI18N
        course1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                course1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                course1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                course1MouseExited(evt);
            }
        });
        jPanel9.add(course1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 270));

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 280, 270));

        btn_logout.setBackground(new java.awt.Color(11, 83, 148));
        btn_logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setText("LOGOUT");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        jPanel4.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, 170, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 90, 950, 490));

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("TEACHER DASHBOARD");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 690, 70));

        notification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/notification.png"))); // NOI18N
        notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationMouseClicked(evt);
            }
        });
        jPanel3.add(notification, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, 90));

        lecturers_count13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lecturers_count13.setForeground(new java.awt.Color(255, 255, 255));
        lecturers_count13.setText("TEACHER NAME HERE");
        lecturers_count13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lecturers_count13MouseEntered(evt);
            }
        });
        jPanel3.add(lecturers_count13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 950, 100));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseClicked
        if (glassPanePopup == null || !glassPanePopup.isVisible()) {
            glassPanePopup = new GlassPanePopup();
            setGlassPane(glassPanePopup);
            glassPanePopup.showPopup(NoticeDatabase.getNotices(tID));
            getGlassPane().setVisible(true);
        }
    }//GEN-LAST:event_notificationMouseClicked

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
            LoginNewGui l = new LoginNewGui();
            l.setVisible(true);

        }
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void course1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_course1MouseEntered

    private void course1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_course1MouseExited

    private void course3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_course3MouseEntered

    private void course3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_course3MouseExited

    private void lecturers_count7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count7MouseEntered

    private void lecturers_count10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count10MouseEntered

    private void lecturers_count13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count13MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count13MouseEntered

    private void stdidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stdidActionPerformed

    private void lecturers_count8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecturers_count8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lecturers_count8MouseEntered

    private void course1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course1MouseClicked
        StudentMarks sm = new StudentMarks();
        this.dispose();
        sm.setVisible(true);
    }//GEN-LAST:event_course1MouseClicked

    private void course3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course3MouseClicked
        // TODO add your handling code here:
        this.dispose();
        ViewStudentMedicalReportsParent p = new ViewStudentMedicalReportsParent(tID);
        p.setVisible(true);
    }//GEN-LAST:event_course3MouseClicked

   
  @Override
    public boolean contains(int x, int y) {
        if (glassPanePopup != null && glassPanePopup.isVisible()) {
            Point glassPanePoint = glassPanePopup.getLocationOnScreen();
            Point mousePoint = MouseInfo.getPointerInfo().getLocation();
            Rectangle labelBounds = new Rectangle(glassPanePoint, glassPanePopup.getSize());
            return labelBounds.contains(mousePoint);
        } else {
            return super.contains(x, y);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logout;
    private javax.swing.JLabel course1;
    private javax.swing.JLabel course3;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_StdID;
    private javax.swing.JLabel lecturers_count10;
    private javax.swing.JLabel lecturers_count13;
    private javax.swing.JLabel lecturers_count7;
    private javax.swing.JLabel lecturers_count8;
    private javax.swing.JLabel notification;
    private javax.swing.JTextField stdid;
    private javax.swing.JTable viewStd;
    // End of variables declaration//GEN-END:variables
}
