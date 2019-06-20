public class Power {
    //Given base and n that are both 1 or more, compute recursively (no loops)
    // the value of base to the n power, so powerN(3, 2) is 9 (3 squared).

    public static void main(String[] args) {
        System.out.println(powerItUp(2, 3));
    }

    public static int powerItUp(int base, int n) {

        if (base < 1 || n < 1) {
            return 1;
        }


        return base * powerItUp(base, n - 1);

    }
}
