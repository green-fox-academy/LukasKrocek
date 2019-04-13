import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {

    public static void mainDraw(Graphics graphics) {

        //x axis
        int topX = WIDTH/2;
        int rightBottomX = 3*WIDTH/4;
        int leftBottomX = WIDTH/4;

        //y axis
        int topY = 0;
        int bottomY12 = HEIGHT/2;

        //size
        int width = WIDTH/2;
        int height = HEIGHT/2;

        int count = 6;

        drawTriangle(count, topX, rightBottomX, leftBottomX, topY, bottomY12, width, height, graphics);

    }

    public static void drawTriangle(int count,
                                   //X axis
                                   int topX, int rightBottomX, int leftBottomX,
                                   //Y axis
                                   int topY, int bottomY12,
                                   //size
                                   int width, int height, Graphics graphics) {
        if (count <= 0) {
            return;
        }
        int[] x = {topX,rightBottomX,leftBottomX};
        int[] y = {topY, bottomY12, bottomY12};
        graphics.drawPolygon(x, y, 3);

        //LEFT TOP TRIANGLE
        drawTriangle(count - 1,
                // X axis
                topX-width/2, rightBottomX-3*width/4, leftBottomX-width/4,
                // Y axis
                topY, bottomY12-height/2,
                // size
                width / 2, height / 2, graphics);

        //RIGHT TOP TRIANGLE
        drawTriangle(count - 1,
                // X axis
                topX+width/2, rightBottomX+width/4, leftBottomX+3*width/4,
                // Y axis
                topY, bottomY12-height/2,
                // size
                width / 2, height / 2, graphics);

        //BOTTOM TRIANGLE
        drawTriangle(count - 1,
                // X axis
                topX, rightBottomX-width/4, leftBottomX+width/4,
                // Y axis
                topY+height, bottomY12+height/2,
                // size
                width / 2, height / 2, graphics);

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
            this.setBackground(Color.yellow);
        }
    }
}

