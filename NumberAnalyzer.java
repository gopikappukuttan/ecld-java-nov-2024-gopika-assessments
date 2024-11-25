package com.edstem.ecld.assessment;

import java.util.Scanner;

public class NumberAnalyzer {
    public static void analyzeNumber(int num) {
        //To check if number is positive or negative
        if (num > 0) {
            System.out.println("-Positive");
        } else if (num < 0) {
            System.out.println("-Negative");
        } else {
            System.out.println("-Zero");
        }
        //To check if number is odd or even
        if (num % 2 == 0) {
            System.out.println("-Even");
        } else {
            System.out.println("-Odd");
        }
        //To check if number is multiple of 5 or not
        if (num % 5 == 0) {
            System.out.println("-Multiple of 5");
        } else {
            System.out.println("-Not a Multiple of 5");
        }
    }
 //main method
    public static void main(String[] args) {
        //making new object of scanner class
        Scanner sc = new Scanner(System.in);
        int i = 1; // To count valid inputs
        while (i <= 5) {
            try {
                // Prompt the user for input
                System.out.print("Enter number " + i + ": ");
                int num = sc.nextInt(); // Read the number
                analyzeNumber(num); // Analyze the number
                i++; // Increment only if input is valid
            } catch (InputMismatchException e) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // Clear the invalid input
            }
        }

        // Close the scanner
        sc.close();
    }
