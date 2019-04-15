import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Hexagon2 {

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

        int count = 5;

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

        //TOP LEFT HEXAGON
        drawHexagon(count - 1,
                // X axis
                leftX04, rightX13 - width / 3, x2 - width/2, x5 + width / 6,
                // Y axis
                topY01, sidesY25 - height / 3, bottomY34 - 2*height / 3,
                // size
                width / 3, height / 3, graphics);

        //TOP RIGHT HEXAGON
        drawHexagon(count - 1,
                // X axis
                leftX04 +width/3, rightX13, x2 - width/6, x5 + width / 2,
                // Y axis
                topY01, sidesY25 - height / 3, bottomY34 - 2*height / 3,
                // size
                width / 3, height / 3, graphics);
        //BOTTOM LEFT HEXAGON
        drawHexagon(count - 1,
                // X axis
                leftX04, rightX13 - width / 3, x2 - width/2, x5 + width / 6,
                // Y axis
                topY01+2*height/3, sidesY25 + height / 3, bottomY34,
                // size
                width / 3, height / 3, graphics);

        //BOTTOM RIGHT HEXAGON
        drawHexagon(count - 1,
                // X axis
                leftX04 +width/3, rightX13, x2 - width/6, x5 + width / 2,
                // Y axis
                topY01+2*height/3, sidesY25 + height / 3, bottomY34,
                // size
                width / 3, height / 3, graphics);


        //MIDDLE LEFT HEXAGON
        drawHexagon(count - 1,
                // X axis
                leftX04-width/6, rightX13 - width / 2, x2 - 2*width/3, x5,
                // Y axis
                topY01+height/3, sidesY25, bottomY34-height/3,
                // size
                width / 3, height / 3, graphics);

        //MIDDLE RIGHT HEXAGON
        drawHexagon(count - 1,
                // X axis
                leftX04 +width/2, rightX13+width/6, x2, x5 + 2*width / 3,
                // Y axis
                topY01+height/3, sidesY25, bottomY34-height/3,
                // size
                width / 3, height / 3, graphics);
    }

    // Don't touch the code below
    static int WIDTH = 640;
    static int HEIGHT = (int) (WIDTH * 0.8657);

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
