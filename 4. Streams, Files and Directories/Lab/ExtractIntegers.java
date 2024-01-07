import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\dodi_\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";

        try (Scanner reader = new Scanner(new FileInputStream(inputPath));
             PrintStream writer = System.out) {
            while (reader.hasNext()) {
                if (reader.hasNextInt()) {
                    writer.println(reader.nextInt());
                }

                reader.next();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
