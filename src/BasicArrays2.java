import java.util.Random;

public class BasicArrays2 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random r = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(100);
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Slot %d contains a %d%n", i, numbers[i]);
        }
    }
}
