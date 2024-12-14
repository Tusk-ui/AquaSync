
package Signup;


import java.awt.*;
import Login.window; //window para login
import addrec.addpop; //window para popup
import addrec.editpop;
import java.sql.Connection;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import jpop.Jpopf;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import raven.chart.ModelChart;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumnModel;


public class Sign extends javax.swing.JFrame {
       private String username;
       private Connection userDbConn; 
       private javax.swing.JPopupMenu calendarPopup;
       private java.util.Date selectedDate; // To store the selected date
       private javax.swing.JDialog calendarDialog; // Dialog to display the calendar
       public addpop addPopWindow = null;
       public editpop editwindow = null;
   public Sign(String username, Connection userDbConn) throws SQLException {
    if (username == null || userDbConn == null) {
        throw new IllegalArgumentException("Username and database connection cannot be null.");
    }

    this.username = username;  
    this.userDbConn = userDbConn; 
   
    initComponents();
    chart.setTitle("Water Usage Data");
    chart.addLegend("Year", new Color(210, 245, 208), new Color(103,101,227,255));
    Tab.getTableHeader().setVisible(false);
    Tab.getTableHeader().setPreferredSize(new Dimension(0, 0));
    initializeConnection();
    
    int yearFilter = yearfilt.getYear();
    fetchUserData(yearFilter);
    showRandomWaterTip();
     refreshTable();
    centerTableValues(Tab); 
    chart.repaint();
    refreshChartData();
    int selectedYear = yearChooser.getYear(); 
     fetchAverageWaterUsage(username,selectedYear); 
    // Set the frame to have rounded corners
    int arcWidth = 20;  // Width of the rounded corners
    int arcHeight = 20;  // Height of the rounded corners
    SwingUtilities.invokeLater(() -> {
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
    });

    // Add a window listener to handle resizing
    this.addComponentListener(new java.awt.event.ComponentAdapter() {
        @Override
        public void componentResized(java.awt.event.ComponentEvent e) {
            setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
        }
    });

    // Optional: Set default close operation, size, and visibility
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1200, 800);  // Adjust to your preferred size
    this.setLocationRelativeTo(null);  // Center the frame on the screen
    this.setVisible(true);  // Make the frame visible
    hint.setVisible(false);
                hint1.setVisible(false);
                hint2.setVisible(false);
}
private void ravdata() {
    try {
        // List to store fetched data
        List<ModelDat> lists = new ArrayList<>();

        // Database connection
        String dbURL = "jdbc:mysql://localhost:3306/user_" + username;
        String dbUser = "root";
        String dbPassword = "";
        userDbConn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
        System.out.println("Connected to the database for user: " + username);

        // Query to fetch the data and sort by Month (January to December)
        String query = "SELECT Month, Year, Useyg FROM usage_data ORDER BY " +
                       "CASE " +
                       "WHEN Month = 'January' THEN 1 " +
                       "WHEN Month = 'February' THEN 2 " +
                       "WHEN Month = 'March' THEN 3 " +
                       "WHEN Month = 'April' THEN 4 " +
                       "WHEN Month = 'May' THEN 5 " +
                       "WHEN Month = 'June' THEN 6 " +
                       "WHEN Month = 'July' THEN 7 " +
                       "WHEN Month = 'August' THEN 8 " +
                       "WHEN Month = 'September' THEN 9 " +
                       "WHEN Month = 'October' THEN 10 " +
                       "WHEN Month = 'November' THEN 11 " +
                       "WHEN Month = 'December' THEN 12 " +
                       "END";

        PreparedStatement ps = userDbConn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        // Process each row
        while (rs.next()) {
            String month = rs.getString("Month");
            int year = rs.getInt("Year");
            double usage = rs.getDouble("Useyg");

            // Add new ModelDat to the list
            lists.add(new ModelDat(month, year, usage));
        }

        // Add data to the chart from the list (iterate forward)
        for (int i = 0; i < lists.size(); i++) {
            ModelDat d = lists.get(i);
            chart.addData(new ModelChart(d.getMonth(), new double[]{d.getAmount()}));
        }

        chart.start();
        chart.repaint();
       

        // Print the list for verification
        for (ModelDat data : lists) {
            System.out.println(data);
        }

    } catch (SQLException e) {
        System.out.println("Error connecting to the database: " + e.getMessage());
        e.printStackTrace();
    }
}

// Helper method to get the index of a month
private int getMonthIndex(String month) {
    switch (month) {
        case "January": return 0;
        case "February": return 1;
        case "March": return 2;
        case "April": return 3;
        case "May": return 4;
        case "June": return 5;
        case "July": return 6;
        case "August": return 7;
        case "September": return 8;
        case "October": return 9;
        case "November": return 10;
        case "December": return 11;
        default: return -1; // Invalid month
    }
}
 
