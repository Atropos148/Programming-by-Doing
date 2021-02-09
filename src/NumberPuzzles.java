public class NumberPuzzles {
    public static void main(String[] args) {
        digitTotals();
    }

    static void digitTotals() {
        for (int i = 10; i <= 56; i++) {
            int digitTotal = 0;
            for (int j = 0; j < String.valueOf(i).length(); j++) {
                int digit = Character.getNumericValue(String.valueOf(i).charAt(j));
                digitTotal += digit;
            }
            if (digitTotal > 10) {
                System.out.println(i);
            }
        }
    }
}
