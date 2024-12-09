import java.util.Scanner;

public class UnMixStrings {
    public static String unmix(String str) {
        char[] inputArray = str.toCharArray();
        for (int i = 0; i < inputArray.length - 1; i += 2) {
            char temp = inputArray[i];
            inputArray[i] = inputArray[i + 1];
            inputArray[i + 1] = temp;
        }
        return new String(inputArray);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input validation for non-empty string
        String str;
        while (true) {
            System.out.println("Enter the mixed up String: ");
            str = sc.nextLine();

            if (str.isEmpty()) {
                System.out.println("The input cannot be empty. Please enter a valid string.");
            } else {
                break;
            }
        }

        System.out.println("Unmixed string: " + unmix(str));
       /* System.out.println(unmix("lPaeesh le pemu mnxit ehess rtnisg! "));
        System.out.println(unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println(unmix("badce"));*/
    }
}
