import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] input = scan.nextLine().split(" ");
        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);

        String oddOrEven = scan.nextLine();

        Predicate<Integer> filterCondition =
                oddOrEven.equals("odd") ?
                        (x -> x % 2 != 0) :
                        (x -> x % 2 == 0);

        IntStream.range(lowerBound, upperBound + 1)
                .filter(n -> filterCondition.test(n))
                .forEach(n -> System.out.print(n + " "));
    }
}
