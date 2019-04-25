import java.util.Arrays;
import java.util.HashMap;

public class StringCounter {

    public HashMap<String, Integer> countWords(String text) {
        if (text.length() == 0) {
            return null;
        }
        HashMap<String, Integer> counter = new HashMap<>();
        text = text.trim();
        while (text.contains("  ")) { //getting rid off additional whitespaces
            text = text.replaceAll("  ", " ");
        }

        if (text.equals("")) { //only whitespace, returns null
            return null;
        }

        String[] words = text.split(" ");

        for (String word : words) {
            if (counter.containsKey(word)) {
                counter.put(word, counter.get(word) + 1);
            } else {
                counter.put(word, 1);
            }
        }
        return counter;
    }
}
