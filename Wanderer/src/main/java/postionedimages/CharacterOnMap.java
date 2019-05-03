package postionedimages;

import map.Map;
import map.Matrix;

public abstract class CharacterOnMap extends PositionedImage {

    public int level;
    public int maxHP;
    public int currentHP;
    public int defendPoint;
    public int strikePoint;
    public int targetPosX;
    public int targetPosY;
    public int direction = -1;
    boolean hasKey = false;
    public boolean move = false;

    public CharacterOnMap(String filename, int posX, int posY) {
        super(filename, posX, posY);
    }

    public void levelUp() {
        level++;
        int levelBooster = (rollDice());
        maxHP += levelBooster;
        defendPoint += levelBooster;
        strikePoint += levelBooster;
    }

    public void strike(CharacterOnMap defender) {
        int strikeValue = 2 * rollDice() + this.strikePoint;
        if (strikeValue > defender.defendPoint) {
            defender.currentHP -= strikeValue;
        }
    }

    public void battle(CharacterOnMap monster) {
        if (this.currentHP > 0 && monster.currentHP > 0) {
            this.strike(monster);
            monster.strike(this);
        }
    }

    public int getIndexX() {
        return indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public boolean isItFloor(int indexX, int indexY) {
        return (Matrix.matrixArray[indexX][indexY] > 0);
    }

    public void moveUp() {

        if (indexY > 0 && isItFloor(getIndexX(), getIndexY() - 1)) {//up
            indexY--;
            targetPosY = posY - Map.getFieldSize();
           // posY -= Map.getFieldSize();
            move = true;
            direction = 0;
        } else {
            move = false;
        }
    }

    public void moveDown() {
        if (indexY < Matrix.matrixSize - 1 && isItFloor(getIndexX(), getIndexY() + 1)) {//down
            indexY++;
            targetPosY = posY + Map.getFieldSize();
            //posY += Map.getFieldSize();
            move = true;
            direction = 1;
        } else {
            move = false;
        }
    }

    public void moveRight() {
        if (indexX < Matrix.matrixSize - 1 && isItFloor(getIndexX() + 1, getIndexY())) {//right
            indexX++;
            targetPosX = posX + Map.getFieldSize();
            move = true;
            direction = 2;
            //posX += Map.getFieldSize();
        } else {
            move = false;
        }
    }

    public void moveLeft() {
        if (indexX > 0 && isItFloor(getIndexX() - 1, getIndexY())) {//left
            indexX--;
            targetPosX = posX - Map.getFieldSize();
            //posX -= Map.getFieldSize();
            move = true;
            direction = 3;
        } else {
            move = false;
        }
    }

    public void setKeyToTrue() {
        this.hasKey = true;
    }

    public void setKeyToFalse() {
        this.hasKey = false;
    }

    public boolean hasKey() {
        return this.hasKey;
    }

    public int rollDice() {
        return (int) (Math.random() * 6 + 1);
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (Level " + level + ")" + " DEF: " + defendPoint + " | DMG: " + strikePoint;
    }
}
