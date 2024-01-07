import java.util.Scanner;

import java.util.*;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = Long.parseLong(input.nextLine());
        System.out.println(getFibonacci(n));
    }

    private static long getFibonacci(long n) {
        ArrayDeque<Long> fibonacci = new ArrayDeque<>();

        if (n <= 2) {
            return 1;
        } else {
            fibonacci.offer(0L);
            fibonacci.offer(1L);
            for (int i = 0; i < n; i++) {
                if (!fibonacci.isEmpty()) {
                    long Sum = fibonacci.poll() + fibonacci.peek();
                    fibonacci.offer(Sum);
                }
            }
        }
        if (!fibonacci.isEmpty()) {
            fibonacci.poll();
        }
        return fibonacci.peek();
    }
}
