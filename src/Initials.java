import java.util.Scanner;
import java.util.HashMap;

public class Initials {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		HashMap<Character, String[]> bigLetters = setup_letters();

		System.out.print("What is your name? > ");
		String name = "";

		name += input.nextLine();
		input.close();

		String[] nameParts = name.split(" ");

		System.out.printf("For the name: %s\n", name);

		StringBuilder[] bigName = new StringBuilder[7];

		for (int i = 0; i < bigName.length; i++) {
			bigName[i] = new StringBuilder();
		}

		for (String namePart : nameParts) {
			Character firstLetter = namePart.toLowerCase().charAt(0);
			int rowIndex = 0;
			for (String row : bigLetters.get(firstLetter)) {
				bigName[rowIndex].append(row);
				bigName[rowIndex].append("  ");
				rowIndex++;
			}
		}

		for (StringBuilder row : bigName) {
			System.out.println(row);
		}

	}

	static HashMap<Character, String[]> setup_letters() {
		HashMap<Character, String[]> bigLetters = new HashMap<>();
		bigLetters.put('a', new String[]{"  A  ", " A A ", "A   A", "AAAAA", "A   A", "A   A", "A   A"});
		bigLetters.put('b', new String[]{"BBBB ", "B   B", "B   B", "BBBB ", "B   B", "B   B", "BBBB "});
		bigLetters.put('c', new String[]{" CCC ", "C   C", "C    ", "C    ", "C    ", "C   C", " CCC "});
		bigLetters.put('d', new String[]{"DDDD ", "D   D", "D   D", "D   D", "D   D", "D   D", "DDDD "});
		bigLetters.put('e', new String[]{"EEEEE", "E    ", "E    ", "EEE  ", "E    ", "E    ", "EEEEE"});
		bigLetters.put('f', new String[]{"FFFFF", "F    ", "F    ", "FFF  ", "F    ", "F    ", "F    "});
		bigLetters.put('g', new String[]{" GGG ", "G   G", "G    ", "GGGGG", "G   G", "G   G", " GGG "});
		bigLetters.put('h', new String[]{"H   H", "H   H", "H   H", "HHHHH", "H   H", "H   H", "H   H"});
		bigLetters.put('i', new String[]{"IIIII", "  I  ", "  I  ", "  I  ", "  I  ", "  I  ", "IIIII"});
		bigLetters.put('j', new String[]{"JJJJJ", "  J  ", "  J  ", "  J  ", "J J  ", "J J  ", " JJ  "});
		bigLetters.put('k', new String[]{"K   K", "K  K ", "K K  ", "KK   ", "K K  ", "K  K ", "K   K"});
		bigLetters.put('l', new String[]{"L    ", "L    ", "L    ", "L    ", "L    ", "L    ", "LLLLL"});
		bigLetters.put('m', new String[]{"M   M", "MM MM", "MM MM", "M M M", "M   M", "M   M", "M   M"});
		bigLetters.put('n', new String[]{"N   N", "NN  N", "N N N", "N  NN", "N   N", "N   N", "N   N"});
		bigLetters.put('o', new String[]{" OOO ", "O   O", "O   O", "O   O", "O   O", "O   O", " OOO "});
		bigLetters.put('p', new String[]{"PPPP ", "P   P", "P   P", "PPPP ", "P    ", "P    ", "P    "});
		bigLetters.put('q', new String[]{" QQQ ", "Q   Q", "Q   Q", "Q   Q", "Q   Q", "Q  Q ", " QQ Q"});
		bigLetters.put('r', new String[]{"RRRR ", "R   R", "R   R", "RRRR ", "R R  ", "R  R ", "R   R"});
		bigLetters.put('s', new String[]{" SSS ", "S   S", "S    ", " SSS ", "    S", "S   S", " SSS "});
		bigLetters.put('t', new String[]{"TTTTT", "  T  ", "  T  ", "  T  ", "  T  ", "  T  ", "  T  "});
		bigLetters.put('u', new String[]{"U   U", "U   U", "U   U", "U   U", "U   U", "U   U", " UUU "});
		bigLetters.put('v', new String[]{"V   V", "V   V", "V   V", "V   V", "V   V", " V V ", "  V  "});
		bigLetters.put('w', new String[]{"W   W", "W   W", "W   W", "W W W", "WW WW", "WW WW", "W   W"});
		bigLetters.put('x', new String[]{"X   X", "X   X", " X X ", "  X  ", " X X ", "X   X", "X   X"});
		bigLetters.put('y', new String[]{"Y   Y", " Y Y ", "  Y  ", "  Y  ", "  Y  ", "  Y  ", "  Y  "});
		bigLetters.put('z', new String[]{"ZZZZZ", "    Z", "   Z ", "  Z  ", " Z   ", "Z    ", "ZZZZZ"});

		return bigLetters;
	}
}

