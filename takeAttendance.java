package com.messmanagementsystem.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class takeAttendance {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mess_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";

    public static void takeAttendance(Scanner scanner) throws SQLException {
        System.out.print("Enter candidate name: ");
        String name = scanner.nextLine();

        System.out.print("Is the candidate present today? (yes/no): ");
        String presentStatus = scanner.nextLine();
        boolean isPresent = presentStatus.equalsIgnoreCase("yes");

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String status = isPresent ? "Present" : "Absent";
            String sql = "INSERT INTO attendance (candidate_name, attendance_date, attendance_status) VALUES (?, CURDATE(), ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, status);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Attendance recorded successfully for " + name + ".");
                } else {
                    System.out.println("Failed to record attendance for " + name + ".");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
