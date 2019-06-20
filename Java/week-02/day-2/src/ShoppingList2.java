import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingList2 {
    public static HashMap<String, Object> list = new HashMap<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean keepGoing = true;
        while (keepGoing) {
            String nextCommand = command();
            switch (nextCommand) {
                case "q":
                    keepGoing = false;
                    break;
                case "p":
                    addProduct();
                    break;
                case "l":
                    System.out.println("adding list");
                    break;
                case "d":
                    deleteProduct();
                    break;
                case "s":
                    showList();
                    break;
                default:
                    System.out.println("command not supported");

            }


        }


    }

    public static String command() {
        System.out.println("---COMMAND LINE-----");
        System.out.println("p - to add new product");
        System.out.println("s - to show list of products");
        System.out.println("d - to delete product");
        System.out.println("q - tp quit");
        return sc.nextLine();
    }

    public static void addProduct() {
        System.out.println("Enter name of the product");
        String productName = sc.nextLine();
        System.out.println("Enter it's price");
        Double price = sc.nextDouble();
        list.put(productName, price);

    }

    public static void showList() {
        System.out.println(list);

    }

    public static void deleteProduct() {
        System.out.println("Enter product name");
        String toDelete = sc.nextLine();
        String notFound = "Not found in the list";
        for (Map.Entry<String, Object> product : list.entrySet()) {
            if (product.getKey().equals(toDelete)) {
                list.remove(product);
                System.out.println(product.getKey() + " was deleted");
                notFound = "";
            }
        }
        if (notFound.equals("Not found in the list")) {
            System.out.println(notFound);
        }
    }


}
