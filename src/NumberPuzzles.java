import java.util.Scanner;

public class NumberPuzzles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1) Find two digit numbers <= 56 with sums of digits > 10");
            System.out.println("2) Find two digit number minus number reversed which equals sum of digits");
            System.out.println("3) Find Armstrong numbers");
            System.out.println("4) Find 4 numbers");
            System.out.println("9) Quit");

            System.out.print("Choose > ");
            choice = scanner.nextInt();
            System.out.println();

            if (choice == 1) {
                digitTotals();
            } else if (choice == 2) {
                sumOfDigitsEqualsReverse();
            } else if (choice == 3) {
                armstrongNumbers();
            } else if (choice == 4) {
                findFourNumbers();
            }
        } while (choice != 9);

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

    static void armstrongNumbers() {
        for (int i = 100; i < 1000; i++) {
            int exponentTotal = 0;

            for (int j = 0; j < String.valueOf(i).length(); j++) {
                int digit = Character.getNumericValue(String.valueOf(i).charAt(j));
                exponentTotal += exponent(digit, 3);
            }

            if (exponentTotal == i) {
                System.out.printf("%d, ", i);
            }
        }

        System.out.printf("%n%n");
    }

    static void findFourNumbers() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                int numbersTotal = 0;

                int firstNumber = i - 2;
                int secondNumber = i + 2;
                int thirdNumber = i / 2;
                int fourthNumber = i * 2;

                int[] numbers = { firstNumber, secondNumber, thirdNumber, fourthNumber };

                for (int number : numbers) {
                    numbersTotal += number;
                }

                if (numbersTotal == 45) {
                    System.out.printf("%d + %d + %d + %d = 45%n", firstNumber, secondNumber, thirdNumber, fourthNumber);
                    System.out.printf("%d + 2 = %d - 2 = %d * 2 = %d / 2", firstNumber, secondNumber, thirdNumber,
                            fourthNumber);
                }
            }
        }
        System.out.printf("%n%n");
    }

    static int exponent(int left, int right) {
        int result = left;
        for (int i = 0; i < right - 1; i++) {
            result = result * left;
        }
        return result;
    }

    static int singleNumberDigitTotal(int number) {
        int digitTotal = 0;
        for (int j = 0; j < String.valueOf(number).length(); j++) {
            int digit = Character.getNumericValue(String.valueOf(number).charAt(j));
            digitTotal += digit;
        }
        return digitTotal;
    }
}
