import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<String, Integer> parse = s -> Integer.parseInt(s);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(", "))
                .map(e -> parse.apply(e))
                .collect(Collectors.toList());

        int sum = numbers.stream().mapToInt(e -> e).sum();

        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + sum);
    }
}
