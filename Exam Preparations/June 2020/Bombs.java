import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> effects = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(effects::offer);

        Deque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(casings::push);

        int daturaCount = 0;
        int cherryCount = 0;
        int smokeCount = 0;

        while (!effects.isEmpty() && !casings.isEmpty()) {
            int firstBombEffect = effects.poll();
            int lastBombCasing = casings.pop();
            int sum = firstBombEffect + lastBombCasing;
            switch (sum) {
                case 40:
                    daturaCount++;
                    break;
                case 60:
                    cherryCount++;
                    break;
                case 120:
                    smokeCount++;
                    break;
                default:
                    effects.push(firstBombEffect);
                    casings.push(lastBombCasing - 5);
            }

            if (daturaCount >= 3 && cherryCount >= 3 && smokeCount >= 3) {
                break;
            }
        }

        if (daturaCount >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            System.out.print(String.join(", ", effects.toString()).replaceAll("[\\[\\]]", ""));
            System.out.println();
        }

        if (casings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            System.out.print(String.join(", ", casings.toString()).replaceAll("[\\[\\]]", ""));
            System.out.println();
        }

        System.out.println("Cherry Bombs: " + cherryCount);
        System.out.println("Datura Bombs: " + daturaCount);
        System.out.println("Smoke Decoy Bombs: " + smokeCount);
    }
}
