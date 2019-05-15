import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise10 {
    public static void main(String[] args) {
        List<Fox> foxFarm = new ArrayList<>();
        foxFarm.add(new Fox("fox1", "orange", 5));
        foxFarm.add(new Fox("fox2", "green", 10));
        foxFarm.add(new Fox("fox3", "yellow", 15));
        foxFarm.add(new Fox("fox4", "green", 3));
        foxFarm.add(new Fox("fox5", "white", 7));

        List<Fox> greenFoxes =
                foxFarm.stream()
                        .filter(fox -> fox.getColor() == "green")
                        .collect(Collectors.toList());
        System.out.println(greenFoxes);

        List<Fox> youngGreenFoxes =
                foxFarm.stream()
                        .filter(fox -> fox.getColor() == "green" && fox.getAge() < 5)
                        .collect(Collectors.toList());
        System.out.println(youngGreenFoxes);

        Map<String, Long> foxesByColor =
                foxFarm.stream()
                        .collect(Collectors.groupingBy(fox -> fox.getColor(), Collectors.counting()));
        System.out.println(foxesByColor);
    }
}
