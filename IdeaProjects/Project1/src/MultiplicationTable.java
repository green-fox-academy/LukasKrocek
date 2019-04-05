import java.sql.SQLOutput;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number you want to multiply");
        int input = scanner.nextInt();
        for (int i = 0; i < 21; i++) {
            int result = i * input;
            System.out.println(i + " * " + input + " = " + result);

        }
    }
}
