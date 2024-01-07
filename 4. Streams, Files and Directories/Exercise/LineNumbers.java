import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String pathFile = "C:\\IDE\\IdeaProjects\\Streams\\ExStream\\src\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        PrintWriter printWriter = new PrintWriter("output.txt");

        List<String> allLines = Files.readAllLines(Path.of(pathFile));
        int lineNumber = 1;
        for (String line : allLines) {
            printWriter.println(lineNumber + ". " + line);
            lineNumber++;
        }
        printWriter.close();
    }
}
