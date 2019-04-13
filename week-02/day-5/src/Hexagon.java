import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Hexagon {

    public static void mainDraw(Graphics graphics) {

        //x axis
        int leftX04 = WIDTH / 4;
        int rightX13 = 3 * WIDTH / 4;
        int x2 = WIDTH;
        int x5 = 0;

        //y axis
        int topY01 = 0;
        int sidesY25 = HEIGHT / 2;
        int bottomY34 = HEIGHT;

        //size
        int width = WIDTH;
        int height = HEIGHT;

        int count = 6;

        drawHexagon(count, leftX04, rightX13, x2, x5, topY01, sidesY25, bottomY34, width, height, graphics);

    }

    public static void drawHexagon(int count,
                                   //X axis
                                   int leftX04, int rightX13, int x2, int x5,
                                   //Y axis
                                   int topY01, int sidesY25, int bottomY34,
                                   //size
                                   int width, int height, Graphics graphics) {
        if (count <= 0) {
            return;
        }
        int[] x = {leftX04, rightX13, x2, rightX13, leftX04, x5};
        int[] y = {topY01, topY01, sidesY25, bottomY34, bottomY34, sidesY25};
        graphics.drawPolygon(x, y, 6);

        //TOP HEXAGON
        drawHexagon(count - 1,
                // X axis
                leftX04, rightX13 - width / 4, x2 - 3 * width / 8, x5 + width / 8,
                // Y axis
                topY01, sidesY25 - height / 4, bottomY34 - height / 2,
                // size
                width / 2, height / 2, graphics);

        //BOTTOM HEXAGON
        drawHexagon(count - 1,
                // X axis
                leftX04, rightX13 - width / 4, x2 - 3 * width / 8, x5 + width / 8,
                // Y axis
                topY01 + height / 2, sidesY25 + height / 4, bottomY34,
                // size
                width / 2, height / 2, graphics);

        //RIGHT HEXAGON
        drawHexagon(count - 1,
                // X axis
                leftX04 + 3 * width / 8, rightX13 + width / 8, x2, x5 + width / 2,
                // Y axis
                topY01 + height / 4, sidesY25, bottomY34 - height / 4,
                // size
                width / 2, height / 2, graphics);

    }

    // Don't touch the code below
    static int WIDTH = 640;
    static int HEIGHT = 640;

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
            this.setBackground(Color.yellow);
        }
    }
}
