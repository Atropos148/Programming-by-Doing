import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadMultipleNumbers {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.printf("Hello! Available files are: 3numbers1.txt, 3numbers2.txt, 3numbers3.txt%nSelect a file > ");
        String fileName = keyboard.nextLine();

        System.out.printf("Reading numbers from %s%n", fileName);

        keyboard.close();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                int[] lineNumbers = new int[3];
                int total = 0;

                int index = 0;
                for (String number : currentLine.split(" ")) {
                    lineNumbers[index] = Integer.valueOf(number);
                    index++;
                }

                for (int number : lineNumbers) {
                    total += number;
                }

                System.out.printf("%d + %d + %d = %d", lineNumbers[0], lineNumbers[1], lineNumbers[2], total);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}