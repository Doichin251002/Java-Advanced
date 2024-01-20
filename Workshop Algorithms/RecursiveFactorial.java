import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        System.out.println(factorial(number));
    }

    private static int factorial(int number) {
        if (number == 1) {
            return number;
        }

        return number * factorial(--number);
    }
}
