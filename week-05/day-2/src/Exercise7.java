import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise7 {
    //Write a Stream Expression to find the strings which starts with a given letter(as parameter)
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first letter of the city");
        String firstLetter = sc.nextLine().toUpperCase();
        List<String> citiesWithSameFirstLetter =
                cities.stream()
                        .filter(city -> city.startsWith(firstLetter))
                        .collect(Collectors.toList());
        System.out.println(citiesWithSameFirstLetter);
    }
}
