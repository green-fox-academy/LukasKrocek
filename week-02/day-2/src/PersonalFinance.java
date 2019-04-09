import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PersonalFinance {
    /*
    Create a list with the following items.
500, 1000, 1250, 175, 800 and 120
Create an application which solves the following problems.
How much did we spend?
Which was our greatest expense?
Which was our cheapest spending?
What was the average amount of our spendings?
     */

    public static void main(String[] args) {
        ArrayList<Integer> finance = new ArrayList<>(Arrays.asList(500, 1000, 1250, 175, 800, 120));
        int sum = 0;
        for (int i = 0; i < finance.size(); i++) {
            sum += finance.get(i);
        }
        System.out.println("We spend : " + sum);
        System.out.println("Greatest expense : " + Collections.max(finance));
        System.out.println("Cheapest expense : " + Collections.min(finance));
        System.out.println("Average amount : " + sum / finance.size());


    }


}
