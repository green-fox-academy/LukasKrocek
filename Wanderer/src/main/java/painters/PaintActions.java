package painters;

import java.awt.*;


public abstract class PaintActions {

    public static void gameOver (Graphics graphics){
        int fontSize = 100;
        graphics.setFont(new Font("Courier New", Font.BOLD, fontSize));
        graphics.drawString("GAME OVER", 100, 300);
    }

    public static void iHaveTheKey (Graphics graphics){
        int fontSize = 100;
        graphics.setFont(new Font("Courier New", Font.BOLD, fontSize));
        graphics.drawString("Key", 100, 300);
    }

}
