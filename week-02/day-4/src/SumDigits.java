public class SumDigits {

    //Given a non-negative int n, return the sum of its digits recursively (no loops).
    // Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

    public static void main(String[] args) {
        System.out.println(SumDigits(125));
    }

    public static int SumDigits(int number) {
        if (number < 1) {
            return 0;

        }

        return number % 10 + SumDigits(number / 10);
    }
}
