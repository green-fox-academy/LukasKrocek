package map;

import postionedimages.PositionedImage;

import java.awt.*;

public class Map {


    private static int mapSize = 720;
    private static int fieldSize = mapSize / Matrix.matrixSize;
    public static int getMapSize() {
        return mapSize;
    }

    public static int getFieldSize() {
        return fieldSize;
    }

    public void generateMap(Graphics graphics) {
        int posX = 0;
        int posY = 0;
        for (int column = 0; column < Matrix.matrixSize; column++) {
            for (int line = 0; line < Matrix.matrixSize; line++) {
                if (Matrix.matrixArray[line][column] > 0) {
                    PositionedImage floor = new Floor("floor.png", posX, posY);
                    floor.draw(graphics);

                } else if (Matrix.matrixArray[line][column] == 0) {
                    PositionedImage wall = new Wall("wall.png", posX, posY);
                    wall.draw(graphics);
                }
                posX += mapSize / Matrix.matrixSize;
            }
            posY += mapSize / Matrix.matrixSize;
            posX = 0;
        }
    }
}
