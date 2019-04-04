import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        // If the second number is not bigger than the first one it should print:
// "The second number should be bigger"
//
// If it is bigger it should count from the first number to the second by one

        Scanner scanner = new Scanner(System.in);
        System.out.println ("Enter first number");
        int firstNumber = scanner.nextInt();
        System.out.println ("Enter second number");
        int secondNumber = scanner.nextInt();
        if (firstNumber>secondNumber){
            System.out.println("The second number should be bigger");
        }
        else {
            for (int i = firstNumber; i < secondNumber; i++) {
                System.out.print(i);

            }
        }
    }
}
