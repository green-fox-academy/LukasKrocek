import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class StringCounterTest {


    @Test
    public void countWords_InNormalText_returnsCountOfWords() {
        StringCounter counter = new StringCounter();
        String text = "Ho Ho Ho guys Ho";
        HashMap<String, Integer> checkMap = new HashMap<>();
        checkMap.put("Ho", 4);
        checkMap.put("guys", 1);
        assertEquals(checkMap, counter.countWords(text));
    }

    @Test
    public void countWords_InTextWithWhiteSpaces_returnsCountOfWords() {
        StringCounter counter = new StringCounter();
        String text = "    Ho     Ho      Ho      guys Ho        ";
        HashMap<String, Integer> checkMap = new HashMap<>();
        checkMap.put("Ho", 4);
        checkMap.put("guys", 1);
        assertEquals(checkMap, counter.countWords(text));
    }

    @Test
    public void countWords_InEmptyStrings_returnsNull() {
        StringCounter counter = new StringCounter();
        String text = "";
        assertEquals(null, counter.countWords(text));
    }

    @Test
    public void countWords_InOnlyWhiteSpaceStrings_returnsNull() {
        StringCounter counter = new StringCounter();
        String text = "             ";
        assertEquals(null, counter.countWords(text));
    }

    @Test
    public void countWords_InOneWordString_returnsCountOfWord() {
        StringCounter counter = new StringCounter();
        String text = "Ho";
        HashMap<String, Integer> checkMap = new HashMap<>();
        checkMap.put("Ho", 1);
        assertEquals(checkMap, counter.countWords(text));
    }

}
