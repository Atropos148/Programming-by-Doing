import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BigBlackjack {
    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("Welcome to Blackjack! Sponsored by @atropos148");
        List<Card> playerHand = dealOpeningHand(rand);
        List<Card> dealerHand = dealOpeningHand(rand);

        System.out.println("Player's hand:");
        showHand(playerHand, false);
        int playerHandTotal = countHandTotal(playerHand);

        System.out.println("Dealer's hand:");
        showHand(dealerHand, true);
        int dealerHandTotal = countHandTotal(dealerHand);

        Scanner scanner = new Scanner(System.in);
        String playerAction = "";
        while (playerAction.equals("stay") == false) {
            System.out.println("Would you like to \"hit\" or \"stay\"?");
            playerAction = scanner.nextLine();
            if (playerAction.equals("hit")) {
                Card drawnCard = drawCard(rand);
                playerHand.add(drawnCard);
                playerHandTotal = countHandTotal(playerHand);
                System.out.printf("You drew a %d.%nYour total is %d.%n", drawnCard.value, playerHandTotal);
            } else if (playerAction.equals("stay") == false) {
                System.out.println("You can only hit or stay.");
            }
        }
        scanner.close();

        System.out.println("Okay, it's dealer's turn now.");
        System.out.printf("Their hidden card was a %d.%nTheir total is %d.%n", dealerHand.get(1).value,
                dealerHandTotal);

        while (dealerHandTotal <= 16) {
            System.out.println("Dealer chooses to hit.");
            Card drawnCard = drawCard(rand);
            dealerHand.add(drawnCard);
            dealerHandTotal = countHandTotal(dealerHand);
            System.out.printf("Dealer drew a %d.%nTheir total is %d.%n", drawnCard.value, dealerHandTotal);
        }
        System.out.println("Dealer stays.");

        System.out.printf("Your total is: %d%nDealer's total is: %d%n", playerHandTotal, dealerHandTotal);

        if (playerHandTotal > dealerHandTotal) {
            System.out.println("You win!");
        } else {
            System.out.println("Dealer wins.");
        }
    }

    static List<Card> dealOpeningHand(Random rand) {
        List<Card> hand = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            hand.add(drawCard(rand));
        }

        return hand;
    }

    static Card drawCard(Random rand) {
        // picks a random int between 0 and 9, then adds 2 to get int between 2 and 11
        return new Card(rand.nextInt(10) + 2);
    }

    static void showHand(List<Card> hand, boolean dealerHand) {

        if (dealerHand) {
            System.out.printf("A %d and a hidden card.%n", hand.get(0).value);
            System.out.println("His total is hidden too.");
        } else {
            System.out.printf("A %d and a %d.%n", hand.get(0).value, hand.get(1).value);
            int currentHandTotal = countHandTotal(hand);
            System.out.printf("Your hand total is %d.%n", currentHandTotal);
        }
        System.out.println();
    }

    static int countHandTotal(List<Card> hand) {
        int handTotal = 0;
        for (Card card : hand) {
            handTotal += card.value;
        }
        return handTotal;
    }

    static class Card {
        int value;

        Card(int value) {
            this.value = value;
        }
    }
}
