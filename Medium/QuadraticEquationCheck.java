import java.util.Scanner;

public class QuadraticEquationCheck {

    // Method to find the number of solutions to a quadratic equation
    public static int solutions(int a, int b, int c) {
        // Calculate the discriminant: D = b² - 4ac
        int discriminant = b * b - 4 * a * c;

        // If the discriminant is positive, there are two real solutions
        if (discriminant > 0) {
            return 2;  // Two solutions
        }
        // If the discriminant is zero, there is one real solution
        else if (discriminant == 0) {
            return 1;  // One solution
        }
        // If the discriminant is negative, there are no real solutions
        else {
            return 0;
        }
    }

    // Main method to test the solutions function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = -1, b = -1, c = -1;

        // Input validation for coefficient a
        while (true) {
            System.out.println("Enter a non-zero integer for coefficient 'a':");
            if (sc.hasNextInt()) {
                a = sc.nextInt();
                if (a != 0) {
                    break; // Valid input for 'a'
                } else {
                    System.out.println("'a' cannot be zero. Quadratic equations require a non-zero 'a'.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); // Clear invalid input
            }
        }

        // Input validation for coefficient b
        while (true) {
            System.out.println("Enter an integer for coefficient 'b':");
            if (sc.hasNextInt()) {
                b = sc.nextInt();
                break; // Valid input for 'b'
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); // Clear invalid input
            }
        }

        // Input validation for coefficient c
        while (true) {
            System.out.println("Enter an integer for coefficient 'c':");
            if (sc.hasNextInt()) {
                c = sc.nextInt();
                break; // Valid input for 'c'
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); // Clear invalid input
            }
        }
        System.out.println("Number of solutions is "+solutions(a,b,c));
    }
}
