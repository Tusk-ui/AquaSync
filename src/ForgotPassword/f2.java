package ForgotPassword;

import Login.window;
import Realsignuppage.Signuppp;
import java.sql.PreparedStatement;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class f2 extends javax.swing.JFrame {
    private Connection userDbConn;

    public f2() {
        initComponents();
    showRandomCode();
        // Set the frame to have rounded corners
        int arcWidth = 80; // Width of the rounded corners
        int arcHeight = 80; // Height of the rounded corners
        this.setShape(new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), arcWidth, arcHeight));

        // Add a window listener to handle resizing
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                // Adjust the rounded shape when the frame is resized
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tip1 = new javax.swing.JLabel();
        us = new javax.swing.JLabel();
        Login1 = new javax.swing.JButton();
        Login = new javax.swing.JButton();
        con1 = new javax.swing.JButton();
        email = new javax.swing.JTextField();
        user1 = new javax.swing.JTextField();
        pas = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        En = new javax.swing.JLabel();
        last = new javax.swing.JLabel();
        last1 = new javax.swing.JLabel();
        En1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 10));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tip1.setFont(new java.awt.Font("Wide Latin", 2, 12)); // NOI18N
        tip1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tip1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(tip1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 130, 30));

        us.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ForgotPassword/user (1).png"))); // NOI18N
        getContentPane().add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 236, 30, 30));

        Login1.setBackground(new java.awt.Color(102, 51, 255));
        Login1.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        Login1.setForeground(new java.awt.Color(255, 255, 255));
        Login1.setText("Signup");
        Login1.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        Login1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login1ActionPerformed(evt);
            }
        });
        getContentPane().add(Login1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 100, 30));

        Login.setBackground(new java.awt.Color(51, 204, 255));
        Login.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("Back");
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 90, 30));

        con1.setFont(new java.awt.Font("Home Video", 0, 18)); // NOI18N
        con1.setText("Reset my Password");
        con1.setBorder(null);
        con1.setContentAreaFilled(false);
        con1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        con1.setFocusPainted(false);
        con1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                con1MouseClicked(evt);
            }
        });
        con1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                con1ActionPerformed(evt);
            }
        });
        getContentPane().add(con1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 200, 30));

        email.setFont(new java.awt.Font("Lucida Console", 0, 20)); // NOI18N
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(null);
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 326, 210, 53));

        user1.setFont(new java.awt.Font("Lucida Console", 0, 20)); // NOI18N
        user1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        user1.setBorder(null);
        user1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        user1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user1ActionPerformed(evt);
            }
        });
        getContentPane().add(user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 225, 192, 53));

        pas.setFont(new java.awt.Font("Lucida Console", 0, 20)); // NOI18N
        pas.setBorder(null);
        getContentPane().add(pas, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 200, 40));

        pass.setFont(new java.awt.Font("Lucida Console", 0, 20)); // NOI18N
        pass.setBorder(null);
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 200, 40));

        En.setFont(new java.awt.Font("Home Video", 0, 20)); // NOI18N
        En.setText("Re-enter new password..");
        getContentPane().add(En, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        last.setFont(new java.awt.Font("Home Video", 0, 20)); // NOI18N
        last.setText("ENTER CODE");
        getContentPane().add(last, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        last1.setFont(new java.awt.Font("Home Video", 0, 20)); // NOI18N
        last1.setText("Enter username");
        getContentPane().add(last1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        En1.setFont(new java.awt.Font("Home Video", 0, 20)); // NOI18N
        En1.setText("Enter new password...");
        getContentPane().add(En1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ForgotPassword/We received a request to reset your password. Don’t worry, we are here to help you. (2).png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private void showRandomCode() {
    // Define the characters that can appear in the captcha
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // Generate a random 6-character string
    StringBuilder captcha = new StringBuilder(6);
    for (int i = 0; i < 6; i++) {
        int randomIndex = (int) (Math.random() * characters.length());
        captcha.append(characters.charAt(randomIndex));
    }

    // Display the captcha
    tip1.setText(captcha.toString());
}
    private void con1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_con1MouseClicked

    }//GEN-LAST:event_con1MouseClicked

    private void con1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_con1ActionPerformed
  String SUrl = "jdbc:mysql://localhost:3306/usage";
    String SUser = "root";
    String SPass = "";
    String query;

    // Get the random code from the tip1 field (the code shown to the user)
    String tip = tip1.getText();  // The random code displayed in `tip1`
    System.out.println("Random Code: " + tip);

    // Get the input fields from the UI
    String username = user1.getText(); // Username entered by the user
    String enteredCode = email.getText(); // Random code entered by the user
    String newPassword = pas.getText(); // New password entered by the user
    String confirmPassword = pass.getText(); // Confirm password entered by the user

    // Validate the inputs
    if (username.isEmpty() || enteredCode.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled in.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if the entered code matches the randomly generated code
    if (!enteredCode.equals(tip)) {
        JOptionPane.showMessageDialog(this, "Code or Username does not match.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if passwords match
    if (!newPassword.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Establish a connection to the database
    try (Connection conn = DriverManager.getConnection(SUrl, SUser, SPass)) {

        // Create the SQL query to update the password for the given username
        String updatePasswordQuery = "UPDATE usern SET passwa = ? WHERE username = ?";

        // Prepare the statement to execute the query
        try (PreparedStatement ps = conn.prepareStatement(updatePasswordQuery)) {
            ps.setString(1, newPassword);  // Set the new password
            ps.setString(2, username);     // Set the username

            // Execute the update
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Password updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                user1.setText("");        // Clear username field
                email.setText("");        // Clear email/code field
                pas.setText("");          // Clear new password field
                pass.setText("");         // Clear confirm password field
                tip1.setText("");   
                this.dispose();
                window logen = new window();
                logen.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Code or Username does not match.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error executing update query: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_con1ActionPerformed

    private void user1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user1ActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed

        window nextWindow = new window(); // Ensure 'Window' class name starts with an uppercase letter
        nextWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LoginActionPerformed

    private void Login1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login1ActionPerformed
        Signuppp nextWindow = new Signuppp();
        nextWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Login1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new f2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel En;
    private javax.swing.JLabel En1;
    private javax.swing.JButton Login;
    private javax.swing.JButton Login1;
    private javax.swing.JLabel background;
    private javax.swing.JButton con1;
    private javax.swing.JTextField email;
    private javax.swing.JLabel last;
    private javax.swing.JLabel last1;
    private javax.swing.JTextField pas;
    private javax.swing.JTextField pass;
    private javax.swing.JLabel tip1;
    private javax.swing.JLabel us;
    private javax.swing.JTextField user1;
    // End of variables declaration//GEN-END:variables
}
