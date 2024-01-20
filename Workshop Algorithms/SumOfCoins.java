import java.util.*;
import java.util.stream.Collectors;

public class SumOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coinsLine = scanner.nextLine().split(": ")[1];
        List<Integer> coins = Arrays.stream(coinsLine.split(", "))
                .map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        int targetSum = Integer.parseInt(scanner.nextLine().split(": ")[1]);

        Map<Integer, Integer> coinsQuantity = chooseCoins(coins, targetSum);

        int collectedSum = coinsQuantity.entrySet().stream().mapToInt(e -> e.getKey() * e.getValue()).sum();

        if (collectedSum != targetSum) {
            System.out.println("Error");
        } else {
            int totalCoinsQuantity = coinsQuantity.values().stream().mapToInt(Integer::valueOf).sum();
            System.out.printf("Number of coins to take: %d%n", totalCoinsQuantity);

            for (Integer key : coinsQuantity.keySet()) {
                System.out.printf("%d coin(s) with value %d%n", coinsQuantity.get(key), key);
            }
        }
    }

    private static Map<Integer, Integer> chooseCoins(List<Integer> coins, int targetSum) {
        Map<Integer, Integer> coinsQuantity = new LinkedHashMap<>();

        while (targetSum > 0 && !coins.isEmpty()) {
            Integer currentCoin = coins.remove(0);

            if (targetSum >= currentCoin) {
                int quantity = targetSum / currentCoin;

                coinsQuantity.put(currentCoin, quantity);

                targetSum = targetSum % currentCoin;
            }
        }
        return coinsQuantity;
    }
}
