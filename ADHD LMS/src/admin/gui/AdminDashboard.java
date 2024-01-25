package admin.gui;

import notice.GlassPanePopup;
import notice.NoticeDatabase;
import common.code.Auth;
import common.code.MyDbConnector;
import common.code.UserProfile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class AdminDashboard extends javax.swing.JFrame  {
    
    int teacherCount=0;
     int coursesCount=0 ;
        int studentCount =0;
        int doctorCount =0;
        int parentCount=0;
    
    UserProfile loggedUser = Auth.getLoggedUser();
    private MyDbConnector dbConnector;
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement preStmt = null;
    
    private GlassPanePopup glassPanePopup;
    private JPanel contentPane;
    
    public AdminDashboard() {
         dbConnector = new MyDbConnector();
         connection = dbConnector.getMyConnection();
   
        initComponents();
        setCounts();
        showPieChart();
        showBarChartStd();
        showBarChartTch();
        showBarChartLevel();
        showBarChartType();
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////

 public void showPieChart(){
        
    
     
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue( "Courses" , coursesCount );  
      barDataset.setValue( "Teachers" , teacherCount   );   
      barDataset.setValue( "Students" , studentCount  );    
      barDataset.setValue( "Parents" ,  parentCount  );  
      barDataset.setValue( "Doctors" ,  doctorCount );  
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Users",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
        piechart.setBackgroundPaint(new Color(251, 255, 239));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
       
        // Set font to Tahoma
    

        // Set title font
        TextTitle title = piechart.getTitle();
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
       // panelBarChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();

    }    
    
    
 
/////////////////////////////////////////////////////////////////////////////////////////////////////////

   public void showBarChartStd() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.setValue(10, "Students", "Jan");
    dataset.setValue(20, "Students", "Feb");
    dataset.setValue(30, "Students", "Mar");
    dataset.setValue(10, "Students", "Apr");
    dataset.setValue(40, "Students", "May");
    dataset.setValue(40, "Students", "Jun");
    dataset.setValue(40, "Students", "Jul");
    dataset.setValue(40, "Students", "Aug");
    dataset.setValue(40, "Students", "Sep");
    dataset.setValue(40, "Students", "Oct");
    dataset.setValue(40, "Students", "Nov");
    dataset.setValue(40, "Students", "Dec");

    JFreeChart chart = ChartFactory.createBarChart("Students", "months", "Students",
    dataset, PlotOrientation.VERTICAL, false, true, false);

    CategoryPlot categoryPlot = chart.getCategoryPlot();
    categoryPlot.setBackgroundPaint(new Color(255,255,255)); // Transparent background

    BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
    Color clr3 = new Color(200, 80, 51);
    renderer.setSeriesPaint(0, clr3);
    
    

    // Set font to Tahoma
    Font labelFont = new Font("Tahoma", Font.PLAIN, 16);
    categoryPlot.getDomainAxis().setLabelFont(labelFont);
    categoryPlot.getRangeAxis().setLabelFont(labelFont);

    // Set legend font (if legend is not null)
    LegendTitle legend = chart.getLegend();
    if (legend != null) {
        legend.setItemFont(labelFont);
    }

    // Set title font
    TextTitle title = chart.getTitle();
    title.setFont(new Font("Tahoma", Font.BOLD, 18));

    // Set outer area background color to red
    chart.setBackgroundPaint(new Color(251, 255, 239));

    ChartPanel barChartPanel = new ChartPanel(chart);
    panelBarChart.removeAll();
    panelBarChart.add(barChartPanel, BorderLayout.CENTER);
    panelBarChart.validate();
}


  
  
  
  public void showBarChartTch() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.setValue(10, "Teachers", "Jan");
    dataset.setValue(20, "Teachers", "Feb");
    dataset.setValue(20, "Teachers", "Mar");
    dataset.setValue(10, "Teachers", "Apr");
    dataset.setValue(5, "Teachers", "May");
    dataset.setValue(5, "Teachers", "Jun");
    dataset.setValue(5, "Teachers", "Jul");
    dataset.setValue(5, "Teachers", "Aug");
    dataset.setValue(5, "Teachers", "Sept");
    dataset.setValue(5, "Teachers", "Oct");
    dataset.setValue(5, "Teachers", "Nov");
    dataset.setValue(5, "Teachers", "Dec");

    JFreeChart chart = ChartFactory.createBarChart("Teachers", "months", "Teachers",
    dataset, PlotOrientation.VERTICAL, false, true, false);

    CategoryPlot categoryPlot = chart.getCategoryPlot();
    categoryPlot.setBackgroundPaint(new Color(255,255,255)); // Transparent background

    BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
    Color clr3 = new Color(80, 90, 51);
    renderer.setSeriesPaint(0, clr3);
    
    

    // Set font to Tahoma
    Font labelFont = new Font("Tahoma", Font.PLAIN, 16);
    categoryPlot.getDomainAxis().setLabelFont(labelFont);
    categoryPlot.getRangeAxis().setLabelFont(labelFont);

    // Set legend font (if legend is not null)
    LegendTitle legend = chart.getLegend();
    if (legend != null) {
        legend.setItemFont(labelFont);
    }

    // Set title font
    TextTitle title = chart.getTitle();
    title.setFont(new Font("Tahoma", Font.BOLD, 18));

    // Set outer area background color to red
    chart.setBackgroundPaint(new Color(251, 255, 239));

    ChartPanel barChartPanel = new ChartPanel(chart);
    panelBarChartTch.removeAll();
    panelBarChartTch.add(barChartPanel, BorderLayout.CENTER);
    panelBarChartTch.validate();
}
 
  
  public void showBarChartLevel() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.setValue(20, "Students", "Level 1");
    dataset.setValue(30, "Students", "Level 2");
    dataset.setValue(20, "Students", "Level 3");
    

    JFreeChart chart = ChartFactory.createBarChart(" Level of Students", "Levels", "Students",
    dataset, PlotOrientation.VERTICAL, false, true, false);

    CategoryPlot categoryPlot = chart.getCategoryPlot();
    categoryPlot.setBackgroundPaint(new Color(255,255,255)); // Transparent background

    BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
    Color clr3 = new Color(60, 90, 200);
    renderer.setSeriesPaint(0, clr3);
    
    

    // Set font to Tahoma
    Font labelFont = new Font("Tahoma", Font.PLAIN, 16);
    categoryPlot.getDomainAxis().setLabelFont(labelFont);
    categoryPlot.getRangeAxis().setLabelFont(labelFont);

    // Set legend font (if legend is not null)
    LegendTitle legend = chart.getLegend();
    if (legend != null) {
        legend.setItemFont(labelFont);
    }

    // Set title font
    TextTitle title = chart.getTitle();
    title.setFont(new Font("Tahoma", Font.BOLD, 18));

    // Set outer area background color to red
    chart.setBackgroundPaint(new Color(251, 255, 239));

    ChartPanel barChartPanel = new ChartPanel(chart);
    panelBarChartLevel.removeAll();
    panelBarChartLevel.add(barChartPanel, BorderLayout.CENTER);
    panelBarChartLevel.validate();
}
  
  
  public void showBarChartType() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.setValue(10, "Students", "Inattentive");
    dataset.setValue(20, "Students", "Hyperactive");
    dataset.setValue(40, "Students", "Impulsive");
   
    

    JFreeChart chart = ChartFactory.createBarChart("Types of ADHD", "Types", "Students",
    dataset, PlotOrientation.VERTICAL, false, true, false);

    CategoryPlot categoryPlot = chart.getCategoryPlot();
    categoryPlot.setBackgroundPaint(new Color(255,255,255)); // Transparent background

    BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
    Color clr3 = new Color(30, 100, 60);
    renderer.setSeriesPaint(0, clr3);
    
    

    // Set font to Tahoma
    Font labelFont = new Font("Tahoma", Font.PLAIN, 16);
    categoryPlot.getDomainAxis().setLabelFont(labelFont);
    categoryPlot.getRangeAxis().setLabelFont(labelFont);

    // Set legend font (if legend is not null)
    LegendTitle legend = chart.getLegend();
    if (legend != null) {
        legend.setItemFont(labelFont);
    }

    // Set title font
    TextTitle title = chart.getTitle();
    title.setFont(new Font("Tahoma", Font.BOLD, 18));

    // Set outer area background color to red
    chart.setBackgroundPaint(new Color(251, 255, 239));

    ChartPanel barChartPanel = new ChartPanel(chart);
    panelBarChartType.removeAll();
    panelBarChartType.add(barChartPanel, BorderLayout.CENTER);
    panelBarChartType.validate();
}
/////////////////////////////////////////////////////////////////////////////////////////////// 
 public void setCounts() {
    try {
        
        teacherCount = getCount(connection, "teacher", "t_id");
        coursesCount = getCount(connection, "courses", "c_id");
        studentCount = getCount(connection, "student", "s_id");
        doctorCount = getCount(connection, "doctor", "d_id");
        parentCount = getCount(connection, "parent", "p_id");

         
         

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private int getCount(Connection connection, String tableName, String columnName) throws SQLException {
    String query = "SELECT COUNT(" + columnName + ") FROM " + tableName;
    try (PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {

        if (resultSet.next()) {
            return resultSet.getInt(1);
        }

        // Return -1 if an error occurs or there are no results
        return -1;
    }
}

   

    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_edit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        panelBarChartLevel = new javax.swing.JPanel();
        panelBarChartType = new javax.swing.JPanel();
        panelBarChartTch = new javax.swing.JPanel();
        panelPieChart = new javax.swing.JPanel();
        panelBarChart = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        btn_logout1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        notification = new javax.swing.JLabel();

        btn_edit.setBackground(new java.awt.Color(11, 83, 148));
        btn_edit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("EDIT PROFILE");
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));
        setForeground(new java.awt.Color(0, 153, 153));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(251, 255, 239));
        jPanel5.setForeground(new java.awt.Color(51, 0, 51));

        panelBarChartLevel.setPreferredSize(new java.awt.Dimension(400, 200));
        panelBarChartLevel.setLayout(new java.awt.BorderLayout());

        panelBarChartType.setPreferredSize(new java.awt.Dimension(400, 200));
        panelBarChartType.setLayout(new java.awt.BorderLayout());

        panelBarChartTch.setPreferredSize(new java.awt.Dimension(400, 200));
        panelBarChartTch.setLayout(new java.awt.BorderLayout());

        panelPieChart.setPreferredSize(new java.awt.Dimension(400, 200));
        panelPieChart.setLayout(new java.awt.BorderLayout());

        panelBarChart.setBackground(new java.awt.Color(251, 255, 239));
        panelBarChart.setForeground(new java.awt.Color(251, 255, 239));
        panelBarChart.setPreferredSize(new java.awt.Dimension(400, 200));
        panelBarChart.setLayout(new java.awt.BorderLayout());

        btn_logout.setBackground(new java.awt.Color(11, 83, 148));
        btn_logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setText("APPROVE TEACHER");
        btn_logout.setBorder(null);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        btn_logout1.setBackground(new java.awt.Color(11, 83, 148));
        btn_logout1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_logout1.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout1.setText("LOGOUT");
        btn_logout1.setBorder(null);
        btn_logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(panelBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelBarChartTch, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(panelPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(panelBarChartType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(panelBarChartLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(445, 445, 445)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelBarChartType, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addComponent(panelBarChartLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBarChartTch, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1250, 630));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("ADMIN DASHBOARD");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 960, 80));

        notification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/notification.png"))); // NOI18N
        notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationMouseClicked(evt);
            }
        });
        jPanel2.add(notification, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 90, 80));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 100));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
       
    }//GEN-LAST:event_btn_editMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editActionPerformed

    private void notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseClicked
