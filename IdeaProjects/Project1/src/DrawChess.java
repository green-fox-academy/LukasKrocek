import java.util.Scanner;

public class DrawChess {
    public static void main(String[] args) {
        System.out.println("How many fields you want?");
        Scanner sc = new Scanner (System.in);
        int numberOfFields = sc.nextInt();
        for (int i = 0; i < numberOfFields; i++) {
            for (int j = 0; j < numberOfFields; j++) {
                if (j % 2 == 0 && i%2 ==0) {
                    System.out.print("█");
                }
                else if(j%2!=0 && i%2 !=0){
                    System.out.print("█");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}