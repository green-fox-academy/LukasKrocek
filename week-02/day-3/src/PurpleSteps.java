import org.w3c.dom.css.RGBColor;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps {

    public static void mainDraw(Graphics graphics){
        graphics.setColor(new Color(200, 43, 187));
        int stepSize = 20;
        int numberOfSteps = 10;
        int margin = 5;
        for (int i = 0; i < numberOfSteps; i++) {
            stepSize += i*5;


            graphics.fillRect(margin,margin,stepSize,stepSize);

            margin += stepSize;

        }



    }

   
    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}