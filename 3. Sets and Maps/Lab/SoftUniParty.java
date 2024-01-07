import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();

        String inputLine = scan.nextLine();
        while (!inputLine.equals("PARTY")) {
            guests.add(inputLine);
            inputLine = scan.nextLine();
        }

        inputLine = scan.nextLine();
        while (!inputLine.equals("END")) {
            guests.remove(inputLine);
            inputLine = scan.nextLine();
        }

        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
