import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Hexagon {

    public static void mainDraw(Graphics graphics) {

        //x axis
        double leftX04 = WIDTH / 4;
        double rightX13 = 3 * WIDTH / 4;
        double x2 = WIDTH;
        double x5 = 0;

        //y axis
        double topY01 = 0;
        double sidesY25 = HEIGHT / 2;
        double bottomY34 = HEIGHT;

        //size
        double width = WIDTH;
        double height = HEIGHT;

        int count = 7;

        drawHexagon(count, leftX04, rightX13, x2, x5, topY01, sidesY25, bottomY34, width, height, graphics);
    }

    public static void drawHexagon(int count,
                                   //X axis
                                   double leftX04, double rightX13, double x2, double x5,
                                   //Y axis
                                   double topY01, double sidesY25, double bottomY34,
                                   //size
                                   double width, double height, Graphics graphics) {
        if (count <= 0) {
            return;
        }
        int[] x = {(int)leftX04, (int)rightX13, (int)x2, (int)rightX13, (int)leftX04, (int)x5};
        int[] y = {(int)topY01, (int)topY01, (int)sidesY25, (int)bottomY34, (int)bottomY34, (int)sidesY25};

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
