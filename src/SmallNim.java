import java.util.HashMap;
import java.util.Scanner;

public class SmallNim {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        HashMap<Character, Integer> piles = new HashMap<>();
        piles.put('A', 3);
        piles.put('B', 3);
        piles.put('C', 3);

        while (piles.get('A') > 0 || piles.get('B') > 0 || piles.get('C') > 0) {
            System.out.printf("%s: %d %s: %d %s: %d %n", 'A', piles.get('A'), 'B', piles.get('B'), 'C', piles.get('C'));
            System.out.print("Choose a pile > ");
            char chosenPile = Character.toUpperCase(keyboard.next().charAt(0));
            System.out.printf("How many coins to remove from pile %s > ", chosenPile);
            int coinsToRemove = keyboard.nextInt();
            int newValue = piles.get(chosenPile) - coinsToRemove;
            piles.put(chosenPile, newValue);
        }
        keyboard.close();
        System.out.printf("%s: %d %s: %d %s: %d %n", 'A', piles.get('A'), 'B', piles.get('B'), 'C', piles.get('C'));
        System.out.println("All piles are empty! Good job!");
    }
}
