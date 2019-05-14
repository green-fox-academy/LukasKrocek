import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Exercise5 {
    //Write a Stream Expression to get the sum of the odd numbers in the following list:
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
        IntSummaryStatistics stats =
                numbers.stream()
                        .filter(n -> n % 2 != 0)
                        .mapToInt(Integer::intValue)
                        .summaryStatistics();
        System.out.println(stats.getSum());
    }
}
