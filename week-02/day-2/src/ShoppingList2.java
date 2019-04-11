import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingList2 {

    public static void main(String[] args) {
        boolean con = true;
        while (con) {
            HashMap <String, Double> products = new HashMap<>();
            products.entrySet();

            System.out.println("Do you want to add another product? y/n");
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine();
            if (answer.equals("n")){
                con = false;
            }
        }

    }
    public static Map.Entry<String, Double> addProduct (){
        Scanner sc = new Scanner(System.in);
        String productName = "";
        Double price;

        System.out.println("Enter name of the product");
        productName = sc.nextLine();
        System.out.println("Enter it's price");
        price = sc.nextDouble();
        HashMap <String, Double> product = new HashMap<>();
        product.put(productName,price);
        return product;
    }

}
