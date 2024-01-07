import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Double, Integer> occurrences = new LinkedHashMap<>();

        String [] numbers = scan.nextLine().split(" ");

        for (String number : numbers) {
            double currentNum = Double.parseDouble(number);

            if (occurrences.containsKey(currentNum)) {
                int count = occurrences.get(currentNum);
                occurrences.put(currentNum,count + 1);
            } else {
                occurrences.put(currentNum, 1);
            }
        }

        for (Double currentNumber : occurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", currentNumber, occurrences.get(currentNumber));
        }
    }
}
