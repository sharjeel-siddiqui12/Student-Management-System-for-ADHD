/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Parent;
import common.code.Auth;
import java.sql.Connection;
import common.code.MyDbConnector;
import common.code.UserProfile;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
//import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.ResultSet;

public class Parent_SignUp extends javax.swing.JFrame {
        Random random = new Random();
        public int parent_randomId = random.nextInt(900) + 100; // Generates a random number between 100 and 999
        public int child_randomId = random.nextInt(900) + 100;
         java.util.Date currentDate = Calendar.getInstance().getTime();
        Date sqlDate;
        public int hyperactivecount = 0;
        public int inattentioncount = 0;
        public int impulsivecount = 0;
 private MyDbConnector dbConnector;
    Connection connection = null;
    
    public Parent_SignUp() {
         dbConnector = new MyDbConnector();
          connection = dbConnector.getMyConnection();
          
        initComponents();

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        q1 = new javax.swing.ButtonGroup();
        q2 = new javax.swing.ButtonGroup();
        q3 = new javax.swing.ButtonGroup();
        q4 = new javax.swing.ButtonGroup();
        q5 = new javax.swing.ButtonGroup();
        hq1 = new javax.swing.ButtonGroup();
        hq2 = new javax.swing.ButtonGroup();
        hq3 = new javax.swing.ButtonGroup();
        hq4 = new javax.swing.ButtonGroup();
        hq5 = new javax.swing.ButtonGroup();
        eq2 = new javax.swing.ButtonGroup();
        eq1 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        ex1 = new javax.swing.ButtonGroup();
        ex1a = new javax.swing.ButtonGroup();
        ex2 = new javax.swing.ButtonGroup();
        ex2a = new javax.swing.ButtonGroup();
        ex3 = new javax.swing.ButtonGroup();
        ex3a = new javax.swing.ButtonGroup();
        Card_Panel = new javax.swing.JPanel();
        Parent_Details = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        pcontact = new javax.swing.JTextField();
        crelation = new javax.swing.JComboBox<>();
        parent_next = new javax.swing.JButton();
        Child_Details = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cname = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        child_next = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        cpass = new javax.swing.JPasswordField();
        jLabel30 = new javax.swing.JLabel();
        c_prev = new javax.swing.JButton();
        cemail = new javax.swing.JTextField();
        cgender = new javax.swing.JComboBox<>();
        cage = new com.toedter.calendar.JDateChooser();
        Hyperactive_Syptom = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        hyperactive_next = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        q1a = new javax.swing.JRadioButton();
        q1b = new javax.swing.JRadioButton();
        q1c = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        q2a = new javax.swing.JRadioButton();
        q2b = new javax.swing.JRadioButton();
        q2c = new javax.swing.JRadioButton();
        q3a = new javax.swing.JRadioButton();
        q3b = new javax.swing.JRadioButton();
        jLabel33 = new javax.swing.JLabel();
        q3c = new javax.swing.JRadioButton();
        jLabel34 = new javax.swing.JLabel();
        q4b = new javax.swing.JRadioButton();
        q4c = new javax.swing.JRadioButton();
        q4a = new javax.swing.JRadioButton();
        q5b = new javax.swing.JRadioButton();
        jLabel35 = new javax.swing.JLabel();
        q5c = new javax.swing.JRadioButton();
        q5a = new javax.swing.JRadioButton();
        Implulsive_Syptom = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        Impulsive_next = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        qc1 = new javax.swing.JRadioButton();
        qc2 = new javax.swing.JRadioButton();
        qc3 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        qc4 = new javax.swing.JRadioButton();
        qc5 = new javax.swing.JRadioButton();
        qc6 = new javax.swing.JRadioButton();
        qc7 = new javax.swing.JRadioButton();
        qc8 = new javax.swing.JRadioButton();
        jLabel39 = new javax.swing.JLabel();
        qc9 = new javax.swing.JRadioButton();
        jLabel40 = new javax.swing.JLabel();
        qc11 = new javax.swing.JRadioButton();
        qc10 = new javax.swing.JRadioButton();
        jLabel41 = new javax.swing.JLabel();
        qc12 = new javax.swing.JRadioButton();
        qc13 = new javax.swing.JRadioButton();
        qc14 = new javax.swing.JRadioButton();
        qc15 = new javax.swing.JRadioButton();
        Inattention_Syptom = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        in1 = new javax.swing.JRadioButton();
        in2 = new javax.swing.JRadioButton();
        in3 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        in4 = new javax.swing.JRadioButton();
        in5 = new javax.swing.JRadioButton();
        in6 = new javax.swing.JRadioButton();
        in7 = new javax.swing.JRadioButton();
        in8 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        in9 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        in11 = new javax.swing.JRadioButton();
        in12 = new javax.swing.JRadioButton();
        in10 = new javax.swing.JRadioButton();
        in14 = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        in15 = new javax.swing.JRadioButton();
        in13 = new javax.swing.JRadioButton();
        ExtraQuestionImpulsiveInattention = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        ei1 = new javax.swing.JRadioButton();
        ei2 = new javax.swing.JRadioButton();
        ei3 = new javax.swing.JRadioButton();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        ei4 = new javax.swing.JRadioButton();
        ei5 = new javax.swing.JRadioButton();
        ei6 = new javax.swing.JRadioButton();
        jLabel81 = new javax.swing.JLabel();
        ExtraQuestionHyperInattention = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        ei11 = new javax.swing.JRadioButton();
        ei12 = new javax.swing.JRadioButton();
        ei13 = new javax.swing.JRadioButton();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        ei14 = new javax.swing.JRadioButton();
        ei15 = new javax.swing.JRadioButton();
        ei16 = new javax.swing.JRadioButton();
        jLabel71 = new javax.swing.JLabel();
        ExtraQuestionHyperImpulsive = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        ei21 = new javax.swing.JRadioButton();
        ei22 = new javax.swing.JRadioButton();
        ei23 = new javax.swing.JRadioButton();
        jLabel58 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        ei24 = new javax.swing.JRadioButton();
        ei25 = new javax.swing.JRadioButton();
        ei26 = new javax.swing.JRadioButton();
        jLabel61 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Card_Panel.setLayout(new java.awt.CardLayout());

        Parent_Details.setBackground(new java.awt.Color(255, 255, 255));
        Parent_Details.setMaximumSize(new java.awt.Dimension(800, 469));
        Parent_Details.setMinimumSize(new java.awt.Dimension(800, 468));
        Parent_Details.setPreferredSize(new java.awt.Dimension(850, 506));

        jPanel2.setBackground(new java.awt.Color(104, 164, 236));
        jPanel2.setMaximumSize(new java.awt.Dimension(308, 506));
        jPanel2.setMinimumSize(new java.awt.Dimension(308, 506));
        jPanel2.setPreferredSize(new java.awt.Dimension(248, 467));

        jLabel9.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/parentDetails.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addGap(88, 88, 88)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(514, 506));
        jPanel3.setPreferredSize(new java.awt.Dimension(514, 506));

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(104, 164, 236));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PARENT DETAILS");

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Parent Name");

        pname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pname.setForeground(new java.awt.Color(102, 102, 102));

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Parent Email");

        pemail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pemail.setForeground(new java.awt.Color(102, 102, 102));

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Parent Password");

        pass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pass.setForeground(new java.awt.Color(102, 102, 102));
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Parent Contact No");

        jLabel28.setBackground(new java.awt.Color(102, 102, 102));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Relation");

        pcontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcontactActionPerformed(evt);
            }
        });

        crelation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Father", "Mother", "Sibling", "Guardian" }));
        crelation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crelationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pname)
                            .addComponent(crelation, 0, 332, Short.MAX_VALUE)
                            .addComponent(pemail)
                            .addComponent(pass)
                            .addComponent(pcontact))))
                .addGap(69, 69, 69))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pname)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pemail)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pcontact)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crelation, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        parent_next.setBackground(new java.awt.Color(104, 164, 236));
        parent_next.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        parent_next.setForeground(new java.awt.Color(255, 255, 255));
        parent_next.setText("NEXT");
        parent_next.setBorder(null);
        parent_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parent_nextMouseClicked(evt);
            }
        });
        parent_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parent_nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Parent_DetailsLayout = new javax.swing.GroupLayout(Parent_Details);
        Parent_Details.setLayout(Parent_DetailsLayout);
        Parent_DetailsLayout.setHorizontalGroup(
            Parent_DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Parent_DetailsLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Parent_DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Parent_DetailsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Parent_DetailsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(parent_next, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        Parent_DetailsLayout.setVerticalGroup(
            Parent_DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Parent_DetailsLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(parent_next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(146, 146, 146))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );

        Card_Panel.add(Parent_Details, "card2");

        Child_Details.setBackground(new java.awt.Color(255, 255, 255));
        Child_Details.setMaximumSize(new java.awt.Dimension(800, 499));
        Child_Details.setMinimumSize(new java.awt.Dimension(800, 499));
        Child_Details.setPreferredSize(new java.awt.Dimension(800, 499));

        jPanel8.setBackground(new java.awt.Color(104, 164, 236));
        jPanel8.setFocusable(false);

        jLabel17.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/stdDetails.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jLabel16))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jLabel16)
                .addGap(95, 95, 95)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(561, 382));

        jLabel18.setBackground(new java.awt.Color(0, 102, 102));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(104, 164, 236));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("CHILD DETAILS");

        jLabel19.setBackground(new java.awt.Color(102, 102, 102));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Child Name");

        cname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cname.setForeground(new java.awt.Color(102, 102, 102));

        jLabel20.setBackground(new java.awt.Color(102, 102, 102));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Child Date Of Birth");

        jLabel21.setBackground(new java.awt.Color(102, 102, 102));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Child Email");

        child_next.setBackground(new java.awt.Color(104, 164, 236));
        child_next.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        child_next.setForeground(new java.awt.Color(255, 255, 255));
        child_next.setText("NEXT");
        child_next.setBorder(null);
        child_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                child_nextMouseClicked(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(102, 102, 102));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Child Password");

        cpass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cpass.setForeground(new java.awt.Color(102, 102, 102));
        cpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpassActionPerformed(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(102, 102, 102));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Child Gender");

        c_prev.setBackground(new java.awt.Color(104, 164, 236));
        c_prev.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_prev.setForeground(new java.awt.Color(255, 255, 255));
        c_prev.setText("PREVIOUS");
        c_prev.setBorder(null);
        c_prev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_prevMouseClicked(evt);
            }
        });
        c_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_prevActionPerformed(evt);
            }
        });

        cgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male ", "Female", "Others" }));

        cage.setMaximumSize(new java.awt.Dimension(82, 22));
        cage.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cageAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel30)
                            .addComponent(jLabel29))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpass)
                            .addComponent(cemail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cgender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(c_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(child_next, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel18)
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel20))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(cage, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(cgender, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cemail, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cpass, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(child_next, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Child_DetailsLayout = new javax.swing.GroupLayout(Child_Details);
        Child_Details.setLayout(Child_DetailsLayout);
        Child_DetailsLayout.setHorizontalGroup(
            Child_DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Child_DetailsLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Child_DetailsLayout.setVerticalGroup(
            Child_DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );

        Card_Panel.add(Child_Details, "card2");

        Hyperactive_Syptom.setBackground(new java.awt.Color(255, 255, 255));
        Hyperactive_Syptom.setPreferredSize(new java.awt.Dimension(860, 690));

        jPanel10.setBackground(new java.awt.Color(104, 164, 236));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/hyperactive__2_-removebg-preview.png"))); // NOI18N
        jPanel10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 210, 300, 430));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("INSTRUCTIONS");
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 30));

        jLabel14.setBackground(new java.awt.Color(104, 164, 236));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("1 = Never Happens");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 30));

        jLabel42.setBackground(new java.awt.Color(104, 164, 236));
        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("2 = Often Happens");
        jPanel10.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 200, 30));

        jLabel43.setBackground(new java.awt.Color(104, 164, 236));
        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("3 = Always Happens");
        jPanel10.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 30));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setBackground(new java.awt.Color(104, 164, 236));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(104, 164, 236));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("CHILD HYPERACTIVE SYMPTOMS DETAILS");

        hyperactive_next.setBackground(new java.awt.Color(104, 164, 236));
        hyperactive_next.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hyperactive_next.setForeground(new java.awt.Color(255, 255, 255));
        hyperactive_next.setText("NEXT");
        hyperactive_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hyperactive_nextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hyperactive_nextMouseEntered(evt);
            }
        });
        hyperactive_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hyperactive_nextActionPerformed(evt);
            }
        });

        prev.setBackground(new java.awt.Color(104, 164, 236));
        prev.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prev.setForeground(new java.awt.Color(255, 255, 255));
        prev.setText("PREVIOUS");
        prev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prevMouseClicked(evt);
            }
        });
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        hq1.add(q1a);
        q1a.setText("1");
        q1a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q1aActionPerformed(evt);
            }
        });

        hq1.add(q1b);
        q1b.setText("2");
        q1b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q1bActionPerformed(evt);
            }
        });

        hq1.add(q1c);
        q1c.setText("3");

        jLabel10.setText("<html>Fidgets with or taps hands or feet or squirms in seat.</html>");

        jLabel32.setText("<html>Leaves seat in situations in which it is inappropriate (NOTE: in adolescents or adults may be limited to feelings of restlessness).</html>");

        hq2.add(q2a);
        q2a.setText("1");
        q2a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q2aActionPerformed(evt);
            }
        });

        hq2.add(q2b);
        q2b.setText("2");
        q2b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q2bActionPerformed(evt);
            }
        });

        hq2.add(q2c);
        q2c.setText("3");

        hq3.add(q3a);
        q3a.setText("1");
        q3a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q3aActionPerformed(evt);
            }
        });

        hq3.add(q3b);
        q3b.setText("2");
        q3b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q3bActionPerformed(evt);
            }
        });

        jLabel33.setText("<html>Unable to play or engage in leisure activities quietly.</html>");

        hq3.add(q3c);
        q3c.setText("3");

        jLabel34.setText("<html>Has difficulty playing or engaging in leisure activities quietly.</html>");

        hq4.add(q4b);
        q4b.setText("2");
        q4b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q4bActionPerformed(evt);
            }
        });

        hq4.add(q4c);
        q4c.setText("3");

        hq4.add(q4a);
        q4a.setText("1");
        q4a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q4aActionPerformed(evt);
            }
        });

        hq5.add(q5b);
        q5b.setText("2");
        q5b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q5bActionPerformed(evt);
            }
        });

        jLabel35.setText("<html>Is \"on the go\" or acts as if \"driven by a motor\" (e.g., is unable to be or uncomfortable being still for extended time in restaurants, meetings; may be experienced by others as being restless or difficult to keep up with).</html>"); // NOI18N

        hq5.add(q5c);
        q5c.setText("3");

        hq5.add(q5a);
        q5a.setText("1");
        q5a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q5aActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(q1a)
                        .addGap(166, 166, 166)
                        .addComponent(q1b)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(q1c))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(q2a)
                        .addGap(166, 166, 166)
                        .addComponent(q2b)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(q2c)))
                .addGap(136, 136, 136))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel31))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel33)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(q4a)
                                        .addGap(166, 166, 166)
                                        .addComponent(q4b)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(q3c)
                                    .addComponent(q4c))
                                .addGap(105, 105, 105))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(q3a)
                                        .addGap(166, 166, 166)
                                        .addComponent(q3b))
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(250, 250, 250)
                                            .addComponent(hyperactive_next, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                            .addGap(29, 29, 29)
                                            .addComponent(q5a)
                                            .addGap(166, 166, 166)
                                            .addComponent(q5b)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(q5c)
                                            .addGap(102, 102, 102))))
                                .addGap(0, 16, Short.MAX_VALUE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel31)
                .addGap(34, 34, 34)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q1a)
                    .addComponent(q1b)
                    .addComponent(q1c))
                .addGap(33, 33, 33)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q2a)
                    .addComponent(q2b)
                    .addComponent(q2c))
                .addGap(18, 18, 18)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q3a)
                    .addComponent(q3b)
                    .addComponent(q3c))
                .addGap(18, 18, 18)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q4a)
                    .addComponent(q4b)
                    .addComponent(q4c))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q5a)
                    .addComponent(q5b)
                    .addComponent(q5c))
                .addGap(34, 34, 34)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hyperactive_next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout Hyperactive_SyptomLayout = new javax.swing.GroupLayout(Hyperactive_Syptom);
        Hyperactive_Syptom.setLayout(Hyperactive_SyptomLayout);
        Hyperactive_SyptomLayout.setHorizontalGroup(
            Hyperactive_SyptomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Hyperactive_SyptomLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Hyperactive_SyptomLayout.setVerticalGroup(
            Hyperactive_SyptomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Hyperactive_SyptomLayout.createSequentialGroup()
                .addGroup(Hyperactive_SyptomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        Card_Panel.add(Hyperactive_Syptom, "card2");

        Implulsive_Syptom.setBackground(new java.awt.Color(255, 255, 255));
        Implulsive_Syptom.setPreferredSize(new java.awt.Dimension(860, 690));

        jPanel13.setBackground(new java.awt.Color(104, 164, 236));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/impulsive.png"))); // NOI18N
        jPanel13.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 270, 430));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("INSTRUCTIONS");
        jPanel13.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 30));

        jLabel45.setBackground(new java.awt.Color(104, 164, 236));
        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("1 = Never Happens");
        jPanel13.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 30));

        jLabel46.setBackground(new java.awt.Color(104, 164, 236));
        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("2 = Often Happens");
        jPanel13.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 200, 30));

        jLabel47.setBackground(new java.awt.Color(104, 164, 236));
        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("3 = Always Happens");
        jPanel13.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 30));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel37.setBackground(new java.awt.Color(104, 164, 236));
        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(104, 164, 236));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("CHILD IMPULSIVE SYMPTOMS DETAILS");

        Impulsive_next.setBackground(new java.awt.Color(104, 164, 236));
        Impulsive_next.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Impulsive_next.setForeground(new java.awt.Color(255, 255, 255));
        Impulsive_next.setText("NEXT");
        Impulsive_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Impulsive_nextMouseClicked(evt);
            }
        });
        Impulsive_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Impulsive_nextActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(104, 164, 236));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("PREVIOUS");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        eq2.add(qc1);
        qc1.setText("1");
        qc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qc1ActionPerformed(evt);
            }
        });

        eq2.add(qc2);
        qc2.setText("2");
        qc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qc2ActionPerformed(evt);
            }
        });

        eq2.add(qc3);
        qc3.setText("3");

        jLabel11.setText("<html>Blurts out an answer before question has been completed (e.g., completes people's sentences; cannot wait for turn in conversation).</html>");

        jLabel38.setText("<html>Has difficulty waiting his or her turn (e.g., while waiting in line).</html>");

        eq1.add(qc4);
        qc4.setText("1");
        qc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qc4ActionPerformed(evt);
            }
        });

        eq1.add(qc5);
        qc5.setText("2");
        qc5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qc5ActionPerformed(evt);
            }
        });

        eq1.add(qc6);
        qc6.setText("3");

        buttonGroup3.add(qc7);
        qc7.setText("1");
        qc7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qc7ActionPerformed(evt);
            }
        });

        buttonGroup3.add(qc8);
        qc8.setText("2");
        qc8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qc8ActionPerformed(evt);
            }
        });

        jLabel39.setText("<html>Interrupts or intrudes on others (eg, butts into conversations, games, or activities; may start using other people's things without asking or receiving permission; for adolescents and adults may intrude into or take over what others are doing).</html>");

        buttonGroup3.add(qc9);
        qc9.setText("3");

        jLabel40.setText("<html>How well does your child control their impulses in various situations? </html>");

        buttonGroup4.add(qc11);
        qc11.setText("2");
        qc11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qc11ActionPerformed(evt);
            }
        });

        buttonGroup4.add(qc10);
        qc10.setText("1");
        qc10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qc10ActionPerformed(evt);
            }
        });

        jLabel41.setText("<html>In situations requiring patience, how does your child usually respond?</html>");

        buttonGroup4.add(qc12);
        qc12.setText("3");
        qc12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qc12ActionPerformed(evt);
            }
        });

        buttonGroup5.add(qc13);
        qc13.setText("1");
        qc13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qc13ActionPerformed(evt);
            }
        });

        buttonGroup5.add(qc14);
        qc14.setText("2");
        qc14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qc14ActionPerformed(evt);
            }
        });

        buttonGroup5.add(qc15);
        qc15.setText("3");
        qc15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qc15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Impulsive_next, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addComponent(jLabel38)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                            .addComponent(jLabel41)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel37)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(qc1)
                                .addGap(166, 166, 166)
                                .addComponent(qc2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qc3))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(qc4)
                                .addGap(166, 166, 166)
                                .addComponent(qc5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qc6))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(qc7)
                                .addGap(166, 166, 166)
                                .addComponent(qc8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qc9))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(qc10)
                                .addGap(166, 166, 166)
                                .addComponent(qc11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qc12)
                                .addGap(2, 2, 2)))
                        .addGap(136, 136, 136))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(qc13)
                        .addGap(166, 166, 166)
                        .addComponent(qc14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(qc15)
                        .addGap(135, 135, 135))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel37)
                .addGap(33, 33, 33)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qc1)
                    .addComponent(qc2)
                    .addComponent(qc3))
                .addGap(33, 33, 33)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qc4)
                    .addComponent(qc5)
                    .addComponent(qc6))
                .addGap(33, 33, 33)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qc7)
                    .addComponent(qc8)
                    .addComponent(qc9))
                .addGap(33, 33, 33)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qc10)
                            .addComponent(qc11)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qc12)))
                .addGap(18, 18, 18)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qc14)
                            .addComponent(qc15)))
                    .addComponent(qc13))
                .addGap(35, 35, 35)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(Impulsive_next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Implulsive_SyptomLayout = new javax.swing.GroupLayout(Implulsive_Syptom);
        Implulsive_Syptom.setLayout(Implulsive_SyptomLayout);
        Implulsive_SyptomLayout.setHorizontalGroup(
            Implulsive_SyptomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Implulsive_SyptomLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Implulsive_SyptomLayout.setVerticalGroup(
            Implulsive_SyptomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Implulsive_SyptomLayout.createSequentialGroup()
                .addGroup(Implulsive_SyptomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Card_Panel.add(Implulsive_Syptom, "card2");

        Inattention_Syptom.setBackground(new java.awt.Color(255, 255, 255));
        Inattention_Syptom.setPreferredSize(new java.awt.Dimension(860, 690));

        jPanel7.setBackground(new java.awt.Color(104, 164, 236));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/inattention__1_-removebg-preview.png"))); // NOI18N
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 180, 260, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("INSTRUCTIONS");
        jPanel7.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 30));

        jLabel49.setBackground(new java.awt.Color(104, 164, 236));
        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("1 = Never Happens");
        jPanel7.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 30));

        jLabel50.setBackground(new java.awt.Color(104, 164, 236));
        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("2 = Often Happens");
        jPanel7.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 200, 30));

        jLabel51.setBackground(new java.awt.Color(104, 164, 236));
        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("3 = Always Happens");
        jPanel7.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 30));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setBackground(new java.awt.Color(104, 164, 236));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(104, 164, 236));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("CHILD INATTENTION SYMPTOMS DETAILS");

        jButton2.setBackground(new java.awt.Color(104, 164, 236));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SUBMIT");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(104, 164, 236));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("PREVIOUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        q1.add(in1);
        in1.setText("1");
        in1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in1ActionPerformed(evt);
            }
        });

        q1.add(in2);
        in2.setText("2");
        in2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in2ActionPerformed(evt);
            }
        });

        q1.add(in3);
        in3.setText("3");

        jLabel3.setText("<html>Fails to give attention to details or makes careless mistakes in schoolwork, work, or during other activities (e.g.,overlooks or misses details, work is inaccurate). </html>");

        jLabel15.setText("<html>Has difficulty sustaining attention to tasks or play activities (e.g., has difficulty remaining focused during lectures; conversations; or lengthy reading).</html>");

        q2.add(in4);
        in4.setText("1");
        in4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in4ActionPerformed(evt);
            }
        });

        q2.add(in5);
        in5.setText("2");
        in5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in5ActionPerformed(evt);
            }
        });

        q2.add(in6);
        in6.setText("3");

        q3.add(in7);
        in7.setText("1");
        in7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in7ActionPerformed(evt);
            }
        });

        q3.add(in8);
        in8.setText("2");
        in8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in8ActionPerformed(evt);
            }
        });

        jLabel22.setText("<html>Does not seem to listen when spoken to directly (e.g., mind seems elsewhere, even in the absence of any obvious distraction).</html>");

        q3.add(in9);
        in9.setText("3");

        jLabel23.setText("<html>Does not follow through on instructions and fails to finish schoolwork, chores, or duties in the workplace (e.g., starts tasks but quickly loses focus and is easily sidetracked).</html>");

        q4.add(in11);
        in11.setText("2");
        in11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in11ActionPerformed(evt);
            }
        });

        q4.add(in12);
        in12.setText("3");

        q4.add(in10);
        in10.setText("1");
        in10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in10ActionPerformed(evt);
            }
        });

        q5.add(in14);
        in14.setText("2");
        in14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in14ActionPerformed(evt);
            }
        });

        jLabel26.setText("<html>Has difficulty organizing tasks and activities (e.g., difficulty managing sequential tasks; difficulty keeping materials and belongings in order; messy, disorganized with work; has poor time management; fails to meet deadlines).</html>");

        q5.add(in15);
        in15.setText("3");

        q5.add(in13);
        in13.setText("1");
        in13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel25))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(in1)
                        .addGap(166, 166, 166)
                        .addComponent(in2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(in3))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(in4)
                        .addGap(166, 166, 166)
                        .addComponent(in5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(in6))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(in7)
                        .addGap(166, 166, 166)
                        .addComponent(in8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(in9))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(in10)
                        .addGap(166, 166, 166)
                        .addComponent(in11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(in12))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(in13)
                        .addGap(166, 166, 166)
                        .addComponent(in14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(in15)))
                .addGap(136, 136, 136))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel25)
                .addGap(33, 33, 33)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in1)
                    .addComponent(in2)
                    .addComponent(in3))
                .addGap(33, 33, 33)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in4)
                    .addComponent(in5)
                    .addComponent(in6))
                .addGap(33, 33, 33)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in7)
                    .addComponent(in8)
                    .addComponent(in9))
                .addGap(33, 33, 33)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in10)
                    .addComponent(in11)
                    .addComponent(in12))
                .addGap(33, 33, 33)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in13)
                    .addComponent(in14)
                    .addComponent(in15))
                .addGap(31, 31, 31)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Inattention_SyptomLayout = new javax.swing.GroupLayout(Inattention_Syptom);
        Inattention_Syptom.setLayout(Inattention_SyptomLayout);
        Inattention_SyptomLayout.setHorizontalGroup(
            Inattention_SyptomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Inattention_SyptomLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Inattention_SyptomLayout.setVerticalGroup(
            Inattention_SyptomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Inattention_SyptomLayout.createSequentialGroup()
                .addGroup(Inattention_SyptomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Card_Panel.add(Inattention_Syptom, "card2");

        ExtraQuestionImpulsiveInattention.setBackground(new java.awt.Color(255, 255, 255));
        ExtraQuestionImpulsiveInattention.setPreferredSize(new java.awt.Dimension(860, 690));

        jPanel19.setBackground(new java.awt.Color(104, 164, 236));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/inattention__1_-removebg-preview.png"))); // NOI18N
        jPanel19.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 180, 260, -1));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("INSTRUCTIONS");
        jPanel19.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 30));

        jLabel74.setBackground(new java.awt.Color(104, 164, 236));
        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("1 = Never Happens");
        jPanel19.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 30));

        jLabel75.setBackground(new java.awt.Color(104, 164, 236));
        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("2 = Often Happens");
        jPanel19.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 200, 30));

        jLabel76.setBackground(new java.awt.Color(104, 164, 236));
        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("3 = Always Happens");
        jPanel19.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 30));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel77.setBackground(new java.awt.Color(104, 164, 236));
        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(104, 164, 236));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("EXTRA QUESTION");

        jButton8.setBackground(new java.awt.Color(104, 164, 236));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("SUBMIT");
        jButton8.setBorder(null);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel78.setText("<html>When working on a project or assessment, how often do you find yourself jumping from task to task without completing them?\n</html>");

        ex1.add(ei1);
        ei1.setText("1");
        ei1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei1ActionPerformed(evt);
            }
        });

        ex1.add(ei2);
        ei2.setText("2");
        ei2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei2ActionPerformed(evt);
            }
        });

        ex1.add(ei3);
        ei3.setText("3");

        jLabel79.setBackground(new java.awt.Color(104, 164, 236));
        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(104, 164, 236));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("IMPULSIVE");

        jLabel80.setText("<html>When working on a project or assessment, how often do you find yourself jumping from task to task without completing them?\n</html>");

        ex1a.add(ei4);
        ei4.setText("1");
        ei4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei4ActionPerformed(evt);
            }
        });

        ex1a.add(ei5);
        ei5.setText("2");
        ei5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei5ActionPerformed(evt);
            }
        });

        ex1a.add(ei6);
        ei6.setText("3");
        ei6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei6ActionPerformed(evt);
            }
        });

        jLabel81.setBackground(new java.awt.Color(104, 164, 236));
        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(104, 164, 236));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("INATTENTION");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(ei1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ei2)
                .addGap(188, 188, 188)
                .addComponent(ei3)
                .addGap(93, 93, 93))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(ei4)
                        .addGap(223, 223, 223)
                        .addComponent(ei5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ei6)
                        .addGap(90, 90, 90))))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel77)
                .addGap(106, 106, 106)
                .addComponent(jLabel81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ei3)
                    .addComponent(ei2)
                    .addComponent(ei1))
                .addGap(70, 70, 70)
                .addComponent(jLabel79)
                .addGap(18, 18, 18)
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ei6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ei5)
                        .addComponent(ei4)))
                .addGap(114, 114, 114)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout ExtraQuestionImpulsiveInattentionLayout = new javax.swing.GroupLayout(ExtraQuestionImpulsiveInattention);
        ExtraQuestionImpulsiveInattention.setLayout(ExtraQuestionImpulsiveInattentionLayout);
        ExtraQuestionImpulsiveInattentionLayout.setHorizontalGroup(
            ExtraQuestionImpulsiveInattentionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExtraQuestionImpulsiveInattentionLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ExtraQuestionImpulsiveInattentionLayout.setVerticalGroup(
            ExtraQuestionImpulsiveInattentionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExtraQuestionImpulsiveInattentionLayout.createSequentialGroup()
                .addGroup(ExtraQuestionImpulsiveInattentionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Card_Panel.add(ExtraQuestionImpulsiveInattention, "card2");

        ExtraQuestionHyperInattention.setBackground(new java.awt.Color(255, 255, 255));
        ExtraQuestionHyperInattention.setPreferredSize(new java.awt.Dimension(860, 690));

        jPanel17.setBackground(new java.awt.Color(104, 164, 236));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/inattention__1_-removebg-preview.png"))); // NOI18N
        jPanel17.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 180, 260, -1));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("INSTRUCTIONS");
        jPanel17.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 30));

        jLabel64.setBackground(new java.awt.Color(104, 164, 236));
        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("1 = Never Happens");
        jPanel17.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 30));

        jLabel65.setBackground(new java.awt.Color(104, 164, 236));
        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("2 = Often Happens");
        jPanel17.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 200, 30));

        jLabel66.setBackground(new java.awt.Color(104, 164, 236));
        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("3 = Always Happens");
        jPanel17.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 30));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel67.setBackground(new java.awt.Color(104, 164, 236));
        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(104, 164, 236));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("EXTRA QUESTION");

        jButton6.setBackground(new java.awt.Color(104, 164, 236));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("SUBMIT");
        jButton6.setBorder(null);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel68.setText("<html>How would you describe your ability to focus on tasks and sustain attention over time?</html>");

        ex2.add(ei11);
        ei11.setText("1");
        ei11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei11ActionPerformed(evt);
            }
        });

        ex2.add(ei12);
        ei12.setText("2");
        ei12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei12ActionPerformed(evt);
            }
        });

        ex2.add(ei13);
        ei13.setText("3");

        jLabel69.setBackground(new java.awt.Color(104, 164, 236));
        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(104, 164, 236));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("INATTENTION");

        jLabel70.setText("<html>When working on a project or assessment, how often do you find yourself jumping from task to task without completing them?</html>");

        ex2a.add(ei14);
        ei14.setText("1");
        ei14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei14ActionPerformed(evt);
            }
        });

        ex2a.add(ei15);
        ei15.setText("2");
        ei15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei15ActionPerformed(evt);
            }
        });

        ex2a.add(ei16);
        ei16.setText("3");

        jLabel71.setBackground(new java.awt.Color(104, 164, 236));
        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(104, 164, 236));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("HYPERACTIVE");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(ei14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ei15)
                        .addGap(188, 188, 188)
                        .addComponent(ei16))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(ei11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ei12)
                        .addGap(188, 188, 188)
                        .addComponent(ei13)))
                .addGap(93, 93, 93))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel67)
                .addGap(89, 89, 89)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ei13)
                    .addComponent(ei12)
                    .addComponent(ei11))
                .addGap(60, 60, 60)
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ei16)
                    .addComponent(ei15)
                    .addComponent(ei14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout ExtraQuestionHyperInattentionLayout = new javax.swing.GroupLayout(ExtraQuestionHyperInattention);
        ExtraQuestionHyperInattention.setLayout(ExtraQuestionHyperInattentionLayout);
        ExtraQuestionHyperInattentionLayout.setHorizontalGroup(
            ExtraQuestionHyperInattentionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExtraQuestionHyperInattentionLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ExtraQuestionHyperInattentionLayout.setVerticalGroup(
            ExtraQuestionHyperInattentionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExtraQuestionHyperInattentionLayout.createSequentialGroup()
                .addGroup(ExtraQuestionHyperInattentionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Card_Panel.add(ExtraQuestionHyperInattention, "card2");

        ExtraQuestionHyperImpulsive.setBackground(new java.awt.Color(255, 255, 255));
        ExtraQuestionHyperImpulsive.setPreferredSize(new java.awt.Dimension(860, 690));

        jPanel15.setBackground(new java.awt.Color(104, 164, 236));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/inattention__1_-removebg-preview.png"))); // NOI18N
        jPanel15.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 180, 260, -1));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("INSTRUCTIONS");
        jPanel15.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 30));

        jLabel54.setBackground(new java.awt.Color(104, 164, 236));
        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("1 = Never Happens");
        jPanel15.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 30));

        jLabel55.setBackground(new java.awt.Color(104, 164, 236));
        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("2 = Often Happens");
        jPanel15.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 200, 30));

        jLabel56.setBackground(new java.awt.Color(104, 164, 236));
        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("3 = Always Happens");
        jPanel15.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 30));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel57.setBackground(new java.awt.Color(104, 164, 236));
        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(104, 164, 236));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("EXTRA QUESTION");

        jButton4.setBackground(new java.awt.Color(104, 164, 236));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("SUBMIT");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel59.setText("<html>How would you describe your ability to focus on tasks and sustain attention over time?\n</html>");

        ex3.add(ei21);
        ei21.setText("1");
        ei21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei21ActionPerformed(evt);
            }
        });

        ex3.add(ei22);
        ei22.setText("2");
        ei22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei22ActionPerformed(evt);
            }
        });

        ex3.add(ei23);
        ei23.setText("3");

        jLabel58.setBackground(new java.awt.Color(104, 164, 236));
        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(104, 164, 236));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("IMPULSIVE");

        jLabel60.setText("<html>When working on a project or assessment, how often do you find yourself jumping from task to task without completing them?\n</html>");

        ex3a.add(ei24);
        ei24.setText("1");
        ei24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei24ActionPerformed(evt);
            }
        });

        ex3a.add(ei25);
        ei25.setText("2");
        ei25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ei25ActionPerformed(evt);
            }
        });

        ex3a.add(ei26);
        ei26.setText("3");

        jLabel61.setBackground(new java.awt.Color(104, 164, 236));
        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(104, 164, 236));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("HYPERACTIVE");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(ei21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                                .addComponent(ei22)
                                .addGap(188, 188, 188)
                                .addComponent(ei23))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(ei24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ei25)
                                .addGap(188, 188, 188)
                                .addComponent(ei26)))
                        .addGap(93, 93, 93))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(39, 39, 39)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel57)
                .addGap(110, 110, 110)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ei23)
                    .addComponent(ei22)
                    .addComponent(ei21))
                .addGap(48, 48, 48)
                .addComponent(jLabel58)
                .addGap(18, 18, 18)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ei26)
                    .addComponent(ei25)
                    .addComponent(ei24))
                .addGap(145, 145, 145)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(141, 141, 141)
                    .addComponent(jLabel61)
                    .addContainerGap(517, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout ExtraQuestionHyperImpulsiveLayout = new javax.swing.GroupLayout(ExtraQuestionHyperImpulsive);
        ExtraQuestionHyperImpulsive.setLayout(ExtraQuestionHyperImpulsiveLayout);
        ExtraQuestionHyperImpulsiveLayout.setHorizontalGroup(
            ExtraQuestionHyperImpulsiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExtraQuestionHyperImpulsiveLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ExtraQuestionHyperImpulsiveLayout.setVerticalGroup(
            ExtraQuestionHyperImpulsiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExtraQuestionHyperImpulsiveLayout.createSequentialGroup()
                .addGroup(ExtraQuestionHyperImpulsiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        Card_Panel.add(ExtraQuestionHyperImpulsive, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Card_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Card_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void cpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpassActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void in2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in2ActionPerformed

    private void in1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in1ActionPerformed

    private void in4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in4ActionPerformed

    private void in5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in5ActionPerformed

    private void in7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in7ActionPerformed

    private void in8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in8ActionPerformed

    private void in11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in11ActionPerformed

    private void in10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in10ActionPerformed

    private void in14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in14ActionPerformed

    private void in13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in13ActionPerformed

    private void hyperactive_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hyperactive_nextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hyperactive_nextActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prevActionPerformed

    private void q1aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q1aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q1aActionPerformed

    private void q1bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q1bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q1bActionPerformed

    private void q2aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q2aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q2aActionPerformed

    private void q2bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q2bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q2bActionPerformed

    private void q3aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q3aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q3aActionPerformed

    private void q3bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q3bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q3bActionPerformed

    private void q4bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q4bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q4bActionPerformed

    private void q4aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q4aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q4aActionPerformed

    private void q5bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q5bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q5bActionPerformed

    private void q5aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q5aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q5aActionPerformed

    private void Impulsive_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Impulsive_nextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Impulsive_nextActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void qc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qc1ActionPerformed

    private void qc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qc2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qc2ActionPerformed

    private void qc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qc4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qc4ActionPerformed

    private void qc5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qc5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qc5ActionPerformed

    private void qc7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qc7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qc7ActionPerformed

    private void qc8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qc8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qc8ActionPerformed

    private void qc11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qc11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qc11ActionPerformed

    private void qc10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qc10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qc10ActionPerformed

    private void parent_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parent_nextActionPerformed
        
    }//GEN-LAST:event_parent_nextActionPerformed

    private void pcontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcontactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcontactActionPerformed

    private void child_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_child_nextMouseClicked
        try {
            // TODO add your handling code here:
            String c_name = cname.getText();
            java.util.Date utilDate = cage.getDate();
            java.sql.Date c_DOB = new java.sql.Date(utilDate.getTime());            
            String c_gender = (String) cgender.getSelectedItem();
            String c_email = cemail.getText();
            String c_password = new String(cpass.getPassword());  
            
            // Check if the email already exists
            String checkEmailQuery = "SELECT COUNT(*) FROM user WHERE email = ?";
            PreparedStatement checkEmailStmt = connection.prepareStatement(checkEmailQuery);
            checkEmailStmt.setString(1, cemail.getText());

            // Execute the query and retrieve the count
            ResultSet resultSet = checkEmailStmt.executeQuery();
            resultSet.next();
            int emailCount = resultSet.getInt(1);

            if (emailCount > 0) {
                // The email already exists, show an error message
                JOptionPane.showMessageDialog(null, "Email already exists. Please use a different email.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
       
            
            String sql = "INSERT INTO student (s_id, name,email, DOB, p_id, gender,s_level, ADHD_type) VALUES (?,?, ?, ?, ?, ?,null,'null')";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, child_randomId);
            preparedStatement.setString(2, c_name); 
            preparedStatement.setString(3, c_email);
            preparedStatement.setDate(4,  sqlDate);
            preparedStatement.setInt(5, parent_randomId);
            preparedStatement.setString(6, c_gender);
            preparedStatement.executeUpdate();
            
             sqlDate = new Date(currentDate.getTime());
       
            sql = "INSERT INTO user (id, name, email,password, role, registered_date) VALUES (?, ?, ?, ?,'Student',?)";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, child_randomId);
            preparedStatement.setString(2, c_name);
            preparedStatement.setString(3, c_email);
            preparedStatement.setString(4, c_password);
            preparedStatement.setDate(5, c_DOB);
            preparedStatement.executeUpdate();
            


              preparedStatement.close();            
            connection.close();
            Card_Panel.removeAll();
            Card_Panel.add(Hyperactive_Syptom);
            
            Card_Panel.repaint();
            Card_Panel.revalidate();
            JOptionPane.showMessageDialog(null, "Please Provide Some Medical Details For Your Child Now", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
        } catch (SQLException ex) {
            Logger.getLogger(Parent_SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_child_nextMouseClicked

    private void parent_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parent_nextMouseClicked
        try {
//             connection = dbConnector.getMyConnection();
          
            // TODO add your handling code here:
            String p_name = pname.getText();
            String p_email = pemail.getText();
            String p_password = new String(pass.getPassword());
            int p_contact = Integer.parseInt (pcontact.getText());            
            String p_relation = (String) crelation.getSelectedItem();
            
                     // Check if the email already exists
    String checkEmailQuery = "SELECT COUNT(*) FROM user WHERE email = ?";
    PreparedStatement checkEmailStmt = connection.prepareStatement(checkEmailQuery);
    checkEmailStmt.setString(1, pemail.getText());
    
    // Execute the query and retrieve the count
    ResultSet resultSet = checkEmailStmt.executeQuery();
    resultSet.next();
    int emailCount = resultSet.getInt(1);

    if (emailCount > 0) {
        // The email already exists, show an error message
        JOptionPane.showMessageDialog(null, "Email already exists. Please use a different email.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        // The email is unique, proceed with the insert operation

            String sql = "";
             sql = "INSERT INTO parent (p_id, name, email, contact, relation) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, parent_randomId);
            preparedStatement.setString(2, p_name);
            preparedStatement.setString(3, p_email);
            preparedStatement.setInt(4, p_contact);
            preparedStatement.setString(5, p_relation);
            preparedStatement.executeUpdate();
            
             sqlDate = new Date(currentDate.getTime());
       
            sql = "INSERT INTO user (id, name, email,password, role, registered_date) VALUES (?, ?, ?, ?,'Parent',?)";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, parent_randomId);
            preparedStatement.setString(2, p_name);
            preparedStatement.setString(3, p_email);
            preparedStatement.setString(4, p_password);
            preparedStatement.setDate(5,sqlDate);
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            
             JOptionPane.showMessageDialog(null, "Acount created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
             // TODO add your handling code here:
            Card_Panel.removeAll();
            Card_Panel.add(Child_Details);
            Card_Panel.repaint();
            Card_Panel.revalidate();
            
    }
        } catch (SQLException ex) {
            Logger.getLogger(Parent_SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_parent_nextMouseClicked

    private void prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_prevMouseClicked

    private void hyperactive_nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hyperactive_nextMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_hyperactive_nextMouseEntered

    private void hyperactive_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hyperactive_nextMouseClicked
        // TODO add your handling code here:
        try{
            //HYPERACTIVE QUESTIONS TOTAL COUNT
        if (q1a.isSelected()) {
            hyperactivecount++;
        } else if (q1b.isSelected()) {
            hyperactivecount+=2;
        } else if (q1c.isSelected()) {
            hyperactivecount+=3;
        }
        if (q2a.isSelected()) {
            hyperactivecount++;
        } else if (q2b.isSelected()) {
            hyperactivecount+=2;
        } else if (q2c.isSelected()) {
            hyperactivecount+=3;
        }
        if (q3a.isSelected()) {
            hyperactivecount++;
        } else if (q3b.isSelected()) {
            hyperactivecount+=2;
        } else if (q3c.isSelected()) {
            hyperactivecount+=3;
        }
        if (q4a.isSelected()) {
            hyperactivecount++;
        } else if (q4b.isSelected()) {
            hyperactivecount+=2;
        } else if (q4c.isSelected()) {
            hyperactivecount+=3;
        }
        if (q5a.isSelected()) {
            hyperactivecount++;
        } else if (q5b.isSelected()) {
            hyperactivecount+=2;
        } else if (q5c.isSelected()) {
            hyperactivecount+=3;
        }
        
        
        if (hq1.getSelection() == null || hq2.getSelection() == null || hq3.getSelection() == null || hq4.getSelection() == null ||  hq5.getSelection() == null) {
            
            JOptionPane.showMessageDialog(null, "please select one option for each question first!", "Error", JOptionPane.ERROR_MESSAGE);

        }
        
            Card_Panel.removeAll();
            Card_Panel.add(Implulsive_Syptom);
            Card_Panel.repaint();
            Card_Panel.revalidate();
       
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_hyperactive_nextMouseClicked

    private void crelationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crelationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crelationActionPerformed

    private void c_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_prevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_prevActionPerformed

    private void c_prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_prevMouseClicked
        // TODO add your handling code here:
            Card_Panel.removeAll();
            Card_Panel.add(Child_Details);
            Card_Panel.repaint();
            Card_Panel.revalidate();
    }//GEN-LAST:event_c_prevMouseClicked

    private void Impulsive_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Impulsive_nextMouseClicked
        // TODO add your handling code here:
    try{
            //IMPULSIVE QUESTIONS TOTAL COUNT
        if (qc1.isSelected()) {
            impulsivecount++;
        } else if (qc2.isSelected()) {
            impulsivecount+=2;
        } else if (qc3.isSelected()) {
            impulsivecount+=3;
        }
        if (qc4.isSelected()) {
            impulsivecount++;
        } else if (qc5.isSelected()) {
            impulsivecount+=2;
        } else if (qc6.isSelected()) {
            impulsivecount+=3;
        }
        if (qc7.isSelected()) {
            impulsivecount++;
        } else if (qc8.isSelected()) {
            impulsivecount+=2;
        } else if (qc9.isSelected()) {
            impulsivecount+=3;
        }
        if (qc10.isSelected()) {
            impulsivecount++;
        } else if (qc11.isSelected()) {
            impulsivecount+=2;
        } else if (qc12.isSelected()) {
            impulsivecount+=3;
        } 
        
        if (qc13.isSelected()) {
            impulsivecount++;
        } else if (qc14.isSelected()) {
            impulsivecount+=2;
        }else if (qc15.isSelected()) {
            impulsivecount+=3;
        }
        
        if (eq2.getSelection() == null || eq1.getSelection() == null || buttonGroup3.getSelection() == null || buttonGroup4.getSelection() == null || buttonGroup5.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "please select one option for each question first!", "Error", JOptionPane.ERROR_MESSAGE);
        }
       
            Card_Panel.removeAll();
            Card_Panel.add(Inattention_Syptom);
            Card_Panel.repaint();
            Card_Panel.revalidate();

        }catch(Exception ex){
            ex.printStackTrace();
        }//check box has to change
        
    }//GEN-LAST:event_Impulsive_nextMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        try{
             connection = dbConnector.getMyConnection();
          
            //Inattention QUESTIONS TOTAL COUNT
        if (in1.isSelected()) {
            inattentioncount++;
        } else if (in2.isSelected()) {
            inattentioncount+=2;
        } else if (in3.isSelected()) {
            inattentioncount+=3;
        }
        if (in4.isSelected()) {
            inattentioncount++;
        } else if (in5.isSelected()) {
            inattentioncount+=2;
        } else if (in6.isSelected()) {
            inattentioncount+=3;
        }
        if (in7.isSelected()) {
            inattentioncount++;
        } else if (in8.isSelected()) {
            inattentioncount+=2;
        } else if (in9.isSelected()) {
            inattentioncount+=3;
        }
        if (in10.isSelected()) {
            inattentioncount++;
        } else if (in11.isSelected()) {
            inattentioncount+=2;
        } else if (in12.isSelected()) {
            inattentioncount+=3;
        }
        if (in13.isSelected()) {
            inattentioncount++;
        } else if (in14.isSelected()) {
            inattentioncount+=2;
        } else if (in15.isSelected()) {
            inattentioncount+=3;
        }
                
        if (q1.getSelection() == null || q2.getSelection() == null || q3.getSelection() == null || q4.getSelection() == null ||  q5.getSelection() == null) {
               JOptionPane.showMessageDialog(null, "please select one option for each question first!", "Error", JOptionPane.ERROR_MESSAGE);
        }
       
if (hyperactivecount == impulsivecount) {
    Card_Panel.removeAll();
    Card_Panel.add(ExtraQuestionHyperImpulsive);
    Card_Panel.repaint();
    Card_Panel.revalidate();
} else if (hyperactivecount == inattentioncount) {
    Card_Panel.removeAll();
    Card_Panel.add(ExtraQuestionHyperInattention);
    Card_Panel.repaint();
    Card_Panel.revalidate();
} else if (impulsivecount == inattentioncount) {
    Card_Panel.removeAll();
    Card_Panel.add(ExtraQuestionImpulsiveInattention);
    Card_Panel.repaint();
    Card_Panel.revalidate();
} else {
    if (hyperactivecount > impulsivecount && hyperactivecount > inattentioncount) {
        updateADHDType("hyperactive", child_randomId);
    } else if (impulsivecount > inattentioncount && impulsivecount > hyperactivecount) {
        updateADHDType("impulsive", child_randomId);
    } else if (inattentioncount > hyperactivecount && inattentioncount > impulsivecount) {
        updateADHDType("inattention", child_randomId);
    }
    insertParentDetails();
     ParentDashboard pd = new ParentDashboard();
        this.dispose();
        pd.setVisible(true);
}

        
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2MouseClicked

    
    public void insertParentDetails(){
    try{
      ResultSet resultSet;
       PreparedStatement preparedStatement ;
      String  sql = "select * from parent where p_id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,  parent_randomId);
        resultSet = preparedStatement.executeQuery();
 UserProfile user = new UserProfile();
         
    while (resultSet.next()) {
                 
                    user.setUsername(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setRole("Parent");
                     user.setId(resultSet.getInt("p_id"));
                        user.setRelation(resultSet.getString("relation"));
    }
    
    Auth.login(user);
    
    } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    private void updateADHDType(String adhdType, int childRandomId) throws SQLException {
     String sql="";
     int severity = 0;
        PreparedStatement preparedStatement ;
       int totaladhdscore = inattentioncount + impulsivecount + hyperactivecount;

        if (totaladhdscore > 25) {
            severity = 3;
        } else if (totaladhdscore > 15) {
            severity = 2;
        } else {
            severity = 1;
        }

        
     sql = "update student set s_level = ? , adhd_type = ? where s_id = ?";
    preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1,  severity);
    preparedStatement.setString(2, adhdType);
    preparedStatement.setInt(3, childRandomId);
    preparedStatement.executeUpdate();
    
    sql = "insert into medical_report(s_id,hyperactive,impulsive,inattention) values(?,?,?,?)";
    preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1,  childRandomId);
    preparedStatement.setInt(2, hyperactivecount);
    preparedStatement.setInt(3, impulsivecount);
    preparedStatement.setInt(4, inattentioncount);
    preparedStatement.executeUpdate();
    
      
             ResultSet rs;
sql = "select c_id from courses where std_level = ?";
preparedStatement = connection.prepareStatement(sql);
preparedStatement.setInt(1,  severity);
rs = preparedStatement.executeQuery();

while (rs.next()) {
    int cid = rs.getInt("c_id");

    sql = "insert into lecture(s_id,c_id,status) values(?,?,'incomplete')";
    preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1,  childRandomId);
    preparedStatement.setInt(2, cid);
    preparedStatement.executeUpdate();

    sql = "insert into stdcourse(s_id,c_id) values(?,?)";
    preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1,  childRandomId);
    preparedStatement.setInt(2, cid);
    preparedStatement.executeUpdate();
}

       
        
   
}

    private void qc12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qc12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qc12ActionPerformed

    private void qc13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qc13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qc13ActionPerformed

    private void qc14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qc14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qc14ActionPerformed

    private void qc15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qc15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qc15ActionPerformed

    private void ei22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei22ActionPerformed

    private void ei21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei21ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          // TODO add your handling code here:
        try{
            
                //Extraa hyperimpulsive QUESTIONS TOTAL COUNT
            if (ei21.isSelected()) {
                hyperactivecount++;
            } else if (ei22.isSelected()) {
                hyperactivecount+=2;
            } else if (ei23.isSelected()) {
                hyperactivecount+=3;
            }
            if (ei24.isSelected()) {
                impulsivecount++;
            } else if (ei25.isSelected()) {
                impulsivecount+=2;
            } else if (ei26.isSelected()) {
                impulsivecount+=3;
            }

            if (ex3.getSelection() == null || ex3a.getSelection() == null ) {
                   JOptionPane.showMessageDialog(null, "please select one option for each question first!", "Error", JOptionPane.ERROR_MESSAGE);
            }
       
        if (hyperactivecount > impulsivecount && hyperactivecount > inattentioncount) {
        updateADHDType("hyperactive", child_randomId);
    } else if (impulsivecount > inattentioncount && impulsivecount > hyperactivecount) {
        updateADHDType("impulsive", child_randomId);
    } else if (inattentioncount > hyperactivecount && inattentioncount > impulsivecount) {
        updateADHDType("inattention", child_randomId);
    }
         ParentDashboard pd = new ParentDashboard();
        this.dispose();
        pd.setVisible(true);
         }catch(SQLException er){
             
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
      
    }//GEN-LAST:event_jButton4MouseClicked

    private void ei24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei24ActionPerformed

    private void ei25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei25ActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
       
        
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
          // TODO add your handling code here:
        try{
           
                //Extraa hyperinattention QUESTIONS TOTAL COUNT
            if (ei11.isSelected()) {
                hyperactivecount++;
            } else if (ei12.isSelected()) {
                hyperactivecount+=2;
            } else if (ei13.isSelected()) {
                hyperactivecount+=3;
            }
            if (ei14.isSelected()) {
                inattentioncount++;
            } else if (ei15.isSelected()) {
                inattentioncount+=2;
            } else if (ei16.isSelected()) {
                inattentioncount+=3;
            }

            if (ex2.getSelection() == null || ex2a.getSelection() == null ) {
                   JOptionPane.showMessageDialog(null, "please select one option for each question first!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        if (hyperactivecount > impulsivecount && hyperactivecount > inattentioncount) {
        updateADHDType("hyperactive", child_randomId);
    } else if (impulsivecount > inattentioncount && impulsivecount > hyperactivecount) {
        updateADHDType("impulsive", child_randomId);
    } else if (inattentioncount > hyperactivecount && inattentioncount > impulsivecount) {
        updateADHDType("inattention", child_randomId);
    }
        insertParentDetails();
         ParentDashboard pd = new ParentDashboard();
        this.dispose();
        pd.setVisible(true);
         }catch(SQLException er){
             
         }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void ei11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei11ActionPerformed

    private void ei12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei12ActionPerformed

    private void ei14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei14ActionPerformed

    private void ei15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei15ActionPerformed

    private void ei5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei5ActionPerformed

    private void ei4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei4ActionPerformed

    private void ei2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei2ActionPerformed

    private void ei1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try{
           
                //Extraa impulive attention QUESTIONS TOTAL COUNT
            if (ei1.isSelected()) {
                inattentioncount++;
            } else if (ei2.isSelected()) {
                inattentioncount+=2;
            } else if (ei3.isSelected()) {
                inattentioncount+=3;
            }
            if (ei4.isSelected()) {
                impulsivecount++;
            } else if (ei5.isSelected()) {
                impulsivecount+=2;
            } else if (ei6.isSelected()) {
                impulsivecount+=3;
            }

            if (ex1.getSelection() == null || ex1a.getSelection() == null ) {
                   JOptionPane.showMessageDialog(null, "please select one option for each question first!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            if (hyperactivecount > impulsivecount && hyperactivecount > inattentioncount) {
                updateADHDType("hyperactive", child_randomId);
            } else if (impulsivecount > inattentioncount && impulsivecount > hyperactivecount) {
                updateADHDType("impulsive", child_randomId);
            } else if (inattentioncount > hyperactivecount && inattentioncount > impulsivecount) {
                updateADHDType("inattention", child_randomId);
            }
             insertParentDetails();
            ParentDashboard pd = new ParentDashboard();
            this.dispose();
            pd.setVisible(true);
            }catch(SQLException er)
            {

            }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jButton8MouseClicked

    private void ei6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ei6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ei6ActionPerformed

    private void cageAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cageAncestorAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cageAncestorAdded

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Card_Panel;
    private javax.swing.JPanel Child_Details;
    private javax.swing.JPanel ExtraQuestionHyperImpulsive;
    private javax.swing.JPanel ExtraQuestionHyperInattention;
    private javax.swing.JPanel ExtraQuestionImpulsiveInattention;
    private javax.swing.JPanel Hyperactive_Syptom;
    private javax.swing.JPanel Implulsive_Syptom;
    private javax.swing.JButton Impulsive_next;
    private javax.swing.JPanel Inattention_Syptom;
    private javax.swing.JPanel Parent_Details;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton c_prev;
    private com.toedter.calendar.JDateChooser cage;
    private javax.swing.JTextField cemail;
    private javax.swing.JComboBox<String> cgender;
    private javax.swing.JButton child_next;
    private javax.swing.JTextField cname;
    private javax.swing.JPasswordField cpass;
    private javax.swing.JComboBox<String> crelation;
    private javax.swing.JRadioButton ei1;
    private javax.swing.JRadioButton ei11;
    private javax.swing.JRadioButton ei12;
    private javax.swing.JRadioButton ei13;
    private javax.swing.JRadioButton ei14;
    private javax.swing.JRadioButton ei15;
    private javax.swing.JRadioButton ei16;
    private javax.swing.JRadioButton ei2;
    private javax.swing.JRadioButton ei21;
    private javax.swing.JRadioButton ei22;
    private javax.swing.JRadioButton ei23;
    private javax.swing.JRadioButton ei24;
    private javax.swing.JRadioButton ei25;
    private javax.swing.JRadioButton ei26;
    private javax.swing.JRadioButton ei3;
    private javax.swing.JRadioButton ei4;
    private javax.swing.JRadioButton ei5;
    private javax.swing.JRadioButton ei6;
    private javax.swing.ButtonGroup eq1;
    private javax.swing.ButtonGroup eq2;
    private javax.swing.ButtonGroup ex1;
    private javax.swing.ButtonGroup ex1a;
    private javax.swing.ButtonGroup ex2;
    private javax.swing.ButtonGroup ex2a;
    private javax.swing.ButtonGroup ex3;
    private javax.swing.ButtonGroup ex3a;
    private javax.swing.ButtonGroup hq1;
    private javax.swing.ButtonGroup hq2;
    private javax.swing.ButtonGroup hq3;
    private javax.swing.ButtonGroup hq4;
    private javax.swing.ButtonGroup hq5;
    private javax.swing.JButton hyperactive_next;
    private javax.swing.JRadioButton in1;
    private javax.swing.JRadioButton in10;
    private javax.swing.JRadioButton in11;
    private javax.swing.JRadioButton in12;
    private javax.swing.JRadioButton in13;
    private javax.swing.JRadioButton in14;
    private javax.swing.JRadioButton in15;
    private javax.swing.JRadioButton in2;
    private javax.swing.JRadioButton in3;
    private javax.swing.JRadioButton in4;
    private javax.swing.JRadioButton in5;
    private javax.swing.JRadioButton in6;
    private javax.swing.JRadioButton in7;
    private javax.swing.JRadioButton in8;
    private javax.swing.JRadioButton in9;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton parent_next;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField pcontact;
    private javax.swing.JTextField pemail;
    private javax.swing.JTextField pname;
    private javax.swing.JButton prev;
    private javax.swing.ButtonGroup q1;
    private javax.swing.JRadioButton q1a;
    private javax.swing.JRadioButton q1b;
    private javax.swing.JRadioButton q1c;
    private javax.swing.ButtonGroup q2;
    private javax.swing.JRadioButton q2a;
    private javax.swing.JRadioButton q2b;
    private javax.swing.JRadioButton q2c;
    private javax.swing.ButtonGroup q3;
    private javax.swing.JRadioButton q3a;
    private javax.swing.JRadioButton q3b;
    private javax.swing.JRadioButton q3c;
    private javax.swing.ButtonGroup q4;
    private javax.swing.JRadioButton q4a;
    private javax.swing.JRadioButton q4b;
    private javax.swing.JRadioButton q4c;
    private javax.swing.ButtonGroup q5;
    private javax.swing.JRadioButton q5a;
    private javax.swing.JRadioButton q5b;
    private javax.swing.JRadioButton q5c;
    private javax.swing.JRadioButton qc1;
    private javax.swing.JRadioButton qc10;
    private javax.swing.JRadioButton qc11;
    private javax.swing.JRadioButton qc12;
    private javax.swing.JRadioButton qc13;
    private javax.swing.JRadioButton qc14;
    private javax.swing.JRadioButton qc15;
    private javax.swing.JRadioButton qc2;
    private javax.swing.JRadioButton qc3;
    private javax.swing.JRadioButton qc4;
    private javax.swing.JRadioButton qc5;
    private javax.swing.JRadioButton qc6;
    private javax.swing.JRadioButton qc7;
    private javax.swing.JRadioButton qc8;
    private javax.swing.JRadioButton qc9;
    // End of variables declaration//GEN-END:variables
}
