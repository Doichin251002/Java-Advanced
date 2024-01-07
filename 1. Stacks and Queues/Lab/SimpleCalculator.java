package Stacks;

import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String expressionLine = scan.nextLine();

        String [] expressionArr = expressionLine.split("\\s+");
        List<String> partsList = Arrays.asList(expressionArr);
        stack.addAll(partsList);
        
        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int second = Integer.parseInt(stack.pop());
            int result;
            
            switch (operation) {
                case "+": result = first + second; break;
                case "-": result = first - second; break;
                default: return;
            }
            stack.push("" + result);
        }

        System.out.println(stack.peek());
    }
}
