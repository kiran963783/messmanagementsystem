package com.messmanagementsystem.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class viewWeeklyMenu {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mess_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";

    public static void viewWeeklyMenu() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {
            
            String sql = "SELECT day, menu_item FROM weekly_menu";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                System.out.println("Weekly Menu:");
                while (rs.next()) {
                    String day = rs.getString("day");
                    String menuItem = rs.getString("menu_item");
                    System.out.println(day + ": " + menuItem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
