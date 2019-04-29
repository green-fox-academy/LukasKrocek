package map;

public class Matrix {

    public static int matrixSize = 10;
    public static int[][] matrixArray = new int[matrixSize][matrixSize];

    public static void generateMatrix() {
        for (int column = 0; column < matrixSize; column++) {
            for (int line = 0; line < matrixSize / 2; line++) {
                matrixArray[line * 2][column] = (int) (Math.random() * 7);
                matrixArray[column][line * 2] = (int) (Math.random() * 7);
            }
        }
        matrixArray[0][0] = 1;
    }
}
