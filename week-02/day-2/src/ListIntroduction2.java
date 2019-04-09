import java.util.ArrayList;
import java.util.Arrays;

public class ListIntroduction2 {
    /*
    Add Passion Fruit and Pummelo to List B in a single statement
    Print out the 3rd element from List A
     */

    public static void main(String[] args) {
        ArrayList <String> listA = new ArrayList<>(Arrays.asList("Apple", "Avocado", "Blueberries", "Durian", "Lyches"));
        ArrayList <String> listB = listA;
        System.out.println(listA.contains("Durian"));
        listB.remove("Durian");
        listA.add(4, "Kiwifruit");
        System.out.println("size of list A: " + listA.size());
        System.out.println("size of list B: " + listB.size());

        System.out.println(listA.indexOf("Avocado"));
        System.out.println(listB.indexOf("Durian"));

        ArrayList <String> newAnimals = new ArrayList<>(Arrays.asList("Passion Fruit","Pommelo"));
        listB.addAll(newAnimals);

        System.out.println(listA.get(2));

        System.out.println("-------------------------------------");

        for (String fruitA:listA
             ) {
            System.out.println(fruitA);
        }

        System.out.println("-------------------------------------");

        for (String fruitB:listB
        ) {
            System.out.println(fruitB);
        }
    }
}
