package Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Box<Double>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double data = Double.parseDouble(scan.nextLine());
            Box<Double> box = new Box<>(data);
            boxes.add(box);
        }
        Box<Double> boxToCompare = new Box<>(Double.parseDouble(scan.nextLine()));

        System.out.println(getCount(boxes, boxToCompare));

    }

    private static <T extends Comparable<T>> int getCount(List<T> boxes, T element) {
        int count = 0;
        for (T box : boxes) {
            int res = box.compareTo(element);
            if (res > 0) {
                count++;
            }
        }
        return count;
    }

}