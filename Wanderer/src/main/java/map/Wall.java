package map;

import map.Tile;

public class Wall extends Tile {
    public Wall(String filename, int posX, int posY) {
        super(filename, posX, posY);
        reachibility = false;
    }
}
