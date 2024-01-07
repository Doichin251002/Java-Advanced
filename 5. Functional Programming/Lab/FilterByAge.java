import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String [] input = scan.nextLine().split(", ");
            people.put(input[0], Integer.parseInt(input[1]));
        }

        String condition = scan.nextLine();
        int ageLimit = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        Predicate<Integer> filter = getPredicate(condition, ageLimit);
        Consumer<Map.Entry<String, Integer>> print = getPrintConsumer(format);

        people.entrySet().stream()
                .filter(entry -> filter.test(entry.getValue()))
                .forEach(entry -> print.accept(entry));
    }

    private static Consumer<Map.Entry<String, Integer>> getPrintConsumer(String format) {
        switch (format) {
            case "name":
                return e -> System.out.println(e.getKey());
            case "age":
                return e -> System.out.println(e.getValue());
            default:
                return e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue());
        }
    }

    private static Predicate<Integer> getPredicate(String condition, int ageLimit) {
        if (condition.equals("older")) {
            return x -> x >= ageLimit;
        } else {
            return x -> x <= ageLimit;
        }

    }
}