package character;

import map.Map;
import map.Matrix;

public class Monster extends CharacterOnMap {
    int indexX;
    int indexY;

    public Monster(String filename, int level) {
        super(filename, RandomPosition.getPosX(), RandomPosition.getPosY());
        indexX = RandomPosition.getIndexX();
        indexY = RandomPosition.getIndexY();
        this.level = level;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public void move() {
        int direction = (int) (Math.random() * 4); //0-up,1-down,2-right, 3 left
        if (direction == 0 && indexY > 0 && isItFloor(getIndexX(), getIndexY() - 1)) {
            indexY--;
            posY -= Map.getFieldSize();
        }
        if (direction == 1 && indexY < Matrix.matrixSize-1 && isItFloor(getIndexX(), getIndexY() + 1)) {
            indexY++;
            posY += Map.getFieldSize();
        }
        if (direction == 2 && indexX < Matrix.matrixSize-1 && isItFloor(getIndexX()+1, getIndexY())) {
            indexX++;
            posX += Map.getFieldSize();
        }
        if (direction == 3 && indexX > 0 && isItFloor(getIndexX()-1, getIndexY())) {
            indexX--;
            posX -= Map.getFieldSize();
        }
    }

    public boolean isItFloor(int indexX, int indexY) {
        return (Matrix.matrixArray[indexX][indexY] > 0);
    }

    public int getIndexX() {
        return indexX;
    }

    public int getIndexY() {
        return indexY;
    }
}



