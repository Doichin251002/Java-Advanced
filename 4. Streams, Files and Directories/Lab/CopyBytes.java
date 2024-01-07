import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws FileNotFoundException {
        String basePath = "C:\\Users\\dodi_\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\copyOutput.txt";

        try (InputStream inputStream = new FileInputStream(inputPath);
             OutputStream outputStream = new FileOutputStream(outputPath)) {
            int readChar = inputStream.read();

            while (readChar >= 0) {
                if (readChar != ' ' && readChar != '\n') {
                    String number = String.valueOf(readChar);

                    for (int i = 0; i < number.length(); i++) {
                        outputStream.write(number.charAt(i));
                    }
                } else {
                    outputStream.write(readChar);
                }
                readChar = inputStream.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
