package Queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int offerElements = scan.nextInt();
        int popElements = scan.nextInt();
        int peekElement = scan.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < offerElements; i++) {
            queue.offer(scan.nextInt());
        }

        for (int i = 0; i < popElements; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(peekElement)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
