package common.gui;
import Doctor.DoctorDashboard;
import Parent.ParentDashboard;
import Teacher.gui.LecturerDashboard;
import admin.gui.AdminDashboard;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import common.code.Auth;
import common.code.UserProfile;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import student.StudentDashboard;


public class LoginNewGui extends javax.swing.JFrame {

    String uname, pword;
    private static String role;
    
    public  String getRole(){
        return role;
    }
    
    public LoginNewGui(){
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_psw = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        jLabel17.setBackground(new java.awt.Color(102, 102, 102));
        jLabel17.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel17.setText("ENTER YOUR QUALIFICATIONS:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Right.setBackground(new java.awt.Color(104, 164, 236));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));
        Right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Right.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 173, -1, -1));
        Right.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 132, 263, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/loginPanel(3) (2).png"))); // NOI18N
        Right.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jPanel1.add(Right);
        Right.setBounds(0, 0, 280, 500);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(104, 164, 236));
        jLabel1.setText("LOGIN");

        txt_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_username.setForeground(new java.awt.Color(102, 102, 102));
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });

        txt_psw.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_pswFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_pswFocusLost(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(104, 164, 236));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOGIN");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("I DON'T HAVE AN ACCOUNT");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 204));
        jButton2.setText("SIGNUP");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(102, 102, 102));
        jLabel18.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel18.setText("ENTER YOUR PASSWORD:");

        jLabel19.setBackground(new java.awt.Color(102, 102, 102));
        jLabel19.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel19.setText("ENTER YOUR EMAIL:");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addGap(0, 59, Short.MAX_VALUE)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(LeftLayout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_psw, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_username, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(84, 84, 84))))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_psw, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jPanel1.add(Left);
        Left.setBounds(280, 0, 520, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UsersSignupScreen SignUpFrame = new UsersSignupScreen();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        uname = txt_username.getText();
        pword = txt_psw.getText();
        
        try {
            LoginCheckAndOpenDashboard();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(LoginNewGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
  public void LoginCheckAndOpenDashboard() throws SQLException{
        common.code.Login login = new common.code.Login();
        UserProfile userProfile = login.authenticateUser(uname, pword);
        
        if (userProfile != null) {
            Auth.login(userProfile);
            String userType = userProfile.getRole();
            switch (userType) {
                case "Admin":
                    AdminDashboard dashboard = new AdminDashboard();
                    dashboard.setVisible(true);
                    this.dispose();
                    break;
                case "Teacher":
                    LecturerDashboard lecDash = new LecturerDashboard();
                    lecDash.setVisible(true);
                    this.dispose();
                    break;
                case "Student":
                    StudentDashboard stuDashboard = new StudentDashboard();
                    stuDashboard.setVisible(true);
                    this.dispose();
                    break;
                
                case "Parent" :
                    ParentDashboard pDashboard = new ParentDashboard();
                    pDashboard.setVisible(true);
                    this.dispose();
                    break;
                
                case "Doctor" :
                    DoctorDashboard dDashboard = new DoctorDashboard();
                    dDashboard.setVisible(true);
                    this.dispose();
                    break;
                              
                default:
                    System.out.println("Error..");
            }
        } else {
            txt_psw.setText("");
            txt_username.setText("");
            txt_psw.setEchoChar('\u0000');
            JOptionPane.showMessageDialog(null, "Wrong Email OR Password!");
        }       
    }
    
    private void txt_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusGained
 if(txt_username.getText().equals("EMAIL ADDRESS"))
        {
            txt_username.setText("");
            txt_username.setForeground(new Color(153,153,153));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameFocusGained

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
   if(txt_username.getText().equals(""))
        {
            txt_username.setText("EMAIL ADDRESS");
            txt_username.setForeground(new Color(153,153,153));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameFocusLost

    private void txt_pswFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_pswFocusGained
  if(txt_psw.getText().equals("PASSWORD"))
        {
            txt_psw.setText("");
            txt_psw.setForeground(new Color(153,153,153));
            txt_psw.setEchoChar('\u2022');
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pswFocusGained

    private void txt_pswFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_pswFocusLost
if(txt_psw.getText().equals(""))
        {
            txt_psw.setText("PASSWORD");
            txt_psw.setEchoChar('\u0000');
            txt_psw.setForeground(new Color(153,153,153));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pswFocusLost

  public static void main(String[] args){
        try {
            UIManager.setLookAndFeel( new FlatMaterialLighterIJTheme() );
            LoginNewGui s = new  LoginNewGui();
            s.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoginNewGui.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_psw;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
