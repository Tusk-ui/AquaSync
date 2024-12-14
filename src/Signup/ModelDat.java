package Signup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelDat {
    private String month; // Holds the month as a string
    private int year;     // Holds the year
    private double amount; // Holds the usage amount

    // Constructor
    public ModelDat(String month, int year, double amount) {
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    // Getters and Setters
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ModelDat{" +
                "month='" + month + '\'' +
                ", year=" + year +
                ", amount=" + amount +
                '}';
    }

    // CRUD Operations

    // Add Record
    public static boolean addRecord(Connection conn, String month, int year, double usage) throws SQLException {
        String query = "INSERT INTO usage_data (Month, Year, Useyg) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, month);
            ps.setInt(2, year);
            ps.setDouble(3, usage);
            return ps.executeUpdate() > 0;
        }
    }

    // Update Record
    public static boolean updateRecord(Connection conn, String oldMonth, int oldYear, String newMonth, int newYear, double newUsage) throws SQLException {
        String query = "UPDATE usage_data SET Month = ?, Year = ?, Useyg = ? WHERE Month = ? AND Year = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, newMonth);
            ps.setInt(2, newYear);
            ps.setDouble(3, newUsage);
            ps.setString(4, oldMonth);
            ps.setInt(5, oldYear);
            return ps.executeUpdate() > 0;
        }
    }

    // Delete Record
    public static boolean deleteRecord(Connection conn, String month, int year) throws SQLException {
        String query = "DELETE FROM usage_data WHERE Month = ? AND Year = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, month);
            ps.setInt(2, year);
            return ps.executeUpdate() > 0;
        }
    }

    // Retrieve All Records
    public static List<ModelDat> getAllRecords(Connection conn) throws SQLException {
        List<ModelDat> dataList = new ArrayList<>();
        String query = "SELECT Month, Year, Useyg FROM usage_data";
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String month = rs.getString("Month");
                int year = rs.getInt("Year");
                double usage = rs.getDouble("Useyg");
                dataList.add(new ModelDat(month, year, usage));
            }
        }
        return dataList;
    }
}
