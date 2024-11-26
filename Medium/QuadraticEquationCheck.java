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
        // Test cases
        System.out.println(solutions(1, 2, 1));
    }
}
