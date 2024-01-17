import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> steel = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Deque<Integer> carbon = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int countGladius = 0;
        int countShamshir = 0;
        int countKatana = 0;
        int countSabre = 0;
        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int firstSteel = steel.removeFirst();
            int lastCarbon = carbon.removeLast();
            int sum = firstSteel + lastCarbon;

            switch (sum) {
                case 70:
                    countGladius++;
                    break;
                case 80:
                    countShamshir++;
                    break;
                case 90:
                    countKatana++;
                    break;
                case 110:
                    countSabre++;
                    break;
                default:
                    carbon.addLast(lastCarbon + 5);
            }
        }

        if ((countGladius + countShamshir + countKatana + countSabre) > 0) {
            System.out.printf("You have forged %d swords.%n", countGladius + countShamshir + countKatana + countSabre);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            List<Integer> listSteel = new ArrayList<>(steel);
            Collections.reverse(listSteel);
            String steelString = listSteel.toString().replaceAll("[\\[\\]]", "");
            System.out.println("Steel left: " + steelString);
        }

        if (carbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            List<Integer> listCarbon = new ArrayList<>(carbon);
            Collections.reverse(listCarbon);
            String carbonString = listCarbon.toString().replaceAll("[\\[\\]]", "");
            System.out.println("Carbon left: " + carbonString);
        }

        if (countGladius > 0) {
            System.out.println("Gladius: " + countGladius);
        }
        if (countKatana > 0) {
            System.out.println("Katana: " + countKatana);
        }
        if (countSabre > 0) {
            System.out.println("Sabre: " + countSabre);
        }
        if (countShamshir > 0) {
            System.out.println("Shamshir: " + countShamshir);
        }

    }
}
