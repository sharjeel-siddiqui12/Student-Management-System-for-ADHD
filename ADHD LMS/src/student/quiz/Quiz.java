/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.quiz;

import common.code.Auth;
import common.code.MyDbConnector;
import common.code.UserProfile;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Timer;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author ABC
 */
public class Quiz extends javax.swing.JFrame {
 private List<QuizQuestions> questions;
    private int currentQuestionIndex = 0;

    private MyDbConnector dbConnector;
    Connection connection = null;
      private long startTime;
    private Timer watchTimer;
   int questionans = 0;
   int cid;
   String cname;
    public Quiz(int cid,String cname) {
         dbConnector = new MyDbConnector();
         connection = dbConnector.getMyConnection();
        
        this.cid = cid;
        this.cname = cname;
        initComponents();
         initializeQuestions();
        displayQuestion();
    }   

    UserProfile loggedUser = Auth.getLoggedUser();  
    int slevel = loggedUser.getSLevel();
    int sid = loggedUser.getId();
    String adhdtype = loggedUser.getAdhdtype();
       
         private void initializeQuestions() {
        // Add questions with choices and correct answer index
        questions = new ArrayList<>();
        if(slevel == 3 && cname.equals("english") && adhdtype.equals("hyperactive") ){
       questions.add(new QuizQuestions("Choose the correct spelling:", new String[]{"Hapiness", "Happyness", "Happiness", "Happyness"}, "Happiness"));
        questions.add(new QuizQuestions("Select the synonym for 'happy':", new String[]{"Sad", "Joyful", "Angry", "Tired"}, "Joyful"));
        questions.add(new QuizQuestions("What is the opposite of 'big'?", new String[]{"Small", "Large", "Huge", "Tiny"}, "Small"));
        questions.add(new QuizQuestions("Which word is a verb?", new String[]{"Cat", "Run", "Blue", "Table"}, "Run"));
        questions.add(new QuizQuestions("Choose the correct sentence:", new String[]{"He go to the store.", "She goes to the store.", "They is going to the store.", "I am go to the store."}, "She goes to the store."));
        }
        else if(slevel == 2 && cname.equals("english") && adhdtype.equals("hyperactive") ){
      // Level 2 Hyperactive English Questions
questions.add(new QuizQuestions("Choose the correct spelling:", new String[]{"Beautiful", "Beutiful", "Lovely", "Attractive"}, "Beautiful"));
questions.add(new QuizQuestions("Select the synonym for 'fast':", new String[]{"Quick", "Slow", "Speedy", "Rapid"}, "Quick"));
questions.add(new QuizQuestions("What is the opposite of 'happy'?", new String[]{"Sad", "Joyful", "Angry", "Content"}, "Sad"));
questions.add(new QuizQuestions("Identify the adverb in the sentence:", new String[]{"She runs quickly.", "He is fast.", "They are happy.", "The cat is black."}, "Quickly"));
questions.add(new QuizQuestions("Choose the correct sentence:", new String[]{"He go to the store.", "She goes to the park.", "They is going to the mall.", "I am go to the party."}, "She goes to the park."));
}
        else if(slevel == 1 && cname.equals("english") && adhdtype.equals("hyperactive") ){
                questions.add(new QuizQuestions("Choose the correct spelling:", new String[]{"Occurrence", "Occurence", "Happening", "Event"}, "Occurrence"));
           questions.add(new QuizQuestions("Select the antonym for 'brave':", new String[]{"Fearless", "Cowardly", "Bold", "Courageous"}, "Cowardly"));
           questions.add(new QuizQuestions("What is the synonym for 'serene'?", new String[]{"Anxious", "Calm", "Nervous", "Energetic"}, "Calm"));
           questions.add(new QuizQuestions("Identify the correct usage of 'their':", new String[]{"Their going to the party.", "They're happy.", "There is a cat.", "They are going to their house."}, "They are going to their house."));
           questions.add(new QuizQuestions("Choose the appropriate conjunction:", new String[]{"But", "Or", "If", "Because"}, "But")); }
        //inattention
        else if(slevel == 3 && cname.equals("english") && adhdtype.equals("inattention") ){
      // Level 1 Inattention English Questions
questions.add(new QuizQuestions("Choose the correct spelling:", new String[]{"Distraction", "Distruction", "Concentration", "Focus"}, "Distraction"));
questions.add(new QuizQuestions("Select the synonym for 'quiet':", new String[]{"Loud", "Noisy", "Silent", "Talkative"}, "Silent"));
questions.add(new QuizQuestions("What is the opposite of 'attentive'?", new String[]{"Distracted", "Alert", "Focused", "Concentrated"}, "Distracted"));
questions.add(new QuizQuestions("Identify the adjective in the sentence:", new String[]{"The cat sleeps.", "She is reading.", "The book is interesting.", "He runs quickly."}, "Interesting"));
questions.add(new QuizQuestions("Choose the correct sentence:", new String[]{"He is busy.", "She is quiet.", "They are talking loudly.", "I am sleeping."}, "She is quiet."));
}
        else if(slevel == 2 && cname.equals("english") && adhdtype.equals("inattention") ){
       // Level 2 Inattention English Questions
questions.add(new QuizQuestions("Choose the correct spelling:", new String[]{"Concentration", "Concentraition", "Distraction", "Attension"}, "Concentration"));
questions.add(new QuizQuestions("Select the antonym for 'focused':", new String[]{"Attentive", "Distracted", "Alert", "Concentrated"}, "Distracted"));
questions.add(new QuizQuestions("What is the synonym for 'neglectful'?", new String[]{"Inattentive", "Careful", "Thoughtful", "Mindful"}, "Inattentive"));
questions.add(new QuizQuestions("Identify the adverb in the sentence:", new String[]{"She reads slowly.", "He is attentive.", "The music is loud.", "They talk quietly."}, "Slowly"));
questions.add(new QuizQuestions("Choose the correct sentence:", new String[]{"He pays attention.", "She is daydreaming.", "They are focused.", "I am not listening."}, "He pays attention."));
}
        else if(slevel == 1 && cname.equals("english") && adhdtype.equals("inattention") ){
      // Level 3 Inattention English Questions
questions.add(new QuizQuestions("Choose the correct spelling:", new String[]{"Inattentiveness", "Inatentioness", "Distractiveness", "Attentionness"}, "Inattentiveness"));
questions.add(new QuizQuestions("Select the antonym for 'negligent':", new String[]{"Attentive", "Inattentive", "Careful", "Thoughtful"}, "Attentive"));
questions.add(new QuizQuestions("What is the synonym for 'unmindful'?", new String[]{"Distracted", "Inattentive", "Careful", "Mindful"}, "Inattentive"));
questions.add(new QuizQuestions("Identify the adverb in the sentence:", new String[]{"She works diligently.", "He is inattentive.", "The room is quiet.", "They speak softly."}, "Diligently"));
questions.add(new QuizQuestions("Choose the correct sentence:", new String[]{"He remains focused.", "She is easily distracted.", "They are attentive.", "I am ignoring."}, "He remains focused."));
}
//        //impulsive
//        else if(slevel == 3 && cname.equals("english") && adhdtype.equals("impulsive") ){
//       questions.add(new QuizQuestions("Choose the correct spelling:", new String[]{"Impulsive", "Impulsiv", "Impulsiveness", "Compulsive"}, "Impulsive"));
//questions.add(new QuizQuestions("Select the synonym for 'rash':", new String[]{"Cautious", "Careful", "Impetuous", "Judicious"}, "Impetuous"));
//questions.add(new QuizQuestions("What is the opposite of 'thoughtful'?", new String[]{"Hasty", "Considerate", "Deliberate", "Reflective"}, "Considerate"));
//questions.add(new QuizQuestions("Identify the adjective in the sentence:", new String[]{"The decision was hasty.", "He acts impulsively.", "The plan is thoughtful.", "She speaks carefully."}, "Hasty"));
//questions.add(new QuizQuestions("Choose the correct sentence:", new String[]{"He thinks before acting.", "She is impulsive.", "They are careful.", "I am pondering."}, "He thinks before acting."));
// }
//        else if(slevel == 2 && cname.equals("english") && adhdtype.equals("impulsive") ){
//      questions.add(new QuizQuestions("Choose the correct spelling:", new String[]{"Spontaneous", "Spontanous", "Impulsiveness", "Compulsiveness"}, "Spontaneous"));
//questions.add(new QuizQuestions("Select the antonym for 'reckless':", new String[]{"Careful", "Thoughtful", "Prudent", "Cautious"}, "Careful"));
//questions.add(new QuizQuestions("What is the synonym for 'precipitate'?", new String[]{"Hasty", "Deliberate", "Considerate", "Reflective"}, "Hasty"));
//questions.add(new QuizQuestions("Identify the adverb in the sentence:", new String[]{"She acts impulsively.", "He is careful.", "The decision was thoughtful.", "They speak rapidly."}, "Rapidly"));
//questions.add(new QuizQuestions("Choose the correct sentence:", new String[]{"He considers before speaking.", "She is impulsive.", "They are prudent.", "I am pondering."}, "He considers before speaking."));
// }
//        else if(slevel == 1 && cname.equals("english") && adhdtype.equals("impulsive") ){
//      questions.add(new QuizQuestions("Choose the correct spelling:", new String[]{"Impulsivity", "Impulsivenes", "Compulsivity", "Rashness"}, "Impulsivity"));
//questions.add(new QuizQuestions("Select the antonym for 'heedless':", new String[]{"Cautious", "Careful", "Prudent", "Deliberate"}, "Cautious"));
//questions.add(new QuizQuestions("What is the synonym for 'rashness'?", new String[]{"Impulsiveness", "Carefulness", "Thoughtfulness", "Judiciousness"}, "Impulsiveness"));
//questions.add(new QuizQuestions("Identify the adverb in the sentence:", new String[]{"She acts impulsively.", "He is careful.", "The decision was thoughtful.", "They speak rapidly."}, "Rapidly"));
//questions.add(new QuizQuestions("Choose the correct sentence:", new String[]{"He considers before speaking.", "She is impulsive.", "They are prudent.", "I am pondering."}, "He considers before speaking.")); }
//        
        //english questions
          if(slevel == 3 && cname.equals("english") && adhdtype.equals("hyperactive") ){
      // Level 1 Hyperactive Maths Questions
questions.add(new QuizQuestions("Solve the equation: 2 + 3 =", new String[]{"4", "5", "6", "7"}, "5"));
questions.add(new QuizQuestions("What is the result of 8 - 3?", new String[]{"2", "3", "4", "5"}, "5"));
questions.add(new QuizQuestions("If you have 2 apples and get 3 more, how many apples do you have?", new String[]{"3", "4", "5", "6"}, "5"));
questions.add(new QuizQuestions("How many sides does a triangle have?", new String[]{"2", "3", "4", "5"}, "3"));
questions.add(new QuizQuestions("Count from 1 to 5.", new String[]{"1, 2, 3", "2, 3, 4", "3, 4, 5", "4, 5, 6"}, "1, 2, 3"));
 }
        
        else if(slevel == 2 && cname.equals("english") && adhdtype.equals("hyperactive") ){
     // Level 2 Hyperactive Maths Questions
questions.add(new QuizQuestions("Solve the equation: 3 x 4 =", new String[]{"10", "12", "15", "18"}, "12"));
questions.add(new QuizQuestions("Calculate the area of a rectangle with length 6 cm and width 4 cm.", new String[]{"18 cm²", "20 cm²", "24 cm²", "30 cm²"}, "24 cm²"));
questions.add(new QuizQuestions("What is the result of 25 ÷ 5?", new String[]{"3", "5", "8", "12"}, "5"));
questions.add(new QuizQuestions("If a square has all sides of equal length, what type of square is it?", new String[]{"Regular", "Irregular", "Triangle", "Circle"}, "Regular"));
questions.add(new QuizQuestions("Simplify: 2 + 3 x 4", new String[]{"14", "16", "18", "20"}, "14"));
}
        else if(slevel == 1 && cname.equals("english") && adhdtype.equals("hyperactive") ){
         questions.add(new QuizQuestions("Solve the quadratic equation: x² - 9 = 0", new String[]{"x = 3, 4", "x = 4, 5", "x = 3, 6", "x = 4, 7"}, "x = 3, 6"));
questions.add(new QuizQuestions("Calculate the volume of a cube with side length 3 cm.", new String[]{"9 cm³", "18 cm³", "27 cm³", "36 cm³"}, "27 cm³"));
questions.add(new QuizQuestions("What is the result of 16 ÷ (4 x 2)?", new String[]{"1", "2", "3", "4"}, "2"));
questions.add(new QuizQuestions("If a parallelogram has opposite sides equal and parallel, what type of parallelogram is it?", new String[]{"Rhombus", "Rectangle", "Square", "Trapezoid"}, "Rhombus"));
questions.add(new QuizQuestions("Simplify: 5² - 3³", new String[]{"4", "16", "22", "34"}, "16"));}
        //inattention
   else if (slevel == 3 && cname.equals("english") && adhdtype.equals("inattention")) {
    // Level 1 Inattention Maths Questions
    questions.add(new QuizQuestions("Solve the equation: 4 + 2 =", new String[]{"5", "6", "7", "8"}, "6"));
    questions.add(new QuizQuestions("What is the result of 9 - 3?", new String[]{"3", "4", "5", "6"}, "6"));
    questions.add(new QuizQuestions("If you have 3 pencils and get 2 more, how many pencils do you have?", new String[]{"3", "4", "5", "6"}, "5"));
    questions.add(new QuizQuestions("How many sides does a rectangle have?", new String[]{"2", "3", "4", "5"}, "4"));
    questions.add(new QuizQuestions("Count from 1 to 6.", new String[]{"1, 2, 3", "2, 3, 4", "3, 4, 5", "4, 5, 6"}, "1, 2, 3"));
}

        else if(slevel == 2 && cname.equals("english") && adhdtype.equals("inattention") ){
      // Level 2 Inattention Maths Questions
questions.add(new QuizQuestions("Solve the equation: 5 x 3 =", new String[]{"10", "12", "15", "18"}, "15"));
questions.add(new QuizQuestions("Calculate the area of a square with side length 5 cm.", new String[]{"15 cm²", "20 cm²", "25 cm²", "30 cm²"}, "25 cm²"));
questions.add(new QuizQuestions("What is the result of 30 ÷ 6?", new String[]{"3", "5", "8", "12"}, "5"));
questions.add(new QuizQuestions("If a triangle has angles 60°, 90°, 30°,what type of triangle is it?", new String[]{"Equilateral", "Isosceles", "Scalene", "Right-angled"}, "Right-angled"));
questions.add(new QuizQuestions("Simplify: 4 + 2 x 3", new String[]{"10", "12", "18", "24"}, "10"));
}
        else if(slevel == 1 && cname.equals("english") && adhdtype.equals("inattention") ){
     // Level 3 Inattention Maths Questions
questions.add(new QuizQuestions("Solve the quadratic equation: x² - 16 = 0", new String[]{"x = 3, 4", "x = 4, 5", "x = 3, 6", "x = 4, 7"}, "x = 4"));
questions.add(new QuizQuestions("Calculate the volume with length 4 cm, width 3 cm, and height 2 cm.", new String[]{"24 cm³", "30 cm³", "36 cm³", "40 cm³"}, "24 cm³"));
questions.add(new QuizQuestions("What is the result of 20 ÷ (5 x 2)?", new String[]{"1", "2", "3", "4"}, "2"));
questions.add(new QuizQuestions("If a rhombus has all sides equal and opposite angles equal, what type of rhombus is it?", new String[]{"Regular", "Irregular", "Triangle", "Square"}, "Regular"));
questions.add(new QuizQuestions("Simplify: 6² - 3³", new String[]{"15", "27", "33", "45"}, "15"));}
        //impulsive
        else if(slevel == 3 && cname.equals("english") && adhdtype.equals("impulsive") ){
       questions.add(new QuizQuestions("Solve the equation: 5 x 3 =", new String[]{"10", "12", "15", "18"}, "15"));
questions.add(new QuizQuestions("Calculate the area of a square with side length 5 cm.", new String[]{"15 cm²", "20 cm²", "25 cm²", "30 cm²"}, "25 cm²"));
questions.add(new QuizQuestions("What is the result of 30 ÷ 6?", new String[]{"3", "5", "8", "12"}, "5"));
questions.add(new QuizQuestions("If a triangle has angles 60°, 90°, 30°,what type of triangle is it?", new String[]{"Equilateral", "Isosceles", "Scalene", "Right-angled"}, "Right-angled"));
questions.add(new QuizQuestions("Simplify: 4 + 2 x 3", new String[]{"10", "12", "18", "24"}, "10"));
 }
        else if(slevel == 2 && cname.equals("english") && adhdtype.equals("impulsive") ){
      questions.add(new QuizQuestions("Solve the equation: 5 x 3 =", new String[]{"10", "12", "15", "18"}, "15"));
questions.add(new QuizQuestions("Calculate the area of a square with side length 5 cm.", new String[]{"15 cm²", "20 cm²", "25 cm²", "30 cm²"}, "25 cm²"));
questions.add(new QuizQuestions("What is the result of 30 ÷ 6?", new String[]{"3", "5", "8", "12"}, "5"));
questions.add(new QuizQuestions("If a triangle has angles 60°, 90°, 30°,what type of triangle is it?", new String[]{"Equilateral", "Isosceles", "Scalene", "Right-angled"}, "Right-angled"));
questions.add(new QuizQuestions("Simplify: 4 + 2 x 3", new String[]{"10", "12", "18", "24"}, "10"));
 }
        else if(slevel == 1 && cname.equals("english") && adhdtype.equals("impulsive") ){
      questions.add(new QuizQuestions("Solve the equation: 5 x 3 =", new String[]{"10", "12", "15", "18"}, "15"));
questions.add(new QuizQuestions("Calculate the area of a square with side length 5 cm.", new String[]{"15 cm²", "20 cm²", "25 cm²", "30 cm²"}, "25 cm²"));
questions.add(new QuizQuestions("What is the result of 30 ÷ 6?", new String[]{"3", "5", "8", "12"}, "5"));
questions.add(new QuizQuestions("If a triangle has angles 60°, 90°, 30°,what type of triangle is it?", new String[]{"Equilateral", "Isosceles", "Scalene", "Right-angled"}, "Right-angled"));
questions.add(new QuizQuestions("Simplify: 4 + 2 x 3", new String[]{"10", "12", "18", "24"}, "10"));     
    }
         }
     private void displayQuestion() {
          q1bg.clearSelection();

        QuizQuestions currentQuestion = questions.get(currentQuestionIndex);
        questionno.setText("QUESTION " + (currentQuestionIndex + 1));
        questionlabel.setText(currentQuestion.getQuestion());

        String[] choices = currentQuestion.getChoices();
        q1p1.setText(choices[0]);
        q1p2.setText(choices[1]);
        q1p3.setText(choices[2]);
        q1p4.setText(choices[3]);
        startWatchTimer();
    }
     
     
    private void startWatchTimer() {
    startTime = System.currentTimeMillis();
    watchTimer = new Timer();
    
       
}
    

