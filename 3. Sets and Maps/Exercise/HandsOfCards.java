import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();

        Map<String, Set<String>> cardsMap = new LinkedHashMap<>();

        while (!inputLine.equals("JOKER")) {
            String player = inputLine.split(": ")[0];
            String [] cards = inputLine.split(": ")[1].split(", ");

            cardsMap.putIfAbsent(player, new HashSet<>());
            cardsMap.get(player).addAll(Arrays.asList(cards));

            inputLine = scan.nextLine();
        }

        for (String player : cardsMap.keySet()) {
            int hand = 0;
            for (String card : cardsMap.get(player)) {
                String power = card.substring(0, card.length() - 1);
                char type = card.charAt(card.length() - 1);

                hand += getHandValue(power, type);
            }
            System.out.printf("%s: %d%n", player, hand);
        }
    }

    private static int getHandValue(String p, char t) {
        int power;
        switch (p) {
            case "J": power = 11; break;
            case "Q": power = 12; break;
            case "K": power = 13; break;
            case "A": power = 14; break;
            default: power = Integer.parseInt(p);
        }

        int type = 0;
        switch (t) {
            case 'S': type = 4; break;
            case 'H': type = 3; break;
            case 'D': type = 2; break;
            case 'C': type = 1; break;
        }
        return power * type;
    }
}
