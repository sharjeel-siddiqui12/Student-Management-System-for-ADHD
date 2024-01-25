/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import com.mysql.cj.jdbc.Blob;
import common.code.Auth;
import common.code.MyDbConnector;
import common.code.UserProfile;
import java.io.File;
import java.sql.Connection;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Kavindu_Dilhara
 */
public class TakeLectures extends javax.swing.JFrame {
    
  
    private MyDbConnector dbConnector;
    Connection connection = null;
    
        PreparedStatement pstmt = null;
    
    boolean leccheck;
     PreparedStatement preparedStatement ;
     int sid = 0;
      private long startTime;
    private Timer watchTimer;
    String cname;
    UserProfile loggedUser = Auth.getLoggedUser();  
    int slevel = loggedUser.getSLevel();
    int cid = 0;
    String videoPaths;
    String adhdtype = loggedUser.getAdhdtype();
     
    public TakeLectures(int s_id){
         dbConnector = new MyDbConnector();
         connection = dbConnector.getMyConnection();
        initComponents();
        this.sid = s_id;
        checkQuiz();
       
    }
    
    public void checkCNAME(String cname){
       //hyperactive
        if(slevel == 1 && cname.equals("english") && adhdtype.equals("hyperactive") ){
             videoPaths = "english1.mp4";
        }
        else if(slevel == 1 && cname.equals("maths") && adhdtype.equals("hyperactive")){
              videoPaths = "english2.mp4";
        }
        else  if(slevel == 2 && cname.equals("english") && adhdtype.equals("hyperactive")){
              videoPaths = "english3.mp4";
        }
        else if(slevel == 2 && cname.equals("maths") && adhdtype.equals("hyperactive")){
              videoPaths = "maths1.mp4";
        }
        else if(slevel == 3 && cname.equals("english") && adhdtype.equals("hyperactive")){
              videoPaths = "maths2.mp4";
        }
        else if(slevel == 3 && cname.equals("maths") && adhdtype.equals("hyperactive")){
             videoPaths = "maths3.mp4";
        } 
        //inattention
        else if(slevel == 1 && cname.equals("english") && adhdtype.equals("inattention") ){
             videoPaths = "english4.mp4";
        }
        else if(slevel == 1 && cname.equals("maths") && adhdtype.equals("inattention")){
              videoPaths = "english5.mp4";
        }
        else  if(slevel == 2 && cname.equals("english") && adhdtype.equals("inattention")){
              videoPaths = "english6.mp4";
        }
        else if(slevel == 2 && cname.equals("maths") && adhdtype.equals("inattention")){
              videoPaths = "maths4.mp4";
        }
        else if(slevel == 3 && cname.equals("english") && adhdtype.equals("inattention")){
              videoPaths = "maths5.mp4";
        }
        else if(slevel == 3 && cname.equals("maths") && adhdtype.equals("inattention")){
             videoPaths = "maths6.mp4";
        }
        
        //inattention
        else if(slevel == 1 && cname.equals("english") && adhdtype.equals("impulsive") ){
             videoPaths = "english7.mp4";
        }
        else if(slevel == 1 && cname.equals("maths") && adhdtype.equals("impulsive")){
              videoPaths = "english8.mp4";
        }
        else  if(slevel == 2 && cname.equals("english") && adhdtype.equals("impulsive")){
              videoPaths = "english9.mp4";
        }
        else if(slevel == 2 && cname.equals("maths") && adhdtype.equals("impulsive")){
              videoPaths = "maths7.mp4";
        }
        else if(slevel == 3 && cname.equals("english") && adhdtype.equals("impulsive")){
              videoPaths = "maths8.mp4";
        }
        else if(slevel == 3 && cname.equals("maths") && adhdtype.equals("impulsive")){
             videoPaths = "maths9.mp4";
        }
    }
    
    public void removeStar(String cname){
     if("english".equals(cname.toLowerCase())){
                        engstar.setText("");
                    }else if("maths".equals(cname.toLowerCase())){
                        mathstar.setText("");
                    }
    }
    
     public void checkQuiz(){
         try {
             String sql="";
             ResultSet rs;
             sql = "select c_name from lecture l , courses c where s_id = ? and watch_time > 3 and c.c_id = l.c_id";
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setInt(1,  sid);
             rs = preparedStatement.executeQuery();
              if (rs.next()) {
                    removeStar(rs.getString(1));
                }
             
             
         } catch (SQLException ex) {
             Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        view_ass_btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_Bck1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        mathslabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        englabel = new javax.swing.JLabel();
        mathbtn = new javax.swing.JButton();
        engstar = new javax.swing.JLabel();
        mathstar = new javax.swing.JLabel();
        engbtn1 = new javax.swing.JButton();

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
        setPreferredSize(new java.awt.Dimension(390, 400));
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
        jLabel18.setText("TAKE LECTURES");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 380, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 100));

