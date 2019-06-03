public class Strings {
    //Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.

    public static void main(String[] args) {
        System.out.println(Change("xaxaxa"));
    }

    public static String Change(String word) {

        if (!word.contains("x")) {
            return word;
        }

        return Change(word.replace('x', 'y'));
    }


}
