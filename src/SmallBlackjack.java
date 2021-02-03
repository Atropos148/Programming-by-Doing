import java.util.Random;

public class SmallBlackjack {
    public static void main(String[] args) {
        System.out.println("Hello");
        Random rand = new Random();

        int[] playerHand = new int[2];
        for (int i = 0; i < 2; i++) {
            playerHand[i] = drawCard(rand) + 1;
        }
        System.out.printf("You drew %d an %d.%n", playerHand[0], playerHand[1]);

        int playerTotal = 0;
        for (int card : playerHand) {
            playerTotal += card;
        }
        System.out.printf("Your total is %d.%n%n", playerTotal);

        int[] dealerHand = new int[2];
        for (int i = 0; i < 2; i++) {
            dealerHand[i] = drawCard(rand) + 1;
        }
        System.out.printf("The dealer has %d and %d.%n", dealerHand[0], dealerHand[1]);

        int dealerTotal = 0;
        for (int card : dealerHand) {
            dealerTotal += card;
        }
        System.out.printf("Dealer's total is %d.%n%n", dealerTotal);

        if (playerTotal > dealerTotal) {
            System.out.println("You win!");
        } else {
            System.out.println("Dealer wins!");
        }

    }

    static int drawCard(Random rand) {
        return rand.nextInt(10);
    }
}
