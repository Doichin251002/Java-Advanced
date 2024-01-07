import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();

        Set<String> cars = new LinkedHashSet<>();

        while (!inputLine.equals("END")) {
            String direction = inputLine.split(", ")[0];
            String carNumber = inputLine.split(", ")[1];

            if (direction.equals("IN")) {
                cars.add(carNumber);
            } else if (direction.equals("OUT")) {
                cars.remove(carNumber);
            }
            inputLine = scan.nextLine();
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}