import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] names = scan.nextLine().split("\\s+");

        Consumer<String> printName = name -> System.out.println("Sir " + name);

        Arrays.stream(names).forEach(printName);
    }
}
