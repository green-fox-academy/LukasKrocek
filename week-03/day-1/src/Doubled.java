import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Doubled {
    // Create a method that decrypts the duplicated-chars.txt
    public static void main(String[] args) {
        System.out.println(decrypt("Duplicated-chars.txt"));
    }

    public static ArrayList decrypt(String pathToFile) {
        List<String> input;
        ArrayList<String> decryptedInput = new ArrayList<>();

        try {
            Path path = Paths.get(pathToFile);
            input = Files.readAllLines(path);
            for (String line : input) {
                char[] lineArray = line.toCharArray();
                for (int i = 0; i < line.length() - 1; i++) {
                    if (line.charAt(i) == line.charAt(i + 1)) {
                        lineArray[i] = ' ';
                    }
                }
                String decryptedLine = new String(lineArray);
                decryptedInput.add(decryptedLine);
            }
        } catch (IOException e) {
            System.out.println(pathToFile + " : not found");
        }

        return decryptedInput;
    }
}
