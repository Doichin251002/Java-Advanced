import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String contact = scan.nextLine();

        Map<String, String> phonebook = new HashMap<>();

        while (!contact.equals("search")) {
            String [] tokens = contact.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];

            phonebook.put(name, phoneNumber);

            contact = scan.nextLine();
        }

        contact = scan.nextLine();
        while (!contact.equals("stop")) {
            if (phonebook.containsKey(contact)) {
                System.out.printf("%s -> %s%n", contact, phonebook.get(contact));
            } else {
                System.out.printf("Contact %s does not exist.%n", contact);
            }
            contact = scan.nextLine();
        }
    }
}
