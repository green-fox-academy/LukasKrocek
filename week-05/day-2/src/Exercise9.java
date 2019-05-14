import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise9 {
    //Write a Stream Expression to find the frequency of characters in a given string!
    public static void main(String[] args) {
        String example = "aefwnugoeurgbeiojqifughbqilthbwo4vhy45hyvie5u6yniwunvtiu45hyui4";

        Map<String, Long> occurencies =
                Arrays.stream(example.toLowerCase().split(""))
                .collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println(occurencies);
    }
}

