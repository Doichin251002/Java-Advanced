import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String pathFolder = "C:\\IDE\\IdeaProjects\\Streams\\ExStream\\src\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(pathFolder);

        File [] allFilesInFolder = folder.listFiles();

        int folderSize = 0;
        if (allFilesInFolder != null) {
            for (File file : allFilesInFolder) {
                folderSize += file.length();
            }
        }
        System.out.println("Folder size: " + folderSize);
    }
}
