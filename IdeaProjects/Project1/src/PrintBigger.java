import java.util.Scanner;

public class PrintBigger {
    public static void main(String[] args) {
        // Write a program that asks for two numbers and prints the bigger one
        Scanner sc = new Scanner(System.in);
        System.out.println("Give me number");
        int a = sc.nextInt();
        System.out.println("Give me one more");
        int b = sc.nextInt();

        if (a>b){
            System.out.println(a +" is bigger");
        }
            else if (a<b){
            System.out.println(b +" is bigger");
        }
                else {
            System.out.println("number are the same");
        }
    }
}