    private void stopWatchTimer() {
        if (watchTimer != null) {
            watchTimer.cancel();
            watchTimer = null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        q1bg = new javax.swing.ButtonGroup();
        q2bg = new javax.swing.ButtonGroup();
        q3bg = new javax.swing.ButtonGroup();
        q4bg = new javax.swing.ButtonGroup();
        q5bg = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        buttonGroup13 = new javax.swing.ButtonGroup();
        buttonGroup14 = new javax.swing.ButtonGroup();
        buttonGroup15 = new javax.swing.ButtonGroup();
        buttonGroup16 = new javax.swing.ButtonGroup();
        buttonGroup17 = new javax.swing.ButtonGroup();
        buttonGroup18 = new javax.swing.ButtonGroup();
        buttonGroup19 = new javax.swing.ButtonGroup();
        buttonGroup20 = new javax.swing.ButtonGroup();
        buttonGroup21 = new javax.swing.ButtonGroup();
        buttonGroup22 = new javax.swing.ButtonGroup();
        buttonGroup23 = new javax.swing.ButtonGroup();
        buttonGroup24 = new javax.swing.ButtonGroup();
        buttonGroup25 = new javax.swing.ButtonGroup();
        buttonGroup26 = new javax.swing.ButtonGroup();
        buttonGroup27 = new javax.swing.ButtonGroup();
        buttonGroup28 = new javax.swing.ButtonGroup();
        buttonGroup29 = new javax.swing.ButtonGroup();
        buttonGroup30 = new javax.swing.ButtonGroup();
        p1 = new javax.swing.JPanel();
        questionno = new javax.swing.JLabel();
        q1p1 = new javax.swing.JRadioButton();
        q1p2 = new javax.swing.JRadioButton();
        q1p3 = new javax.swing.JRadioButton();
        q1p4 = new javax.swing.JRadioButton();
        next1 = new javax.swing.JButton();
        questionlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p1.setBackground(new java.awt.Color(255, 217, 66));
        p1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(102, 0, 0)));
        p1.setForeground(new Color(0,0,0,5));

