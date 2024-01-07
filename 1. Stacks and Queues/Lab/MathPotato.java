package Queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] names = scan.nextLine().split(" ");
        int steps = Integer.parseInt(scan.nextLine());

        PriorityQueue<String> players = new PriorityQueue<>();
        Collections.addAll(players, names);

        int currentSteps = 1;
        while (players.size() > 1) {
            for (int i = 1; i < steps; i++) {
                String currentPlayer = players.poll();
                players.offer(currentPlayer);
            }

            if (isPrime(currentSteps)) {
                System.out.println("Prime " + players.peek());
            } else {
                String removedPlayer = players.poll();
                System.out.println("Removed " + removedPlayer);
            }

            currentSteps++;
        }

        System.out.println("Last is " + players.poll());
    }

    private static boolean isPrime (int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