//        if (glassPanePopup == null || !glassPanePopup.isVisible()) {
//            glassPanePopup = new GlassPanePopup();
//            setGlassPane(glassPanePopup);
//            glassPanePopup.showPopup(NoticeDatabase.getNotices());
//            getGlassPane().setVisible(true);
//        }
    }//GEN-LAST:event_notificationMouseClicked

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
       ApproveTeacherStatus aps = new ApproveTeacherStatus();
       this.dispose();
       aps.setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout1ActionPerformed
       int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btn_logout1ActionPerformed

//    @Override
//    public boolean contains(int x, int y) {
//        if (glassPanePopup != null && glassPanePopup.isVisible()) {
//            Point glassPanePoint = glassPanePopup.getLocationOnScreen();
//            Point mousePoint = MouseInfo.getPointerInfo().getLocation();
//            Rectangle labelBounds = new Rectangle(glassPanePoint, glassPanePopup.getSize());
//            return labelBounds.contains(mousePoint);
//        } else {
//            return super.contains(x, y);
//        }
//    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_logout1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel notification;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JPanel panelBarChartLevel;
    private javax.swing.JPanel panelBarChartTch;
    private javax.swing.JPanel panelBarChartType;
    private javax.swing.JPanel panelPieChart;
    // End of variables declaration//GEN-END:variables
}
