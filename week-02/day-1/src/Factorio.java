public class Factorio {

//  Create the usual class wrapper
//  and main method on your own.

// - Create a function called `factorio`
//   that returns it's input's factorial

    public static void main(String[] args) {

        System.out.println(factorio(4));

    }

    public static int factorio(int a) {
        int factorial = 1;
        for (int i = 0; i < a; i++) {
            factorial *= i + 1;
        }
        return factorial;
    }
}
