import java.util.Scanner;

public class RectangleInCircle {
    // Method to check if a rectangle can fit inside a circle
    public static boolean rectangleInCircle(int w, int h, int radius) {
        // Calculate the diagonal of the rectangle using Pythagoras' theorem
        double diagonal = Math.sqrt(w * w + h * h);
        // Calculate the diameter of the circle
        double diameter = 2 * radius;
        // Check if the rectangle's diagonal is less than or equal to the circle's diameter
        return diagonal <= diameter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = -1, h = -1, radius = -1;

        // Input validation for width
        while (w <= 0) {
            System.out.println("Enter a positive integer for the width of the rectangle:");
            if (sc.hasNextInt()) {
                w = sc.nextInt();
                if (w <= 0) {
                    System.out.println("Width must be greater than zero.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); // Clear invalid input
            }
        }

        // Input validation for height
        while (h <= 0) {
            System.out.println("Enter a positive integer for the height of the rectangle:");
            if (sc.hasNextInt()) {
                h = sc.nextInt();
                if (h <= 0) {
                    System.out.println("Height must be greater than zero.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); // Clear invalid input
            }
        }

        // Input validation for radius
        while (radius <= 0) {
            System.out.println("Enter a positive integer for the radius of the circle:");
            if (sc.hasNextInt()) {
                radius = sc.nextInt();
                if (radius <= 0) {
                    System.out.println("Radius must be greater than zero.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); // Clear invalid input
            }
        }
        System.out.println(rectangleInCircle(w,h,radius));
    }
}
