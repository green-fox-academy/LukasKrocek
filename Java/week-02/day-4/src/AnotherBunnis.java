public class AnotherBunnis {
    /*We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..)
    have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot.
     Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
     */

    public static void main(String[] args) {
        System.out.println(counter(10));
    }

    public static int counter(int numberOfBunnies) {
        int result;
        if (numberOfBunnies <= 0) {
            return 0;

        } else if (numberOfBunnies % 2 == 0) {
            result = 3 + counter(numberOfBunnies - 1);
        } else result = 2 + counter(numberOfBunnies - 1);
        return result;
    }
}
