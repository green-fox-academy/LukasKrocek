import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Koch {

    public static void mainDraw(Graphics g) {
        int level = 12;
        int x1 = 0, y1 = HEIGHT - 20;
        int x2 = 160, y2 = 20;
        int x3 = WIDTH, y3 = HEIGHT - 20;

        drawFlake(level, x1, y1, x3, y3, g);
    }

    public static void drawFlake(int order, double x1, double y1, double x5, double y5, Graphics g) {
        double deltaX, deltaY, x2, y2, x3, y3, x4, y4;

        if (order == 1) {
            g.drawLine((int) x1, (int) y1, (int) x5, (int) y5);

        } else {
            deltaX = x5 - x1;
            deltaY = y5 - y1;

            x2 = x1 + deltaX / 3;
            y2 = y1 + deltaY / 3;

            x3 = ((x1 + x5) / 2 - (Math.sqrt(3.0) / 6) * (y1 - y5));
            y3 = ((y1 + y5) / 2 - (Math.sqrt(3.0) / 6) * (x5 - x1));

            x4 = x1 + deltaX * 2 / 3;
            y4 = y1 + deltaY * 2 / 3;

            drawFlake(order - 1, x1, y1, x2, y2, g);
            drawFlake(order - 1, x2, y2, x3, y3, g);
            drawFlake(order - 1, x3, y3, x4, y4, g);
            drawFlake(order - 1, x4, y4, x5, y5, g);
        }
    }

    // Don't touch the code below
    static int WIDTH = 1000;
    static int HEIGHT = 1000;

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

