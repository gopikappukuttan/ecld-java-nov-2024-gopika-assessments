import java.util.Arrays;

public class FindLargestGap {
    //method to find largest gap between numbers
    public static int largestGap(int[] numbers) {
        // Sort the array in ascending order
        Arrays.sort(numbers);
        int largestGap = 0;
        // Iterate through the sorted array to find the largest gap
        for (int i = 1; i < numbers.length; i++) {
            int gap = numbers[i] - numbers[i - 1];
            if (gap > largestGap) {
                largestGap = gap;
            }
        }
        return largestGap;
    }

    public static void main(String[] args) {
        //Test cases
        int[] numbers = {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5};
        System.out.println(largestGap(numbers));
        numbers = new int[]{0, 0, 4, 5, 5, 6, 9, 28, 25, 26, 26};
        System.out.println(largestGap(numbers));
    }
}
