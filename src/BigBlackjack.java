import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BigBlackjack {
    public static void main(String[] args) {
        System.out.printf("Welcome to BlackJack Night! Sponsored by @atropos148!%n%n");

        Hand playerHand = new Hand(2);
        Hand dealerHand = new Hand(2);

        System.out.printf("You get a %d and a %d.%n", playerHand.cards.get(0).value, playerHand.cards.get(1).value);
        System.out.printf("Your total is %d.%n%n", playerHand.currentTotal);
        System.out.printf("Dealer gets a %d and a hidden card.%n", dealerHand.cards.get(0).value);
        System.out.println("Dealer's total is also hidden.");
    }
}

class Card {
    int value;

    Card(int value) {
        this.value = value;
    }
}

class Hand {
    List<Card> cards = new ArrayList<>();
    Random rand = new Random();
    int currentTotal = 0;

    Hand(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            drawCard();
        }
        getTotal();
    }

    void drawCard() {
        this.cards.add(new Card(rand.nextInt(10) + 2));
        getTotal();
    }

    void getTotal() {
        int handTotal = 0;
        for (Card card : cards) {
            handTotal += card.value;
        }
        currentTotal = handTotal;
    }
}