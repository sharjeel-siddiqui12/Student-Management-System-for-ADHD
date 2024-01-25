package common.gui;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Splashscreen extends javax.swing.JFrame {

    public Splashscreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        percentage = new javax.swing.JLabel();
        loarding = new javax.swing.JLabel();
        pbar = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        aboutUs3 = new javax.swing.JLabel();
        aboutUs1 = new javax.swing.JLabel();
        aboutUs2 = new javax.swing.JLabel();
        aboutUs1img = new javax.swing.JLabel();
        aboutUs3img = new javax.swing.JLabel();
        aboutUs2img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(160, 219, 221));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        percentage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        percentage.setText("0 %");
        getContentPane().add(percentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 620, -1, -1));

        loarding.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        loarding.setText("Loarding...");
        getContentPane().add(loarding, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 200, -1));
        getContentPane().add(pbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 1230, 10));

        jPanel1.setBackground(new java.awt.Color(143, 198, 227));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Brainz logo.png"))); // NOI18N
        jPanel1.add(jLabel2);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 290));

        aboutUs3.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        aboutUs3.setText("<html>Step into a world where education meets innovation. Brainz is not just a software; it's a community that understands and supports the unique journey of each child. </html>");
        getContentPane().add(aboutUs3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 440, 340, 150));

        aboutUs1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        aboutUs1.setText("<html>Welcome to Brainz! At Brainz, we're dedicated to creating a nurturing space for children affected by ADHD, fostering an environment where learning and development thrive.</html>");
        getContentPane().add(aboutUs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 290, 160));

        aboutUs2.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        aboutUs2.setText("<html>At the heart of Brainz is the belief that every child deserves an opportunity to succeed. Our team of passionate educators, psychologists, and developers collaborated to craft a software solution that goes beyond traditional learning methods. </html>");
        getContentPane().add(aboutUs2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 380, 200));

        aboutUs1img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/about1.png"))); // NOI18N
        getContentPane().add(aboutUs1img, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 130, 100));

        aboutUs3img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/about3.png"))); // NOI18N
        getContentPane().add(aboutUs3img, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 330, 130, 100));

        aboutUs2img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/about2.png"))); // NOI18N
        getContentPane().add(aboutUs2img, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 120, 90));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        Splashscreen splash = new Splashscreen();
        splash.setVisible(true);
        splash.aboutUs1img.setVisible(false);
        splash.aboutUs2img.setVisible(false);
        splash.aboutUs3img.setVisible(false);
        splash.aboutUs1.setVisible(false);
         splash.aboutUs2.setVisible(false);
         splash.aboutUs3.setVisible(false);
       

        try{
             UIManager.setLookAndFeel( new FlatMaterialLighterIJTheme() );
                for(int i=0;i<=100;i++){
                        Thread.sleep(100);
                        splash.percentage.setText(i+"%");

                        if(i == 10){
                                splash.loarding.setText("Turning On Modules...");
                                 splash.aboutUs1img.setVisible(true);
                                 splash.aboutUs1.setVisible(true);
                        }
                        if(i == 20){
                                splash.loarding.setText("Loading On Modules...");
                               
                                
                        }
                        if(i == 50){
                                splash.loarding.setText("Connecting to Database...");
                                splash.aboutUs2img.setVisible(true);
                                 splash.aboutUs2.setVisible(true);
                        }
                        if(i == 70){
                                splash.loarding.setText("Connection Successful !");
                        }
                        if(i == 80){
                                splash.loarding.setText("Lunching Application...");
                                splash.aboutUs3img.setVisible(true);
                                 splash.aboutUs3.setVisible(true);
                        }
                        splash.pbar.setValue(i);
                }
        }catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
        } 
        
        LoginNewGui userLogin = new LoginNewGui();
        userLogin.setVisible(true);
        splash.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutUs1;
    private javax.swing.JLabel aboutUs1img;
    private javax.swing.JLabel aboutUs2;
    private javax.swing.JLabel aboutUs2img;
    private javax.swing.JLabel aboutUs3;
    private javax.swing.JLabel aboutUs3img;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loarding;
    private javax.swing.JProgressBar pbar;
    private javax.swing.JLabel percentage;
    // End of variables declaration//GEN-END:variables
}
