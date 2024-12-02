import java.util.Scanner;

public class OddOneOut {
    public static boolean oddOneOut(String[] words) {
        int firstLength = words[0].length();
        int oddLength = -1;
        int oddCount = 0;

        // Count occurrences of differing lengths
        for (String word : words) {
            int length = word.length();
            if (length != firstLength) {
                if (oddLength == -1) {
                    oddLength = length; // Record the first differing length
                }
                if (length != oddLength) {
                    return false; // More than one differing length
                }
                oddCount++;
            }
        }

        // Check if exactly one odd-length word exists
        return oddCount == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input validation
        System.out.print("Enter the number of words (minimum 3): ");
        int n;
        while (true) {
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n >= 3) {
                    break;
                } else {
                    System.out.print("Please enter a number greater than or equal to 3: ");
                }
            } else {
                System.out.print("Invalid input. Please enter a valid number: ");
                scanner.next(); // Clear invalid input
            }
        }

        String[] words = new String[n];
        scanner.nextLine(); // Consume the newline character

        // Collect words from the user
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            System.out.print("Word " + (i + 1) + ": ");
            words[i] = scanner.nextLine().trim();

            // Validate that the input is non-empty
            while (words[i].isEmpty()) {
                System.out.print("Word cannot be empty. Enter again: ");
                words[i] = scanner.nextLine().trim();
            }
        }

        // Check if there's exactly one odd-length word
        boolean result = oddOneOut(words);
        System.out.println("Result: " + result);

        scanner.close();
    }
}