        jPanel2.setBackground(new java.awt.Color(248, 248, 241));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(248, 248, 241));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mathslabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mathslabel.setText("Maths");
        jPanel3.add(mathslabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 80, 40));

        jPanel6.setBackground(new java.awt.Color(248, 248, 241));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/courseIcon.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 320, 190));

        englabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        englabel.setText("English");
        jPanel3.add(englabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 80, 40));

        mathbtn.setBackground(new java.awt.Color(51, 153, 255));
        mathbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mathbtn.setForeground(new java.awt.Color(255, 255, 255));
        mathbtn.setText("PLAY VIDEO");
        mathbtn.setBorder(null);
        mathbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mathbtnActionPerformed(evt);
            }
        });
        jPanel3.add(mathbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 260, 50));

        engstar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        engstar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        engstar.setText("*");
        jPanel3.add(engstar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 20, 50));

        mathstar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mathstar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mathstar.setText("*");
        jPanel3.add(mathstar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 20, 50));

        engbtn1.setBackground(new java.awt.Color(51, 153, 255));
        engbtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        engbtn1.setForeground(new java.awt.Color(255, 255, 255));
        engbtn1.setText("PLAY VIDEO");
        engbtn1.setBorder(null);
        engbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engbtn1ActionPerformed(evt);
            }
        });
        jPanel3.add(engbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 260, 50));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 260));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 750, 250));

        setSize(new java.awt.Dimension(765, 356));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BckMouseClicked
         StudentDashboard sd = new StudentDashboard();
        sd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_BckMouseClicked

    
    private void view_ass_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_ass_btnActionPerformed

    }//GEN-LAST:event_view_ass_btnActionPerformed

    private void mathbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mathbtnActionPerformed
       someMethod("maths");
       
    }//GEN-LAST:event_mathbtnActionPerformed

    private void engbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engbtn1ActionPerformed
       
         someMethod("english");
    }//GEN-LAST:event_engbtn1ActionPerformed
  
public void someMethod(String cname) {
    checkCNAME(cname);
    int cid2 = getCID(cname);

    if (cid2 != 0) {
        startWatchTimer(cid2);
        playVideo(videoPaths);
    } else {
        // Handle the case where getCID() returns 0
        System.out.println("CID is 0. Unable to proceed.");
    }
}

public int getCID(String cname) {
    int cid = 0; // Initialize to a default value

    try (Connection connection = dbConnector.getMyConnection();
         PreparedStatement pstmt = connection.prepareStatement("SELECT c_id FROM courses WHERE c_name = ? AND std_level = ?")) {
        
        pstmt.setString(1, cname);
        pstmt.setInt(2, slevel);

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                cid = rs.getInt(1);
                System.out.println("CID: " + cid);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    return cid;
}


    private void startWatchTimer(int lectureId) {
    startTime = System.currentTimeMillis();
    watchTimer = new Timer();
    watchTimer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            long elapsedTime = System.currentTimeMillis() - startTime;
            long elapsedMinutes = elapsedTime / (60 * 1000);
            
        System.out.println(lectureId +  elapsedMinutes);
            // Update watch time in the database every minute
            updateWatchTimeInDatabase(lectureId, elapsedMinutes);

            if (elapsedMinutes >= 3) {
                showCompletionPopup();
                stopWatchTimer();
                updateStatusInDatabase(lectureId); // Update status to completed in database
            }
        }
    }, 0, 60 * 1000); // Check every minute
}
    
    private void updateWatchTimeInDatabase(int lectureId, long elapsedMinutes) {
    try {
       
        // Update watch time in the database
        String updateSQL = "UPDATE lecture SET watch_time = ? WHERE c_id = ? and s_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(updateSQL);
        pstmt.setLong(1, elapsedMinutes);
        pstmt.setInt(2, lectureId);
        pstmt.setInt(3, sid);
        pstmt.executeUpdate();

        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void stopWatchTimer() {
        if (watchTimer != null) {
            watchTimer.cancel();
            watchTimer = null;
        }
    }

    private void playVideo(String videoPath) {
        try {
            File videoFile = new File(videoPath);
            System.out.println(videoFile);
            if (videoFile.exists()) {
                // Use the Desktop class to open the default media player
                Desktop.getDesktop().open(videoFile);
            } else {
                JOptionPane.showMessageDialog(this, "Video file not found: " + videoPath, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error opening video: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateStatusInDatabase(int lectureId) {
        try {

            // Update status to completed
            String updateSQL = "UPDATE lecture SET status = 'completed' WHERE c_id = ? and s_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(updateSQL);
            pstmt.setInt(1, lectureId);
        pstmt.setInt(2, sid);
            pstmt.executeUpdate();

            System.out.println("Status updated to completed successfully.");

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showCompletionPopup() {
        JOptionPane.showMessageDialog(this, "3 minutes completed!", "Watch Time Completion", JOptionPane.INFORMATION_MESSAGE);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_Bck1;
    private javax.swing.JButton engbtn1;
    private javax.swing.JLabel englabel;
    private javax.swing.JLabel engstar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton mathbtn;
    private javax.swing.JLabel mathslabel;
    private javax.swing.JLabel mathstar;
    private javax.swing.JButton view_ass_btn;
    // End of variables declaration//GEN-END:variables
}
