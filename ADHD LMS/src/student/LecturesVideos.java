///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package student;
//
//import common.code.Auth;
//import common.code.MyDbConnector;
//import common.code.UserProfile;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class LecturesVideos extends JFrame {
//
//   
//    public LecturesVideos(String cname) {
//        this.cname = cname;
//        
//        dbConnector = new MyDbConnector();
//        
//        System.out.println(slevel);
//        
//      
//        getCID();
//        // Create a JComboBox to select the video
//
//        // Create a "Play" button
//        JButton playButton = new JButton("Play");
//        playButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                startWatchTimer(cid);
//                playVideo(videoPaths);
//            }
//        });
//
//        // Set up the layout
//        JPanel panel = new JPanel();
//        panel.add(playButton);
//
//        getContentPane().add(panel);
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(200, 100);
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//}
