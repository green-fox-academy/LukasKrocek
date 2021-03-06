package postionedimages;

import map.Matrix;

public class Monster extends CharacterOnMap {

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
        if (direction == 0) {
            moveUp();

        } else if (direction == 1) {
            moveDown();
        } else if (direction == 2) {
            moveRight();
        } else if (direction == 3) {
            moveLeft();
        } else {
        }
    }

    public boolean isItFloor(int indexX, int indexY) {
        return (Matrix.matrixArray[indexX][indexY] > 0);
    }

    public int getIndexX() {
        return (int) indexX;
    }

    public int getIndexY() {
        return (int) indexY;
    }
}



