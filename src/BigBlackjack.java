import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BigBlackjack {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.printf("Welcome to BlackJack Night! Sponsored by @atropos148!%n%n");

        Hand playerHand = new Hand(2);
        playerHand.player = true;
        Hand dealerHand = new Hand(2);

        System.out.printf("You get a %d and a %d.%n", playerHand.cards.get(0).value, playerHand.cards.get(1).value);
        System.out.printf("Your total is %d.%n%n", playerHand.currentTotal);
        System.out.printf("Dealer gets a %d and a hidden card.%n", dealerHand.cards.get(0).value);
        System.out.println("Dealer's total is also hidden.");

        checkImmediateWin(playerHand, dealerHand);

        // TODO playerLoop
        String action;
        do {
            System.out.print("Would you like to hit or stay? > ");
            action = keyboard.nextLine();
            if (action.equals("hit")) {
                takeTurn(action, playerHand);
                checkImmediateWin(playerHand, dealerHand);
            }
        } while (!action.equals("stay"));

        if (action.equals("stay")) {
            System.out.printf("Okay, it's dealer's turn now.%n%n");
            System.out.printf("His hidden card was a %d.%nHis total is %d.%n%n",
                    dealerHand.cards.get(dealerHand.cards.size() - 1).value, dealerHand.currentTotal);
            keyboard.nextLine();

            do {
                System.out.println("Dealer chooses to hit.");
                takeTurn("hit", dealerHand);
                keyboard.nextLine();
                checkImmediateWin(playerHand, dealerHand);
            } while (dealerHand.currentTotal <= 16);

            System.out.printf("Dealer chooses to stay.%n%n");
            System.out.printf("Your total is %d.%nDealer's total is %d.%n", playerHand.currentTotal,
                    dealerHand.currentTotal);

            if (playerHand.currentTotal > dealerHand.currentTotal) {
                System.out.println("You win!");
            } else {
                System.out.println("Dealer wins.");
            }
            keyboard.close();
        }
    }

    static void handeImmediateWin(Hand checkedHand) {
        if (checkedHand.player) {
            System.out.println("You win!");
            System.exit(0);
        } else {
            System.out.println("Dealer wins!");
            System.exit(0);
        }
    }

    static void checkImmediateWin(Hand playerHand, Hand dealerHand) {
        if (playerHand.currentTotal == 21) {
            handeImmediateWin(playerHand);
        } else if (playerHand.currentTotal > 21) {
            handeImmediateWin(dealerHand);
        }

        if (dealerHand.currentTotal == 21) {
            handeImmediateWin(dealerHand);
        } else if (dealerHand.currentTotal > 21) {
            handeImmediateWin(playerHand);
        }
    }

    static void takeTurn(String action, Hand actionHand) {
        if (action.equals("hit")) {
            actionHand.drawCard();
            if (actionHand.player) {
                System.out.printf("You drew a %d.%nYour total is %d.%n",
                        actionHand.cards.get(actionHand.cards.size() - 1).value, actionHand.currentTotal);
            } else {
                System.out.printf("Dealer drew a %d.%nDealer's total is %d.%n",
                        actionHand.cards.get(actionHand.cards.size() - 1).value, actionHand.currentTotal);
            }

        }
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
    boolean player = false;

    Hand(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            drawCard();
        }
        setTotal();
    }

    void drawCard() {
        this.cards.add(new Card(rand.nextInt(10) + 2));
        setTotal();
    }

    void setTotal() {
        int handTotal = 0;
        for (Card card : cards) {
            handTotal += card.value;
        }
        currentTotal = handTotal;
    }
}