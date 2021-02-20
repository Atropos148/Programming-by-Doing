import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GradesInAnArrayAndAFile {
    public static void main(String[] args) {
        int[] grades = new int[5];
        Random r = new Random();
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter your name (first last) > ");
        String name = keyboard.nextLine();

        System.out.print("Enter filename > ");
        String filename = keyboard.nextLine();
        keyboard.close();

        System.out.println("Here are some random grades (hope you pass):");

        for (int i = 0; i < grades.length; i++) {
            grades[i] = r.nextInt(99) + 1;
        }

        for (int i = 0; i < grades.length; i++) {
            System.out.printf("Grade %d: %d%n", i + 1, grades[i]);
        }

        try (FileWriter writer = new FileWriter(filename + ".txt")) {
            writer.write(name);
            writer.write(System.lineSeparator());

            StringBuilder gradesString = new StringBuilder();
            for (int i = 0; i < grades.length; i++) {
                gradesString.append(grades[i]);
                gradesString.append(" ");
            }

            writer.write(String.valueOf(gradesString));
        } catch (IOException e) {
            System.out.println("Grade file not found");
        }
    }
}
