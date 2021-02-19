import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HighScoreFile {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("highscore.txt")) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("You got a highscore!");

            System.out.print("Enter your score > ");
            int score = scanner.nextInt();
            System.out.println(score);

            System.out.print("Enter your name > ");
            String name = scanner.next();

            scanner.close();

            writer.write(name);
            writer.write(" > ");
            writer.write(String.valueOf(score));

            System.out.println("Data stored into highscore.txt");
        } catch (IOException e) {
            System.out.println("Error occured");
        }
    }
}
