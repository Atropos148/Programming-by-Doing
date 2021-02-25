import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class AddressString {
    String street;
    String city;
    String state;
    int zip;

    public String oneLineAdress() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.street + ", ");
        sb.append(this.city + ", ");
        sb.append(this.state + ", ");
        sb.append(this.zip);

        return sb.toString();
    }
}

public class WebAddressesArray {
    public static void main(String[] args) throws Exception {
        File file = new File("adresses.txt");
        ArrayList<AddressString> addresses = new ArrayList<>();

        try (Scanner fin = new Scanner(file)) {

            AddressString uno = new AddressString();
            uno.street = fin.nextLine();
            uno.city = fin.nextLine();
            uno.state = fin.next();
            uno.zip = fin.nextInt();
            addresses.add(uno);

            // skip ghost newline
            fin.nextLine();

            AddressString dos = new AddressString();
            dos.street = fin.nextLine();
            dos.city = fin.nextLine();
            dos.state = fin.next();
            dos.zip = fin.nextInt();
            addresses.add(dos);

            // skip ghost newline
            fin.nextLine();

            AddressString tre = new AddressString();
            tre.street = fin.nextLine();
            tre.city = fin.nextLine();
            tre.state = fin.next();
            tre.zip = fin.nextInt();
            addresses.add(tre);

            // skip ghost newline
            fin.nextLine();

            AddressString four = new AddressString();
            four.street = fin.nextLine();
            four.city = fin.nextLine();
            four.state = fin.next();
            four.zip = fin.nextInt();
            addresses.add(four);

            // skip ghost newline
            fin.nextLine();

            AddressString five = new AddressString();
            five.street = fin.nextLine();
            five.city = fin.nextLine();
            five.state = fin.next();
            five.zip = fin.nextInt();
            addresses.add(five);

            int index = 1;
            for (AddressString adress : addresses) {
                System.out.println(index + ": " + adress.oneLineAdress());
                index++;
            }
        }
    }
}
