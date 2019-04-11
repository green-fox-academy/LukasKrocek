import java.awt.*;

public class Bunnies {
    //We have a number of bunnies and each bunny has two big floppy ears.
    // We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).

    public static void main(String[] args) {
        System.out.println(Counter(100));
    }

    public static int Counter (int numberOfBunnies){
        if (numberOfBunnies<=0){
            return 0;
        }
        int result =2+Counter(numberOfBunnies-1);

        return result;

    }
}
