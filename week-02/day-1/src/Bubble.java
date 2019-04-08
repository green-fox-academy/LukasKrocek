import java.util.Arrays;

public class Bubble {
    //  Create a function that takes a list of numbers as parameter
    //  Returns a list where the elements are sorted in ascending numerical order
    //  Make a second boolean parameter, if it's `true` sort that list descending

    //  Example:
    //System.out.println(bubble(new int[] {34, 12, 24, 9, 5}));
    //  should print [5, 9, 12, 24, 34]
    //System.out.println(advancedBubble(new int[] {34, 12, 24, 9, 5}, true));
    //  should print [34, 24, 12, 9, 5]

    public static void main(String[] args) {
        System.out.println(bubble(new int[]{34, 12, 24, 9, 5}));
        System.out.println(advancedBubble(new int[]{34, 12, 24, 9, 5}, true));

    }


    public static String bubble(int[] a) {

        Arrays.sort(a);
        String sortedStringArray = "";
        for (int i = 0; i < a.length; i++) {
            sortedStringArray += a[i] + " , ";
        }

        return sortedStringArray;
    }

    public static String advancedBubble(int[] a, boolean b) {
        String sortedStringArray = "";
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            sortedStringArray += a[i] + " , ";
        }
        if (b == true) {
            sortedStringArray = "";
            for (int i = 0; i < a.length / 2; i++) {
                int temp = a[i];
                a[i] = a[a.length - i - 1];
                a[a.length - i - 1] = temp;

            }
            for (int i = 0; i < a.length; i++) {
                sortedStringArray += a[i] + " , ";
            }
        }
            return sortedStringArray;

        }


    }



