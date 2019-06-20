public class Fibonacci {

    public int fibonacciGetter(int index) {
        if (index < 2) {
            return index;
        }
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;
        for (int i = 1; i < index; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }

        return n3;
    }
}
