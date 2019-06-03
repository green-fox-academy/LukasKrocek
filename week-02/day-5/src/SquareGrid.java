import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SquareGrid {

    public static void mainDraw(Graphics graphics) {

        int x = HEIGHT / 4;
        int y = WIDTH / 4;
        int size = WIDTH / 2;
        int penWidth = 30;
        int count = 7;

        drawSquare(count, x, y, size, penWidth, graphics);

    }

    public static void drawSquare(int count, int x, int y, int size, int penWidth, Graphics graphics) {
        if (count <= 0) {
            return;
        }
        BasicStroke bs = new BasicStroke();
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke(penWidth));
        graphics.drawRect(x, y, size, size);

        //TOP LEFT SQUARE
        drawSquare(count - 1, x - size / 4, y - size / 4, size / 2, penWidth / 2, graphics);
        //TOP RIGHT SQUARE
        drawSquare(count - 1, x + 3 * size / 4, y - size / 4, size / 2, penWidth / 2, graphics);
        //BOTTOM LEFT SQUARE
        drawSquare(count - 1, x - size / 4, y + 3 * size / 4, size / 2, penWidth / 2, graphics);
        //BOTTOM RIGHT SQUARE
        drawSquare(count - 1, x + 3 * size / 4, y + 3 * size / 4, size / 2, penWidth / 2, graphics);

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

