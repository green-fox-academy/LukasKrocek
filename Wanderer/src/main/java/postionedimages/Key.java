package postionedimages;

import map.Map;

public class Key extends PositionedImage {
    public static String filename = "key.png";
    public static int posX = Map.getMapSize() + Map.getFieldSize() / 2;
    public static int posY = Map.getMapSize() - Map.getFieldSize();

    public Key() {
        super(filename, posX, posY);
    }
}
