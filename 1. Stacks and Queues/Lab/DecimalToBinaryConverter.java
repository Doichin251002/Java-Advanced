package Stacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> binary = new ArrayDeque<>();
        int num = Integer.parseInt(scan.nextLine());

        if (num == 0) {
            System.out.println(0);
            return;
        }
        while (num != 0) {
            binary.push(num % 2);

            num /= 2;
        }

        while (!binary.isEmpty()) {
            System.out.print(binary.pop());
        }
    }
}
