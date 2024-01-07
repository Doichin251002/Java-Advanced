import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        Map<String, String> emailsMap = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scan.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emailsMap.put(name, email);
            }
            name = scan.nextLine();
        }

        emailsMap.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
