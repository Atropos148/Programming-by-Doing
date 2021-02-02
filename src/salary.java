import java.util.Scanner;

public class salary {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("What is your name? > ");
		String name = keyboard.nextLine();
		System.out.printf("Hello, %s!\n", name);

		System.out.print("How old are you? > ");
		try{
			int age = Integer.parseInt(keyboard.nextLine());
			System.out.printf("So you are %d years old?\n", age);
		} catch (NumberFormatException e) {
			// e.printStackTrace();
			System.out.println("So you are ERROR years old?");
		}


		System.out.print("How much money do you make? > ");
		try {
			double salary = Double.parseDouble(keyboard.nextLine());
			System.out.printf("%.2f! You deserve that, but per hour!\n", salary);
		} catch (NumberFormatException e) {
			System.out.println("So you make ERROR dollars a day?!?");
		}
	}
}
