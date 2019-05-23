package map;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Matrix {

    public static int matrixSize = 10;
    public static int[][] matrixArray = new int[matrixSize][matrixSize];

    public static void generateMatrix( int x, int y) {
        if (!isNeighborSafe(x,y)) {
            return;
        }
        matrixArray[x][y] = 1;

        List<Integer> list = Arrays.asList(0,1,2,3);
        Collections.shuffle(list);

        for(int i: list)
        {
            if(i == 0 && (y > 0)){
                generateMatrix( x, y - 1);
            }
            if(i == 1 && y < matrixSize - 1){
                generateMatrix( x, y + 1);
            }
            if(i == 2 && x < matrixSize - 1){
                generateMatrix( x + 1, y);
            }
            if(i == 3 && (x > 0)){
                generateMatrix( x - 1, y);
            }
        }
    }

    public static void clearMatrix(){
        for (int i = 0; i <matrixSize ; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrixArray [i][j] = 0;
            }
        }
    }

    public static boolean isNeighborSafe(int x, int y) {
        if (countSafeNeibours(x, y) <= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int countSafeNeibours(int x, int y) {
        int floorCounter = 0;
        if (x > 0 && matrixArray[x - 1][y] == 1) {
            floorCounter++;
        }
        if (x < matrixSize - 1 && matrixArray[x + 1][y] == 1) {
            floorCounter++;
        }
        if (y > 0 && matrixArray[x][y - 1] == 1) {
            floorCounter++;
        }
        if (y < matrixSize - 1 && matrixArray[x][y + 1] == 1) {
            floorCounter++;
        }
        if (floorCounter <= 1) {
        }
        return floorCounter;
    }
}


