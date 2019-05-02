package postionedimages;

import map.Map;
import map.Matrix;

public class RandomPosition {
    static int posX;
    static int posY ;
    static int indexX;
    static int indexY;

    public static int getIndexX() {
        return indexX;
    }

    public static int getIndexY() {
        return indexY;
    }

    public static int getPosX() {
        getPositions();
        return posX;
    }
    public static int getPosY() {
        return posY;
    }


    public static void getPositions() {
        do {
            indexY = (int) (Math.random() * Matrix.matrixSize);
            indexX = (int) (Math.random() * Matrix.matrixSize);

        } while (Matrix.matrixArray[indexX][indexY] < 1);

        posX = indexX * Map.getFieldSize();
        posY = indexY * Map.getFieldSize();
    }
}
