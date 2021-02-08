import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Calculator");

        double firstNumber = 1.0;

        while (firstNumber != 0.0) {
            System.out.print("What do you want to calculate? > ");
            String expression = keyboard.nextLine();

            String[] operations = { "+", "-", "*", "/" };
            int operationIndex = 0;

            for (String operation : operations) {
                if (expression.contains(operation)) {
                    operationIndex = expression.indexOf(operation);
                }
            }

            String leftSide = expression.substring(0, operationIndex).trim();
            String rightSide = expression.substring(operationIndex + 1).trim();
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
        }
        keyboard.close();
    }

    static double addition(double x, double y) {
        return x + y;
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
            default: {
                return left + right;
            }
        }
    }
}
