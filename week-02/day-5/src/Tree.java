import javax.swing.*;

import java.awt.*;
import java.util.HashMap;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Tree {

    public static void mainDraw(Graphics graphics) {


        int x1 = HEIGHT / 2;
        int x2 = HEIGHT / 2;
        int y1 = WIDTH - 100;
        int y2 = WIDTH - 150;

        int count = 10;

        drawLine(count, x1, y1, x2, y2, graphics);

    }

    public static void drawLine(int count, int x1, int y1, int x2, int y2, Graphics graphics) {

        if (count <= 0) {
            return;
        }
        int vectorX = x2 - x1;
        int vectorY = y2 - y1;
        int x3 = x2 + vectorX;
        int y3 = y2 + vectorY;
        int leftX = (int) (x2 + Math.cos(30) * (vectorX + vectorY));
        int leftY = (int) (y2 + Math.cos(30) * (vectorX + vectorY));
        //  int x4 = x2 + vectorY/5;
        // int y4 = y2 + vectorX/5;

        graphics.drawLine(x1, y1, x2, y2);


        //STRAIGHT LINE
        drawLine(count - 1, x2, y2, x3, y3, graphics);
        // LEFT LINE
        drawLine(count - 1, x2, y2, leftX, leftY, graphics);
        //RIGHT LINE
        //   drawLine(count - 1, x2, y2, x2 + 20, y2 - 10 * branchLength, branchLength-1, graphics);

    }

    // Don't touch the code below
    static int WIDTH = 500;
    static int HEIGHT = 500;

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

