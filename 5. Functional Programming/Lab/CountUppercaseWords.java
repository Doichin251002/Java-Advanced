import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> words = Arrays.stream(scan.nextLine().split(" "))
                .filter(e -> Character.isUpperCase(e.charAt(0)))
                .collect(Collectors.toList());

        System.out.println(words.size());
        words.forEach(System.out::println);
    }
}
