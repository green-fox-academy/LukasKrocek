

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("first word: ");
        String firstWord = sc.nextLine();

        System.out.println("second word: ");
        String secondWord = sc.nextLine();


        char [] firstArray = firstWord.toCharArray();
        char [] secondArray = secondWord.toCharArray();
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        System.out.println(firstArray);
        System.out.println(secondArray);



        if (firstArray == secondArray){
            System.out.println("true");
        } else {
            System.out.println("false");
        }


    }
}
