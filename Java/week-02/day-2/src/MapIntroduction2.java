import java.util.HashMap;

public class MapIntroduction2 {
    /*
Map introduction 2
Create a map where the keys are strings and the values are strings with the following initial values

Key	Value
978-1-60309-452-8	A Letter to Jo
978-1-60309-459-7	Lupus
978-1-60309-444-3	Red Panda and Moon Bear
978-1-60309-461-0	The Lab
Print all the key-value pairs in the following format

A Letter to Jo (ISBN: 978-1-60309-452-8)
Lupus (ISBN: 978-1-60309-459-7)
Red Panda and Moon Bear (ISBN: 978-1-60309-444-3)
The Lab (ISBN: 978-1-60309-461-0)
Remove the key-value pair with key 978-1-60309-444-3

Remove the key-value pair with value The Lab

Add the following key-value pairs to the map

Key	Value
978-1-60309-450-4	They Called Us Enemy
978-1-60309-453-5	Why Did We Trust Him?
Print whether there is an associated value with key 478-0-61159-424-8 or not

Print the value associated with key 978-1-60309-453-5
     */

    public static void main(String[] args) {
        HashMap<String, String> secondMap = new HashMap<>();
        secondMap.put("978-1-60309-452-8", "A Letter to Jo");
        secondMap.put("978-1-60309-459-7", "Lupus");
        secondMap.put("978-1-60309-444-3", "Red Panda and Moon Bear");
        secondMap.put("978-1-60309-461-0", "The Lab");

        for (String key : secondMap.keySet()) {
            System.out.println(secondMap.get(key) + " (ISBN: " + key);
        }

        secondMap.remove("978-1-60309-444-3");

        secondMap.remove(secondMap.containsValue("The Lab"));

        secondMap.put("978-1-60309-450-4", "They Called Us Enemy");
        secondMap.put("978-1-60309-453-5", "Why Did We Trust Him?");

        System.out.println(secondMap.get("478-0-61159-424-8"));
        System.out.println(secondMap.get("978-1-60309-453-5"));


    }
}
