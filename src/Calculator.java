import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Calculator");

        double firstNumber = 1.0;

        while (firstNumber != 0.0) {
            System.out.print("What do you want to calculate? > ");
            String expression = keyboard.nextLine();

            String[] operations = { "+", "-", "*", "/", "^", "%", "!" };
            int operationIndex = 0;

            for (String operation : operations) {
                if (expression.contains(operation)) {
                    operationIndex = expression.indexOf(operation);
                }
            }

            String leftSide = expression.substring(0, operationIndex).trim();
            String rightSide = "";
            try {
                rightSide = expression.substring(operationIndex + 1).trim();
                char operation = expression.charAt(operationIndex);
                if (leftSide.length() == 1) {
                    firstNumber = Double.parseDouble(leftSide);

                    if (firstNumber == 0) {
                        System.out.println("Goodbye.");
                        keyboard.close();
                        System.exit(0);
                    }
                }

                Expression result = new Expression(leftSide, rightSide, operation);
                System.out.println(result.giveResult());
            } catch (NumberFormatException e) {
                firstNumber = Double.parseDouble(leftSide);
                double result = factorial(firstNumber);
                System.out.println(result);
            }
        }
        keyboard.close();
    }

    static double factorial(double number) {
        double multiply_by = number - Double.valueOf(1);
        double result = number;

        for (int i = 0; i < number - Double.valueOf(1); i++) {
            result = result * multiply_by;
            multiply_by = multiply_by - Double.valueOf(1);
        }
        return result;
    }
}

class Expression {
    String leftSide;
    String rightSide;
    char operation;

    Expression(String leftSide, String rightSide, char operation) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.operation = operation;
    }

    double giveResult() {
        double left = Double.parseDouble(leftSide);
        double right = Double.parseDouble(rightSide);

        switch (operation) {
            case '+': {
                return left + right;
            }
            case '-': {
                return left - right;
            }
            case '*': {
                return left * right;
            }
            case '/': {
                return left / right;
            }
            case '^': {
                return exponent(left, right);
            }
            case '%': {
                return left % right;
            }
            default: {
                return left + right;
            }
        }
    }

    double exponent(double left, double right) {
        double result = left;
        for (int i = 0; i < right - 1; i++) {
            result = result * left;
        }
        return result;
    }
}
