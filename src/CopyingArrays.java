import java.util.Random;

public class CopyingArrays {
    public static void main(String[] args) {
        int[] numbersFirst = new int[10];
        Random r = new Random();

        for (int i = 0; i < numbersFirst.length; i++) {
            numbersFirst[i] = r.nextInt(99) + 1;
        }

        int[] numbersSecond = new int[numbersFirst.length];

        System.arraycopy(numbersFirst, 0, numbersSecond, 0, numbersFirst.length);

        numbersFirst[numbersFirst.length - 1] = -7;

        System.out.print("Array 1: ");
        for (int i = 0; i < numbersFirst.length; i++) {
            System.out.printf("%d  ", numbersFirst[i]);
        }

        System.out.printf("%nArray 2: ");

        for (int i = 0; i < numbersSecond.length; i++) {
            System.out.printf("%d  ", numbersSecond[i]);
        }
    }
}
