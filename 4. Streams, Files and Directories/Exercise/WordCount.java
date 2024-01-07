import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String pathFile = "C:\\IDE\\IdeaProjects\\Streams\\ExStream\\src\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathFile));

        Map<String, Integer> countWords = new HashMap<>();

        for (String line : allLinesWithWords) {
            String [] wordsLine = line.split("\\s+");
            Arrays.stream(wordsLine).forEach(word -> countWords.put(word, 0));
        }

        String pathText = "C:\\IDE\\IdeaProjects\\Streams\\ExStream\\src\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        List<String> allLinesWithText = Files.readAllLines(Path.of(pathText));

        for (String currentLine : allLinesWithText) {
            String [] words = currentLine.split("\\s+");
            Arrays.stream(words).forEach(word -> {
                if (countWords.containsKey(word)) {
                    countWords.put(word, countWords.get(word) + 1);
                }
            });
        }

        PrintWriter printWriter = new PrintWriter("result.txt");
        countWords.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> printWriter.println(entry.getKey() + " - " + entry.getValue()));

        printWriter.close();
    }
}
