public class Letter {
	public static void main(String[] args) {
		int letterWidth = 50;
		int letterHeight = 9;

		print_border(letterWidth);
		print_stamp_rows(letterWidth);
		print_empty_row(letterWidth);
		print_address_rows(letterWidth);
		print_empty_row(letterWidth);
		print_border(letterWidth);
	}

	static void print_border(int letterWidth) {
		System.out.print('+');
		for(int i = 0; i < letterWidth; i++) {
			System.out.print('-');
		}
		System.out.println('+');
	}

	static void print_stamp_rows(int letterWidth) {
		int stampHeight = 3;
		int stampWidth = 4;
		for (int row = 0; row < stampHeight; row++) {
			System.out.print('|');
			for (int column = 1; column < (letterWidth - (stampWidth - 1)); column++) {
				System.out.print(' ');
			}
			for (int stampColumn = 0; stampColumn < stampWidth; stampColumn++) {
				System.out.print('#');
			}
			System.out.println('|');
		}
	}

	static void print_empty_row(int letterWidth) {
		System.out.print('|');
		for(int i = 0; i < letterWidth; i++) {
			System.out.print(' ');
		}
		System.out.println('|');
	}

	static void print_address_rows(int letterWidth) {
		int startColumn = 24;
		int addressRows = 3;

		String[] address = {"Bill Gates", "1 Microsoft Bay", "Redmond, WA 98104"};

		for (String addressPart : address) {
			System.out.print('|');
			for(int i = 0; i < startColumn; i++) {
				System.out.print(' ');
			}
			System.out.print(addressPart);
			int afterAddressPartColumn = startColumn + addressPart.length();
			for(int i = afterAddressPartColumn; i < letterWidth; i++) {
				System.out.print(' ');
			}
			System.out.println('|');
		}
	}
}
