package com.messmanagementsystem.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class clientapp {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mess_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";
    static double WALKING_MEMBER_RATE_PER_PLATE = 50.0;
    static double MONTHLY_MEMBER_FEES = 1000.0; 

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Mess Management System");
            System.out.println("Choose an option:");
            System.out.println("1. Register candidate");
            System.out.println("2. Take attendance of candidate");
            System.out.println("3. View Weekly Menu");
            System.out.println("4. Calculate Monthly Bill");
            System.out.println("5. Count the total number of candidate visits in the month for walking");
            System.out.println("6. Count monthly members");
            System.out.println("7. Find the total bill from monthly members");
            System.out.println("8. Find the total bill of walking members");
            System.out.println("9. Set the per plate rate for walking members");
            System.out.println("10. Set the monthly fees for monthly members");
            System.out.println("11. Show bill comparison between monthly members and daily walking members");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    registerCandidate.registerCandidate(scanner);
                    break;
                case 2:             
                    takeAttendance.takeAttendance(scanner);
                    break;
                case 3:                 
                    viewWeeklyMenu.viewWeeklyMenu();
                    break;
                case 4:                   
                    calculateMonthlyBill.calculateMonthlyBill();
                    break;
                case 5:               
                    countWalkingVisits.countWalkingVisits();
                    break;
                case 6:            
                    countMonthlyMembers.countMonthlyMembers();
                    break;
                case 7:        
                    findTotalBillFromMonthlyMembers.findTotalBillFromMonthlyMembers();
                    break;
                case 8:       
                    findTotalBillOfWalkingMembers.findTotalBillOfWalkingMembers();
                    break;
                case 9:
                    setPerPlateRateForWalkingMembers.setPerPlateRateForWalkingMembers(scanner);
                    break;
                case 10:
                    setMonthlyFeesForMonthlyMembers.setMonthlyFeesForMonthlyMembers(scanner);
                    break;
                case 11:
                    showBillComparison.showBillComparison();
                    break;
                default:
                    System.out.println("Invalid option selected.");
            }

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
