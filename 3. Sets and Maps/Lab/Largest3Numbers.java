import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputLine = scan.nextLine().split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String element : inputLine) {
            numbers.add(Integer.parseInt(element));
        }

        List<Integer> sortedList = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int limit = Math.min(sortedList.size(), 3);
        for (int i = 0; i < limit; i++) {
            System.out.print(sortedList.get(i) + " ");
        }
    }
}
