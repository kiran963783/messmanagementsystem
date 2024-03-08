package com.messmanagementsystem.manager;

import java.util.Scanner;

public class setMonthlyFeesForMonthlyMembers {

    public static void setMonthlyFeesForMonthlyMembers(Scanner scanner) {
        try {
            System.out.print("Enter the new monthly fees for monthly members: ");
            double newMonthlyFees = scanner.nextDouble();
            clientapp.MONTHLY_MEMBER_FEES = newMonthlyFees;
            System.out.println("Monthly fees for monthly members updated successfully.");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

}
