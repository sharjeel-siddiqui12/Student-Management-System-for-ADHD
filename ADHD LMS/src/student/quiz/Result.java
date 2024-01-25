/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.quiz;

import common.code.Auth;
import common.code.MyDbConnector;
import common.code.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import student.StudentDashboard;
import student.quiz.QuizQuestions;

/**
 *
 * @author ABC
 */
public class Result extends javax.swing.JFrame {

    private List<QuizQuestions> questions = new ArrayList<>();
    int correctans = 0;
    
    private MyDbConnector dbConnector;
    Connection connection = null;
    
     UserProfile loggedUser = Auth.getLoggedUser();  
    String name = loggedUser.getUsername();
    int sid = loggedUser.getId();
    
    
    public Result(List<QuizQuestions> questions,int correctans,int cid) {
         dbConnector = new MyDbConnector();
         connection = dbConnector.getMyConnection();
        initComponents();
        this.questions = questions;
        this.correctans = correctans;
         studname.setText(name.toUpperCase());
        displayQuestionsWithAnswers(questions);
        // Provide remarks based on the score
        displayRemarks(cid);
        
    }
    
     private void insertmarks(int cid,int marks, String feedback) {
    try {
       
        // Update watch time in the database
        String updateSQL = "insert into quiz_marks(c_id,s_id,marks,feedback) values(?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(updateSQL);
        pstmt.setLong(1, cid);
        pstmt.setInt(2, sid);
        pstmt.setInt(3, marks);
        pstmt.setString(4, feedback);
        pstmt.executeUpdate();

        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
     private void displayRemarks(int cid) {
        double percentage = (double) correctans / 5 * 100;

        if (percentage >= 80) {
            remarksLabel.setText("Great job! You scored an excellent grade!");
        } else if (percentage >= 60) {
            remarksLabel.setText("Well done! You scored a good grade.");
        } else if (percentage >= 40) {
            remarksLabel.setText("Keep practicing! You're making progress.");
        } else {
            remarksLabel.setText("You may need more practice. Don't give up!");
        }
         System.out.println(cid + " " + sid + "" + correctans);
        insertmarks(cid,correctans,remarksLabel.getText());
    }
     private void displayQuestionsWithAnswers(List<QuizQuestions> questions) {
    for (int i = 0; i < questions.size(); i++) {
        QuizQuestions question = questions.get(i);
        String questionText = question.getQuestion();
        String userSelectedAnswer = question.getUserSelected();
        String correctAnswer = question.getCorrectAnswer();

        JLabel questionLabel = getQuestionLabel(i + 1);
        JLabel correctAnsLabel = getCorrectAnsLabel(i + 1);
        JLabel wrongAnsLabel = getWrongAnsLabel(i + 1);

        questionLabel.setText("Q" + (i + 1) + ": " + questionText);

        if (userSelectedAnswer != null && !userSelectedAnswer.equals(correctAnswer)) {
            // Wrong answer selected, display only the correct answer
            correctAnsLabel.setText("Correct Answer: " + correctAnswer);
            wrongAnsLabel.setText("Your Answer: " + userSelectedAnswer);
        } else {
            // Either correct answer selected or no answer, display only the correct answer
            correctAnsLabel.setText("Correct Answer: " + correctAnswer);
            wrongAnsLabel.setVisible(false);

        }
    }
}

    private JLabel getQuestionLabel(int index) {
        switch (index) {
            case 1:
                return q1;
            case 2:
                return q2;
            case 3:
                return q3;
            case 4:
                return q4;
            case 5:
                return q5;
            default:
                return new JLabel();
        }
    }

    private JLabel getCorrectAnsLabel(int index) {
        switch (index) {
            case 1:
                return correctans1;
            case 2:
                return correctans2;
            case 3:
                return correctans3;
            case 4:
                return correctans4;
            case 5:
                return correctans5;
            default:
                return new JLabel();
        }
    }

    private JLabel getWrongAnsLabel(int index) {
        switch (index) {
            case 1:
                return wrongans1;
            case 2:
                return wrongans2;
            case 3:
                return wrongans3;
            case 4:
                return wrongans4;
            case 5:
                return wrongans5;
            default:
                return new JLabel();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        wrongans1 = new javax.swing.JLabel();
        q1 = new javax.swing.JLabel();
        correctans1 = new javax.swing.JLabel();
        correctans2 = new javax.swing.JLabel();
        wrongans2 = new javax.swing.JLabel();
        correctans3 = new javax.swing.JLabel();
        wrongans3 = new javax.swing.JLabel();
        wrongans4 = new javax.swing.JLabel();
        correctans4 = new javax.swing.JLabel();
        correctans5 = new javax.swing.JLabel();
        wrongans5 = new javax.swing.JLabel();
        q2 = new javax.swing.JLabel();
        q3 = new javax.swing.JLabel();
        q4 = new javax.swing.JLabel();
        q5 = new javax.swing.JLabel();
        remarksLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        studname = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wrongans1.setBackground(new java.awt.Color(0, 204, 0));
        wrongans1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        wrongans1.setForeground(new java.awt.Color(153, 0, 0));
        wrongans1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wrongans1.setText("IF WRONG ANSWER THEN IT WILL COME HERE");
        wrongans1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jPanel1.add(wrongans1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 320, 50));

        q1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        q1.setText("QUESTION NO 1) COMES HERE");
        jPanel1.add(q1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 390, 50));

        correctans1.setBackground(new java.awt.Color(0, 204, 0));
        correctans1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        correctans1.setForeground(new java.awt.Color(0, 204, 0));
        correctans1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        correctans1.setText("CORRECT ANSWER COMES HERE");
        correctans1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel1.add(correctans1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 290, 50));

        correctans2.setBackground(new java.awt.Color(0, 204, 0));
        correctans2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        correctans2.setForeground(new java.awt.Color(0, 204, 0));
        correctans2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        correctans2.setText("CORRECT ANSWER COMES HERE");
        correctans2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel1.add(correctans2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 290, 50));

