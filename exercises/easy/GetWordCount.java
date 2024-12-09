// A class to demonstrate counting the number of words in a sentence
public class GetWordCount {

    // Method to count the words in a given string
    public static int countWords(String s) {
        // Trim leading and trailing whitespace and split the string into words using regex "\\s+".
        // "\\s+" matches one or more whitespace characters.
        String words[] = s.trim().split("\\s+");

        // Loop through each word in the array and print it
        for (String word : words) {
            System.out.println(word); // Print each word for debugging or verification
        }

        // Print a message indicating that word count will be displayed next
        System.out.print("Words count is ");

        // Return the number of words in the array (the word count)
        return words.length;
    }

    // Main method to test the word count functionality
    public static void main(String[] args) {
        // Call the countWords method with a sample sentence and store the result
        int count = countWords("Heloo.. I'm Gopika p a");

        // Print the total word count
        System.out.println(count);
    }
}
