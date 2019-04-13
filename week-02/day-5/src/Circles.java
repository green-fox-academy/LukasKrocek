import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Circles {

    public static void mainDraw(Graphics graphics) {

        int x = 0;
        int y = 0;

        //size
        int width = WIDTH;
        int height = HEIGHT;

        int count = 6;

        drawCircle(count, x, y, width, height, graphics);

    }

    public static void drawCircle(int count, int x, int y,
                                  //size
                                  int width, int height, Graphics graphics) {
        if (count <= 0) {
            return;
        }

        graphics.drawOval(x, y, width,height);

        //TOP CIRCLE
        drawCircle(count - 1, x+width/4,y,

                width / 2, height / 2, graphics);

        //RIGHT BOTTOM CIRCLE
        drawCircle(count - 1, x+15*width/32,y+6*width/16,

                width / 2, height / 2, graphics);


        //RIGHT BOTTOM CIRCLE
        drawCircle(count - 1, x+width/32,y+6*width/16,

                width / 2, height / 2, graphics);

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
            this.setBackground(Color.yellow);
        }
    }
}

