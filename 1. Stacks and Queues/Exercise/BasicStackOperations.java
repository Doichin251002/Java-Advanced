package Stacks;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pushElements = scan.nextInt();
        int popElements = scan.nextInt();
        int peekElement = scan.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < pushElements; i++) {
            stack.push(scan.nextInt());
        }

        for (int i = 0; i < popElements; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(peekElement)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
