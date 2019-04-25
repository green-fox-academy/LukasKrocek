import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class SummingTest {

    List<Integer> numbers;

    @Before
    public void beforeTest() {
        numbers = new ArrayList<>();
    }

    @After
    public void afterTest() {
        numbers = null;
    }

    @Test
    public void SumOfIntegers_returnSumOf23_equals5() {
        numbers.add(2);
        numbers.add(3);
        Summing sum23 = new Summing(numbers);

        assertEquals(2 + 3, sum23.sumOfIntegers());
    }

    @Test
    public void SumOfIntegers_returnSumOfEmptyList_equals0() {
        Summing sum = new Summing(numbers);

        assertEquals(0, sum.sumOfIntegers());
    }

    @Test
    public void SumOfIntegers_returnSumOfOneElement_equalsElement() {
        int element = 3;
        numbers.add(element);
        Summing sum = new Summing(numbers);

        assertEquals(element, sum.sumOfIntegers());
    }
}
