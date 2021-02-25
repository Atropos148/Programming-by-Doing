import java.io.File;
import java.util.Scanner;

class Address {
    String street;
    String city;
    String state;
    int zip;
}

public class WebAddresses {
    public static void main(String[] args) throws Exception {
        File file = new File("adresses.txt");

        try (Scanner fin = new Scanner(file)) {

            Address uno = new Address();
            uno.street = fin.nextLine();
            uno.city = fin.nextLine();
            uno.state = fin.next();
            uno.zip = fin.nextInt();
            System.out.println(uno.street + ", " + uno.city + ", " + uno.state + " " + uno.zip);

            // skip ghost newline
            System.out.println(fin.nextLine());

            Address dos = new Address();
            dos.street = fin.nextLine();
            dos.city = fin.nextLine();
            dos.state = fin.next();
            dos.zip = fin.nextInt();
            System.out.println(dos.street + ", " + dos.city + ", " + dos.state + " " + dos.zip);

            // skip ghost newline
            System.out.println(fin.nextLine());

            Address tre = new Address();
            tre.street = fin.nextLine();
            tre.city = fin.nextLine();
            tre.state = fin.next();
            tre.zip = fin.nextInt();
            System.out.println(tre.street + ", " + tre.city + ", " + tre.state + " " + tre.zip);

            // skip ghost newline
            System.out.println(fin.nextLine());

            Address four = new Address();
            four.street = fin.nextLine();
            four.city = fin.nextLine();
            four.state = fin.next();
            four.zip = fin.nextInt();
            System.out.println(four.street + ", " + four.city + ", " + four.state + " " + four.zip);

            // skip ghost newline
            System.out.println(fin.nextLine());

            Address five = new Address();
            five.street = fin.nextLine();
            five.city = fin.nextLine();
            five.state = fin.next();
            five.zip = fin.nextInt();
            System.out.println(five.street + ", " + five.city + ", " + five.state + " " + five.zip);
        }
    }
}
