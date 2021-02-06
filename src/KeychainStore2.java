import java.util.InputMismatchException;
import java.util.Scanner;

public class KeychainStore2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int keychainsAmount = 0;
        double keychainsPrice = 10.00;
        double salesTax = 0.0825;
        double shippingPerOrder = 5.00;
        double shippingPerKeychain = 1.00;

        System.out.println("@atropos148 Keychain store!");

        int choice = 0;
        do {
            printMenu();
            try {
                choice = keyboard.nextInt();
            } catch (InputMismatchException e) {
                keyboard.next();
                System.out.println("Only use numbers to select menu options");
            }

            switch (choice) {
                case 1:
                    keychainsAmount = addKeychains(keychainsAmount, keyboard);
                    break;
                case 2:
                    keychainsAmount = removeKeychains(keychainsAmount, keyboard);
                    break;
                case 3:
                    viewOrder(keychainsAmount, keychainsPrice, shippingPerKeychain, shippingPerOrder, salesTax);
                    break;
                case 4:
                    checkout(keychainsAmount, keychainsPrice, shippingPerKeychain, shippingPerOrder, salesTax,
                            keyboard);
                    break;
                default:
                    System.out.printf("Choose one of the options%n%n");
            }
        } while (choice != 4);
        keyboard.close();

    }

    static void printMenu() {
        System.out.println("1. Add keychains to order");
        System.out.println("2. Remove keychains from order");
        System.out.println("3. View current order");
        System.out.println("4. Checkout");
        System.out.printf("%nPlease enter you choice > ");
    }

    static int addKeychains(int totalKeychains, Scanner keyboard) {
        System.out.printf("You have %d keychains. How many do you want to add? > ", totalKeychains);
        int keychainsToAdd = keyboard.nextInt();
        return totalKeychains + keychainsToAdd;
    }

    static int removeKeychains(int totalKeychains, Scanner keyboard) {
        System.out.printf("You have %d keychains. How many do you want to remove? > ", totalKeychains);
        int keychainsToRemove = keyboard.nextInt();
        if (keychainsToRemove > totalKeychains) {
            return 0;
        } else {
            return totalKeychains - keychainsToRemove;
        }

    }

    static void viewOrder(int totalKeychains, double pricePer, double shippingPer, double baseShippingCost,
            double salesTax) {
        System.out.printf("%nYou have %d keychains.%nKeychains cost $10 each.%n", totalKeychains);

        double totalShipping = (totalKeychains * shippingPer) + baseShippingCost;
        double subtotal = (totalKeychains * pricePer) + totalShipping;
        double tax = subtotal * salesTax;
        double totalCost = subtotal + tax;
        System.out.printf(
                "Total shipping charges: $%.2f%nSubtotal before tax: $%.2f%nTax: $%.2f%nTotal cost: $%.2f%n%n",
                totalShipping, subtotal, tax, totalCost);
    }

    static void checkout(int totalKeychains, double pricePer, double shippingPer, double baseShippingCost,
            double salesTax, Scanner keyboard) {
        System.out.print("What is your name? > ");
        String customerName = keyboard.next();
        viewOrder(totalKeychains, pricePer, shippingPer, baseShippingCost, salesTax);
        System.out.printf("Thanks for your order, %s", customerName);
    }
}
