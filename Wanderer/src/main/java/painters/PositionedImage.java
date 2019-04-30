package painters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class PositionedImage {

    public BufferedImage image;
    protected int posX, posY;

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
