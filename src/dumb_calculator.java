import java.util.Scanner;

public class dumb_calculator {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("What is your first number? > ");
		String firstNumber = keyboard.nextLine();
		double firstNumberClean = Double.parseDouble(firstNumber);

		System.out.print("What is your second number? > ");
		String secondNumber = keyboard.nextLine();
		double secondNumberClean = Double.parseDouble(secondNumber);

		System.out.print("What is your third number? > ");
		String thirdNumber = keyboard.nextLine();
		double thirdNumberClean = Double.parseDouble(thirdNumber);

		double totalClean = firstNumberClean + secondNumberClean + thirdNumberClean;
		System.out.printf("Result: (%.2f + %.2f + %.2f) / 2 = %.2f", firstNumberClean, secondNumberClean, thirdNumberClean, totalClean / 2.0);
	}
}
