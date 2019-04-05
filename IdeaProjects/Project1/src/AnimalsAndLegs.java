import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {
        // Write a program that asks for two integers
        // The first represents the number of chickens the farmer has
        // The second represents the number of pigs owned by the farmer
        // It should print how many legs all the animals have

        Scanner sc = new Scanner(System.in);
        System.out.println("How many chickens farmer has? HOW MANY?");
        int chickens = sc.nextInt();
        System.out.println("Great! How many pigs?");
        int pigs = sc.nextInt();
        int legs = chickens * 2 + pigs * 4;

        System.out.println("Guess, how many legs they have together?");
        int legGuess = sc.nextInt();

        if (legGuess == legs) {
            System.out.println("You are right, you little genius!");
        } else {
            System.out.println("nope, its: " + legs);

        }
    }
}