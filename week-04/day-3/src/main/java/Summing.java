import java.util.List;

public class Summing {
    List <Integer> numbers;
    Summing (List <Integer> numbers){
        this.numbers = numbers;
    }

    public int sumOfIntegers() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
