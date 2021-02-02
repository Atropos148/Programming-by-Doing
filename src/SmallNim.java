import java.util.HashMap;
import java.util.Scanner;

public class SmallNim {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        HashMap<Character, Integer> piles = new HashMap<>();
        piles.put('A', 3);
        piles.put('B', 3);
        piles.put('C', 3);

        System.out.printf("%s: %d %s: %d %s: %d", 'A', piles.get('A'), 'B', piles.get('B'), 'C', piles.get('C'));
    }
}
