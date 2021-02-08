public class IndividualDigits {
    public static void main(String[] args) {
        for (int i = 10; i < 100; i++) {
            int[] digits = new int[2];

            for (int j = 0; j < String.valueOf(i).length(); j++) {
                int digit = Character.getNumericValue(String.valueOf(i).charAt(j));
                digits[j] = digit;
            }

            int result = digits[0] + digits[1];
            System.out.printf("%d, %d + %d = %d", i, digits[0], digits[1], result);

            System.out.println();
        }
    }
}
