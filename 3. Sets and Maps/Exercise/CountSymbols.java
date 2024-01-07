import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();

        Map<Character, Integer> countSymbols = new TreeMap<>();

        for (char letter : inputLine.toCharArray()) {
            countSymbols.putIfAbsent(letter, 0);
            countSymbols.put(letter, countSymbols.get(letter) + 1);
        }

        countSymbols.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
