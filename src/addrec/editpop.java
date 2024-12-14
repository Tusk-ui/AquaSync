/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package addrec;

import Signup.Sign;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
/**
 *
 * @author tuskc
 */
public class editpop extends javax.swing.JFrame {
    
    
      private Connection userDbConn;
      private String username;
      private String oldMonth;
      private double oldUsage;
      private Sign parent;

public editpop(Sign parent, Connection dbConn, String selectedMonthYear, double selectedUsage) {
    initComponents();
    
    this.userDbConn = dbConn;
    this.oldMonth = selectedMonthYear;
    this.oldUsage = selectedUsage;
    this.parent = parent; // Store reference to parent Sign class

    int arcWidth = 50;  // Width of the rounded corners
    int arcHeight = 50;  // Height of the rounded corners
    SwingUtilities.invokeLater(() -> {
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
    });
    try {
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MMMM yyyy");
        java.util.Date date = dateFormat.parse(selectedMonthYear);

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(date);

        int month = calendar.get(java.util.Calendar.MONTH); // 0 = January, 11 = December
        int year = calendar.get(java.util.Calendar.YEAR);

        // Set the values in JMonthChooser and JYearChooser
        monthch.setMonth(month); // JMonthChooser expects 0-based month index
        this.year.setYear(year);

    } catch (java.text.ParseException e) {
        JOptionPane.showMessageDialog(this, "Error parsing month and year: " + e.getMessage(), "Parse Error", JOptionPane.ERROR_MESSAGE);
    }

    // Set the usage field
    usa.setText(String.valueOf(selectedUsage));
}

    
     class JPanelGradient1 extends JPanel {
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

        jPanel1 = new JPanelGradient1();
        jLabel1 = new javax.swing.JLabel();
        usa = new javax.swing.JTextField();
        Edit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Leave = new javax.swing.JButton();
        monthch = new com.toedter.calendar.JMonthChooser();
        year = new com.toedter.calendar.JYearChooser();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 250));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 350));

        jLabel1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel1.setText("EDIT RECORD");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        usa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usaActionPerformed(evt);
            }
        });

        Edit.setText("Save Changes");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel2.setText("Input Usage");

        Leave.setText("Leave");
        Leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaveActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel3.setText("Select Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(monthch, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10))
                                    .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Leave, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(monthch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Edit)
                .addGap(47, 47, 47)
                .addComponent(Leave)
                .addGap(80, 80, 80))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(400, 350));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    
    private void usaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usaActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
try {
    // Get selected month and year from JMonthChooser and JYearChooser
    int selectedMonth = monthch.getMonth(); // 0 = January, 11 = December
    int selectedYear = year.getYear();

    // Get the updated usage value
    String usageInput = usa.getText().trim();
    if (usageInput.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a usage value.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    double newUsage = Double.parseDouble(usageInput);
    if (newUsage < 0) {
        JOptionPane.showMessageDialog(this, "Usage value cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Convert the month index (0-11) to the corresponding month name
    String[] monthNames = {
        "January", "February", "March", "April", "May", "June", 
        "July", "August", "September", "October", "November", "December"
    };
    String newMonthName = monthNames[selectedMonth];

    // Extract old year and month from oldMonth
    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MMMM yyyy");
    java.util.Date oldDate = dateFormat.parse(oldMonth);
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    calendar.setTime(oldDate);
    String oldMonthName = monthNames[calendar.get(java.util.Calendar.MONTH)];
    int oldYear = calendar.get(java.util.Calendar.YEAR);

    // Check if the selected month and year already exist in the database, excluding the current record
    String checkQuery = "SELECT COUNT(*) FROM usage_data WHERE Month = ? AND Year = ? AND NOT (Month = ? AND Year = ?)";
    try (PreparedStatement checkPs = userDbConn.prepareStatement(checkQuery)) {
        checkPs.setString(1, newMonthName);
        checkPs.setInt(2, selectedYear);
        checkPs.setString(3, oldMonthName);
        checkPs.setInt(4, oldYear);
        ResultSet rs = checkPs.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, "This month and year already exist. Duplicate entries are not allowed.", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }

    if (selectedYear != oldYear || !newMonthName.equals(oldMonthName)) {
        // If the year or month has changed, transfer the value
        String deleteQuery = "DELETE FROM usage_data WHERE Month = ? AND Year = ?";
        try (PreparedStatement deletePs = userDbConn.prepareStatement(deleteQuery)) {
            deletePs.setString(1, oldMonthName);
            deletePs.setInt(2, oldYear);
            deletePs.executeUpdate();
        }

        String insertQuery = "INSERT INTO usage_data (Month, Year, Useyg) VALUES (?, ?, ?)";
        try (PreparedStatement insertPs = userDbConn.prepareStatement(insertQuery)) {
            insertPs.setString(1, newMonthName);
            insertPs.setInt(2, selectedYear);
            insertPs.setDouble(3, newUsage);
            insertPs.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Usage value transferred successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Update the usage value for the same month and year
        String updateQuery = "UPDATE usage_data SET Useyg = ? WHERE Month = ? AND Year = ?";
        try (PreparedStatement updatePs = userDbConn.prepareStatement(updateQuery)) {
            updatePs.setDouble(1, newUsage);
            updatePs.setString(2, oldMonthName);
            updatePs.setInt(3, oldYear);
            updatePs.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Usage value updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Notify parent to refresh the table
    if (parent != null) {
        parent.refreshTable();
        parent.setEnabled(false);
    }

} catch (java.text.ParseException e) {
    JOptionPane.showMessageDialog(this, "Error parsing date: " + e.getMessage(), "Parse Error", JOptionPane.ERROR_MESSAGE);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number for Usage.", "Input Error", JOptionPane.ERROR_MESSAGE);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_EditActionPerformed

    private void LeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaveActionPerformed
     if (parent != null) {
        parent.setEnabled(true); 
        parent.setVisible(true);
        parent.editwindow = null; 
        
        // Ensure data changes in the pop-up are reflected
        parent.refreshTable(); 
    }
    this.dispose();
    }//GEN-LAST:event_LeaveActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Edit;
    private javax.swing.JButton Leave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JMonthChooser monthch;
    private javax.swing.JTextField usa;
    private com.toedter.calendar.JYearChooser year;
    // End of variables declaration//GEN-END:variables
}