class JPanelGradient extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        
        Color color1 = new Color(242,242,242);
        Color color2 = new Color(86,180,211);
        
        GradientPaint gp = new GradientPaint(0,0,color1,180,height,color2);
        g2d.setPaint(gp);
        g2d.fillRect(0,0,width,height);
                }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconplaced = new swing.RoundPanel();
        jPanel1 = new JPanelGradient1();
        home = new javax.swing.JButton();
        white9 = new swing.white();
        result = new javax.swing.JButton();
        logawt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hint = new javax.swing.JLabel();
        hint1 = new javax.swing.JLabel();
        hint2 = new javax.swing.JLabel();
        show = new javax.swing.JRadioButton();
        white6 = new swing.white();
        white10 = new swing.white();
        white11 = new swing.white();
        AQUASYNC = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        quit = new javax.swing.JButton();
        upperpane = new swing.GruPanel();
        Tabunder = new javax.swing.JPanel();
        tab = new javax.swing.JTabbedPane();
        hometabb = new javax.swing.JPanel();
        Homing = new swing.conserved();
        jSeparator1 = new javax.swing.JSeparator();
        white2 = new swing.white();
        jLabel6 = new javax.swing.JLabel();
        waver = new javax.swing.JLabel();
        yourPanel = new javax.swing.JPanel();
        yearChooser = new com.toedter.calendar.JYearChooser();
        chart = new raven.chart.CurveLineChart();
        usagel = new javax.swing.JLabel();
        usagel1 = new javax.swing.JLabel();
        Homing1 = new swing.conserved();
        sidedddd3 = new swing.sidedddd();
        getname = new javax.swing.JLabel();
        sidedddd2 = new swing.sidedddd();
        white7 = new swing.white();
        orange = new javax.swing.JPanel();
        red = new javax.swing.JPanel();
        green = new javax.swing.JPanel();
        tip4 = new swing.white();
        white12 = new swing.white();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        white1 = new swing.white();
        tip1 = new javax.swing.JLabel();
        tip = new swing.white();
        jLabel2 = new javax.swing.JLabel();
        Resultt = new swing.conserved();
        tiwat = new javax.swing.JLabel();
        tiwat2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tab = new javax.swing.JTable();
        Addbut1 = new javax.swing.JButton();
        tiwat1 = new javax.swing.JLabel();
        Edit = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        tiwat3 = new javax.swing.JLabel();
        tiwat4 = new javax.swing.JLabel();
        yearfilt = new com.toedter.calendar.JYearChooser();
        white13 = new swing.white();
        white14 = new swing.white();
        white15 = new swing.white();
        white16 = new swing.white();
        Refresh = new javax.swing.JButton();
        tiwat5 = new javax.swing.JLabel();
        Dashhh = new swing.conserved();
        circleee1 = new swing.circleee();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        conserved1 = new swing.conserved();
        jLabel3 = new javax.swing.JLabel();
        white5 = new swing.white();
        white8 = new swing.white();
        Cons = new swing.conserved();
        Tips = new swing.conserved();
        jButton1 = new javax.swing.JButton();
        sharpsidesett1 = new swing.sharpsidesett();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(10, 100));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconplaced.setBackground(new java.awt.Color(0, 0, 0));
        iconplaced.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(210, 245, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home.setFont(new java.awt.Font("Wonderful Future", 0, 20)); // NOI18N
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Signup/home_10079449.png"))); // NOI18N
        home.setText("  Home");
        home.setBorder(null);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        home.setIconTextGap(5);
        home.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Signup/home_10079155.png"))); // NOI18N
        home.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Signup/home_10080464.png"))); // NOI18N
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                homeMouseReleased(evt);
            }
        });
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jPanel1.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 150, -1));

        white9.setBackground(new java.awt.Color(102, 255, 102));
        white9.setForeground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout white9Layout = new javax.swing.GroupLayout(white9);
        white9.setLayout(white9Layout);
        white9Layout.setHorizontalGroup(
            white9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        white9Layout.setVerticalGroup(
            white9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.add(white9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 160, 80));

        result.setFont(new java.awt.Font("Wonderful Future", 0, 20)); // NOI18N
        result.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Signup/data-analysis_8991824.png"))); // NOI18N
        result.setText("   Record");
        result.setBorder(null);
        result.setBorderPainted(false);
        result.setContentAreaFilled(false);
        result.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        result.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        result.setIconTextGap(5);
        result.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Signup/analytics_16971858.png"))); // NOI18N
        result.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Signup/analytics_16971858.png"))); // NOI18N
        result.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                resultMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                resultMouseReleased(evt);
            }
        });
        result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultActionPerformed(evt);
            }
        });
        jPanel1.add(result, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 150, -1));

        logawt.setBackground(new java.awt.Color(255, 255, 255));
        logawt.setFont(new java.awt.Font("Wonderful Future", 0, 20)); // NOI18N
        logawt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logawt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Signup/out (1).jpg"))); // NOI18N
        logawt.setText("Logout");
        logawt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logawt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        logawt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logawtMouseClicked(evt);
            }
        });
        jPanel1.add(logawt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Realsignuppage/Watier (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 16, 130, 110));

        jLabel5.setFont(new java.awt.Font("Nostalgic Whispers", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Your water, Your control");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 160, -1));

        hint.setText("Start by adding your monthly here");
        jPanel1.add(hint, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 190, 40));

        hint1.setText("Check your updated data here");
        jPanel1.add(hint1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 170, -1));

        hint2.setText("After adding ");
        jPanel1.add(hint2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 110, -1));

        show.setBackground(new java.awt.Color(255, 255, 255));
        show.setText("Show tips");
        show.setBorder(null);
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        show.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                showPropertyChange(evt);
            }
        });
        jPanel1.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 550, 140, 40));

        white6.setBackground(new java.awt.Color(102, 255, 102));
        white6.setForeground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout white6Layout = new javax.swing.GroupLayout(white6);
        white6.setLayout(white6Layout);
        white6Layout.setHorizontalGroup(
            white6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        white6Layout.setVerticalGroup(
            white6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        jPanel1.add(white6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 160, 47));

        white10.setBackground(new java.awt.Color(102, 255, 102));
        white10.setForeground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout white10Layout = new javax.swing.GroupLayout(white10);
        white10.setLayout(white10Layout);
        white10Layout.setHorizontalGroup(
            white10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        white10Layout.setVerticalGroup(
            white10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.add(white10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 160, 80));

        white11.setBackground(new java.awt.Color(102, 255, 102));
        white11.setForeground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout white11Layout = new javax.swing.GroupLayout(white11);
        white11.setLayout(white11Layout);
        white11Layout.setHorizontalGroup(
            white11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        white11Layout.setVerticalGroup(
            white11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(white11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 160, 40));

        AQUASYNC.setFont(new java.awt.Font("Cinzel SemiBold", 0, 24)); // NOI18N
        AQUASYNC.setText("AquaSync");
        jPanel1.add(AQUASYNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 120, -1, 30));

        iconplaced.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 660));

        getContentPane().add(iconplaced, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 40, 210, 660));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        quit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Signup/remove_5859923.png"))); // NOI18N
        quit.setBorder(null);
        quit.setBorderPainted(false);
        quit.setContentAreaFilled(false);
        quit.setIconTextGap(0);
        quit.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Signup/remove (2).png"))); // NOI18N
        quit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Signup/remove (2).png"))); // NOI18N
        quit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                quitMouseDragged(evt);
            }
        });
        quit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitMouseClicked(evt);
            }
        });
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        jPanel2.add(quit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1204, 0, 30, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 40));

        upperpane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(upperpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 40));

        Tabunder.setBackground(new java.awt.Color(255, 255, 255));
        Tabunder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab.setBackground(new java.awt.Color(0, 51, 51));

        hometabb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Homing.setMinimumSize(new java.awt.Dimension(1050, 708));
        Homing.setPreferredSize(new java.awt.Dimension(1050, 708));
        Homing.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Homing.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 573, 1030, 0));

        jLabel6.setFont(new java.awt.Font("Nostalgic Whispers", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Average Water Consumption");

        waver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        waver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout white2Layout = new javax.swing.GroupLayout(white2);
        white2.setLayout(white2Layout);
        white2Layout.setHorizontalGroup(
            white2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(white2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(white2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(white2Layout.createSequentialGroup()
                        .addGap(0, 94, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addComponent(waver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        white2Layout.setVerticalGroup(
            white2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(white2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(waver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Homing.add(white2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 400, 80));

        yourPanel.setBackground(new java.awt.Color(255, 255, 255));
        yourPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        yourPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        yearChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                yearChooserPropertyChange(evt);
            }
        });
        yourPanel.add(yearChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 70, 30));

        chart.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        chart.setFillColor(true);
        yourPanel.add(chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 240));

        Homing.add(yourPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 900, 240));

        usagel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usagel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Homing.add(usagel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 170, 30));

        usagel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usagel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Homing.add(usagel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1030, 30));

        Homing1.setMinimumSize(new java.awt.Dimension(1050, 708));
        Homing1.setPreferredSize(new java.awt.Dimension(1050, 708));
        Homing1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidedddd3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getname.setFont(new java.awt.Font("Wonderful Future", 0, 44)); // NOI18N
        getname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sidedddd3.add(getname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 540, 70));

        sidedddd2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        sidedddd3.add(sidedddd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 70));

        Homing1.add(sidedddd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, 70));

        javax.swing.GroupLayout white7Layout = new javax.swing.GroupLayout(white7);
        white7.setLayout(white7Layout);
        white7Layout.setHorizontalGroup(
            white7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        white7Layout.setVerticalGroup(
            white7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Homing1.add(white7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-270, -70, -1, -1));

        orange.setBackground(new java.awt.Color(255, 204, 51));

        javax.swing.GroupLayout orangeLayout = new javax.swing.GroupLayout(orange);
        orange.setLayout(orangeLayout);
        orangeLayout.setHorizontalGroup(
            orangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        orangeLayout.setVerticalGroup(
            orangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Homing1.add(orange, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1030, 20));

        red.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout redLayout = new javax.swing.GroupLayout(red);
        red.setLayout(redLayout);
        redLayout.setHorizontalGroup(
            redLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        redLayout.setVerticalGroup(
            redLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Homing1.add(red, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1030, 20));

        green.setBackground(new java.awt.Color(102, 255, 102));

        javax.swing.GroupLayout greenLayout = new javax.swing.GroupLayout(green);
        green.setLayout(greenLayout);
        greenLayout.setHorizontalGroup(
            greenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        greenLayout.setVerticalGroup(
            greenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Homing1.add(green, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1030, 20));

        javax.swing.GroupLayout tip4Layout = new javax.swing.GroupLayout(tip4);
        tip4.setLayout(tip4Layout);
        tip4Layout.setHorizontalGroup(
            tip4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        tip4Layout.setVerticalGroup(
            tip4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        Homing1.add(tip4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 1030, 80));

        white12.setBackground(new java.awt.Color(102, 255, 102));
        white12.setForeground(new java.awt.Color(51, 255, 0));

        jLabel7.setFont(new java.awt.Font("Nostalgic Whispers", 1, 13)); // NOI18N
        jLabel7.setText("Low Usage");

        jLabel9.setFont(new java.awt.Font("Nostalgic Whispers", 1, 13)); // NOI18N
        jLabel9.setText("Moderate Usage");

        jLabel8.setFont(new java.awt.Font("Nostalgic Whispers", 1, 13)); // NOI18N
        jLabel8.setText("High Usage");

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(102, 255, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout white12Layout = new javax.swing.GroupLayout(white12);
        white12.setLayout(white12Layout);
        white12Layout.setHorizontalGroup(
            white12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(white12Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(white12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(white12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        white12Layout.setVerticalGroup(
            white12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(white12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(white12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(white12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(white12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        Homing1.add(white12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 190, 80));

        javax.swing.GroupLayout white1Layout = new javax.swing.GroupLayout(white1);
        white1.setLayout(white1Layout);
        white1Layout.setHorizontalGroup(
            white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        white1Layout.setVerticalGroup(
            white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        Homing1.add(white1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 190, 90));

        tip1.setFont(new java.awt.Font("Nostalgic Whispers", 0, 18)); // NOI18N
        tip1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tip1.setText("\n");
        Homing1.add(tip1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 590, 580, 60));
        Homing1.add(tip, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 590, 580, 60));

        jLabel2.setFont(new java.awt.Font("Nostalgic Whispers", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Water Saving Tips");
        Homing1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 560, 130, 40));

        Homing.add(Homing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        hometabb.add(Homing, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));

        tab.addTab("Home", hometabb);

        Resultt.setPreferredSize(new java.awt.Dimension(1300, 700));
        Resultt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tiwat.setBackground(new java.awt.Color(255, 255, 255));
        tiwat.setFont(new java.awt.Font("Classy Vogue", 1, 18)); // NOI18N
        tiwat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiwat.setText("Sort by Year");
        Resultt.add(tiwat, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, 140, 50));

        tiwat2.setBackground(new java.awt.Color(255, 255, 255));
        tiwat2.setFont(new java.awt.Font("Classy Vogue", 1, 24)); // NOI18N
        tiwat2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiwat2.setText("Year");
        Resultt.add(tiwat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 170, 60));

        Tab.setAutoCreateRowSorter(true);
        Tab.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Tab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Tab.setForeground(new java.awt.Color(0, 51, 51));
        Tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tab.setAutoscrolls(false);
        Tab.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tab.setDragEnabled(true);
        Tab.setGridColor(new java.awt.Color(255, 255, 255));
        Tab.setIntercellSpacing(new java.awt.Dimension(20, 20));
        Tab.setRowHeight(50);
        Tab.setSelectionBackground(new java.awt.Color(204, 204, 255));
        Tab.setSelectionForeground(new java.awt.Color(51, 51, 51));
        Tab.setShowGrid(true);
        jScrollPane2.setViewportView(Tab);
        if (Tab.getColumnModel().getColumnCount() > 0) {
            Tab.getColumnModel().getColumn(0).setResizable(false);
            Tab.getColumnModel().getColumn(1).setResizable(false);
            Tab.getColumnModel().getColumn(2).setResizable(false);
            Tab.getColumnModel().getColumn(3).setResizable(false);
        }

        Resultt.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 690, 520));

        Addbut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addrec/add (3) (1).png"))); // NOI18N
        Addbut1.setText("Add");
        Addbut1.setBorder(null);
        Addbut1.setBorderPainted(false);
        Addbut1.setContentAreaFilled(false);
        Addbut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Addbut1ActionPerformed(evt);
            }
        });
        Resultt.add(Addbut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 100, 40));

        tiwat1.setFont(new java.awt.Font("Classy Vogue", 1, 24)); // NOI18N
        tiwat1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiwat1.setText("Water Consumption");
        Resultt.add(tiwat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 13, 590, -1));

        Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addrec/edit (1) (1) (1).png"))); // NOI18N
        Edit.setText("Edit");
        Edit.setBorder(null);
        Edit.setBorderPainted(false);
        Edit.setContentAreaFilled(false);
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        Resultt.add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 100, 40));

        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addrec/remove (2) (1).png"))); // NOI18N
        Delete.setText("Delete");
        Delete.setBorder(null);
        Delete.setBorderPainted(false);
        Delete.setContentAreaFilled(false);
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        Resultt.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 100, 40));

        tiwat3.setBackground(new java.awt.Color(255, 255, 255));
        tiwat3.setFont(new java.awt.Font("Classy Vogue", 1, 24)); // NOI18N
        tiwat3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiwat3.setText("Month");
        Resultt.add(tiwat3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 170, 60));

        tiwat4.setBackground(new java.awt.Color(255, 255, 255));
        tiwat4.setFont(new java.awt.Font("Classy Vogue", 1, 18)); // NOI18N
        tiwat4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiwat4.setText("Approx. Water Bill");
        Resultt.add(tiwat4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 170, 60));

        yearfilt.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                yearfiltPropertyChange(evt);
            }
        });
        Resultt.add(yearfilt, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, 130, -1));

        white13.setBackground(new java.awt.Color(102, 255, 102));
        white13.setForeground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout white13Layout = new javax.swing.GroupLayout(white13);
        white13.setLayout(white13Layout);
        white13Layout.setHorizontalGroup(
            white13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        white13Layout.setVerticalGroup(
            white13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        Resultt.add(white13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 120, 40));

        white14.setBackground(new java.awt.Color(102, 255, 102));
        white14.setForeground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout white14Layout = new javax.swing.GroupLayout(white14);
        white14.setLayout(white14Layout);
        white14Layout.setHorizontalGroup(
            white14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        white14Layout.setVerticalGroup(
            white14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        Resultt.add(white14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 120, 40));

        white15.setBackground(new java.awt.Color(102, 255, 102));
        white15.setForeground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout white15Layout = new javax.swing.GroupLayout(white15);
        white15.setLayout(white15Layout);
        white15Layout.setHorizontalGroup(
            white15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        white15Layout.setVerticalGroup(
            white15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        Resultt.add(white15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 120, 40));

        white16.setBackground(new java.awt.Color(102, 255, 102));
        white16.setForeground(new java.awt.Color(51, 255, 0));

        Refresh.setText("Current Year");
        Refresh.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Refresh.setBorderPainted(false);
        Refresh.setContentAreaFilled(false);
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout white16Layout = new javax.swing.GroupLayout(white16);
        white16.setLayout(white16Layout);
        white16Layout.setHorizontalGroup(
            white16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, white16Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        white16Layout.setVerticalGroup(
            white16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, white16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Resultt.add(white16, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 180, 130, 20));

        tiwat5.setBackground(new java.awt.Color(255, 255, 255));
        tiwat5.setFont(new java.awt.Font("Classy Vogue", 1, 24)); // NOI18N
        tiwat5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiwat5.setText("Usage");
        Resultt.add(tiwat5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 170, 60));

        tab.addTab("Result", Resultt);

        Dashhh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Dashhh.add(circleee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 260, 260));

        jButton2.setText("Weekly/Monthly  Water Usage");
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Dashhh.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 550, 240, 30));

        jButton3.setText("Water Usage");
        jButton3.setContentAreaFilled(false);
        Dashhh.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, 240, 30));
        Dashhh.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, -1, -1));
        Dashhh.add(conserved1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 340, 240));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Chart");
        Dashhh.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 30));
        Dashhh.add(white5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 910, 320));
        Dashhh.add(white8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 410, 200));

        tab.addTab("Dashboard", Dashhh);

        Cons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tab.addTab("Conserved", Cons);

        Tips.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Whyyy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Tips.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 410, 120));

        tab.addTab("Tips", Tips);
        tab.addTab("tab6", sharpsidesett1);

        Tabunder.add(tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -38, 1060, 700));

        getContentPane().add(Tabunder, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 1050, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    public void setName(String name){
    getname.setText("Welcome " + name + "!");
    }
    private String[] waterTips = {
        "Fix leaking faucets to save water.",
        "Turn off the tap while brushing your teeth.",
        "Use a bucket instead of a hose for washing cars.",
        "Run full loads in washing machines and dishwashers.",
        "Collect rainwater for watering plants.",
        "Take shorter showers to conserve water.",
        "Install water-efficient fixtures.",
        "Reuse water from washing vegetables for your plants.",
        "Water your garden early in the morning or late in the evening.",
        "Place a brick or water bottle in your toilet tank to reduce water per flush.",
        "Sweep driveways and sidewalks instead of using a hose.",
        "Use a basin to rinse dishes instead of running water continuously.",
        "Wash your car less often, or take it to a car wash that recycles water.",
        "Repair leaking pipes immediately to prevent water loss.",
        "Use drought-tolerant plants in your garden to reduce water consumption.",
        "Cover your pool to reduce evaporation.",
        "Only boil the water you need instead of filling the entire kettle.",
        "Keep a bottle of drinking water in the fridge to avoid running the tap.",
        "Use mulch in your garden to retain soil moisture.",
        "Consider installing a dual-flush toilet to save water.",
        "Turn off the shower while soaping up or shampooing your hair.",
        "Check your water meter regularly to detect hidden leaks.",
        "Teach children water-saving habits, like turning off taps properly.",
        "Use a drip irrigation system for your plants to minimize water waste.",
        "Upgrade old appliances to water-efficient models."
    };
            
    private void showRandomWaterTip(){
        int randomIndex = (int) (Math.random() * waterTips.length); //Generate a random index
        tip1.setText(waterTips[randomIndex]); //Set the random tip to the label
    }
    
    
    
    public void initializeConnection() {
        try {
            // Use the username to build the database URL
            String dbURL = "jdbc:mysql://localhost:3306/user_" + username;  // Use user-specific database
            String dbUser = "root";  // Database username
            String dbPassword = "";  // Database password

            // Initialize the connection to the user-specific database
            userDbConn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            System.out.println("Connected to the database for user: " + username);
        } catch (SQLException e) {
            System.out.println("Error connecting to the user database: " + e.getMessage());
            e.printStackTrace();
        }
 }
 
public void fetchUserData(int yearFilter) throws SQLException {
    if (userDbConn == null || userDbConn.isClosed()) {
        System.out.println("Database connection is not initialized or closed.");
        return;
    }

    String query = "SELECT * FROM usage_data WHERE Year = ?";
    try (PreparedStatement ps = userDbConn.prepareStatement(query)) {
        ps.setInt(1, yearFilter);
        try (ResultSet rs = ps.executeQuery()) {
            List<Map<String, Object>> data = new ArrayList<>();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                String month = rs.getString("Month");
                int year = rs.getInt("Year");
                double usage = rs.getDouble("Useyg"); // Corrected typo here
              row.put("month", month);
                row.put("year", year);
                row.put("usage", usage);
           data.add(row);
            }

            Collections.sort(data, (o1, o2) -> {
                String month1 = (String) o1.get("month");
                String month2 = (String) o2.get("month");
                Map<String, Integer> monthOrder = new HashMap<>();
                monthOrder.put("January", 1);
                monthOrder.put("February", 2);
                monthOrder.put("March", 3);
                monthOrder.put("April", 4);
                monthOrder.put("May", 5);
                monthOrder.put("June", 6);
                monthOrder.put("July", 7);
                monthOrder.put("August", 8);
                monthOrder.put("September", 9);
                monthOrder.put("October", 10);
                monthOrder.put("November", 11);
                monthOrder.put("December", 12);
                return Integer.compare(monthOrder.get(month1), monthOrder.get(month2));
            });

            DefaultTableModel model = (DefaultTableModel) Tab.getModel();
            if (model == null) {
                System.err.println("Error: Tab's model is null. Check your table initialization.");
                return; // or throw an exception
            }
            model.setRowCount(0);

            for (Map<String, Object> row : data) {
                // Explicit type casting and null checks (added for robustness)
                String month = (String) row.get("month");
                Integer year = (Integer) row.get("year");
                Double usage = (Double) row.get("usage");
               if (month == null || year == null || usage == null) {
                    System.err.println("Error: Null value encountered in data row. Skipping row.");
                    continue; // Skip this row if any value is null
                }

                model.addRow(new Object[]{month, year, usage});
            }
        } catch (SQLException e) {
            System.err.println("SQL Error fetching user data: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassCastException e) {
            System.err.println("Type casting error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


    private double calculateApproximateCost(double usage) {
        double cost = 0;

    if (usage <= 10) {
        cost = 194.90; // Minimum charge
    } else if (usage <= 20) {
        cost = 194.90 + (usage - 10) * 22.75;
    } else if (usage <= 30) {
        cost = 194.90 + 10 * 22.75 + (usage - 20) * 26.30;
    } else if (usage <= 40) {
        cost = 200 + 10 * 22.75 + 10 * 26.30 + (usage - 30) * 30.10;
    } else if (usage <= 50) {
        cost = 194.90 + 10 * 22.75 + 10 * 26.30 + 10 * 30.10 + (usage - 40) * 34.10;
    } else {
        cost = 190.90 + 10 * 22.75 + 10 * 26.30 + 10 * 30.10 + 10 * 34.10 + (usage - 50) * 34.10;
    }
    return cost;
}

    private void filterTableByYear(int selectedYear) {
        try {
            fetchUserData(selectedYear);
            refreshChartData(); // Ensure the chart updates with the filtered data
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error filtering data by year: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
  class JPanelGradient1 extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        
        Color color1 = new Color(210, 245, 208);
        Color color2 = new Color(187, 230, 231);
        
        GradientPaint gp = new GradientPaint(0,0,color1,180,height,color2);
        g2d.setPaint(gp);
        g2d.fillRect(0,0,width,height);

                }
    }  
 public void refreshTable() {
     try {
        // Get the selected year from JYearChooser
        int yearFilter = yearfilt.getYear();

        // SQL query to fetch data for the specified year, ordered by Month
        String query = """
            SELECT Month, Year, Useyg 
            FROM usage_data 
            WHERE Year = ? 
            ORDER BY FIELD(Month, 
                'January', 'February', 'March', 'April', 'May', 'June', 
                'July', 'August', 'September', 'October', 'November', 'December')
        """;

        try (PreparedStatement ps = userDbConn.prepareStatement(query)) {
            ps.setInt(1, yearFilter); // Set the year filter parameter

            try (ResultSet rs = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) Tab.getModel();
                model.setRowCount(0); // Clear existing rows

                // Populate the table with the fetched data
                while (rs.next()) {
                    String month = rs.getString("Month"); // Month column
                    int year = rs.getInt("Year");         // Year column
                    double usage = rs.getDouble("Useyg"); // Usage column

                    // Calculate cost and format it with the peso sign
                    double cost = calculateApproximateCost(usage);
                    String formattedCost = "₱" + String.format("%.2f", cost);

                    // Add the row to the table
                    model.addRow(new Object[]{month, year, usage, formattedCost});
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
 public void setUserDbConn(Connection userDbConn) {
        this.userDbConn = userDbConn;
    }

    // Getter method (optional) to retrieve the connection
    public Connection getUserDbConn() {
        return this.userDbConn;
    }
    private void resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultActionPerformed
        int yearFilter = yearfilt.getYear();
    try {
        fetchUserData(yearFilter); // Populate the table
        refreshTable(); // Perform additional refresh logic, if any
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error fetching data for Home: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
    }//GEN-LAST:event_resultActionPerformed

    private void resultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultMouseClicked
     
        tab.setSelectedIndex(1);
    }//GEN-LAST:event_resultMouseClicked
    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked

        tab.setSelectedIndex(0);
    }//GEN-LAST:event_homeMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMousePressed
        home.setFont(new java.awt.Font("Wonderful Future", java.awt.Font.BOLD, 18));
    }//GEN-LAST:event_homeMousePressed

    private void homeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseReleased
        home.setFont(new java.awt.Font("Wonderful Future", java.awt.Font.PLAIN, 20));
    }//GEN-LAST:event_homeMouseReleased

    private void resultMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultMousePressed
        result.setFont(new java.awt.Font("Wonderful Future", java.awt.Font.BOLD, 18));
    }//GEN-LAST:event_resultMousePressed

    private void resultMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultMouseReleased
        result.setFont(new java.awt.Font("Wonderful Future", java.awt.Font.PLAIN, 20));
    }//GEN-LAST:event_resultMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Jpopf popwin = new Jpopf();
            popwin.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
private void refreshChartData() {
    // Clear existing data from the chart
     chart.clear();

    // Get the currently selected year from the JYearChooser
    int selectedYear = yearChooser.getYear();

    // Fetch and display data for the selected year
    updateChartByYear(selectedYear);
}
    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
    int selectedYear = yearChooser.getYear(); 
       
        fetchAverageWaterUsage(username,selectedYear); 
    showRandomWaterTip();
    refreshChartData();
    }//GEN-LAST:event_homeActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        yearfilt.setYear(Calendar.getInstance().get(Calendar.YEAR)); 
         int selectedYear = yearfilt.getYear();
         refreshTable();
    }//GEN-LAST:event_RefreshActionPerformed

    private void Addbut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Addbut1ActionPerformed
       try {
        // Ensure only one pop-up window is open
        if (addPopWindow == null || !addPopWindow.isVisible()) {
            addPopWindow = new addpop(this, userDbConn); // Create a new instance of addpop
            addPopWindow.setVisible(true);               // Show the pop-up window
            this.setEnabled(false);                      // Disable the parent window
        } else {
            addPopWindow.toFront();  // Bring the existing window to the front if it's already open
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_Addbut1ActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
int selectedRow = Tab.getSelectedRow(); // Get selected row index

if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Please select a row to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
    return;
}

// Get the data from the selected row
String selectedMonth = Tab.getValueAt(selectedRow, 0).toString(); // Month in column 0
String selectedYear = Tab.getValueAt(selectedRow, 1).toString();  // Year in column 1
String selectedUsage = Tab.getValueAt(selectedRow, 2).toString(); // Usage in column 2

try {
    // Convert Usage to double and Year to integer
    double usageValue = Double.parseDouble(selectedUsage);
    int yearValue = Integer.parseInt(selectedYear);

    // Format selected month and year as "MMMM yyyy" (e.g., "January 2024")
    String selectedMonthYear = selectedMonth + " " + selectedYear;

    // Open the editpop window with selected data (Month, Year, Usage)
    editpop editWindow = new editpop(this, userDbConn, selectedMonthYear, usageValue);
    
    // Make the parent window disabled while the pop-up is open
    this.setEnabled(false);

    // Once the edit window is closed, re-enable the parent window
    editWindow.setVisible(true);
    editWindow.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
            setEnabled(true); // Re-enable the parent Sign window when the edit window is closed
            try {
                refreshTable();
            } catch (Exception ex) {
                Logger.getLogger(Sign.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Invalid usage or year value in the selected row.", "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_EditActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
  int selectedRow = Tab.getSelectedRow();
    
    // Check if a row is selected
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Retrieve the Month and Year of the selected row
    String monthToDelete = Tab.getValueAt(selectedRow, 0).toString().trim(); // Assuming Month is in column 0
    int yearToDelete;
    
    // Check if the Year is stored as Double or Integer and cast it accordingly
    Object yearObj = Tab.getValueAt(selectedRow, 1); // Get the Year value
    
    if (yearObj instanceof Double) {
        yearToDelete = ((Double) yearObj).intValue();
    } else if (yearObj instanceof Integer) {
        yearToDelete = (int) yearObj;
    } else {
        // If Year is stored as a String, parse it
        yearToDelete = Integer.parseInt(yearObj.toString());
    }

    // Confirm deletion with the user
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.NO_OPTION) {
        return;  // If the user cancels, do nothing
    }

    try {
        // Prepare the SQL query for deletion
        String query = "DELETE FROM usage_data WHERE UPPER(Month) = UPPER(?) AND Year = ?";
        PreparedStatement ps = userDbConn.prepareStatement(query);

        // Set the parameters for the query
        ps.setString(1, monthToDelete);
        ps.setInt(2, yearToDelete);

        // Execute the deletion
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            // Notify the user that the record was deleted
            JOptionPane.showMessageDialog(this, "Record deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            // Remove the row from the table model to reflect the changes in the UI
            ((DefaultTableModel) Tab.getModel()).removeRow(selectedRow);
        } else {
            // If no rows were affected, the record was not found in the database
            JOptionPane.showMessageDialog(this, "No record found for the selected Month and Year.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        refreshTable();
    } catch (SQLException e) {
        // Handle any SQL exceptions
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_DeleteActionPerformed

    private void updateChartByYear(int selectedYear) {
    try {
        // Clear the chart
        chart.clear();

        // Query the database for data for the selected year
        String query = "SELECT Month, Year, Useyg FROM usage_data WHERE Year = ? ORDER BY " +
                       "CASE " +
                       "WHEN Month = 'January' THEN 1 " +
                       "WHEN Month = 'February' THEN 2 " +
                       "WHEN Month = 'March' THEN 3 " +
                       "WHEN Month = 'April' THEN 4 " +
                       "WHEN Month = 'May' THEN 5 " +
                       "WHEN Month = 'June' THEN 6 " +
                       "WHEN Month = 'July' THEN 7 " +
                       "WHEN Month = 'August' THEN 8 " +
                       "WHEN Month = 'September' THEN 9 " +
                       "WHEN Month = 'October' THEN 10 " +
                       "WHEN Month = 'November' THEN 11 " +
                       "WHEN Month = 'December' THEN 12 " +
                       "END";

        PreparedStatement ps = userDbConn.prepareStatement(query);
        ps.setInt(1, selectedYear); // Set the year parameter
        ResultSet rs = ps.executeQuery();

        // Process each row and update the chart
        while (rs.next()) {
            String month = rs.getString("Month");
            double usage = rs.getDouble("Useyg");

            // Add the data to the chart
            chart.addData(new ModelChart(month, new double[]{usage}));
        }

        chart.start();
        chart.repaint();
    } catch (SQLException e) {
        System.out.println("Error updating chart: " + e.getMessage());
        e.printStackTrace();
    }
}
    private void logawtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logawtMouseClicked
      int response = JOptionPane.showConfirmDialog(
        this, // parent component (usually the current window)
        "Are you sure you want to log out?", // message
        "Logout", // title of the dialog
        JOptionPane.YES_NO_OPTION, // options (yes/no)
        JOptionPane.QUESTION_MESSAGE // message type
    );

    
    if (response == JOptionPane.YES_OPTION) {
        window login = new window();
        login.setVisible(true);
        this.dispose(); 
    }
    }//GEN-LAST:event_logawtMouseClicked
   
public void fetchAverageWaterUsage(String username, int selectedYear) {
    try {
        // Construct the database URL dynamically based on the username
        String url = "jdbc:mysql://localhost:3306/user_" + username; // Dynamic database based on username
        String user = "root";
        String password = "";

        // Establish the connection to the user-specific database
        Connection conn = DriverManager.getConnection(url, user, password);

        // SQL query to fetch the average usage for the selected year
        String query = "SELECT AVG(Useyg) AS avg_usage FROM usage_data WHERE Year = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, selectedYear); // Set the year parameter

        ResultSet rs = stmt.executeQuery();

        // Check if data exists
        if (rs.next()) {
            double avgUsage = rs.getDouble("avg_usage");

            if (!rs.wasNull() && avgUsage > 0) {
                // Update the label with usage data
                waver.setText(String.format("Year %d: %.2f Cubic Meter", selectedYear, avgUsage));
                evaluateYearlyUsage(avgUsage); // Call method to show tips and color
            } else {
                // No data found; clear the label and panels
                clearUsageLabelAndPanels();
            }
        } else {
            // No data found; clear the label and panels
            clearUsageLabelAndPanels();
        }

        stmt.close();
        conn.close();
    } catch (SQLException e) {
        // Handle SQL errors
        waver.setText("Error fetching data!");
        clearUsageLabelAndPanels();
        e.printStackTrace();
    }
}

// Helper method to clear the label and hide panels
private void clearUsageLabelAndPanels() {
    waver.setText("No data available for the selected year");
    usagel.setText(""); // Clear usage label
    usagel1.setText(""); // Clear detailed explanation
    green.setVisible(false);
    orange.setVisible(false);
    red.setVisible(false);
}

public void evaluateYearlyUsage(double avgUsage) {
    // Hide all panels initially
    green.setVisible(false);
    orange.setVisible(false);
    red.setVisible(false);

    if (avgUsage <= 18) { // Example threshold for "Good"
        usagel.setText("Low Usage"); // Short description
        usagel1.setText("Your water usage is excellent. Keep up the good work by continuing to use water responsibly!");
        green.setVisible(true); // Show green panel
    } else if (avgUsage <= 28) { // Example threshold for "Moderate"
        usagel.setText("Moderate Usage"); // Short description
        usagel1.setText("You're doing okay, but there’s room for improvement. Consider adopting water-saving techniques to reduce consumption.");
        orange.setVisible(true); // Show orange panel
    } else if (avgUsage > 28) { // "High" usage
        usagel.setText("High Usage"); // Short description
        usagel1.setText("Your water consumption is significantly above the recommended level. Take immediate steps to reduce your usage to avoid wastage and high costs.");
        red.setVisible(true); // Show red panel
    }
}
public void centerTableValues(javax.swing.JTable Tab) {
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    // Apply the renderer to each column in the table
    TableColumnModel columnModel = Tab.getColumnModel();
    for (int i = 0; i < columnModel.getColumnCount(); i++) {
        columnModel.getColumn(i).setCellRenderer(centerRenderer);
    }
}
    private void yearChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_yearChooserPropertyChange
        if ("year".equals(evt.getPropertyName())) { // Listen for year property changes
        int selectedYear = yearChooser.getYear(); // Get the selected year
        updateChartByYear(selectedYear); 
        fetchAverageWaterUsage(username,selectedYear);        // Call the method to update the chart
    }
    }//GEN-LAST:event_yearChooserPropertyChange

    private void yearfiltPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_yearfiltPropertyChange
      if ("year".equals(evt.getPropertyName())) { // Check if the property change is related to the year selection
        
        refreshTable();
    }
    }//GEN-LAST:event_yearfiltPropertyChange

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed

    }//GEN-LAST:event_showActionPerformed

    private void showPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_showPropertyChange
    show.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                // Show the labels when the radio button is selected
                hint.setVisible(true);
                hint1.setVisible(true);
                hint2.setVisible(true);

                // Change the radio button text to "Hide tips"
                show.setText("Hide tips");
            } else {
                // Hide the labels when the radio button is deselected
                hint.setVisible(false);
                hint1.setVisible(false);
                hint2.setVisible(false);

                // Change the radio button text back to "Show tips"
                show.setText("Show tips");
            }
        }
    });

    }//GEN-LAST:event_showPropertyChange

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quitActionPerformed

    private void quitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitMouseClicked
        int response = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to exit?",
            "Confirm Exit",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            // Close the window and exit the program
            this.dispose();
        }
    }//GEN-LAST:event_quitMouseClicked

    private void quitMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitMouseDragged

    }//GEN-LAST:event_quitMouseDragged

 protected static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new window().setVisible(true);
        });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AQUASYNC;
    private javax.swing.JButton Addbut1;
    private swing.conserved Cons;
    private swing.conserved Dashhh;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private swing.conserved Homing;
    private swing.conserved Homing1;
    private javax.swing.JButton Refresh;
    private swing.conserved Resultt;
    private javax.swing.JTable Tab;
    private javax.swing.JPanel Tabunder;
    private swing.conserved Tips;
    private raven.chart.CurveLineChart chart;
    private swing.circleee circleee1;
    private swing.conserved conserved1;
    private javax.swing.JLabel getname;
    private javax.swing.JPanel green;
    private javax.swing.JLabel hint;
    private javax.swing.JLabel hint1;
    private javax.swing.JLabel hint2;
    private javax.swing.JButton home;
    private javax.swing.JPanel hometabb;
    private swing.RoundPanel iconplaced;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logawt;
    private javax.swing.JPanel orange;
    private javax.swing.JButton quit;
    private javax.swing.JPanel red;
    private javax.swing.JButton result;
    private swing.sharpsidesett sharpsidesett1;
    private javax.swing.JRadioButton show;
    private swing.sidedddd sidedddd2;
    private swing.sidedddd sidedddd3;
    private javax.swing.JTabbedPane tab;
    private swing.white tip;
    private javax.swing.JLabel tip1;
    private swing.white tip4;
    private javax.swing.JLabel tiwat;
    private javax.swing.JLabel tiwat1;
    private javax.swing.JLabel tiwat2;
    private javax.swing.JLabel tiwat3;
    private javax.swing.JLabel tiwat4;
    private javax.swing.JLabel tiwat5;
    private swing.GruPanel upperpane;
    private javax.swing.JLabel usagel;
    private javax.swing.JLabel usagel1;
    private javax.swing.JLabel waver;
    private swing.white white1;
    private swing.white white10;
    private swing.white white11;
    private swing.white white12;
    private swing.white white13;
    private swing.white white14;
    private swing.white white15;
    private swing.white white16;
    private swing.white white2;
    private swing.white white5;
    private swing.white white6;
    private swing.white white7;
    private swing.white white8;
    private swing.white white9;
    private com.toedter.calendar.JYearChooser yearChooser;
    private com.toedter.calendar.JYearChooser yearfilt;
    private javax.swing.JPanel yourPanel;
    // End of variables declaration//GEN-END:variables
}
