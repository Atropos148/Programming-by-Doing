import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadName {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("name.txt"))) {
            String name;

            while ((name = reader.readLine()) != null) {
                System.out.printf("Hello, %s! Is your whole name %s?", name.split(" ")[0], name);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
