import java.util.*;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> concerts = new LinkedHashMap<>();

        String command = scan.nextLine();
        while (!command.equals("End")) {
            if (!command.contains(" @")) {
                command = scan.nextLine();
                continue;
            } else {
                String singer = command.substring(0, command.indexOf("@") - 1);

                int firstIndexOfNumber = getFirstIndexOfNumber(command);
                if (firstIndexOfNumber == -1) {
                    command = scan.nextLine();
                    continue;
                }

                String venue = command.substring(command.indexOf("@") + 1, firstIndexOfNumber - 1);
                String numbers = command.substring(firstIndexOfNumber);
                String [] numbersArray = numbers.split("\\s+");
                if (numbersArray.length != 2) {
                    command = scan.nextLine();
                    continue;
                }
                int price = Integer.parseInt(numbersArray[0]);
                int capacity = Integer.parseInt(numbersArray[1]);
                int money = price * capacity;

                concerts.putIfAbsent(venue, new LinkedHashMap<>());
                concerts.get(venue).putIfAbsent(singer, 0);
                int totalMoney = concerts.get(venue).get(singer);
                concerts.get(venue).put(singer, totalMoney + money);
            }
            command = scan.nextLine();
        }

        for (String venue : concerts.keySet()) {
            System.out.println(venue);

            Map<String, Integer> singerMoney = concerts.get(venue);
            singerMoney.entrySet().stream()
                    .sorted((money1, money2) -> money2.getValue().compareTo(money1.getValue()))
                    .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));
        }
    }

    private static int getFirstIndexOfNumber(String command) {
        int firstIndexOfNumber;
        for (int i = command.indexOf("@"); i < command.length(); i++) {
            char currentSymbol = command.charAt(i);
            if (Character.isDigit(currentSymbol) && command.charAt(i - 1) == ' ') {
                firstIndexOfNumber = i;
                return firstIndexOfNumber;
            }
        }
        return -1;
    }
}
