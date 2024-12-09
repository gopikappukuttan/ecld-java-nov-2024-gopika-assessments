package com.edstem.ecld.assessment;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TemperatureConverter {
    // Method to convert temperature in Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return ((celsius * 1.8) + 32);
    }

    // Method to convert temperature in Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return ((fahrenheit - 32) / 1.8);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueConversion = true;

        while (continueConversion) {
            int choice = 0;
            // Input validation for menu choice
            while (true) {
                try {
                    System.out.println("======Menu======");
                    System.out.println("1. Convert Celsius to Fahrenheit\n" +
                            "2. Convert Fahrenheit to Celsius\n" +
                            "3. Exit");
                    System.out.print("Choose Option: ");
                    choice = sc.nextInt();

                    if (choice >= 1 && choice <= 3) {
                        break; // Valid choice
                    } else {
                        System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    sc.next(); // Clear invalid input
                }
            }

            if (choice == 1) {
                // Celsius to Fahrenheit conversion
                double celsius = 0;
                while (true) {
                    try {
                        System.out.print("Enter temperature in Celsius (-273.15 to 1000): ");
                        celsius = sc.nextDouble();
                        if (celsius >= -273.15 && celsius <= 1000) {
                            break; // Valid input
                        } else {
                            System.out.println("Invalid temperature range. Please enter a value between -273.15 and 1000.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        sc.next(); // Clear invalid input
                    }
                }
                System.out.printf(celsius + "°C = " + String.format("%.1f", celsiusToFahrenheit(celsius)) + "°F\n");

            } else if (choice == 2) {
                // Fahrenheit to Celsius conversion
                double fahrenheit = 0;
                while (true) {
                    try {
                        System.out.print("Enter temperature in Fahrenheit (-459.67 to 1832): ");
                        fahrenheit = sc.nextDouble();
                        if (fahrenheit >= -459.67 && fahrenheit <= 1832) {
                            break; // Valid input
                        } else {
                            System.out.println("Invalid temperature range. Please enter a value between -459.67 and 1832.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        sc.next(); // Clear invalid input
                    }
                }
                System.out.printf(fahrenheit + "°F = " + String.format("%.1f", fahrenheitToCelsius(fahrenheit)) + "°C\n");

            } else if (choice == 3) {
                // Exit the program
                System.out.println("Exiting the program.");
                continueConversion = false;
            }
        }

        // Close the scanner
        sc.close();
    }
}
