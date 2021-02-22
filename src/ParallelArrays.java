import java.util.Scanner;

public class ParallelArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = { "Mitchell", "Ortiz", "Luu", "Zimmerman", "Brooks" };
        double[] gradeAverages = { 99.5, 78.5, 95.6, 96.8, 82.7 };
        int[] sID = { 123456, 813225, 823669, 307760, 827131 };

        System.out.println("Student info:");
        System.out.println("Name Grade-Average sID");

        for (int i = 0; i < names.length; i++) {
            System.out.printf("%s %.1f %d%n", names[i], gradeAverages[i], sID[i]);
        }

        System.out.print("Enter sID to show more info > ");
        int lookingForsID = scanner.nextInt();

        int index = 0;
        for (int id : sID) {
            if (id == lookingForsID) {
                System.out.printf("%nsID found in slot %d%n", index);
                System.out.printf("\tName: %s%n", names[index]);
                System.out.printf("\tGrade Average: %.1f%n", gradeAverages[index]);
                System.out.printf("\tsID: %d%n", id);
            }
            index++;
        }
    }
}
