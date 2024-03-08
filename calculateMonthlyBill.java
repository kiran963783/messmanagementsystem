package com.messmanagementsystem.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class calculateMonthlyBill {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mess_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";

    public static void calculateMonthlyBill() throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM candidates");
            
            while (rs.next()) {
                String name = rs.getString("name");
                int attendanceCount = getAttendanceCount(conn, name);
                double totalBill = attendanceCount * 50; // Assuming charge per day is 50
                System.out.println("Candidate: " + name + ", Total Bill: " + totalBill);
            }
        }
    }
    
    private static int getAttendanceCount(Connection conn, String candidateName) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS attendance_count FROM attendance WHERE candidate_name = '" + candidateName + "'");
            if (rs.next()) {
                return rs.getInt("attendance_count");
            }
        }
        return 0;
    }
}
