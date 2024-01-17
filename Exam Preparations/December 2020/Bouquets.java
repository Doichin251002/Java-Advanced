import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> tulips = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Deque<Integer> daffodils = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int bouquets = 0;
        int totalFlowers = 0;
        while (!daffodils.isEmpty() && !tulips.isEmpty()) {
            int lastTulips = tulips.removeLast();
            int sum = daffodils.getFirst() + lastTulips;
            if (sum == 15) {
                bouquets++;
                daffodils.removeFirst();
            } else if (sum > 15) {
                tulips.addLast(lastTulips - 2);
            } else {
                totalFlowers += sum;
                daffodils.removeFirst();
            }
        }

        if (totalFlowers >= 15) {
            totalFlowers /= 15;
            bouquets += totalFlowers;
        }

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