        questionno.setFont(new java.awt.Font("Bookman Old Style", 1, 48)); // NOI18N
        questionno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionno.setText("QUESTION 1");

        q1bg.add(q1p1);
        q1p1.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        q1p1.setText("Run ");
        q1p1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        q1p1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q1p1ActionPerformed(evt);
            }
        });

        q1bg.add(q1p2);
        q1p2.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        q1p2.setText("Happy");
        q1p2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        q1p2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q1p2ActionPerformed(evt);
            }
        });

        q1bg.add(q1p3);
        q1p3.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        q1p3.setText("Dog");
        q1p3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q1p3ActionPerformed(evt);
            }
        });

        q1bg.add(q1p4);
        q1p4.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        q1p4.setText("Quickly");
        q1p4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q1p4ActionPerformed(evt);
            }
        });

        next1.setBackground(new java.awt.Color(51, 0, 0));
        next1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        next1.setForeground(new java.awt.Color(255, 255, 255));
        next1.setText("NEXT");
        next1.setBorder(null);
        next1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        next1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next1ActionPerformed(evt);
            }
        });

        questionlabel.setFont(new java.awt.Font("Bahnschrift", 1, 30)); // NOI18N
        questionlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionlabel.setText("<html>Which word is a noun?</html>");

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(next1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(p1Layout.createSequentialGroup()
                                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(q1p1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                    .addComponent(q1p3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(49, 49, 49)
                                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(q1p2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(q1p4, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))))
                        .addGap(51, 51, 51))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(questionno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(questionlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE))))
                .addContainerGap())
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(questionno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(questionlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q1p1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q1p2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q1p3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q1p4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(next1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        getContentPane().add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/quiz/ezgif.com-resize-overlay (1).jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void next1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next1ActionPerformed
        if (q1bg.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Please select one option for each question first!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            ButtonModel selectedModel = q1bg.getSelection();
            String selectedOption = "";

            for (Enumeration<AbstractButton> buttons = q1bg.getElements(); buttons.hasMoreElements(); ) {
                AbstractButton button = buttons.nextElement();
                if (button.getModel() == selectedModel) {
                    selectedOption = button.getActionCommand();
                    break;
                }
            }

            questions.get(currentQuestionIndex).setUserSelectedIndex(selectedOption);

            if (questions.get(currentQuestionIndex).isCorrect()) {
                questionans += 1;
            }

            currentQuestionIndex++;

            if (currentQuestionIndex < questions.size()) {
                displayQuestion();
            } else {
            // If it's the last question, change the button text to "Submit"
            next1.setText("Submit");
        
            if (currentQuestionIndex == questions.size()) {
                // If it's the last question, handle the submission
                stopWatchTimer();
                submitQuiz();
                
            }
           
            }
        }
    
    }//GEN-LAST:event_next1ActionPerformed
    private void submitQuiz() {
        // Handle the submission logic here
        // For example, open the result class JFrame
        Result resultFrame = new Result(questions,questionans,cid);
        resultFrame.setVisible(true);
        // You might want to close the current quiz JFrame or perform other actions as needed
        this.dispose();
    }
    private void q1p4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q1p4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q1p4ActionPerformed

    private void q1p3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q1p3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q1p3ActionPerformed

    private void q1p2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q1p2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q1p2ActionPerformed

    private void q1p1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q1p1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q1p1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup13;
    private javax.swing.ButtonGroup buttonGroup14;
    private javax.swing.ButtonGroup buttonGroup15;
    private javax.swing.ButtonGroup buttonGroup16;
    private javax.swing.ButtonGroup buttonGroup17;
    private javax.swing.ButtonGroup buttonGroup18;
    private javax.swing.ButtonGroup buttonGroup19;
    private javax.swing.ButtonGroup buttonGroup20;
    private javax.swing.ButtonGroup buttonGroup21;
    private javax.swing.ButtonGroup buttonGroup22;
    private javax.swing.ButtonGroup buttonGroup23;
    private javax.swing.ButtonGroup buttonGroup24;
    private javax.swing.ButtonGroup buttonGroup25;
    private javax.swing.ButtonGroup buttonGroup26;
    private javax.swing.ButtonGroup buttonGroup27;
    private javax.swing.ButtonGroup buttonGroup28;
    private javax.swing.ButtonGroup buttonGroup29;
    private javax.swing.ButtonGroup buttonGroup30;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton next1;
    private javax.swing.JPanel p1;
    private javax.swing.ButtonGroup q1bg;
    private javax.swing.JRadioButton q1p1;
    private javax.swing.JRadioButton q1p2;
    private javax.swing.JRadioButton q1p3;
    private javax.swing.JRadioButton q1p4;
    private javax.swing.ButtonGroup q2bg;
    private javax.swing.ButtonGroup q3bg;
    private javax.swing.ButtonGroup q4bg;
    private javax.swing.ButtonGroup q5bg;
    private javax.swing.JLabel questionlabel;
    private javax.swing.JLabel questionno;
    // End of variables declaration//GEN-END:variables
}
