import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class addProduct {
    public static ArrayList<HashMap<String, Object>> storage = new ArrayList<>();

    public static HashMap add() {
        Scanner sc = new Scanner(System.in);
        String productName;
        Double price;

        System.out.println("Enter name of the product");
        productName = sc.nextLine();
        System.out.println("Enter it's price");
        price = sc.nextDouble();
        HashMap<String, Object> firstList = new HashMap<>();
        firstList.put(productName, price);


        return firstList;

    }
}
