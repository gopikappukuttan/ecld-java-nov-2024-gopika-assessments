package com.edstem.ecld.assessment;

import java.util.Scanner;

public class Calculator {
    //method to add 2 variables
    public static double add(double a, double b) {
        return (a + b);
    }

    //method to substract 2 variables
    public static double substract(double a, double b) {
        return (a - b);
    }

    //method to multiply 2 variables
    public static double multiply(double a, double b) {
        return (a * b);
    }

    //method to divide 2 variables
    public static double divide(double a, double b) {
        return (a / b);
    }

    public static void main(String[] args) {
        //making new object of scanner class
        Scanner sc = new Scanner(System.in);
        //user inputs and method use
        System.out.print("Enter first number:");
        double a = sc.nextDouble();
        System.out.print("Enter second number:");
        double b = sc.nextDouble();
        System.out.print("Choose Operation:\n" +
                "1.Add (+)\n" +
                "2.Substract(-)\n" +
                "3.Multiply(*)\n" +
                "4.Divide(/)\n" +
                "Enter choice:");
        int choiceNum = sc.nextInt();
        //calling method add() if chosen option is 1
        if (choiceNum == 1) {
            System.out.println(a + " + " + b + " = " + add(a, b));
        }
        //calling method substract() if chosen option is 2
        if (choiceNum == 2) {
            System.out.println(a + " - " + b + " = " + substract(a, b));
        }
        //calling method multiply() if chosen option is 3
        if (choiceNum == 3) {
            System.out.println(a + " * " + b + " = " + multiply(a, b));
        }
        //calling method divide() if chosen option is 4
        if (choiceNum == 4) {
            if(b==0){
                System.out.println("Invalid since divison is by zero");
            }else{
                System.out.println(a + " / " + b + " = " + divide(a, b));
            }
        }
        //closing scanner
        sc.close();
    }
}
