package painters;

import character.*;
import map.Map;
import map.Matrix;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Board extends JComponent implements KeyListener {
    Map map;
    ArrayList<Monster> monsters;
    Hero hero;
    int boardWidth;
    int boardHeight;
    int currentLevel;
    int keyStrokeCounter;
    int timeBetweenMovements;

    public Board() {
        hero = new Hero("hero-down.png", 0, 0);
        timeBetweenMovements = 2000;
        currentLevel = 0;
        boardWidth = 720;
        boardHeight = 900;
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setVisible(true);
        regenerateMap();
    }

    Timer timer = new java.util.Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            for (Monster monster:monsters) {
                monster.move();
                repaint();
            }
        }
    };

    public void startTimer (){
        timer.scheduleAtFixedRate(task,timeBetweenMovements,timeBetweenMovements);
    }


    public void regenerateMap() {
        timeBetweenMovements = 9*timeBetweenMovements/10;
        hero.setKeyToFalse();
        hero.setToStart();
        hero.regenHP();
        keyStrokeCounter = 0;
        map = new Map();
        currentLevel++;
        Matrix.generateMatrix();
        monsters = new ArrayList<>();
        monsters.add(new Boss(currentLevel));
        for (int i = 0; i < (int) (Math.random() * 20 + 3); i++) {
            monsters.add(new Skeleton(currentLevel));
        }
        int whoGetsKey = (int) (Math.random() * monsters.size());
        monsters.get(whoGetsKey).setKeyToTrue();
    }

    public boolean bossIsDead() {
        for (Monster monster : monsters) {
            if (monster.getClass().getSimpleName().equals("Boss")) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void paint(Graphics graphics) {
        if (bossIsDead() && hero.hasKey()) {
            regenerateMap();
        }
        if (hero.isAlive()) {
            super.paint(graphics);
            map.generateMap(graphics);
            for (Monster monster : monsters) {
                monster.draw(graphics);
            }

            if (keyStrokeCounter < 5) {
                int fontSize = 80;
                graphics.setFont(new Font("Courier New", Font.BOLD, fontSize));
                graphics.drawString("Level: " + currentLevel, 100, boardWidth + 2 * fontSize);
            }
            hero.draw(graphics);
            int stringPositionY = 750;
            graphics.setFont(new Font("Courier New", Font.BOLD, 20));
            graphics.drawString(hero.toString(), 100, stringPositionY);
            int monsterCounter = 0;
            for (Monster monster : monsters) {

                if (monster.getIndexX() == hero.indexX && monster.getIndexY() == hero.indexY) {
                    monsterCounter++;
                    if (monsterCounter == 1) {
                        stringPositionY += 40;
                        graphics.drawString("To battle press SPACE", 180, stringPositionY);
                    }
                    stringPositionY += 40;
                    graphics.drawString(monster.toString(), 100, stringPositionY);
                }
            }
        } else {
            PaintActions.gameOver(graphics);
        }
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
            keyStrokeCounter++;
            hero.filename = "hero-up.png";
            if (hero.indexY > 0 && Matrix.matrixArray[hero.indexX][hero.indexY - 1] != 0) {
                hero.posY -= Map.getFieldSize();
                hero.indexY--;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keyStrokeCounter++;
            hero.filename = "hero-down.png";
            if (hero.indexY < Matrix.matrixSize - 1 && Matrix.matrixArray[hero.indexX][hero.indexY + 1] != 0) {
                hero.posY += Map.getFieldSize();
                hero.indexY++;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keyStrokeCounter++;
            hero.filename = "hero-right.png";
            if (hero.indexX < Matrix.matrixSize - 1 && Matrix.matrixArray[hero.indexX + 1][hero.indexY] != 0) {
                hero.posX += Map.getFieldSize();
                hero.indexX++;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keyStrokeCounter++;
            hero.filename = "hero-left.png";
            if (hero.indexX > 0 && Matrix.matrixArray[hero.indexX - 1][hero.indexY] != 0) {
                hero.posX -= Map.getFieldSize();
                hero.indexX--;
            }

            //battle
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            int indexOfMonsterToRemove = -1;
            for (Monster monster : monsters) {
                if (monster.getIndexY() == hero.indexY && monster.getIndexX() == hero.indexX) {
                    hero.battle(monster);
                    if (monster.currentHP <= 0) {
                        indexOfMonsterToRemove = monsters.indexOf(monster);
                    }
                }
            }
            if (indexOfMonsterToRemove >= 0) {
                if (monsters.get(indexOfMonsterToRemove).hasKey()) {
                    hero.setKeyToTrue();
                }
                monsters.remove(indexOfMonsterToRemove);
                hero.levelUp();
            }
        }
        // and redraw to have a new picture with the new coordinates
        repaint();
    }
}
