import painters.Board;
import map.Matrix;

import javax.swing.*;

public class Main{

    public static void main(String[] args) {
        JFrame frame = new JFrame("RPG Game");
        Matrix.generateMatrix();
        Board board = new Board();
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        frame.addKeyListener(board);
    }
}
