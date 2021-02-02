import javax.swing.*;

public class FirstGUI {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("What is your name?");

		String input = JOptionPane.showInputDialog("How old are you?");
		int age = Integer.parseInt(input);

		System.out.printf("Hello, Agent %s.\n", name);
		System.out.printf("Next year, you will be %d.", age+1);
	}
}
