import java.util.HashMap;
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
        System.out.println("You need phone number for? [Enter full name]");
        String name = sc.nextLine();
        System.out.println(getNumber(name));

        System.out.println("Enter phone number : ");
        String phone = sc.nextLine();
        System.out.println(getName(phone));
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
        String phone = "";
        HashMap<String, String> phones = new HashMap<>();
        phones.put("William A. Lathan", "405-709-1865");
        phones.put("John K. Miller", "402-247-8568");
        phones.put("Hortensia E. Foster", "606-481-6467");
        phones.put("Amanda D. Newland", "319-243-5613");
        phones.put("Brooke P. Askew", "307-687-2982");

     /*   if(phones.containsValue(phoneNumber)){
            ?????
            return ;

        } else */return "Number is not in our phone book";
    }


}
