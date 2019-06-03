import org.junit.*;

import static org.junit.Assert.*;

public class AnagramTest {

    @Test
    public void isAnagram_compareTwoAnagrams_returnTrue() {
        Anagram anagram = new Anagram();
        String one = "moh";
        String two = "hom";
        assertEquals(true, anagram.isAnagram(one, two));

    }

    @Test
    public void isAnagram_compareSameLengthNoAnagrams_returnFalse() {
        Anagram anagram = new Anagram();
        String one = "mohsd";
        String two = "homrf";
        assertEquals(false, anagram.isAnagram(one, two));

    }

    @Test
    public void isAnagram_compareDifferentLengthStrings_returnFalse() {
        Anagram anagram = new Anagram();
        String one = "mohsdwd";
        String two = "homrf";
        assertEquals(false, anagram.isAnagram(one, two));

    }

    @Test
    public void isAnagram_compareAnagramsWithDifferentCasing_returnTrue() {
        Anagram anagram = new Anagram();
        String one = "moH";
        String two = "hOM";
        assertEquals(true, anagram.isAnagram(one, two));

    }
}
