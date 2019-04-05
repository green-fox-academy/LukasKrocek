import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give me number");
        int size = sc.nextInt();

        //PYRAMID LOOP
        for (int i = 0; i < size; i++) {
            //spaces
            for (int j = size; j > i; j--) {
                System.out.print(" ");

            }

            //symbols
            for (int j = 0; j < i; j++) {
                System.out.print("*");

            }

            // symbols on right
            for (int j = 0; j < i-1; j++) {
                System.out.print("*");

            }

            //lines
            System.out.println();
        }
    }
}
