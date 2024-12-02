import java.util.Scanner;

public class ReverseWords {

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int end = s.length() - 1;

        while (end >= 0) {
            // Skip trailing spaces
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }

            // If no more characters, break
            if (end < 0) break;

            // Find the start of the word
            int start = end;
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }

            // Add the word to the result
            result.append(s.substring(start + 1, end + 1)).append(" ");

            // Move end pointer to the next word
            end = start;
        }

        // Remove the trailing space and return
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to reverse its words:");
        String input = scanner.nextLine();

        // Check if the input is empty or contains only spaces
        if (input.trim().isEmpty()) {
            System.out.println("Invalid input. Please enter a non-empty string.");
        } else {
            String reversed = reverseWords(input);
            System.out.println("Reversed words: " + reversed);
        }

        scanner.close();
    }
}
