import java.util.ArrayList;

public class ListIntroduction {
    /*
    Create an empty list which will contain names (strings)
    Print out the number of elements in the list
    Add William to the list
    Print out whether the list is empty or not
    Add John to the list
    Add Amanda to the list
    Print out the number of elements in the list
    Print out the 3rd element
    Iterate through the list and print out each name
     */

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        System.out.println(names.size());
        names.add("William");
        boolean empty = names.isEmpty();
        System.out.println(empty);
        names.add("John");
        names.add("Amanda");
        System.out.println(names.size());
        System.out.println(names.get(2));

        for (String name : names) {
            System.out.println(name);
        }
    }


}
