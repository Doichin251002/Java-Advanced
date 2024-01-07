package Queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] names = scan.nextLine().split(" ");
        int steps = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> players = new ArrayDeque<>();
        Collections.addAll(players, names);

        while (players.size() > 1) {
            for (int i = 1; i < steps; i++) {
                String currentPlayer = players.poll();
                players.offer(currentPlayer);
            }

            String removedPlayer = players.poll();
            System.out.println("Removed " + removedPlayer);
        }

        System.out.println("Last is " + players.poll());
    }
}
