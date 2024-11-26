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
        // Test cases
        System.out.println(warOfNumbers(new int[]{2, 8, 7, 5}));
        System.out.println(warOfNumbers(new int[]{12, 90, 75, 55, 9}));
    }
}


