public class Summing {
    // Create the usual class wrapper and main method on your own.

    // Write a function called `sum` that returns the sum of numbers from zero to the given parameter
    public static void main(String[] args) {
        System.out.println(sum(2));
    }

    public static int sum(int a) {

        int sum = 0;
        for (int i = 0; i < a + 1; i++) {

            sum += i;
        }

        return sum;
    }
}
