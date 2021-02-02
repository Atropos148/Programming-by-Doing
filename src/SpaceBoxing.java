import java.util.Hashtable;
import java.util.Scanner;

public class SpaceBoxing {
	public static void main(String[] args) {
		Hashtable<String, Double> planetWeightModifiers = new Hashtable<>();
		planetWeightModifiers.put("Venus", 0.78);
		planetWeightModifiers.put("Mars", 0.39);
		planetWeightModifiers.put("Jupiter", 2.65);
		planetWeightModifiers.put("Saturn", 1.17);
		planetWeightModifiers.put("Uranus", 1.05);
		planetWeightModifiers.put("Neptune", 1.23);

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter your current earth weight > ");
		double weight = keyboard.nextDouble();

		System.out.println("I have information for the following planets:");

		Hashtable<Integer, String> planetMenu = new Hashtable<>();
		int planetIndex = 1;

		for (String planet : planetWeightModifiers.keySet()) {
			System.out.printf("%d. %s\n", planetIndex, planet);
			planetMenu.put(planetIndex, planet);
			planetIndex++;
		}

		System.out.print("\nWhich planet are you visiting? > ");
		int chosenPlanetIndex = keyboard.nextInt();
		String chosenPlanet = planetMenu.get(chosenPlanetIndex);

		System.out.printf("If you weight %.2f kg on Earth, you will weight %.2f on %s", weight, planetWeightModifiers.get(chosenPlanet) * weight, chosenPlanet);
	}
}
