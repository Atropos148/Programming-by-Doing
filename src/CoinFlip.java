import java.util.Scanner;
import java.util.Random;

public class CoinFlip {
    public static void main(String[] args) {
        String[] coinSides = { "Heads", "Tails" };
        Random flipper = new Random();
        Scanner keyboard = new Scanner(System.in);
        char answer;

        do {
            String result = coinSides[flipper.nextInt(coinSides.length)];
            System.out.printf("You flip a coin...the result is: %s%n", result);
            System.out.print("Do you want to flip again (y/n)? > ");
            answer = keyboard.nextLine().charAt(0);
            answer = Character.toLowerCase(answer);

        } while (answer == 'y');
        keyboard.close();

    }
}
