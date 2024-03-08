package com.messmanagementsystem.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class countWalkingVisits {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mess_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";

    public static void countWalkingVisits() throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) FROM attendance WHERE MONTH(attendance_date) = MONTH(CURDATE()) AND YEAR(attendance_date) = YEAR(CURDATE()) AND attendance_status = 'Present' AND category = 'Daily Walking'")) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int walkingVisits = rs.getInt(1);
                System.out.println("Total number of candidate visits in the month for walking: " + walkingVisits);
            }
        }
    }
}
