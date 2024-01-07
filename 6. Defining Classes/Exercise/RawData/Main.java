package RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countCars = Integer.parseInt(scan.nextLine());

        Map<String, List<Car>> cargoTypeList = new LinkedHashMap<>();
        for (int i = 0; i < countCars; i++) {
            String [] data = scan.nextLine().split("\\s+");
            String model = data[0];
            int speed = Integer.parseInt(data[1]);
            int power = Integer.parseInt(data[2]);
            Engine engine = new Engine(speed, power);

            int weight = Integer.parseInt(data[3]);
            String type = data[4];
            Cargo cargo = new Cargo(weight, type);

            List<Tire> tireList = new ArrayList<>();
            for (int j = 1; j <= 4; j += 2) {
                double pressure = Double.parseDouble(data[4 + j]);
                int age = Integer.parseInt(data[5 + j]);

                Tire tire = new Tire(pressure, age);
                tireList.add(tire);
            }
            Car car = new Car(model, engine, cargo, tireList);
            cargoTypeList.putIfAbsent(type, new ArrayList<>());
            cargoTypeList.get(type).add(car);
        }

        String command = scan.nextLine();
        cargoTypeList.get(command).forEach(car -> car.extract(command));
    }
}
