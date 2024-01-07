import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String pathFile = "C:\\IDE\\IdeaProjects\\Streams\\ExStream\\src\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        byte[] allBytes = Files.readAllBytes(Path.of(pathFile));

        int sum = 0;
        for (byte ascii: allBytes) {
            if (ascii != 10 && ascii != 13) {
                sum += ascii;
            }
        }
        System.out.println(sum);
    }
}
