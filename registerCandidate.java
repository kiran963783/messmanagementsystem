package com.messmanagementsystem.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class registerCandidate {

    public static void registerCandidate(Scanner scanner) throws SQLException {
        System.out.println("Enter candidate details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Advance amount: ");
        double advanceAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Category (Monthly/Daily Walking): ");
        String category = scanner.nextLine();

        final String JDBC_URL = "jdbc:mysql://localhost:3306/mess_db";
        final String USERNAME = "root";
        final String PASSWORD = "1234";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO candidates (name, phone, email, address, advance_amount, category) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, phone);
                pstmt.setString(3, email);
                pstmt.setString(4, address);
                pstmt.setDouble(5, advanceAmount);
                pstmt.setString(6, category);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Candidate registered successfully.");
                } else {
                    System.out.println("Failed to register candidate.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
