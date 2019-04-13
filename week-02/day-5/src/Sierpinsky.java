import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Sierpinsky {

    public static void mainDraw(Graphics graphics) {

        int x = HEIGHT/3;
        int y = WIDTH/3;
        int size = WIDTH/3;


        int count = 7;

        fillSquare(count, x, y, size, graphics);

    }

    public static void fillSquare(int count, int x, int y,int size, Graphics graphics) {
        if (count <= 0) {
            return;
        }

        graphics.fillRect(x,y,size,size);

        //TOP LEFT SQUARE
        fillSquare(count - 1, x-2*size/3,y-2*size/3,size/3, graphics);
        //TOP MIDDLE SQUARE
        fillSquare(count - 1, x+size/3,y-2*size/3,size/3, graphics);
        //TOP RIGHT SQUARE
        fillSquare(count - 1, x+4*size/3,y-2*size/3,size/3, graphics);
        //MIDDLE LEFT SQUARE
        fillSquare(count - 1, x-2*size/3,y+size/3,size/3, graphics);
        //MIDDLE RIGHT SQUARE
        fillSquare(count - 1, x+4*size/3,y+size/3,size/3, graphics);
        //BOTTOM LEFT SQUARE
        fillSquare(count - 1, x-2*size/3,y+4*size/3,size/3, graphics);
        //BOTTOM MIDDLE SQUARE
        fillSquare(count - 1, x+size/3,y+4*size/3,size/3, graphics);
        //BOTTOM RIGHT SQUARE
        fillSquare(count - 1, x+4*size/3,y+4*size/3,size/3, graphics);

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

