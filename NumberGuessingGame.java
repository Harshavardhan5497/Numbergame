import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRounds = 3;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            for (int round = 1; round <= maxRounds; round++) {
                int generatedNumber = random.nextInt(100) + 1; 
                int maxAttempts = 5;
                boolean correctGuess = false;
                
                System.out.println("\nRound " + round + " of " + maxRounds);
                System.out.println("You have " + maxAttempts + " attempts to guess the number.");

                for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                    System.out.print("Attempt " + attempt + ": Enter your guess (1-100): ");
                    int userGuess = scanner.nextInt();

                    if (userGuess == generatedNumber) {
                        System.out.println("Congratulations! You guessed the correct number.");
                        score += (maxAttempts - attempt + 1); 
                        correctGuess = true;
                        break;
                    } else if (userGuess > generatedNumber) {
                        System.out.println("Your guess is too high.");
                    } else {
                        System.out.println("Your guess is too low.");
                    }
                }

                if (!correctGuess) {
                    System.out.println("Sorry! You've used all attempts. The correct number was: " + generatedNumber);
                }
            }

            System.out.println("\nYour total score after " + maxRounds + " rounds is: " + score);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");

            if (playAgain) {
                score = 0;
            }
        }

        System.out.println("Thank you for playing! Goodbye.");
        scanner.close();
    }
}
