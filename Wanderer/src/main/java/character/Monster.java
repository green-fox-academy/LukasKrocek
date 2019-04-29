package character;

import map.Map;
import map.Matrix;

public class Monster extends CharacterOnMap {
    int indexX;
    int indexY;

    public Monster(String filename) {
        super(filename, RandomPosition.getPosX(), RandomPosition.getPosY());
    }

    public int getIndexX() {
        return indexX;
    }

    public int getIndexY() {
        return indexY;
    }
}

