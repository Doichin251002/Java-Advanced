import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.print(numbers.toString().replaceAll("[\\[\\]]", ""));
        System.out.println();

        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.print(sortedNumbers.toString().replaceAll("[\\[\\]]", ""));
    }
}