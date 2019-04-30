package map;

public class Matrix {

    public static int matrixSize = 10;
    public static int[][] matrixArray = new int[matrixSize][matrixSize];

    public static void generateMatrix() {
        for (int column = 0; column < matrixSize; column++) {
            for (int line = 0; line < matrixSize; line++) {
                matrixArray[line][column] = (int) (Math.random() * 8);

            }
        }
        matrixArray[0][0] = 1;
    }
}
