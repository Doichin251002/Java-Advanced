package Stacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String currentInput = scan.nextLine();

        ArrayDeque<String> backHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        while (!currentInput.equals("Home")) {
            if (currentInput.equals("back")) {
                if (backHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    currentInput = backHistory.pop();
                    forwardStack.push(currentInput);
                    System.out.println(backHistory.peek());
                }
            } else if (currentInput.equals("forward")) {
                if (forwardStack.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    currentInput = forwardStack.pop();
                    backHistory.push(currentInput);
                    System.out.println(backHistory.peek());
                }
            } else {
                backHistory.push(currentInput);
                System.out.println(backHistory.peek());
                forwardStack.clear();
            }
            currentInput = scan.nextLine();
        }
    }
}
