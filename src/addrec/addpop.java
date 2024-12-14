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
import java.sql.ResultSet;
/**
 *
 * @author tuskc
 */
public class addpop extends javax.swing.JFrame {
    
    
      private Connection userDbConn;
      private String username;
      private Sign parent;
      
     public addpop(Sign parent,Connection userDbConn) {
         this.userDbConn = userDbConn;  
         this.parent = parent;
        initComponents();
        int arcWidth = 50;  // Width of the rounded corners
    int arcHeight = 50;  // Height of the rounded corners
    SwingUtilities.invokeLater(() -> {
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
    });
    }
public void actionPerformed(ActionEvent e) {
                addRecordToTable();
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Leave = new javax.swing.JButton();
        monthch = new com.toedter.calendar.JMonthChooser();
        year = new com.toedter.calendar.JYearChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 250));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 350));

        jLabel1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select Date");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        usa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usaActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Input Usage");

        Leave.setText("Leave");
        Leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaveActionPerformed(evt);
            }
        });

        jLabel3.setText("Cubic Meter");

        jLabel4.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ADD NEW RECORD");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Leave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(monthch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(usa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(52, 52, 52)))))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(monthch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(48, 48, 48)
                .addComponent(Leave)
                .addGap(82, 82, 82))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(400, 350));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  private void addRecordToTable() {
      try {
        // Get selected month and year from JMonthChooser and JYearChooser
        int selectedMonth = monthch.getMonth(); // 0 = January, 11 = December
        int selectedYear = year.getYear(); 

        // Validate input
        if (usa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a value for Usage.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convert usage to a double
        double usage = Double.parseDouble(usa.getText().trim());

        // Format the date to "MMMM yyyy"
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MMMM yyyy");
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(java.util.Calendar.MONTH, selectedMonth);
        calendar.set(java.util.Calendar.YEAR, selectedYear);
        String formattedDate = dateFormat.format(calendar.getTime());

        // Prepare SQL query to insert data
        String query = "INSERT INTO usage_data (Month, Useyg) VALUES (?, ?)";
        PreparedStatement ps = userDbConn.prepareStatement(query);

        // Set query parameters
        ps.setString(1, formattedDate); // Set formatted date
        ps.setDouble(2, usage);         // Set usage value

        // Execute query
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Record added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Optionally refresh the parent table
        if (parent != null) {
            int yearFilter = 2024; 
        parent.refreshTable();
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number for Usage.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }
    
    private void usaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try {
        // Retrieve selected month and year
        int selectedMonth = monthch.getMonth(); // 0 = January, 11 = December
        int selectedYear = year.getYear();

        // Convert numeric month to its name
        String monthName = getMonthName(selectedMonth);

        // Get the entered usage value
        String usageInput = usa.getText().trim();
        if (usageInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a usage value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double usage = Double.parseDouble(usageInput);
        if (usage < 0) {
            JOptionPane.showMessageDialog(this, "Usage value cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if the month and year already exist in the database
        String checkQuery = "SELECT COUNT(*) FROM usage_data WHERE Month = ? AND Year = ?";
        PreparedStatement checkStmt = userDbConn.prepareStatement(checkQuery);
        checkStmt.setString(1, monthName); // Store the month as its name (e.g., "January")
        checkStmt.setInt(2, selectedYear);

        ResultSet rs = checkStmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        if (count > 0) {
            JOptionPane.showMessageDialog(this, "This month and year already exist in the database.", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
        } else {
            // Insert the new record
            String insertQuery = "INSERT INTO usage_data (Month, Year, Useyg) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = userDbConn.prepareStatement(insertQuery);
            insertStmt.setString(1, monthName); // Insert month as name
            insertStmt.setInt(2, selectedYear);
            insertStmt.setDouble(3, usage);
            insertStmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Record added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Refresh the table in the parent class
            if (parent != null) {
                 
                 parent.refreshTable();
                 parent.setEnabled(false);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid usage value. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Helper method to get month name
private String getMonthName(int month) {
    String[] months = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    if (month >= 0 && month < 12) {
        return months[month];
    } else {
        throw new IllegalArgumentException("Invalid month: " + month);
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void LeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaveActionPerformed
    if (parent != null) {
        parent.setEnabled(true); 
        parent.setVisible(true);
        parent.addPopWindow = null; 
        
        // Ensure data changes in the pop-up are reflected
        parent.refreshTable(); 
    }
    this.dispose();

    }//GEN-LAST:event_LeaveActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Leave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JMonthChooser monthch;
    private javax.swing.JTextField usa;
    private com.toedter.calendar.JYearChooser year;
    // End of variables declaration//GEN-END:variables
}
