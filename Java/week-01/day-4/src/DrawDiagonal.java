import java.util.Scanner;

public class DrawDiagonal {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // square like this:
        //
        //
        // %%%%%
        // %%  %
        // % % %
        // %  %%
        // %%%%%
        //
        // The square should have as many lines as the number was
        System.out.println("input your number");
        Scanner sc = new Scanner(System.in);
        int pickedNumber = sc.nextInt();

        for (int i = 0; i < pickedNumber; i++) {
            for (int j = 0; j < pickedNumber; j++) {
                if (i == 0 || j == 0 || i == pickedNumber - 1 || j == pickedNumber - 1 || j == i) {
                    System.out.print("&");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }

    }
}
