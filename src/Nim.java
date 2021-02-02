import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Nim {
    // Code for Nim assignment found here: http://programmingbydoing.com/a/nim.html
    // Main code with these bonuses:
    // Bonus #1 - Cheat Protection
    // Bonus #2 - Dignity
    // Bonus #3 - Fancy Display (Rows)

    public static void main(String[] args) {
        System.out.println("Hello Nim!");
        System.out.println("Nim is a 2 player game.");

        Scanner keyboard = new Scanner(System.in);
        HashMap<Character, Integer> piles = new HashMap<>();
        piles.put('A', 3);
        piles.put('B', 4);
        piles.put('C', 5);

        int totalCoins = piles.get('A') + piles.get('B') + piles.get('C');

        String[] playerNames = getPlayerNames(keyboard);
        String currentPlayer = playerNames[0];
        String namePlayer1 = currentPlayer;
        String otherPlayer = playerNames[1];
        String namePlayer2 = otherPlayer;

        while (piles.get('A') > 0 || piles.get('B') > 0 || piles.get('C') > 0) {
            showPiles(piles);

            char chosenPile;
            do {
                do {
                    System.out.printf("%s, choose a pile > ", currentPlayer);
                    chosenPile = Character.toUpperCase(keyboard.next().charAt(0));
                    if (chosenPile != 'A' && chosenPile != 'B' && chosenPile != 'C') {
                        System.out.printf("%s, you can only choose from piles A, B and C.%n", currentPlayer);
                    }
                } while (chosenPile != 'A' && chosenPile != 'B' && chosenPile != 'C');

                if (piles.get(chosenPile) <= 0) {
                    System.out.printf("Nice try, %s. That pile is empty.%n", currentPlayer);
                }
            } while (piles.get(chosenPile) <= 0);

            int coinsToRemove;

            int newValue;
            do {
                System.out.printf("How many coins to remove from pile %s > ", chosenPile);
                coinsToRemove = keyboard.nextInt();
                newValue = piles.get(chosenPile) - coinsToRemove;
                if (coinsToRemove <= 0) {
                    System.out.printf("%s, you must remove at least 1 coin.%n", currentPlayer);
                } else if (newValue < 0) {
                    System.out.printf("%s, pile %s doesn't have that many coins.%n", currentPlayer, chosenPile);
                }
            } while (coinsToRemove <= 0 || newValue < 0);

            piles.put(chosenPile, newValue);

            totalCoins -= coinsToRemove;
            if (totalCoins == 1 || totalCoins == 0) {
                if (totalCoins == 1) {
                    showPiles(piles);
                    System.out.printf("%s, you must take the last coin, so you lose. %s wins!", otherPlayer,
                            currentPlayer);
                } else {
                    showPiles(piles);
                    System.out.printf("%s, there are no coins left so you win!", otherPlayer);
                }
                break;
            }

            if (currentPlayer.equals(namePlayer1)) {
                currentPlayer = namePlayer2;
                otherPlayer = namePlayer1;
            } else {
                currentPlayer = namePlayer1;
                otherPlayer = namePlayer2;
            }
        }
        keyboard.close();
    }

    static void showPiles(HashMap<Character, Integer> piles) {
        for (Map.Entry<Character, Integer> pile : piles.entrySet()) {
            int pileAmount = pile.getValue();
            StringBuilder visualAmount = new StringBuilder();
            for (int i = 0; i < pileAmount; i++) {
                visualAmount.append("*");
            }
            System.out.printf("%s (%d): %s %n", pile.getKey(), pile.getValue(), visualAmount);
        }
    }

    static String[] getPlayerNames(Scanner keyboard) {
        System.out.print("Player 1, enter your name > ");
        String namePlayer1 = keyboard.nextLine();
        System.out.print("Player 2, enter your name > ");
        String namePlayer2 = keyboard.nextLine();
        String[] playerNames = { namePlayer1, namePlayer2 };
        return playerNames;
    }
}
