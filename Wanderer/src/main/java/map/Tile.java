package map;

import painters.PositionedImage;

public abstract class Tile extends PositionedImage {

    boolean reachibility;

    public Tile(String filename, int posX, int posY) {
        super(filename, posX, posY);
    }
}
