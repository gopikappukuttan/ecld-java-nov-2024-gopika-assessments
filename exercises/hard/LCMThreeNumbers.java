import java.util.Scanner;

public class LCMThreeNumbers {

    // Function to compute the GCD
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to compute the LCM of two numbers
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Function to compute the LCM of three numbers
    public static int lcmThree(int[] nums) {
        if (nums.length != 3) {
            throw new IllegalArgumentException("The array must contain exactly three numbers.");
        }
        return lcm(lcm(nums[0], nums[1]), nums[2]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three numbers separated by spaces:");
        String[] input = scanner.nextLine().split(" ");

        if (input.length != 3) {
            System.out.println("Please provide exactly three numbers.");
            return;
        }

        try {
            int[] numbers = new int[3];
            for (int i = 0; i < 3; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }

            int result = lcmThree(numbers);
            System.out.println("The LCM of the given numbers is: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter integers only.");
        }

        scanner.close();
    }
}
