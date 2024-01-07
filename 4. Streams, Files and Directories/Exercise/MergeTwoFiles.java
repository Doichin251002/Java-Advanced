import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String pathInput1 = "C:\\IDE\\IdeaProjects\\Streams\\ExStream\\src\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathInput2 = "C:\\IDE\\IdeaProjects\\Streams\\ExStream\\src\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        List<String> allLines = Files.readAllLines(Path.of(pathInput1));

        for (String line : allLines) {
            writer.write(line + "\n");
        }

        allLines = Files.readAllLines(Path.of(pathInput2));
        for (String line : allLines) {
            writer.write(line + "\n");
        }
        writer.close();

    }
}
