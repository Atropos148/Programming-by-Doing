public class BasicArrays1 {
    public static void main(String[] args) {
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = -113;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Slot %d contains a %d%n", i, numbers[i]);
        }
    }
}
