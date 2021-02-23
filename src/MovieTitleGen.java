import java.util.Random;

public class MovieTitleGen {
    public static void main(String[] args) {
        Random rand = new Random();
        String[] adjectives = { "Big", "Cyber", "Long", "Dark", "Flaming" };
        String[] nouns = { "Dog", "Mars", "Music", "Church", "Evening" };

        System.out.println("Random Movie Title Generator - by atropos148\n");

        System.out.print("Choosing randomly from " + adjectives.length + " adjectives ");
        System.out.println("and " + nouns.length + " nouns (" + (adjectives.length * nouns.length) + " combinations).");
        for (int i = 0; i < 10; i++) {
            System.out.println(generateMovieName(adjectives, nouns, rand));
        }
    }

    public static String generateMovieName(String[] adjectives, String[] nouns, Random rand) {

        String adjective1 = adjectives[rand.nextInt(adjectives.length)];
        String adjective2 = adjectives[rand.nextInt(adjectives.length)];
        String noun = nouns[rand.nextInt(nouns.length)];

        return adjective1 + " " + adjective2 + " " + noun;
    }
}