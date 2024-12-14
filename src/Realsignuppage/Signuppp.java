package Realsignuppage;

import Login.window;
import Signup.Sign;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.SwingUtilities;

public class Signuppp extends javax.swing.JFrame {

    // Constructor
    public Signuppp() {
        initComponents();
        int arcWidth = 40;  // Width of the rounded corners
    int arcHeight = 40;  // Height of the rounded corners
    SwingUtilities.invokeLater(() -> {
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
    });

    }

    // Method to save user data
    private void saveUserData(String username, String password, String email) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("userDatabase.txt", true))) {
            writer.write(username + "," + password + "," + email);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Sign up successful!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving user data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JButton();
        AQUASYNC = new javax.swing.JLabel();
        Logoaqua = new javax.swing.JLabel();
        Welcome = new javax.swing.JLabel();
        Welcome1 = new javax.swing.JLabel();
        Welcome2 = new javax.swing.JLabel();
        Welcome3 = new javax.swing.JLabel();
        Welcome4 = new javax.swing.JLabel();
        Welcome5 = new javax.swing.JLabel();
        Hello = new javax.swing.JLabel();
        Passlogo = new javax.swing.JLabel();
        Userlogo = new javax.swing.JLabel();
        Emaillogo = new javax.swing.JLabel();
        Signupbutton = new javax.swing.JButton();
        white1 = new swing.white();
        username1 = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        password1 = new javax.swing.JPasswordField();
        Hello1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mainwin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 132));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Login.setBackground(new java.awt.Color(153, 255, 255));
        Login.setFont(new java.awt.Font("Qilka", 1, 16)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 80, 23));

        AQUASYNC.setBackground(new java.awt.Color(204, 204, 204));
        AQUASYNC.setFont(new java.awt.Font("Cinzel SemiBold", 1, 26)); // NOI18N
        AQUASYNC.setForeground(new java.awt.Color(255, 255, 255));
        AQUASYNC.setText("AquaSync");
        getContentPane().add(AQUASYNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 160, 50));

        Logoaqua.setFont(new java.awt.Font("Laisha", 0, 22)); // NOI18N
        Logoaqua.setForeground(new java.awt.Color(255, 255, 255));
        Logoaqua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Realsignuppage/Watier (2).png"))); // NOI18N
        Logoaqua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Logoaqua, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, -30, 180, 260));

        Welcome.setFont(new java.awt.Font("Laisha", 1, 22)); // NOI18N
        Welcome.setForeground(new java.awt.Color(255, 255, 255));
        Welcome.setText("AquaSync.");
        getContentPane().add(Welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 120, 30));

        Welcome1.setFont(new java.awt.Font("Laisha", 0, 22)); // NOI18N
        Welcome1.setForeground(new java.awt.Color(255, 255, 255));
        Welcome1.setText("Track, save, and manage ");
        getContentPane().add(Welcome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 300, 30));

        Welcome2.setFont(new java.awt.Font("Laisha", 0, 22)); // NOI18N
        Welcome2.setForeground(new java.awt.Color(255, 255, 255));
        Welcome2.setText("Sign  up  to ");
        getContentPane().add(Welcome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, 130, 30));

        Welcome3.setFont(new java.awt.Font("Laisha", 0, 22)); // NOI18N
        Welcome3.setForeground(new java.awt.Color(255, 255, 255));
        Welcome3.setText("and lower your bills today!");
        getContentPane().add(Welcome3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, 300, 30));

        Welcome4.setFont(new java.awt.Font("Laisha", 0, 22)); // NOI18N
        Welcome4.setForeground(new java.awt.Color(255, 255, 255));
        Welcome4.setText("your  water  usage  with");
        getContentPane().add(Welcome4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 270, 30));

        Welcome5.setFont(new java.awt.Font("Laisha", 0, 22)); // NOI18N
        Welcome5.setForeground(new java.awt.Color(255, 255, 255));
        Welcome5.setText("start   conserving  water");
        getContentPane().add(Welcome5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 270, 30));

        Hello.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        Hello.setForeground(new java.awt.Color(255, 255, 255));
        Hello.setText("Already have an account?");
        getContentPane().add(Hello, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, -1, 20));

        Passlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Passlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Realsignuppage/lock (1).png"))); // NOI18N
        Passlogo.setText(" ");
        Passlogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Passlogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 354, 40, 40));

        Userlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Userlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Realsignuppage/user (1).png"))); // NOI18N
        Userlogo.setText("\n");
        getContentPane().add(Userlogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 212, 40, 40));

        Emaillogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Emaillogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Realsignuppage/email.png"))); // NOI18N
        Emaillogo.setText(" ");
        Emaillogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Emaillogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 283, 40, 40));

        Signupbutton.setFont(new java.awt.Font("Qilka", 0, 21)); // NOI18N
        Signupbutton.setForeground(new java.awt.Color(51, 153, 255));
        Signupbutton.setText("Signup");
        Signupbutton.setBorder(null);
        Signupbutton.setBorderPainted(false);
        Signupbutton.setContentAreaFilled(false);
        Signupbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Signupbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignupbuttonMouseClicked(evt);
            }
        });
        Signupbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignupbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(Signupbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 140, 40));
        getContentPane().add(white1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 160, 40));

        username1.setFont(new java.awt.Font("Nostalgic Whispers", 0, 24)); // NOI18N
        username1.setBorder(null);
        username1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username1ActionPerformed(evt);
            }
        });
        getContentPane().add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 209, 240, 44));

        email.setFont(new java.awt.Font("Nostalgic Whispers", 0, 24)); // NOI18N
        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 280, 240, 44));

        password1.setFont(new java.awt.Font("Nostalgic Whispers", 0, 24)); // NOI18N
        password1.setBorder(null);
        password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password1ActionPerformed(evt);
            }
        });
        getContentPane().add(password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 352, 240, 43));

        Hello1.setFont(new java.awt.Font("Anastasia", 0, 50)); // NOI18N
        Hello1.setForeground(new java.awt.Color(255, 255, 255));
        Hello1.setText("HELLO!");
        getContentPane().add(Hello1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 110, 60));

        jLabel1.setBackground(new java.awt.Color(51, 153, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 340, 160));

        mainwin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Realsignuppage/Untitled (1).jpeg"))); // NOI18N
        getContentPane().add(mainwin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SignupbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignupbuttonActionPerformed
                                           
    String SUrl = "jdbc:mysql://localhost:3306/usage";  
    String SUser = "root";  
    String SPass = "";
    String query;

    try {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a connection to the main login database
        Connection conn = DriverManager.getConnection(SUrl, SUser, SPass);

        // Check for empty fields
        if ("".equals(username1.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Username is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(email.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Email is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!email.getText().contains("@")) {
            JOptionPane.showMessageDialog(new JFrame(), "Email must contain '@'", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (password1.getPassword().length == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String username = username1.getText();
            String emailadd = email.getText();
            String password = new String(password1.getPassword());

            // Check if the username or email already exists
            String checkQuery = "SELECT COUNT(*) FROM usern WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, username);
          
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(new JFrame(), "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Insert user credentials into the central database
                query = "INSERT INTO usern(username, emailadd, passwa) VALUES(?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(query);
                insertStmt.setString(1, username);
                insertStmt.setString(2, emailadd);
                insertStmt.setString(3, password);
                insertStmt.executeUpdate();

                // Create a new database for the user
                String createDbQuery = "CREATE DATABASE IF NOT EXISTS user_" + username;
                Statement state2 = conn.createStatement();
                state2.executeUpdate(createDbQuery);  // Create user-specific database

                // Create the 'usage_data' table with ID, Month, and Usage fields in the user-specific database
                String createTableQuery = "CREATE TABLE IF NOT EXISTS user_" + username + ".usage_data ("
                         + "ID INT AUTO_INCREMENT PRIMARY KEY, "
                         + "Month VARCHAR(20), "  // Holds the month as a string (e.g., 'January')
                         + "Year INT, "           // Holds the year as an integer (e.g., 2024)
                         + "Useyg DOUBLE"         // Holds the water usage value
                         + ")";
                state2.executeUpdate(createTableQuery);  // Create the table inside the user-specific database

                // Clear form fields
                username1.setText("");
                email.setText("");
                password1.setText("");

                // Show success message
                JOptionPane.showMessageDialog(null, "Account created successfully");

                // Now connect to the newly created user's specific database
                String userDbUrl = "jdbc:mysql://localhost:3306/user_" + username;
                Connection userDbConn = DriverManager.getConnection(userDbUrl, SUser, SPass);

                this.dispose();
                window logen = new window();
                logen.setVisible(true);
            }
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_SignupbuttonActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
    String username = username1.getText();
    String password = new String(password1.getPassword());
    String Email = email.getText();

    // Email validation (must include '@' and '.com')
    if (!Email.contains("@") || !Email.contains(".com")) {
        JOptionPane.showMessageDialog(this, "Please enter a valid Email address.", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Write user data to a text file
    try (FileWriter writer = new FileWriter("userDatabase.txt", true)) {
        writer.write(username + "," + password + "," + email + "\n");
        JOptionPane.showMessageDialog(this, "Sign up successful!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);

    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error saving user data.");
    }
    }//GEN-LAST:event_emailActionPerformed

    private void username1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username1ActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
    window loginWindow = new window();
    loginWindow.setVisible(true);

    this.dispose();
    }//GEN-LAST:event_LoginActionPerformed

    private void SignupbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignupbuttonMouseClicked
 
    }//GEN-LAST:event_SignupbuttonMouseClicked

    private void password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signuppp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            new Signuppp().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AQUASYNC;
    private javax.swing.JLabel Emaillogo;
    private javax.swing.JLabel Hello;
    private javax.swing.JLabel Hello1;
    private javax.swing.JButton Login;
    private javax.swing.JLabel Logoaqua;
    private javax.swing.JLabel Passlogo;
    private javax.swing.JButton Signupbutton;
    private javax.swing.JLabel Userlogo;
    private javax.swing.JLabel Welcome;
    private javax.swing.JLabel Welcome1;
    private javax.swing.JLabel Welcome2;
    private javax.swing.JLabel Welcome3;
    private javax.swing.JLabel Welcome4;
    private javax.swing.JLabel Welcome5;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mainwin;
    private javax.swing.JPasswordField password1;
    private javax.swing.JTextField username1;
    private swing.white white1;
    // End of variables declaration//GEN-END:variables
}
