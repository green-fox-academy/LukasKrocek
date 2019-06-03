public class CommonDivisor {

    //Find the greatest common divisor of two numbers using recursion.

    public static void main(String[] args) {
        System.out.println(greatestDivisor(222, 20));


    }

    public static int greatestDivisor(int a, int b) {
        if (b == 0)
            return a;
        else
            return greatestDivisor(b, a % b);
    }
}

