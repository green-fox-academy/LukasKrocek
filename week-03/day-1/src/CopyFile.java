import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    // Write a function that copies the contents of a file into another
    // It should take the filenames as parameters
    // It should return a boolean that shows if the copy was successful
    public static void main(String[] args) {
        boolean copied = copyPaste("WriteMultipleLines.txt", "my-file.txt");
        System.out.println(copied);
    }

    public static boolean copyPaste(String copiedFile, String targetFile) {
        boolean copied = true;
        List<String> copy = new ArrayList<>();

        try {
            Path copyPath = Paths.get(copiedFile);
            copy = Files.readAllLines(copyPath);
            Path targetPath = Paths.get(targetFile);
            Files.write(targetPath, copy);
        } catch (IOException e) {
            copied = false;
        }
        return copied;
    }
}
