import java.util.Scanner;

public class ParameticAverage {
    public static void main(String[] args) {
        // Write a program that asks for a number.
        // It would ask this many times to enter an integer,
        // if all the integers are entered, it should print the sum and average of these
        // integers like:
        //
        // Sum: 22, Average: 4.4
        Scanner sc = new Scanner(System.in);
        int b;
        int sum = 0;
        float average = 0;
        int numberOfNumbers = 3;

        for (int i = 0; i < numberOfNumbers; i++) {

            System.out.println("Enter "+ (i+1) +". Number: ");
            b = sc.nextInt();
            sum += b;
        }
        average= (float)sum/numberOfNumbers;
        System.out.println("sum: "+ sum);
        System.out.println("average:"+ average);



    }
}
