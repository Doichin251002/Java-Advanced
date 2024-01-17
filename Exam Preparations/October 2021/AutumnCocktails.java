import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(ingredients::offer);

        Deque<Integer> freshLevel = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(freshLevel::push);

        int countPearSour = 0;
        int countHarvest = 0;
        int countAppleHinny = 0;
        int countHighFashion = 0;

        while (!ingredients.isEmpty() && !freshLevel.isEmpty()) {
            int firstIngredient = ingredients.poll();
            if (firstIngredient == 0) continue;

            int lastFreshLevel = freshLevel.pop();
            int product = firstIngredient * lastFreshLevel;

            switch (product) {
                case 150:
                    countPearSour++;
                    break;
                case 250:
                    countHarvest++;
                    break;
                case 300:
                    countAppleHinny++;
                    break;
                case 400:
                    countHighFashion++;
                    break;
                default:
                    firstIngredient += 5;
                    ingredients.addLast(firstIngredient);
                    break;
            }
        }

        if (countPearSour + countHarvest + countAppleHinny + countHighFashion >= 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()) {
            int sum = ingredients.stream().mapToInt(ingredient -> ingredient).sum();
            System.out.println("Ingredients left: " + sum);
        }

        if (countAppleHinny > 0) {
            System.out.println(" # Apple Hinny --> " + countAppleHinny);
        }
        if (countHighFashion > 0) {
            System.out.println(" # High Fashion --> " + countHighFashion);
        }
        if (countPearSour > 0) {
            System.out.println(" # Pear Sour --> " + countPearSour);
        }
        if (countHarvest > 0) {
            System.out.println(" # The Harvest --> " + countHarvest);
        }
    }
}
