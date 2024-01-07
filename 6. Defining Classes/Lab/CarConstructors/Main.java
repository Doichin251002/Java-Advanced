package CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(" ");
            Car car;
            if (tokens.length > 1) {
                int hp = Integer.parseInt(tokens[2]);

                car = new Car(tokens[0], tokens[1], hp);
            } else {
                car = new Car(tokens[0]);
            }

            System.out.println(car);
        }
    }
}