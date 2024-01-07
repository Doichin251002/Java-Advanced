import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int divisor = Integer.parseInt(scan.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> checkDivision2 = number -> number % divisor == 0;
        numbers.removeIf(checkDivision2);

        numbers.forEach(e -> System.out.print(e + " "));
    }
}
