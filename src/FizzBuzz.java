public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println("Hello");
        for (int i = 1; i < 101; i++) {
            StringBuilder result = new StringBuilder();
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0) {
                    result.append("Fizz");
                }

                if (i % 5 == 0) {
                    result.append("Buzz");
                }
            } else {
                result.append(i);
            }
            System.out.printf("%s%n", result);
        }
    }
}
