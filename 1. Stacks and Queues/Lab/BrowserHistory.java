package Stacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();

        String currentInput = scan.nextLine();
        while (!currentInput.equals("Home")) {
            if (currentInput.equals("back")) {
                if (history.isEmpty() || history.size() == 1) {
                    System.out.println("no previous URLs");
                }
                else {
                    history.pop();
                    System.out.println(history.peek());
                }
            } else {
                history.push(currentInput);
                System.out.println(history.peek());
            }

            currentInput = scan.nextLine();
        }
    }
}
