import java.io.FileWriter;
import java.io.IOException;

public class LetterFileMaker {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("letter.txt");) {
            int letterWidth = 50;

            String border = printBorder(letterWidth);
            String stamp = printStampRows(letterWidth);
            String emptyRow = printEmptyRow(letterWidth);
            String address = printAddressRows(letterWidth);
            System.out.println(border);

            writer.write(border);
            writer.write(stamp);
            writer.write(emptyRow);
            writer.write(address);
            writer.write(emptyRow);
            writer.write(System.getProperty("line.separator"));
            writer.write(border);

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

        //
        //
        // printEmptyRow(letterWidth);
        // printBorder(letterWidth);
    }

    static String printBorder(int letterWidth) {
        StringBuilder sb = new StringBuilder();

        sb.append('+');

        for (int i = 0; i < letterWidth; i++) {
            sb.append('-');
        }

        sb.append('+');

        return sb.toString();
    }

    static String printStampRows(int letterWidth) {
        StringBuilder sb = new StringBuilder();

        int stampHeight = 3;
        int stampWidth = 4;

        for (int row = 0; row < stampHeight; row++) {
            sb.append(System.getProperty("line.separator"));
            sb.append('|');

            for (int column = 1; column < (letterWidth - (stampWidth - 1)); column++) {
                sb.append(' ');
            }

            for (int stampColumn = 0; stampColumn < stampWidth; stampColumn++) {
                sb.append('#');
            }

            sb.append('|');
        }

        return sb.toString();
    }

    static String printEmptyRow(int letterWidth) {
        StringBuilder sb = new StringBuilder();

        sb.append(System.getProperty("line.separator"));
        sb.append('|');

        for (int i = 0; i < letterWidth; i++) {
            sb.append(' ');
        }

        sb.append('|');

        return sb.toString();
    }

    static String printAddressRows(int letterWidth) {
        StringBuilder sb = new StringBuilder();

        int startColumn = 24;

        String[] address = { "Bill Gates", "1 Microsoft Bay", "Redmond, WA 98104" };

        for (String addressPart : address) {
            sb.append(System.getProperty("line.separator"));
            sb.append('|');
            for (int i = 0; i < startColumn; i++) {
                sb.append(' ');
            }
            sb.append(addressPart);
            int afterAddressPartColumn = startColumn + addressPart.length();
            for (int i = afterAddressPartColumn; i < letterWidth; i++) {
                sb.append(' ');
            }
            sb.append('|');
        }

        return sb.toString();
    }
}
