package map;

import map.Tile;

public class Floor extends Tile {

    public Floor(String filename, int posX, int posY) {
        super(filename, posX, posY);
        reachibility = true;
    }
}

