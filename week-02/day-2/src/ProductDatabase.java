import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {
    /*
    We are going to represent our products in a map where the keys are strings
     representing the product's name and the values are numbers representing the product's price.

Create a map with the following key-value pairs.
Product name (key)	Price (value)

Create an application which solves the following problems.

What is the average price?
How many products' price is below 300?
Is there anything we can buy for exactly 125?
What is the cheapest product?
     */
    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Eggs", 200);
        products.put("Milk", 200);
        products.put("Fish", 400);
        products.put("Apples", 150);
        products.put("Bread", 50);
        products.put("Chicken", 550);
        //How much is the fish?
        System.out.println(products.get("Fish"));
        //What is the most expensive product?


    }

}
