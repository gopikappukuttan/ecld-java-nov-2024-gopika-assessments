public class RemoveVowelsProgram {

    // Method to remove vowels from a given string
    public static String removeVowels(String s) {
        // Using StringBuilder to build the resulting string
        StringBuilder string = new StringBuilder();
        // Defining vowels (both uppercase and lowercase)
        String vowels = "aeiouAEIOU";

        // Iterating through each character in the string
        for (char c : s.toCharArray()) {
            // Check if the character is not a vowel
            if (vowels.indexOf(c) == -1) {
                // If not a vowel, append it to the result
                string.append(c);
            }
        }
        // Return the resulting string without vowels
        return string.toString();
    }

    public static void main(String[] args) {
        // Test the removeVowels method with sample input
        String result = removeVowels("I have never seen a thin person drinking Diet Coke.");
        // Print the result
        System.out.println(result);

        // Test with another input
        result = removeVowels("We're gonna build a wall!");
        // Print the result
        System.out.println(result);
    }
}
