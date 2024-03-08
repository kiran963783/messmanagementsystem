package com.messmanagementsystem.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class findTotalBillOfWalkingMembers {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mess_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";

    public static void findTotalBillOfWalkingMembers() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT SUM(advance_amount) FROM candidates WHERE category = 'Daily Walking'")) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                double totalBill = rs.getDouble(1);
                System.out.println("Total bill of walking members: " + totalBill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
