package com.edstem.ecld.assessment;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator {
    // Method to add 2 variables
    public static double add(double a, double b) {
        return (a + b);
    }

    // Method to subtract 2 variables
    public static double subtract(double a, double b) {
        return (a - b);
    }

    // Method to multiply 2 variables
    public static double multiply(double a, double b) {
        return (a * b);
    }

    // Method to divide 2 variables
    public static double divide(double a, double b) {
        return (a / b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueCalculation = true;

        while (continueCalculation) {
            try {
                System.out.print("Enter first number: ");
                double a = sc.nextDouble();

                System.out.print("Enter second number: ");
                double b = sc.nextDouble();

                System.out.println("Choose Operation:\n" +
                        "1. Add (+)\n" +
                        "2. Subtract (-)\n" +
                        "3. Multiply (*)\n" +
                        "4. Divide (/)\n" +
                        "5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println(a + " + " + b + " = " + add(a, b));
                        break;
                    case 2:
                        System.out.println(a + " - " + b + " = " + subtract(a, b));
                        break;
                    case 3:
                        System.out.println(a + " * " + b + " = " + multiply(a, b));
                        break;
                    case 4:
                        if (b == 0) {
                            System.out.println("Undefined (division by zero is not allowed)");
                        } else {
                            System.out.println(a + " / " + b + " = " + divide(a, b));
                        }
                        break;
                    case 5:
                        System.out.println("Exiting the calculator. Goodbye!");
                        continueCalculation = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next(); // Clear invalid input
            }
        }

        sc.close();
    }
}
