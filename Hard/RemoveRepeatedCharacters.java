import java.util.Scanner;

public class RemoveRepeatedCharacters {
    // Method to remove repeated characters
    public static String unrepeated(String str) {
        StringBuilder string = new StringBuilder();
        String presentChar = "";
        // Iterate through each character in the string
        for (char c : str.toCharArray()) {
            if (!presentChar.contains(String.valueOf(c))) {
                string.append(c);
                presentChar += c;
            } else {
                continue;
            }
        }
        return string.toString();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        System.out.println("Enter the String : ");
        String str = sc.nextLine();
        if (str == null || str.trim().isEmpty()) {
            System.out.println("Invalid input! The string cannot be empty.");
        } else {
            // Call the unrepeated function if the input is valid
            System.out.println("String is " + unrepeated(str));
        }
    }
}
