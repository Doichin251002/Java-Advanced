import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String pathFile = "C:\\IDE\\IdeaProjects\\Streams\\ExStream\\src\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        List<String> allLines = Files.readAllLines(Path.of(pathFile));
        int vowelsCount = 0;
        int punctuationCount = 0;
        int othersCount = 0;
        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                if (symbol == ' ') {
                    continue;
                } else if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                    vowelsCount++;
                } else if (symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?') {
                    punctuationCount++;
                } else {
                    othersCount++;
                }
            }
        }
        System.out.println("Vowels: " + vowelsCount);
        System.out.println("Other symbols: " + othersCount);
        System.out.println("Punctuation: " + punctuationCount);
        writer.close();
    }
}
