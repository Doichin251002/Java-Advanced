package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countCars = Integer.parseInt(scan.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < countCars; i++) {
            String [] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double consumptionFuelPerKm = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, consumptionFuelPerKm);
            cars.put(model, car);
        }

        String command = scan.nextLine();
        while (!command.equals("End")) {
            String carModelToDrive = command.split("\\s+")[1];
            int kmToDrive = Integer.parseInt(command.split("\\s+")[2]);

            Car carToDrive = cars.get(carModelToDrive);
            if (!carToDrive.drive(kmToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }

            command = scan.nextLine();
        }

        for (Car car : cars.values()) {
            System.out.println(car.toString());
        }
    }
}