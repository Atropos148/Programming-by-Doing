import java.util.Scanner;

public class BankPin {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int correctPin = 12345;

        System.out.println("Welcome to Sarif Bank.");
        System.out.print("What is your PIN? > ");

        int guessedPin = keyboard.nextInt();
        while (guessedPin != correctPin) {
            System.out.println("Incorrect PIN. Try Again.");
            System.out.print("What is your PIN? > ");
            guessedPin = keyboard.nextInt();
        }

        keyboard.close();
        System.out.println("PIN accepted. Welcome, Mr. Jensen.");
    }
}
