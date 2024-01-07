import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<Double, Double> addVat = d -> d * 1.2;
        Consumer<Double> print = num -> System.out.printf("%.2f%n", num);

        System.out.println("Prices with VAT:");
        Arrays.stream(scan.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .map(price -> addVat.apply(price))
                .forEach(priceWithVat -> print.accept(priceWithVat));
    }
}
