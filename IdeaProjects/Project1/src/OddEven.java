import java.util.Scanner;

public class OddEven {
    // Write a program that reads a number from the standard input,
    // Then prints "Odd" if the number is odd, or "Even" if it is even.
    public static void main(String[] args) {

        //trying while loop
        int endOfProgram = 1;
        Scanner sc = new Scanner(System.in);
        while (endOfProgram == 1) {
            //getting number

            System.out.println("Gimme number!");
            int givenNumber = sc.nextInt();

            // condition printer
            if (givenNumber % 2 == 0) {
                System.out.println("We are even bro!");
            } else {
                System.out.println("you are odd, just like your number!");
            }
            System.out.println();
            System.out.println();

            System.out.println("Wanna try it again, maaaan?");
            System.out.println("if yes type 1, if not type any other number and be free to go");
            endOfProgram = sc.nextInt();
        }
    }
}