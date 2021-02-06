import java.util.Scanner;

public class KeychainStore1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("@atropos148 Keychain store!");

        int choice = 0;
        do {
            printMenu();
            choice = keyboard.nextInt();
            switch (choice) {
                case 1:
                    addKeychains();
                    break;
                case 2:
                    removeKeychains();
                    break;
                case 3:
                    viewOrder();
                    break;
                case 4:
                    checkout();
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

    static void addKeychains() {
        System.out.println("add_keychains");
    }

    static void removeKeychains() {
        System.out.println("remove_keychains");
    }

    static void viewOrder() {
        System.out.println("view_order");
    }

    static void checkout() {
        System.out.println("checkout");
    }
}
