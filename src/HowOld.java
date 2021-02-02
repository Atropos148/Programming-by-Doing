import java.util.Scanner;

public class HowOld {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Hey, what's your name? > ");
		String name = keyboard.nextLine();
		System.out.printf("Ok, %s, how old are you? > ", name);
		int age = keyboard.nextInt();
		System.out.println();
		if (age < 16) {
			System.out.printf("You can't drive, %s.", name);
		}
		else if (age <= 17) {
			System.out.printf("You can drive but not vote, %s.", name);
		}
		else if (age <= 24) {
			System.out.printf("You can vote but not rent a car, %s.", name);
		}
		else {
			System.out.printf("You can do pretty much anything, %s.", name);
		}
	}
}
