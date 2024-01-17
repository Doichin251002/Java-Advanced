import java.util.*;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(liquids::offer);

        Deque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(ingredients::push);

        int biscuitCount = 0;
        int cakeCount = 0;
        int pastryCount = 0;
        int pieCount = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int firstLiquid = liquids.poll();
            int lastIngredient = ingredients.pop();
            int sum = firstLiquid + lastIngredient;
            switch (sum) {
                case 25: biscuitCount++; break;
                case 50: cakeCount++; break;
                case 75: pastryCount++; break;
                case 100: pieCount++; break;
                default: ingredients.push(lastIngredient + 3);
            }
        }

        if (biscuitCount > 0 && cakeCount > 0 && pastryCount > 0 && pieCount > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if (liquids.isEmpty()) {
            System.out.print("none");
        } else {
            System.out.print(String.join(", ", liquids.toString().replaceAll("[\\[\\]]", "")));
        }
        System.out.println();

        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()) {
            System.out.print("none");
        } else {
            System.out.print(String.join(", ", ingredients.toString().replaceAll("[\\[\\]]", "")));
        }

        System.out.println();
        System.out.println("Biscuit: " + biscuitCount);
        System.out.println("Cake: " + cakeCount);
        System.out.println("Pie: " + pieCount);
        System.out.println("Pastry: " + pastryCount);
    }
}
