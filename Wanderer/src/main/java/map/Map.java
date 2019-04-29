package map;

import painters.PositionedImage;

import java.awt.*;

public class Map {


    private static int boardSize = 720;
    private static int fieldSize = boardSize / Matrix.matrixSize;
    public static int getBoardSize() {
        return boardSize;
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
                posX += boardSize / Matrix.matrixSize;
            }
            posY += boardSize / Matrix.matrixSize;
            posX = 0;
        }
    }
}
