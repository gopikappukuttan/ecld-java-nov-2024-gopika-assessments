import java.util.Scanner;

public class ExtractWordFromSentence {
    public static String removeWord(final String sentence, final String word) {
        String[] newSentenceArray = sentence.split("\\s+");
        StringBuilder newSentence = new StringBuilder();
        for (String str : newSentenceArray) {
            if (!str.equals(word)) {
                if (newSentence.length() > 0) {
                    newSentence.append(" ");
                }
                newSentence.append(str);
            }
        }
        return newSentence.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Validate sentence input
        String sentence = "";
        while (true) {
            System.out.println("Enter the sentence:");
            sentence = sc.nextLine();
            if (sentence.isEmpty()) {
                System.out.println("Sentence cannot be empty. Please enter a valid sentence.");
            } else {
                break;
            }
        }

        // Validate word input
        String word = "";
        while (true) {
            System.out.println("Now enter the word to be extracted from sentence:");
            word = sc.nextLine();
            if (word.isEmpty()) {
                System.out.println("Word cannot be empty. Please enter a valid word.");
            } else {
                break;
            }
        }

        if (!sentence.contains(word)) {
            System.out.println("The word '" + word + "' was not found in the sentence.");
        } else {
            System.out.println("Sentence after removing the word: \n" + removeWord(sentence, word));
        }
    }
}
