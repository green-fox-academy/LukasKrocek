import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise8 {
    //Write a Stream Expression to concatenate a Character list to a string!
    public static void main(String[] args) {
        Character[] array = {('a'), ('b'), ('c')};
        String result =
                Arrays.stream(array)
                        .map(c -> c.toString())
                        .collect(Collectors.joining());
        System.out.println(result);
    }
}
