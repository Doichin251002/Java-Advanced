package Stacks;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();

            switch (operation) {
                case 1: stack.push(scan.nextInt()); break;
                case 2: stack.pop(); break;
                case 3: System.out.println(Collections.max(stack)); break;
            }
        }

    }
}
