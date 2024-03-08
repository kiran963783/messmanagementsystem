package com.messmanagementsystem.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class showBillComparison {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mess_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";

    public static void showBillComparison() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {
            double monthlyBill = 0;
            double walkingBill = 0;

            ResultSet rs = stmt.executeQuery("SELECT * FROM candidates");
            while (rs.next()) {
                String category = rs.getString("category");
                double advanceAmount = rs.getDouble("advance_amount");
                if ("Monthly".equals(category)) {
                    monthlyBill += advanceAmount;
                } else if ("Daily Walking".equals(category)) {
                    walkingBill += advanceAmount;
                }
            }

            System.out.println("Total bill from monthly members: " + monthlyBill);
            System.out.println("Total bill from walking members: " + walkingBill);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
