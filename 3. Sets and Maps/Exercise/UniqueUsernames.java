import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        Set<String> usernamesSet = new LinkedHashSet<>();

        for (int i = 0; i < count; i++) {
            String username = scan.nextLine();
            usernamesSet.add(username);
        }

        usernamesSet.forEach(System.out::println);
    }
}
