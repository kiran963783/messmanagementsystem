package com.messmanagementsystem.manager;

import java.util.Scanner;

public class setPerPlateRateForWalkingMembers {

    public static double WALKING_MEMBER_RATE_PER_PLATE = 50.0; // Assuming charge per plate for walking members

    public static void setPerPlateRateForWalkingMembers(Scanner scanner) {
        System.out.print("Enter the new per plate rate for walking members: ");
        WALKING_MEMBER_RATE_PER_PLATE = scanner.nextDouble();
        System.out.println("Per plate rate for walking members updated successfully.");
    }

}
