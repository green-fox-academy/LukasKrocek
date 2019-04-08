import java.util.Scanner;

public class Palindrom {

    public static void main(String[] args) {
        System.out.println("Please enter you word");
        Scanner sc = new Scanner(System.in);
        System.out.println(PalindromMaker(sc.nextLine()));


    }




    public static char [] PalindromMaker(String a) {
        char[] word = a.toCharArray();
        char [] reverse = word;

        //making reverse
        for (int i = 0; i < reverse.length / 2; i++) {
            char temp = word[i];
            reverse[i] = word[word.length - i - 1];
            reverse[word.length - i - 1] = temp;

            
        }






        return reverse;

    }
}