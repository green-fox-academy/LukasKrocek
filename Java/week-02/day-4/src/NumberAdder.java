public class NumberAdder {
    //Write a recursive function that takes one parameter: n and adds numbers from 1 to n.

    public static void main(String[] args) {
        System.out.println(Adder(4));
    }

    public static int Adder(int number) {
        int result;

        if (number < 1) {
            return 0;

        }

        result = Adder(number - 1) + number;

        return result;

    }
}
