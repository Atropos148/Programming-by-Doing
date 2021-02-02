import java.util.HashMap;
import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        System.out.println("Hello Nim!");
        System.out.println("Nim is a 2 player game.");

        Scanner keyboard = new Scanner(System.in);
        HashMap<Character, Integer> piles = new HashMap<>();
        piles.put('A', 3);
        piles.put('B', 4);
        piles.put('C', 5);

        System.out.print("Player 1, enter your name > ");
        String namePlayer1 = keyboard.nextLine();
        System.out.print("Player 2, enter your name > ");
        String namePlayer2 = keyboard.nextLine();

        String currentPlayer = namePlayer1;

        while (piles.get('A') > 0 || piles.get('B') > 0 || piles.get('C') > 0) {
            System.out.printf("%s: %d %s: %d %s: %d %n", 'A', piles.get('A'), 'B', piles.get('B'), 'C', piles.get('C'));

            System.out.printf("%s, choose a pile > ", currentPlayer);
            char chosenPile = Character.toUpperCase(keyboard.next().charAt(0));

            System.out.printf("How many coins to remove from pile %s > ", chosenPile);
            int coinsToRemove = keyboard.nextInt();
            int newValue = piles.get(chosenPile) - coinsToRemove;

            piles.put(chosenPile, newValue);

            if (currentPlayer.equals(namePlayer1)) {
                currentPlayer = namePlayer2;
            } else {
                currentPlayer = namePlayer1;
            }
        }
        keyboard.close();

        System.out.printf("%s, there are no coins left so you win!", currentPlayer);
    }
}
