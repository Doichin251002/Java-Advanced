import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\dodi_\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\3LineOutput.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {

            int lineCount = 1;
            String line = reader.readLine();

            while (line != null) {
                if (lineCount % 3 == 0) {
                    writer.println(line);
                }

                line = reader.readLine();
                lineCount++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
