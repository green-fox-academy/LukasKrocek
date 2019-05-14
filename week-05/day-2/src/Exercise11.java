import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Create a Stream expression which reads all text from this file, and prints the 100 most common words
// in descending order. Keep in mind that the text contains punctuation characters which should be ignored.
public class Exercise11 {
    public static void main(String[] args) {
        try {
            Path filePath = Paths.get("wiki.txt");
            Map<String, Long> occurencies =
                    Files.readAllLines(filePath).stream()
                            .map(w -> w.split(" ")).flatMap(Arrays::stream)
                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(occurencies);
        } catch (IOException e) {
            System.out.println("cannot read");
        }
    }
}
