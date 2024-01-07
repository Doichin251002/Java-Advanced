import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        Set<String> chemicals = new TreeSet<>();

        for (int i = 0; i < count; i++) {
            String [] tokens = scan.nextLine().split(" ");

            Collections.addAll(chemicals, tokens);
        }

        chemicals.forEach(e -> System.out.print(e + " "));
    }
}
