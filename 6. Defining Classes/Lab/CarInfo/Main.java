package CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(" ");
            Car car = new Car();
            car.setBrand(tokens[0]);
            car.setModel(tokens[1]);
            car.setHorsepower(Integer.parseInt(tokens[2]));

            System.out.println(car);
        }
    }
}