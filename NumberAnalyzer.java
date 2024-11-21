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
        //user inputs and method use
        System.out.println("Enter 5 different Numbers");
        int num1 = sc.nextInt();
        analyzeNumber(num1);
        System.out.println("Enter next Number");
        int num2 = sc.nextInt();
        System.out.println("Enter next Number");
        analyzeNumber(num2);
        System.out.println("Enter next Number");
        int num3 = sc.nextInt();
        analyzeNumber(num3);
        System.out.println("Enter next Number");
        int num4 = sc.nextInt();
        analyzeNumber(num4);
        System.out.println("Enter next Number");
        int num5 = sc.nextInt();
        analyzeNumber(num5);
        //closing scanner
        sc.close();
    }
}
