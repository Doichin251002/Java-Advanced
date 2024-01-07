import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] sizes = scan.nextLine().split(" ");
        int sizeFirst = Integer.parseInt(sizes[0]);
        int sizeSecond = Integer.parseInt(sizes[1]);

        Set<Integer> numbersFirstSet = new LinkedHashSet<>();
        Set<Integer> numbersSecondSet = new LinkedHashSet<>();

        for (int i = 0; i < sizeFirst; i++) {
            int num = scan.nextInt();
            numbersFirstSet.add(num);
        }

        for (int i = 0; i < sizeSecond; i++) {
            int num = scan.nextInt();
            numbersSecondSet.add(num);
        }

        numbersFirstSet.retainAll(numbersSecondSet);

        for (Integer e : numbersFirstSet) {
            System.out.print(e + " ");
        }
    }
}
