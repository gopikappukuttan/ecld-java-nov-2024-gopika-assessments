import java.util.Scanner;

public class PerfectNumberCheck {

    // Method to check if a number is perfect
    public static boolean checkPerfect(int num) {
        int sum = 0;
        // Loop through all numbers from 1 to num-1 to find divisors
        for (int i = 1; i < num; i++) {
            // Check if i is a divisor of num
            if (num % i == 0) {
                sum += i;
            }
        }
        return num == sum;//returns true if its perfect
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=-1;
        // Input validation
        while (num <= 0) {
            System.out.println("Enter a positive integer:");
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                if (num <= 0) {
                    System.out.println("Please enter a number greater than zero.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); // Clear the invalid input
            }
        }
        System.out.println(checkPerfect(num));
    }
}
