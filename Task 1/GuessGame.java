
import java.util.Scanner;

public class GuessGame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int RandomNumber = ((int) (Math.random() * 100));
        int maxAttempts = 10;

        boolean playAgain = true;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        while (playAgain) {
            int attempts = 0;
            roundsPlayed++;

            System.out.println("Round " + roundsPlayed + ":");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == RandomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                } else if (userGuess < RandomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + RandomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }

        double averageAttemptsPerRound = (double) totalAttempts / roundsPlayed;
        System.out.println("Game over. Rounds played: " + roundsPlayed);
        System.out.println("Your average attempts per round: " + averageAttemptsPerRound);

        scanner.close();
    }
}