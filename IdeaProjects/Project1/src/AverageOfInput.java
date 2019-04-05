import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args) {
        // Write a program that asks for 5 integers in a row,
        // then it should print the sum and the average of these numbers like:
        //
        // Sum: 22, Average: 4.4
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter 5 awesome numbers. Press enter after each one of them (I know... life is hard)");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        int sum = a + b + c + d + e;
        float average = sum / 5f;

        System.out.println("Sum of your awesome numbers is " + sum + ". And it's average is " + average);
    }
}
