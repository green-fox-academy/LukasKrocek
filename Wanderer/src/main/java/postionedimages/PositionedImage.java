package postionedimages;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PositionedImage {

    public BufferedImage image;
    public int posX, posY;
    public int indexX;
    public int indexY;

    public PositionedImage(String filename, int posX, int posY) {
        try {
            this.image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.posX = posX;
        this.posY = posY;
    }

    public void draw(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, posX, posY, null);
        }
    }
}
