import java.util.HashMap;

public class StringCounter {

    public HashMap<String, Integer> stringCounter(String text) {
        if (text.length() == 0) {
            return null;
        }

        HashMap<String, Integer> counter = new HashMap<>();
        String[] words = text.split(" ");

        if (words.length == 0) {
            return null;
        }
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
