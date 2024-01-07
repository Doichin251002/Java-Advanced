package CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countEngines = Integer.parseInt(scan.nextLine());

        List<Engine> enginesList = new ArrayList<>();
        for (int i = 0; i < countEngines; i++) {
            String [] dataEngine = scan.nextLine().split("\\s+");
            String model = dataEngine[0];
            int power = Integer.parseInt(dataEngine[1]);
            int displacement = 0;
            String efficiency = null;

            if (dataEngine.length == 4) {
                displacement = Integer.parseInt(dataEngine[2]);
                efficiency = dataEngine[3];
            } else if (dataEngine.length == 3) {
                if (Character.isDigit(dataEngine[2].charAt(0))) {
                    displacement = Integer.parseInt(dataEngine[2]);
                } else {
                    efficiency = dataEngine[2];
                }
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            enginesList.add(engine);
        }

        int countCar = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < countCar; i++) {
            String [] dataCar = scan.nextLine().split("\\s+");
            String carModel = dataCar[0];
            String engineModel = dataCar[1];
            int weight = 0;
            String color = null;

            if (dataCar.length == 4) {
                weight = Integer.parseInt(dataCar[2]);
                color = dataCar[3];
            } else if (dataCar.length == 3) {
                if (Character.isDigit(dataCar[2].charAt(0))) {
                    weight = Integer.parseInt(dataCar[2]);
                } else {
                    color = dataCar[2];
                }
            }

            Engine carEngine = null;
            for (Engine engine : enginesList) {
                if (engineModel.equals(engine.getModel())) {
                    carEngine = engine;
                    break;
                }
            }

            Car car = new Car(carModel, carEngine, weight, color);
            System.out.println(car.toString());
        }
    }
}
