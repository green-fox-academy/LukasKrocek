public class CommonDivisor {

    //Find the greatest common divisor of two numbers using recursion.

    public static void main(String[] args) {
        System.out.println(GreatestDivisor(222,20));



    }

    public static int GreatestDivisor (int a, int b) {
        if (b==0)
            return a;
        else
            return GreatestDivisor(b, a % b);
    }
}

