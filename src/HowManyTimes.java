import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HowManyTimes {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(49) + 1;
        }

        System.out.print("Array: ");
        for (int number : numbers) {
            System.out.printf("%d ", number);
        }

        System.out.printf("%nWhat number should i find? (1-50) > ");
        int numberToFind = scanner.nextInt();
        scanner.close();

        int foundNumberTotal = 0;
        ArrayList<Integer> foundNumbersPositions = new ArrayList<>();

        int index = 0;
        for (int number : numbers) {
            if (number == numberToFind) {
                foundNumberTotal++;
                foundNumbersPositions.add(index);
            }
            index++;
        }

        if (foundNumberTotal > 0) {
            System.out.printf("%d was found %d times.%n", numberToFind, foundNumberTotal);
            if (foundNumberTotal > 1) {
                System.out.printf("%d was found in these positions: ", numberToFind);
            } else {
                System.out.printf("%d was found in this position: ", numberToFind);
            }

            for (int position : foundNumbersPositions) {
                System.out.printf("%d, ", position + 1);
            }
        } else {
            System.out.printf("I didn't find %d", numberToFind);
        }
    }
}
