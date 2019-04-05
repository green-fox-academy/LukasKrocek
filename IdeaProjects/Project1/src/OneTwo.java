import java.util.Scanner;

public class OneTwo {

    // Write a program that reads a number form the standard input,
// If the number is zero or smaller it should print: Not enough
// If the number is one it should print: One
// If the number is two it should print: Two
// If the number is more than two it should print: A lot
    public static void main(String[] args) {

        //Getting number
        Scanner sc = new Scanner(System.in);
        System.out.println("Give me number");
        int givenHumber = sc.nextInt();

        //condition printer

        if (givenHumber <= 0) {
            System.out.println("Not enough");
        } else if (givenHumber == 1) {
            System.out.println("one");
        } else if (givenHumber == 2) {
            System.out.println("two");
        } else {
            System.out.println("a lot");
        }
    }
}