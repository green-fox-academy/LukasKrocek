import java.util.Arrays;

public class Anagram {

    public boolean isAnagram(String textOne, String textTwo) {
        if (textOne.length() != textTwo.length()) {
            return false;
        }
        textOne = textOne.toLowerCase();
        textTwo = textTwo.toLowerCase();
        char[] arrayTextOne = textOne.toCharArray();
        char[] arrayTextTwo = textTwo.toCharArray();

        Arrays.sort(arrayTextOne);
        Arrays.sort(arrayTextTwo);

        return Arrays.equals(arrayTextOne, arrayTextTwo);
    }
}
