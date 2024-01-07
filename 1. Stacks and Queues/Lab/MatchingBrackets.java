package Stacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        for (int i = 0; i < inputLine.length(); i++) {
            if (inputLine.charAt(i) == '(') {
                indexes.push(i);
            } else if (inputLine.charAt(i) == ')') {
                int openedBracketIndex = indexes.pop();

                String expression = inputLine.substring(openedBracketIndex, i + 1);
                System.out.println(expression);
            }
        }
    }
}
