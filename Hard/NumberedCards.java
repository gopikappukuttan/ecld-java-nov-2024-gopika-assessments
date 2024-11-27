import java.util.Arrays;
import java.util.Scanner;

public class NumberedCards {
    public static boolean winRound(int[] yourCards, int[] opponentCards) {
        // Sort both arrays in ascending order to easily find the two largest digits
        Arrays.sort(yourCards);
        Arrays.sort(opponentCards);

        // Form the largest two-digit number from your cards and opponent's cards
        int yourMax = yourCards[4] * 10 + yourCards[3]; // largest two digits
        int opponentMax = opponentCards[4] * 10 + opponentCards[3]; // largest two digits

        // Return true if your number is greater than opponent's number
        return yourMax > opponentMax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] yourCards = new int[5];
        int[] opponentCards = new int[5];

        // Get validated input for your cards
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter your 5 cards (separated by spaces, each between 0 and 9):");
            String input = scanner.nextLine();
            String[] inputArray = input.split("\\s+");

            // Check if the input contains exactly 5 cards
            if (inputArray.length == 5) {
                validInput = true;
                // Validate each card to ensure it's a number between 0 and 9
                for (int i = 0; i < 5; i++) {
                    try {
                        int card = Integer.parseInt(inputArray[i]);
                        if (card < 0 || card > 9) {
                            System.out.println("Each card must be between 0 and 9. Please try again.");
                            validInput = false;
                            break;
                        }
                        yourCards[i] = card;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter integers between 0 and 9.");
                        validInput = false;
                        break;
                    }
                }
            } else {
                System.out.println("You must enter exactly 5 cards. Please try again.");
            }
        }

        // Get validated input for opponent's cards
        validInput = false;
        while (!validInput) {
            System.out.println("Enter your opponent's 5 cards (separated by spaces, each between 0 and 9):");
            String input = scanner.nextLine();
            String[] inputArray = input.split("\\s+");

            // Check if the input contains exactly 5 cards
            if (inputArray.length == 5) {
                validInput = true;
                // Validate each card to ensure it's a number between 0 and 9
                for (int i = 0; i < 5; i++) {
                    try {
                        int card = Integer.parseInt(inputArray[i]);
                        if (card < 0 || card > 9) {
                            System.out.println("Each card must be between 0 and 9. Please try again.");
                            validInput = false;
                            break;
                        }
                        opponentCards[i] = card;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter integers between 0 and 9.");
                        validInput = false;
                        break;
                    }
                }
            } else {
                System.out.println("You must enter exactly 5 cards. Please try again.");
            }
        }

        // Check if your cards win and print the result
        if (winRound(yourCards, opponentCards)) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }

        scanner.close();
    }
}

