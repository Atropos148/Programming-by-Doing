import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BigBlackjack {
    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("Welcome to Blackjack! Sponsored by @atropos148");
        List<Card> playerHand = dealOpeningHand(rand);
        List<Card> dealerHand = dealOpeningHand(rand);

        System.out.println("Player's hand:");
        showHand(playerHand, false);

        System.out.println("Dealer's hand:");
        showHand(dealerHand, true);
    }

    static List<Card> dealOpeningHand(Random rand) {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            hand.add(drawCard(rand));
        }
        return hand;
    }

    static Card drawCard(Random rand) {
        return new Card(rand.nextInt(10) + 2);
    }

    static void showHand(List<Card> hand, boolean dealerHand) {
        if (dealerHand) {
            System.out.printf("A %d and a hidden card.", hand.get(0).value);
        } else {
            System.out.printf("A %d and a %d", hand.get(0).value, hand.get(1).value);
        }
        System.out.println();
    }

    static class Card {
        int value;

        Card(int value) {
            this.value = value;
        }
    }
}
