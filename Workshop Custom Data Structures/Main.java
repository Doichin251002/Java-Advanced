import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();

        long start = System.currentTimeMillis();

        IntStream.rangeClosed(1, 1000000).forEach(smartArray::add);

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}