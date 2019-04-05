import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
// diamond like this:
//
//
//    *
//   ***
//  *****
// *******
//  *****
//   ***
//    *
//
// The diamond should have as many lines as the number was

        System.out.println("Enter your number");
        Scanner sc = new Scanner (System.in);
        int size = sc.nextInt();


        String symbol = "k";
        int increment =0;

        //upper part of diamond works

        //lines
        for (int i = 0; i < size/2+1; i++) {
            //spaces
            for (int j = size/2; j > i; j--) {
                System.out.print(" ");
            }

            //symbols
            for (int j = 0; j < i+increment+1; j++) {
                System.out.print("*");
            }


            increment++;
            System.out.println();
        }
        // End of upper part


        // Start of lower part

        int decrement = size/2;

        // Lines
        for (int i = 0; i < size/2; i++) {

            //spaces
            for (int j = 0; j < i+1; j++) {
                System.out.print(" ");
            }

            //symbols
            for (int j = size/2; j > i-decrement+1; j--) {
                System.out.print(symbol);
            }

             decrement--;
            System.out.println();
    }


    }
}
