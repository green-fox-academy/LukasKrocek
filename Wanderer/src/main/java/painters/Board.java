package painters;

import character.*;
import map.Map;
import map.Matrix;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class Board extends JComponent implements KeyListener {
    Map map;
    ArrayList<Monster> monsters;
    Hero hero;

    public Board() {
        map = new Map();
        monsters = new ArrayList<>();
        setPreferredSize(new Dimension(720, 820));
        setVisible(true);
        monsters.add(new Skeleton());
        monsters.add(new Skeleton());
        monsters.add(new Skeleton());
        monsters.add(new Boss());
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        map.generateMap(graphics);
        hero = new Hero();
        for (Monster monster:monsters) {
            monster.draw(graphics);
        }
        hero.draw(graphics);
        graphics.drawString(hero.toString(), 250, 750);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // When the up or down keys hit, we change the position of our box
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Hero.filename = "hero-up.png";
            if (Hero.indexY > 0 && Matrix.matrixArray[Hero.indexX][Hero.indexY - 1] != 0) {
                Hero.posY -= Map.getFieldSize();
                Hero.indexY--;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Hero.filename = "hero-down.png";
            if (Hero.indexY < Matrix.matrixSize - 1 && Matrix.matrixArray[Hero.indexX][Hero.indexY + 1] != 0) {
                Hero.posY += Map.getFieldSize();
                Hero.indexY++;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Hero.filename = "hero-right.png";
            if (Hero.indexX < Matrix.matrixSize - 1 && Matrix.matrixArray[Hero.indexX + 1][Hero.indexY] != 0) {
                Hero.posX += Map.getFieldSize();
                Hero.indexX++;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Hero.filename = "hero-left.png";
            if (Hero.indexX > 0 && Matrix.matrixArray[Hero.indexX - 1][Hero.indexY] != 0) {
                Hero.posX -= Map.getFieldSize();
                Hero.indexX--;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            for (Monster monster : monsters) {

            }
        }
        // and redraw to have a new picture with the new coordinates
        repaint();
    }
}
