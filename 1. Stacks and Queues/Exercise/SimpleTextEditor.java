package Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        StringBuilder currentText = new StringBuilder();

        ArrayDeque<String> textStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String operation = scan.nextLine();

            if (operation.startsWith("1")) {
                textStack.push(currentText.toString());

                String appendText = operation.split("\\s+")[1];

                currentText.append(appendText);
            } else if (operation.startsWith("2")) {
                textStack.push(currentText.toString());

                int eraseChars = Integer.parseInt(operation.split("\\s+")[1]);

                int startIndexDeleted = currentText.length() - eraseChars;
                currentText.delete(startIndexDeleted, currentText.length());
            } else if (operation.startsWith("3")) {
                int index = Integer.parseInt(operation.split("\\s+")[1]);

                System.out.println(currentText.charAt(index - 1));
            } else if (operation.equals("4")) {
                if (!textStack.isEmpty()) {
                    String last = textStack.pop();
                    currentText = new StringBuilder(last);
                }
            }
        }
    }
}
