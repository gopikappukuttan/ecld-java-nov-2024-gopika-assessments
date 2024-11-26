public class StringEndsCheck {

    // Method to check if str1 ends with str2
    public static boolean checkEnding(String str1, String str2) {
        // Using endsWith() method to check str1 ends with str2
        return str1.endsWith(str2);
    }

    public static void main(String[] args) {
        // Test case 1
        boolean check = checkEnding("abc", "bc");
        System.out.println(check); //  true

        // Test case 2
        check = checkEnding("feminine", "nine");
        System.out.println(check); //true

        // Test case 3
        check = checkEnding("convention", "tio");
        System.out.println(check); // false
    }
}
