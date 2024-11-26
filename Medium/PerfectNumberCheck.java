public class PerfectNumberCheck {

    // Method to check if a number is perfect
    public static boolean checkPerfect(int num) {
        int sum = 0;

        // Loop through all numbers from 1 to num-1 to find divisors
        for (int i = 1; i < num; i++) {
            // Check if i is a divisor of num
            if (num % i == 0) {
                sum += i; // Add divisor to sum
            }
        }
        // If the sum of divisors equals the number, it's perfect
        if (num == sum) {
            return true;
        } else {
            return false; // Return false if the sum doesn't equal the number
        }
    }

    public static void main(String[] args) {
        // Test cases for the checkPerfect method
        System.out.println(checkPerfect(6));   // true
        System.out.println(checkPerfect(28));  // true
        System.out.println(checkPerfect(88));  // false
    }
}
