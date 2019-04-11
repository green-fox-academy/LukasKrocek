import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelephoneBook {
    /*

Create an application which solves the following problems.
What is John K. Miller's phone number?
Whose phone number is 307-687-2982?
Do we know Chris E. Myers' phone number?
     */

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        boolean con = true;
        while (con) {
            con = false;
            System.out.println("Do you wanna search by number of name?");
            String answer = sc.nextLine();

            if (answer.equals("name")) {
                System.out.println("You need phone number for? [Enter full name]");
                String name = sc.nextLine();
                System.out.println(getNumber(name));

            } else if (answer.equals("number")) {

                System.out.println("Enter phone number : ");
                String phone = sc.nextLine();
                System.out.println(getName(phone));

            } else {
                System.out.println("Sorry, but I dont understand. Please try again.");
                con = true;
            }
        }
    }

    public static String getNumber(String name) {
        HashMap<String, String> phones = new HashMap<>();
        phones.put("William A. Lathan", "405-709-1865");
        phones.put("John K. Miller", "402-247-8568");
        phones.put("Hortensia E. Foster", "606-481-6467");
        phones.put("Amanda D. Newland", "319-243-5613");
        phones.put("Brooke P. Askew", "307-687-2982");


        if (phones.get(name) == null) {
            return name + " is not in our Telephone Book";
        } else {
            return phones.get(name);
        }
    }

    public static String getName(String phoneNumber) {
        HashMap<String, String> phones = new HashMap<>();
        phones.put("William A. Lathan", "405-709-1865");
        phones.put("John K. Miller", "402-247-8568");
        phones.put("Hortensia E. Foster", "606-481-6467");
        phones.put("Amanda D. Newland", "319-243-5613");
        phones.put("Brooke P. Askew", "307-687-2982");

        String name = "not found";
        if (!phones.containsValue(phoneNumber)) {
            return phoneNumber + " is not in our Book";
        } else {
            for (Map.Entry <String, String> contact : phones.entrySet()) {
                if (contact.getValue().equals(phoneNumber)) {
                    name = contact.getKey();

                }
            }
            return name;
        }
    }
}