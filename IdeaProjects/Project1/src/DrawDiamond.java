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

        //upper part of diamond
        for (int i = 0; i <size-1 ; i++) {

            //spaces
            for (int j = size;  j> i+2; j--) {

                    System.out.print(" ");

            }
             //symbol
            for (int j = 0; j < i; j++) {
                System.out.print(symbol);

            }
            //right side of symbols
            for (int j = 0; j < i-1; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
        // End of upper part

        // Start of lower part

        for (int i = 0; i < size-3; i++) {

            //spaces
            for (int j = 0; j < i+1; j++) {
                System.out.print(" ");
            }

            //symbols
            for (int j = size-1;  j> i+3; j--) {

                System.out.print(symbol);
            }


            //right side
            for (int j = size;  j> i+3; j--) {

                System.out.print(symbol);
            }

            System.out.println();
    }


    }
}
