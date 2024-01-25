/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher.gui;

import com.itextpdf.text.log.Logger;
import common.code.Auth;
import common.code.MyDbConnector;
import common.code.UserProfile;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kavindu_Dilhara
 */
public class StudentMarks extends javax.swing.JFrame {
    
    private MyDbConnector dbConnector;
    Connection connection = null;
    
     PreparedStatement preparedStatement ;

    UserProfile loggedUser = Auth.getLoggedUser();
String name = loggedUser.getUsername();
int ID = loggedUser.getId();

List<String> studentNames = new ArrayList<>();
List<Integer> quizIds = new ArrayList<>();

    public StudentMarks() {
        dbConnector = new MyDbConnector();
        connection = dbConnector.getMyConnection();
        initComponents();
        checkStudentId();
    }
   public void checkStudentId() {
    try {
        String sql = "SELECT DISTINCT s.name, q.id FROM student s, stdcourse sc, teacher t, quiz_marks q " +
                     "WHERE s.s_id = sc.s_id AND t.c_id = sc.c_id AND t.t_id = ? AND q.c_id = t.c_id";
        
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, ID);
        ResultSet rs = preparedStatement.executeQuery();

        // Use sets to store unique values
        Set<String> uniqueStudentNames = new HashSet<>();
        Set<Integer> uniqueQuizIds = new HashSet<>();

        while (rs.next()) {
            uniqueStudentNames.add(rs.getString(1));
            uniqueQuizIds.add(rs.getInt(2));
        }

        // Update GUI components
        updateGUI(new ArrayList<>(uniqueStudentNames), new ArrayList<>(uniqueQuizIds));

    } catch (SQLException ex) {
        // Handle the exception appropriately
        ex.printStackTrace();
    }
}

private void updateGUI(List<String> studentNames, List<Integer> quizIds) {
    // Assuming studnames and quizcombo are JComboBox components

    // Clear existing items in combo boxes
    studnames.removeAllItems();
    quizcombo.removeAllItems();

    // Add new items to combo boxes
    for (String studentName : studentNames) {
        studnames.addItem(studentName);
    }

    for (Integer quizId : quizIds) {
        quizcombo.addItem(String.valueOf(quizId));
    }
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lbl_stdID = new javax.swing.JLabel();
        btn_Calculate22 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_ViewMarks2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lbl_stdID3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        quizcombo = new javax.swing.JComboBox<>();
        studnames = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        txt_copy1 = new javax.swing.JLabel();
        btn_Bck1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(248, 248, 241));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_stdID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_stdID.setText("Student Name:");
        jPanel4.add(lbl_stdID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 40));

        btn_Calculate22.setBackground(new java.awt.Color(51, 153, 255));
        btn_Calculate22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Calculate22.setForeground(new java.awt.Color(255, 255, 255));
        btn_Calculate22.setText("SEARCH");
        btn_Calculate22.setActionCommand("CLEAR");
        btn_Calculate22.setBorder(null);
        btn_Calculate22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Calculate22MouseClicked(evt);
            }
        });
        btn_Calculate22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Calculate22ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Calculate22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 440, 40));

        tbl_ViewMarks2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Quiz ID", "Quiz Marks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_ViewMarks2);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 440, 310));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("SELECT STUDENT ID OR QUIZ ID");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 730, 40));

        lbl_stdID3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_stdID3.setText("Quiz ID:");
        jPanel4.add(lbl_stdID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 60, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/resources/marks3d.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 290, 490));

        quizcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(quizcombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 120, 40));

        studnames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(studnames, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 130, 40));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_copy1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_copy1.setForeground(new java.awt.Color(255, 255, 255));
        txt_copy1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_copy1.setText("TEACHER NAME HERE");
        jPanel1.add(txt_copy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, 50));

        btn_Bck1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/backbtn.png"))); // NOI18N
        btn_Bck1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Bck1MouseClicked(evt);
            }
        });
        jPanel1.add(btn_Bck1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, -1, 70));

        jLabel18.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 40)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("VIEW STUDENT MARKS");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 570, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Calculate22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Calculate22MouseClicked
        
    }//GEN-LAST:event_btn_Calculate22MouseClicked

    private void btn_Calculate22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Calculate22ActionPerformed
      
         
        DefaultTableModel model2 = (DefaultTableModel) tbl_ViewMarks2.getModel();
        model2.setRowCount(0);

        // Retrieve the student ID from the text field
        String studentID = studnames.getSelectedItem().toString(); 
        String quizID = quizcombo.getSelectedItem().toString(); 
        // Retrieve the marks for the student from the database
        ResultSet rs = null;
        try {
            rs = retrieveStudentMarks(studentID,quizID);
            processStudentMarks(rs, model2,studentID,quizID);
            
             
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

  private ResultSet retrieveStudentMarks(String studentID, String qid) throws SQLException {
    StringBuilder sql = new StringBuilder("SELECT id, s_id, c_id, marks FROM quiz_marks WHERE id = ? and s_id = (select s_id from student where name = ?)");

    try {
        PreparedStatement stmt = connection.prepareStatement(sql.toString());
        stmt.setString(1, qid);
        stmt.setString(2, studentID);

        return stmt.executeQuery();
    } catch (SQLException e) {
        System.out.println("dbConnector not assigned: " + e.getMessage());
        throw e;
    }
}


    private void processStudentMarks(ResultSet rs,DefaultTableModel model, String studentID, String qid) throws SQLException {
        try {
            
             if (!rs.next()) {
            // No records found
            JOptionPane.showMessageDialog(null, "No records found", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;  // Return from the method as there are no records
        }

        do {
                int courseID,quizid2,quizmarks2,aid2,amarks2,sid;
                if (!studentID.isEmpty()) {
                    courseID = rs.getInt("c_id");
                    sid = rs.getInt("s_id");
                  quizid2= rs.getInt("id");
                 quizmarks2 = rs.getInt("marks");
 
                model.addRow(new Object[]{ sid, quizid2, quizmarks2});
                 }
                
               
               
            } while (rs.next());
        } catch (SQLException e) {
            System.out.println("dbConnector not assigned inside process student marks: " + e.getMessage());
            throw e;
        }
    
    }//GEN-LAST:event_btn_Calculate22ActionPerformed

   
    
    private void btn_Bck1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Bck1MouseClicked
        LecturerDashboard ll = null;
        try {
            ll = new LecturerDashboard();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(StudentMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        ll.setVisible(true);
    }//GEN-LAST:event_btn_Bck1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_Bck1;
    private javax.swing.JButton btn_Calculate22;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_stdID;
    private javax.swing.JLabel lbl_stdID3;
    private javax.swing.JComboBox<String> quizcombo;
    private javax.swing.JComboBox<String> studnames;
    private javax.swing.JTable tbl_ViewMarks2;
    private javax.swing.JLabel txt_copy1;
    // End of variables declaration//GEN-END:variables
}
