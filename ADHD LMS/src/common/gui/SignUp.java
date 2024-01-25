
package common.gui;

import common.code.MyDbConnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JOptionPane;

public class SignUp extends javax.swing.JFrame {
 private MyDbConnector dbConnector;
    Connection connection = null;
    
 
    public SignUp() {
        dbConnector = new MyDbConnector();
         connection = dbConnector.getMyConnection();
   
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        signup_btn = new javax.swing.JButton();
        login_btn = new javax.swing.JButton();
        gender = new javax.swing.JComboBox<>();
        role = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        qual = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel2.setBackground(new java.awt.Color(104, 164, 236));

        jLabel9.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/signupPanel(2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(104, 164, 236));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CREATE ACCOUNT");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 530, -1));

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel5.setText("SELECT YOUR ROLE:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        jLabel8.setText("I'VE AN ACCOUNT");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, 110, 40));

        signup_btn.setBackground(new java.awt.Color(0, 51, 255));
        signup_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signup_btn.setForeground(new java.awt.Color(255, 255, 255));
        signup_btn.setText("SIGN UP");
        signup_btn.setBorder(null);
        signup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_btnActionPerformed(evt);
            }
        });
        jPanel3.add(signup_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, 330, 40));

        login_btn.setBackground(new java.awt.Color(255, 255, 153));
        login_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        login_btn.setText("LOGIN");
        login_btn.setBorder(null);
        login_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });
        jPanel3.add(login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, 220, 41));

        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        jPanel3.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 160, 40));

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Teacher", "Doctor", " " }));
        jPanel3.add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 160, 40));

        jLabel13.setBackground(new java.awt.Color(102, 102, 102));
        jLabel13.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel13.setText("ENTER YOUR FULL NAME:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel14.setBackground(new java.awt.Color(102, 102, 102));
        jLabel14.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel14.setText("ENTER YOUR EMAIL:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel15.setBackground(new java.awt.Color(102, 102, 102));
        jLabel15.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel15.setText("ENTER YOUR PASSWORD:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, -1, -1));

        jLabel16.setBackground(new java.awt.Color(102, 102, 102));
        jLabel16.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel16.setText("GENDER:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, -1));

        jLabel17.setBackground(new java.awt.Color(102, 102, 102));
        jLabel17.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel17.setText("ENTER YOUR QUALIFICATIONS:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        name.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jPanel3.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 332, 40));

        email.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jPanel3.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 332, 40));

        qual.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jPanel3.add(qual, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 332, 40));

        pass.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jPanel3.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 330, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        LoginNewGui lng = new LoginNewGui();
        this.dispose();
        lng.setVisible(true);
    }                                         

    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {                                           
                                             
   try {
    java.util.Date currentDate = Calendar.getInstance().getTime();
    Date sqlDate = new Date(currentDate.getTime());
    String genderr = (String) gender.getSelectedItem();
    String rolee = (String) role.getSelectedItem();

    // Check if the email already exists
    String checkEmailQuery = "SELECT COUNT(*) FROM user WHERE email = ?";
    PreparedStatement checkEmailStmt = connection.prepareStatement(checkEmailQuery);
    checkEmailStmt.setString(1, email.getText());
    
    // Execute the query and retrieve the count
    ResultSet resultSet = checkEmailStmt.executeQuery();
    resultSet.next();
    int emailCount = resultSet.getInt(1);

    if (emailCount > 0) {
        // The email already exists, show an error message
        JOptionPane.showMessageDialog(null, "Email already exists. Please use a different email.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        // The email is unique, proceed with the insert operation

        // Generate a random 3-digit ID
        Random random = new Random();
        int randomId = random.nextInt(900) + 100; // Generates a random number between 100 and 999

        // Insert the new user
        String insertUser = "INSERT INTO user (id, name, email, password, role, registered_date) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(insertUser);
        pstmt.setInt(1, randomId);
        pstmt.setString(2, name.getText());
        pstmt.setString(3, email.getText());
        pstmt.setString(4, pass.getText());
        pstmt.setString(5, rolee);
        pstmt.setDate(6, sqlDate);

        // Execute the update
        pstmt.executeUpdate();

        // Insert role-specific details
        String insertRole = "";
        if (rolee.equals("Teacher")) {
            insertRole = "INSERT INTO " + rolee.toLowerCase() + " (t_id, name, email, qualification, gender) VALUES (?, ?, ?, ?, ?)";
        } else if (rolee.equals("Doctor")) {
            insertRole = "INSERT INTO " + rolee.toLowerCase() + " (d_id, name, email, qualification, gender) VALUES (?, ?, ?, ?, ?)";
        }

        pstmt = connection.prepareStatement(insertRole);
        pstmt.setInt(1, randomId);
        pstmt.setString(2, name.getText());
        pstmt.setString(3, email.getText());
        pstmt.setString(4, qual.getText());
        pstmt.setString(5, genderr);

        // Show a message dialog indicating success
        if (rolee.equals("Teacher")) {
            JOptionPane.showMessageDialog(null, "Account created successfully! Please wait until your details are approved!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (rolee.equals("Doctor")) {
            JOptionPane.showMessageDialog(null, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        // Execute the update
        pstmt.executeUpdate();
        pstmt.close();
        this.dispose();
        LoginNewGui lg = new LoginNewGui();
        lg.setVisible(true);
    }

} catch (SQLException e) {
    e.printStackTrace(); // Handle the exception appropriately
}




    }                                          

   public static void main(String[] args){
       SignUp s = new  SignUp();
       s.setVisible(true);
   }


    // Variables declaration - do not modify                     
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton login_btn;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField qual;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JButton signup_btn;
    // End of variables declaration                   
}
