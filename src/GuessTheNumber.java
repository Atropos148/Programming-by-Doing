import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        int totalGuessTurns = 7;
        int currentGuessTurn = 0;
        int secretNumber = new Random().nextInt(100) + 1;
        int guessedNumber = 0;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("I'm thinking about a number between 1 and 100. You have 7 guesses to find the number.");

        do {
            if (currentGuessTurn == 0) {
                System.out.print("First guess > ");
            } else {
                System.out.printf("Guess #%d > ", currentGuessTurn + 1);
            }
            guessedNumber = keyboard.nextInt();

            if (guessedNumber < secretNumber) {
                System.out.println("Sorry, that guess is too low.");
            } else if (guessedNumber > secretNumber) {
                System.out.println("Sorry, that guess is too high.");
            } else {
                break;
            }
            currentGuessTurn++;
        } while (currentGuessTurn < totalGuessTurns);

        keyboard.close();

        if (currentGuessTurn == totalGuessTurns) {
            System.out.println("Sorry, you didn't guess it in 7 tries. You lose.");
        } else {
            System.out.println("You guessed it!  What are the odds?!?");
        }
    }
}
