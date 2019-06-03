import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean con = true;
        Scanner sc = new Scanner(System.in);
        while (con) {

            System.out.println("p = add product , l = add list, d = delete");
            String command = sc.nextLine();
            System.out.println();
            switch (command) {

                case "p":
                    addProduct.add();
                    break;
                case "l":
                    System.out.println("adding list");
                    break;
                case "d":
                    System.out.println("delete product");
                    break;
                default:
                    System.out.println("command not supported");
            }

            System.out.println("Do you want to continue? y/n");

            String answer = sc.nextLine();
            if (answer.equals("n")) {
                con = false;
            }

        }


    }


}

