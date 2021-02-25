import java.util.Scanner;

public class BasicRecords {
    static class Student {
        String firstName;
        int grade;
        double gradeAverage;

        public Student(String firstName, int grade, double gradeAverage) {
            this.firstName = firstName;
            this.grade = grade;
            this.gradeAverage = gradeAverage;
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter first student name > ");
        String firstName = keyboard.nextLine();
        System.out.print("Enter first student grade > ");
        int firstGrade = keyboard.nextInt();
        System.out.print("Enter first student grade average > ");
        double firstGradeAverage = keyboard.nextDouble();

        Student firstStudent = new Student(firstName, firstGrade, firstGradeAverage);

        System.out.print("Enter second student name > ");
        String secondName = keyboard.next();
        System.out.print("Enter second student grade > ");
        int secondGrade = keyboard.nextInt();
        System.out.print("Enter second student grade average > ");
        double secondGradeAverage = keyboard.nextDouble();

        Student secondStudent = new Student(secondName, secondGrade, secondGradeAverage);

        System.out.print("Enter third student name > ");
        String thirdName = keyboard.next();
        System.out.print("Enter third student grade > ");
        int thirdGrade = keyboard.nextInt();
        System.out.print("Enter third student grade average > ");
        double thirdGradeAverage = keyboard.nextDouble();

        Student thirdStudent = new Student(thirdName, thirdGrade, thirdGradeAverage);

        keyboard.close();

        System.out.printf("Names are: %s %s %s%n", firstStudent.firstName, secondStudent.firstName,
                thirdStudent.firstName);
        System.out.printf("Grades are: %d %d %d%n", firstStudent.grade, secondStudent.grade, thirdStudent.grade);
        System.out.printf("Averages are: %.1f %.1f %.1f%n", firstStudent.gradeAverage, secondStudent.gradeAverage,
                thirdStudent.gradeAverage);

        System.out.printf("Average of averages of these 3 students is: %.1f",
                (firstStudent.gradeAverage + secondStudent.gradeAverage + thirdStudent.gradeAverage) / 3);
    }
}
