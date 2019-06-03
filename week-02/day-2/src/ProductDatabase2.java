import java.util.HashMap;
import java.util.Map;

public class ProductDatabase2 {
    public static void main(String[] args) {
        HashMap<String, Integer> ProductsMap = new HashMap<>();
        ProductsMap.put("Eggs", 200);
        ProductsMap.put("Milk", 200);
        ProductsMap.put("Fish", 400);
        ProductsMap.put("Apples", 150);
        ProductsMap.put("Bread", 50);
        ProductsMap.put("Chicken", 550);

        //Create an application which solves the following problems.
        //Which ProductsMap cost less than 201? (just the name)
        //Which ProductsMap cost more than 150? (name + price)

        for (Map.Entry<String, Integer> product : ProductsMap.entrySet()
        ) {
            if (product.getValue() < 201) {
                System.out.println(product.getKey());
            }
            if (product.getValue() > 150) {
                System.out.println(product);
            }


        }
    }
}
