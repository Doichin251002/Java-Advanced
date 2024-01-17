
import java.util.*;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] input = scan.nextLine().split("\\s+");
        Deque<Integer> textiles = new ArrayDeque<>();
        Arrays.stream(input).map(Integer::parseInt).forEach(textiles::offer);

        input = scan.nextLine().split("\\s+");
        Deque<Integer> medicaments = new ArrayDeque<>();
        Arrays.stream(input).map(Integer::parseInt).forEach(medicaments::push);

        int countPatch = 0;
        int countBandage = 0;
        int countMedKit = 0;
        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int firstTextiles = textiles.poll();
            int lastMedicaments = medicaments.pop();
            int sum = firstTextiles + lastMedicaments;

            if (sum == 30) {
                countPatch++;
            } else if (sum == 40) {
                countBandage++;
            } else if (sum == 100) {
                countMedKit++;
            } else if (sum > 100) {
                countMedKit++;
                int remainingMedicaments = medicaments.pop() + sum - 100;
                medicaments.push(remainingMedicaments);

            } else {
                medicaments.push(lastMedicaments + 10);
            }
        }

        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        Map<String, Integer> items = new TreeMap<>();
        items.put("Patch", countPatch);
        items.put("Bandage", countBandage);
        items.put("MedKit", countMedKit);

        Map<String, Integer> sortedItems = new LinkedHashMap<>();
        items.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> sortedItems.put(e.getKey(), e.getValue()));


        sortedItems.forEach((key, value) -> System.out.printf("%s - %d%n", key, value));

        if (!medicaments.isEmpty()) {
            String medicamentsString = medicaments.toString().replaceAll("[\\[\\]]", "").trim();
            System.out.printf("Medicaments left: %s", medicamentsString.trim());
        } else if (!textiles.isEmpty()) {
            String textilesString = textiles.toString().replaceAll("[\\[\\]]", "").trim();
            System.out.printf("Textiles left: %s", textilesString.trim());
        }
    }
}