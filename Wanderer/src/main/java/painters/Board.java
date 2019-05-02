package painters;

import postionedimages.*;
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
    PaintAction paintActions;
    ArrayList<Monster> monsters;
    Hero hero;
    Key key;
    Doctor doctor;
    boolean doctorUsed = false;
    int boardWidth;
    int boardHeight;
    int currentLevel;
    int keyStrokeCounter;
    int timeBetweenMovements;

    public Board() {
        key = new Key();
        hero = new Hero("hero-down.png", 0, 0);
        timeBetweenMovements = 1000;
        currentLevel = 0;
        boardWidth = 1350;
        boardHeight = 720;
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setVisible(true);
        regenerateMap();
    }

    Timer timer = new java.util.Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            for (Monster monster : monsters) {
                doctor = new Doctor();
                monster.move();
                repaint();
            }
        }
    };

    public void startTimer() {
        timer.scheduleAtFixedRate(task, timeBetweenMovements, timeBetweenMovements);
    }


    public void regenerateMap() {
        hero.setKeyToFalse();
        hero.setToStart();
        hero.regenHP();
        keyStrokeCounter = 0;
        doctorUsed = false;
        map = new Map();
        currentLevel++;
        Matrix.generateMatrix();
        doctor = new Doctor();
        monsters = new ArrayList<>();
        monsters.add(new Boss(currentLevel + (int) (Math.random() * currentLevel)));
        for (int i = 0; i < (int) (Math.random() * 3 + currentLevel); i++) {
            monsters.add(new Skeleton(currentLevel + (int) (Math.random() * currentLevel)));
        }
        int whoGetsKey = (int) (Math.random() * monsters.size());
        monsters.get(whoGetsKey).setKeyToTrue();
        repaint();
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
        paintActions = new PaintAction(this, graphics);
        if (hero.isAlive()) {
            super.paint(graphics);
            graphics.setColor(new Color(122, 31, 31));
            graphics.fillRect(0, 0, boardWidth, boardHeight);
            map.generateMap(graphics);
            for (Monster monster : monsters) {
                monster.draw(graphics);
            }

            if (bossIsDead() && hero.hasKey()) {
                regenerateMap();
            }

            if (hero.hasKey()) {
                key.draw(graphics);
            }

            if (keyStrokeCounter < 5) {
                int fontSize = 80;
                graphics.setColor(Color.blue);
                graphics.setFont(new Font("Courier New", Font.BOLD, fontSize));
                graphics.drawString("Level:" + currentLevel, 150, Map.getMapSize() / 2 - fontSize / 2);
            }

            if (hero.getIndexX() == doctor.getIndexX() && hero.getIndexY() == doctor.getIndexY() && !doctorUsed) {
                doctor.heal(hero);
                doctorUsed = true;
            }
            if (!doctorUsed) {
                doctor.draw(graphics);
            }
            hero.draw(graphics);

            int stringPositionY = 40;
            graphics.setFont(new Font("Courier New", Font.BOLD, 20));
            paintActions.drawCharacterStats(hero, stringPositionY);
            int monsterCounter = 0;
            for (Monster monster : monsters) {
                if (monster.getIndexX() == hero.getIndexX() && monster.getIndexY() == hero.getIndexY()) {
                    monsterCounter++;
                    if (monsterCounter == 1) {
                        stringPositionY += 40;
                        graphics.drawString("To battle press SPACE", Map.getMapSize() + 50, stringPositionY);
                    }
                    stringPositionY += 50;
                    paintActions.penetrationIndicator(stringPositionY, monster, hero, graphics);

                    paintActions.drawCharacterStats(monster, stringPositionY);

                }
            }
        } else {
            PositionedImage gameOver = new PositionedImage("gameover.png", 0, 0);
            gameOver.draw(graphics);
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
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keyStrokeCounter++;
            hero.filename = "hero-down.png";
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keyStrokeCounter++;
            hero.filename = "hero-right.png";
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keyStrokeCounter++;
            hero.filename = "hero-left.png";
            hero.moveLeft();

            //battle
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            int indexOfMonsterToRemove = -1;
            for (Monster monster : monsters) {
                if (monster.getIndexY() == hero.getIndexY() && monster.getIndexX() == hero.getIndexX()) {
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
