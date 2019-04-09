import java.lang.reflect.Array;
import java.util.Scanner;


public class Palindrom {

    public static void main(String[] args) {
        System.out.println("Please enter you word");
        Scanner sc = new Scanner(System.in);
        System.out.println(PalindromMaker(sc.nextLine()));


    }


    public static String PalindromMaker(String a) {
        String word = a;
        char[] reverse = word.toCharArray();


        //making reverse
        for (int i = 0; i < reverse.length / 2; i++) {
            char temp = reverse[i];
            reverse[i] = reverse[reverse.length - i - 1];
            reverse[reverse.length - i - 1] = temp;
        }

        //making palindrom
        String palindrom = "";
        if (word.equals(new String(reverse))){
            palindrom = word;
        } else {
            palindrom = word + new String(reverse);
        }


        return palindrom;

    }
}