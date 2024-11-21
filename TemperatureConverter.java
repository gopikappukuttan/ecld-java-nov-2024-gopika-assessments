package com.edstem.ecld.assessment;

import java.util.Scanner;

public class TemperatureConverter {
    //method to convert temperature in degree celsius to fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return ((celsius * 1.8) + 32);
    }

    //method to convert temperature in fahrenheit to degree celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return ((fahrenheit - 32) / 1.8);
    }

    public static void main(String[] args) {
        //making new object of scanner class
        Scanner sc = new Scanner(System.in);
        //user inputs and method use
        System.out.println("======Menu======");
        System.out.println("1.Convert celsius to Fahrenheit\n" +
                "2.Convert Fahrenheit to celsius\n" +
                "3.Exit");
        System.out.print("Choose Option:");
        int num = sc.nextInt();
        //calling method celsiusToFahrenheit() if chosen option is 1
        if (num == 1) {
            System.out.println("Enter temperature in Celsius");
            double celsius = sc.nextDouble();
            System.out.printf(celsius + "°C = " + String.format("%.1f", celsiusToFahrenheit(celsius)) + "°F");//%.1f to convert to one decimal place
        }
        //calling method fahrenheitToCelsius() if chosen option is 2
        if (num == 2) {
            System.out.println("Enter temperature in Fahrenheit");
            double fahrenheit = sc.nextDouble();
            System.out.printf(fahrenheit + "°F = " + String.format("%.1f", fahrenheitToCelsius(fahrenheit)) + "°C");//%.1f to convert to one decimal place
        }
        //closing scanner
        sc.close();
    }
}
