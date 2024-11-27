import java.util.Scanner;

public class SumOddEven {

    public static int warOfNumbers(int[] numbers) {
        // Initializing variables for even and odd sums
        int sumEven = 0;
        int sumOdd = 0;

        // Iterate over the array once
        for (int number : numbers) {
            if (number % 2 == 0) { // If the number is even
                sumEven += number;
            } else { // If the number is odd
                sumOdd += number;
            }
        }
        // Return the difference between the sum of even and odd numbers
        return Math.abs(sumEven - sumOdd);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;

        // Input validation for the size of the array
        while (n <= 0) {
            System.out.println("Enter the number of elements in the array (positive integer):");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("The number of elements must be greater than zero.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); // Clear invalid input
            }
        }

        int[] numbers = new int[n];

        // Input validation for the array elements
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Element " + (i + 1) + ": ");
                if (sc.hasNextInt()) {
                    numbers[i] = sc.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    sc.next(); // Clear invalid input
                }
            }
        }
        System.out.println("Result: "+warOfNumbers(numbers));
    }
}


