package postionedimages;

import map.Map;
import map.Matrix;

public abstract class CharacterOnMap extends PositionedImage {

    public int level;
    public int maxHP;
    public int currentHP;
    public int defendPoint;
    public int strikePoint;
    boolean hasKey = false;

    public CharacterOnMap(String filename, int posX, int posY) {
        super(filename, posX, posY);
    }

    public void levelUp() {
        level++;
        int levelBooster = (rollDice());
        maxHP += levelBooster;
        defendPoint += +levelBooster;
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
            posY -= Map.getFieldSize();
        }
    }

    public void moveDown() {
        if (indexY < Matrix.matrixSize - 1 && isItFloor(getIndexX(), getIndexY() + 1)) {//down
            indexY++;
            posY += Map.getFieldSize();
        }
    }

    public void moveRight() {
        if (indexX < Matrix.matrixSize - 1 && isItFloor(getIndexX() + 1, getIndexY())) {//right
            indexX++;
            posX += Map.getFieldSize();
        }
    }

    public void moveLeft() {
        if (indexX > 0 && isItFloor(getIndexX() - 1, getIndexY())) {//left
            indexX--;
            posX -= Map.getFieldSize();
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
