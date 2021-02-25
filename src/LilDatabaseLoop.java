import java.util.Scanner;

public class LilDatabaseLoop {
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
        Student[] students = new Student[3];

        final String STUDENT_NUM = "Enter student #";

        for (int i = 0; i < students.length; i++) {
            System.out.print(STUDENT_NUM + (i + 1) + " name > ");
            String name = keyboard.next();
            System.out.print(STUDENT_NUM + (i + 1) + " grade > ");
            int grade = keyboard.nextInt();
            System.out.print(STUDENT_NUM + (i + 1) + " grade average > ");
            double gradeAverage = keyboard.nextDouble();

            System.out.println();

            students[i] = new Student(name, grade, gradeAverage);
        }
        keyboard.close();

        System.out.print("Names are: ");
        for (Student student : students) {
            System.out.print(student.firstName + " ");
        }
        System.out.println();

        System.out.print("Grades are: ");
        for (Student student : students) {
            System.out.print(student.grade + " ");
        }
        System.out.println();

        System.out.print("Averages are: ");
        for (Student student : students) {
            System.out.print(student.gradeAverage + " ");
        }
        System.out.println();

        System.out.printf("Average of averages of these 3 students is: %.1f",
                (students[0].gradeAverage + students[1].gradeAverage + students[2].gradeAverage) / 3);
    }
}
