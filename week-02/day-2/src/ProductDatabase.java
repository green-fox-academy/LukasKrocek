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
        System.out.println("-----------------------");

        int max = 0;
        String maxKeyName = "";
        int min = 1000;
        String minKeyName = "";
        int sum = 0;
        int numberOfProducts = 0;


        for (Map.Entry<String, Integer> product : products.entrySet()
        ) {


            //What is the average price?
            sum += product.getValue();

            //most expensive product
            if (product.getValue() > max) {
                max = product.getValue();
                maxKeyName = product.getKey();
            }

            //number of products more expensive than 300
            if (product.getValue() > 300) {
                numberOfProducts++;
            }

            //Is there anything we can buy for exactly 125?
            if (product.getValue() == 125) {
                System.out.println("For exactly 125 we can buy : " + product.getKey());
            }
            //What is the cheapest product?
            if (product.getValue() < min) {
                min = product.getValue();
                minKeyName = product.getKey();
            }

        }
        System.out.println("Most expensive product is : " + maxKeyName);
        System.out.println("Average price is : " + sum / products.size());
        System.out.println(numberOfProducts + " Products are more expensive than 300");
        System.out.println("Cheapest product is : " + minKeyName);
    }
}
