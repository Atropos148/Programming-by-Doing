import java.util.Random;

public class BasicArrays3 {
    public static void main(String[] args) {
        int[] numbers = new int[1000];
        Random r = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(89) + 10;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d  ", numbers[i]);
        }
    }
}
