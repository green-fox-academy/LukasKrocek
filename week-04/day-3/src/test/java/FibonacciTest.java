import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTest {
Fibonacci get = new Fibonacci();

   @Test
   public void fibonacciGetter_indexZero_returnsZero (){
       assertEquals(0,get.fibonacciGetter(0));
   }
    @Test
    public void fibonacciGetter_indexOne_returnsOne (){
        assertEquals(1,get.fibonacciGetter(1));
    }
    @Test
    public void fibonacciGetter_indexTwo_returnsOne (){
        assertEquals(1,get.fibonacciGetter(2));
    }
    @Test
    public void fibonacciGetter_indexFour_returnsThree (){
        assertEquals(3,get.fibonacciGetter(4));
    }
    @Test
    public void fibonacciGetter_indexFive_returnsFive (){
        assertEquals(5,get.fibonacciGetter(5));
    }
    @Test
    public void fibonacciGetter_indexSix_returnsEight (){
        assertEquals(8,get.fibonacciGetter(6));
    }
    @Test
    public void fibonacciGetter_indexTwenty_returns6765 (){
        assertEquals(6765,get.fibonacciGetter(20));
    }
}
