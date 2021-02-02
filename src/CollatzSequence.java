import java.util.Scanner;

public class CollatzSequence {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Pick the first number > ");
        int currentNumber = keyboard.nextInt();
        keyboard.close();

        int steps = 0;
        int largestNumber = currentNumber;
        int currentColumn = 0;
        int totalColumns = 6;

        System.out.printf("%d\t", currentNumber);

        while (currentNumber != 1) {
            if ((currentNumber % 2) == 0) {
                currentNumber /= 2;
            } else {
                currentNumber *= 3;
                currentNumber++;
            }
            if (currentNumber > largestNumber) {
                largestNumber = currentNumber;
            }
            System.out.printf("%d\t", currentNumber);
            steps++;
        }
        System.out.printf("%nNumber 1 found in %d steps. Largest number in sequence is %d.", steps, largestNumber);
    }
}
