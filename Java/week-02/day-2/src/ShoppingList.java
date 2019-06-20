import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShoppingList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Is it in the list?");
        System.out.println(ListCheck(sc.nextLine()));

    }

    public static String ListCheck(String check) {
        ArrayList<String> shoppingList = new ArrayList<>(Arrays.asList("Eggs", "milk", "fish", "apples", "bread", "chicken"));

        if (shoppingList.contains(check)) {
            return "it is on the list";
        } else {
            return "not in the list";
        }
    }
}
