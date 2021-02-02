import java.util.Random;
import java.util.Scanner;

public class DiceRoller {
	public static void main(String[] args) {
		Random dice = new Random();
		Scanner keyboard = new Scanner(System.in);

		System.out.println("* Dice Roller *");

		System.out.print("What dice do you want to roll? Example: \"2 d10\" > ");
		String diceToRoll = keyboard.nextLine();
		keyboard.close();

		int numberOfDice = 0;
		int diceType = 0;

		String[] diceToRollParts = diceToRoll.split(" ");
		if (diceToRollParts.length == 2) {
			if (diceToRollParts[1].length() > 1) {
				numberOfDice = Integer.parseInt(diceToRollParts[0]);
				diceType = Integer.parseInt(diceToRollParts[1].split("d")[1]);
			} else {
				System.out.println("Only use dice format as d(number), for example: d6, d12, d100");
			}
		}

		System.out.printf("Rolling %d d%d: %n", numberOfDice, diceType);

		int totalRoll = 0;

		for (int i = 0; i < numberOfDice; i++) {
			long diceRoll = dice.nextInt(diceType) + 1;
			// System.out.printf("%d, ", diceRoll);
			totalRoll += diceRoll;
		}
		System.out.printf("%nRoll total is: %d", totalRoll);
	}
}