        wrongans2.setBackground(new java.awt.Color(0, 204, 0));
        wrongans2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        wrongans2.setForeground(new java.awt.Color(153, 0, 0));
        wrongans2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wrongans2.setText("IF WRONG ANSWER THEN IT WILL COME HERE");
        wrongans2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jPanel1.add(wrongans2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 320, 50));

        correctans3.setBackground(new java.awt.Color(0, 204, 0));
        correctans3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        correctans3.setForeground(new java.awt.Color(0, 204, 0));
        correctans3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        correctans3.setText("CORRECT ANSWER COMES HERE");
        correctans3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel1.add(correctans3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 290, 50));

        wrongans3.setBackground(new java.awt.Color(0, 204, 0));
        wrongans3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        wrongans3.setForeground(new java.awt.Color(153, 0, 0));
        wrongans3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wrongans3.setText("IF WRONG ANSWER THEN IT WILL COME HERE");
        wrongans3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jPanel1.add(wrongans3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 320, 50));

        wrongans4.setBackground(new java.awt.Color(0, 204, 0));
        wrongans4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        wrongans4.setForeground(new java.awt.Color(153, 0, 0));
        wrongans4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wrongans4.setText("IF WRONG ANSWER THEN IT WILL COME HERE");
        wrongans4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jPanel1.add(wrongans4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 320, 50));

        correctans4.setBackground(new java.awt.Color(0, 204, 0));
        correctans4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        correctans4.setForeground(new java.awt.Color(0, 204, 0));
        correctans4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        correctans4.setText("CORRECT ANSWER COMES HERE");
        correctans4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel1.add(correctans4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 290, 50));

        correctans5.setBackground(new java.awt.Color(0, 204, 0));
        correctans5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        correctans5.setForeground(new java.awt.Color(0, 204, 0));
        correctans5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        correctans5.setText("CORRECT ANSWER COMES HERE");
        correctans5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel1.add(correctans5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 290, 50));

        wrongans5.setBackground(new java.awt.Color(0, 204, 0));
        wrongans5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        wrongans5.setForeground(new java.awt.Color(153, 0, 0));
        wrongans5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wrongans5.setText("IF WRONG ANSWER THEN IT WILL COME HERE");
        wrongans5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jPanel1.add(wrongans5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 320, 50));

        q2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        q2.setText("QUESTION NO 2) COMES HERE");
        jPanel1.add(q2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 390, 50));

        q3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        q3.setText("QUESTION NO 3) COMES HERE");
        jPanel1.add(q3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 390, 50));

        q4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        q4.setText("QUESTION NO 4) COMES HERE");
        jPanel1.add(q4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 390, 50));

        q5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        q5.setText("QUESTION NO 5) COMES HERE");
        jPanel1.add(q5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 390, 50));

        remarksLabel.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        remarksLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        remarksLabel.setText("excellent");
        remarksLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remarksLabelMouseClicked(evt);
            }
        });
        jPanel1.add(remarksLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 620, 50));

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("STUDENT QUIZ RESULT");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 720, 70));

        studname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        studname.setForeground(new java.awt.Color(255, 255, 255));
        studname.setText("STUDENT NAME HERE");
        studname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studnameMouseEntered(evt);
            }
        });
        jPanel6.add(studname, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("HOME");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1087, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void remarksLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remarksLabelMouseClicked
        //        admin.back(admin);
        //        this.dispose();
    }//GEN-LAST:event_remarksLabelMouseClicked

    private void studnameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studnameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_studnameMouseEntered

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        //        admin.back(admin);
        student.StudentDashboard d = new StudentDashboard();
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel correctans1;
    private javax.swing.JLabel correctans2;
    private javax.swing.JLabel correctans3;
    private javax.swing.JLabel correctans4;
    private javax.swing.JLabel correctans5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel q1;
    private javax.swing.JLabel q2;
    private javax.swing.JLabel q3;
    private javax.swing.JLabel q4;
    private javax.swing.JLabel q5;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JLabel studname;
    private javax.swing.JLabel wrongans1;
    private javax.swing.JLabel wrongans2;
    private javax.swing.JLabel wrongans3;
    private javax.swing.JLabel wrongans4;
    private javax.swing.JLabel wrongans5;
    // End of variables declaration//GEN-END:variables
}
