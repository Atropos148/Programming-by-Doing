import java.util.Scanner;

public class NumberPuzzles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1) Find two digit numbers <= 56 with sums of digits > 10");
            System.out.println("2) Find two digit number minus number reversed which equals sum of digits");
            System.out.println("3) Quit");

            choice = scanner.nextInt();
            System.out.println();

            if (choice == 1) {
                digitTotals();
            } else if (choice == 2) {
                sumOfDigitsEqualsReverse();
            }
        } while (choice != 3);

        scanner.close();
    }

    static void digitTotals() {
        for (int i = 10; i <= 56; i++) {
            int digitTotal = 0;
            for (int j = 0; j < String.valueOf(i).length(); j++) {
                int digit = Character.getNumericValue(String.valueOf(i).charAt(j));
                digitTotal += digit;
            }
            if (digitTotal > 10) {
                System.out.printf("%d, ", i);
            }
        }
        System.out.printf("%n%n");
    }

    static int singleNumberDigitTotal(int number) {
        int digitTotal = 0;
        for (int j = 0; j < String.valueOf(number).length(); j++) {
            int digit = Character.getNumericValue(String.valueOf(number).charAt(j));
            digitTotal += digit;
        }
        return digitTotal;
    }

    static void sumOfDigitsEqualsReverse() {
        for (int i = 10; i < 100; i++) {
            int digitTotal = singleNumberDigitTotal(i);
            StringBuilder reversedNumberStringBuilder = new StringBuilder();
            reversedNumberStringBuilder.append(i).reverse();
            String reversedNumberString = reversedNumberStringBuilder.toString();
            int reversedNumber = Integer.parseInt(reversedNumberString);
            int minusResult = i - reversedNumber;
            if (digitTotal == minusResult) {
                System.out.printf("Number: %d, Reversed: %d, N minus R: %d, Number digits added together: %d%n", i,
                        reversedNumber, minusResult, digitTotal);
            }
        }
        System.out.printf("%n");
    }
}
