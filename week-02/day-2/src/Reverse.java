import java.util.Arrays;

public class Reverse {
    public static void main(String... args) {
        String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

        // Create a method that can reverse a String, which is passed as the parameter
        // Use it on this reversed string to check it!
        // Try to solve this using charAt() first, and optionally anything else after.


        System.out.println(reverse(reversed));
    }

    public static String reverse(String word) {
        char[] reversed = word.toCharArray();
        for (int i = 0; i < reversed.length / 2; i++) {
            char temp = reversed[i];
            reversed[i] = reversed[reversed.length - i - 1];
            reversed[reversed.length - i - 1] = temp;
        }
        String finalReverse = new String(reversed);

        return finalReverse;
    }
}