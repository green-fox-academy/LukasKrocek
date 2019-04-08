import java.lang.reflect.Array;

public class Matrix {
    // - Create (dynamically) a two dimensional array
    //   with the following matrix. Use a loop!
    //
    //   1 0 0 0
    //   0 1 0 0
    //   0 0 1 0
    //   0 0 0 1
    //
    // - Print this two dimensional array to the output

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];


        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[j][i]);
            }

        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("iiii"+ i + matrix[i][0]);
            for (int j = 0; j < matrix.length; j++) {
                System.out.print("jjjj"+ j + matrix[i][j]);

            }

        }

    }
}

