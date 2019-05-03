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
        timeBetweenMovements = 1920;
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
            doctor = new Doctor();
            for (Monster monster : monsters) {
                monster.move();
            }
            repaint();
        }
    };

    TimerTask changePosition = new TimerTask() {
        @Override
        public void run() {
            for (Monster monster : monsters) {
                if (monster.move) {
                    if (monster.direction == 0) {
                        monster.posY -= 3;
                    } else if (monster.direction == 1) {
                        monster.posY += 3;
                    } else if (monster.direction == 2) {
                        monster.posX += 3;
                    } else if (monster.direction == 3) {
                        monster.posX -= 3;
                    }

                }

                repaint();

            }

            repaint();

        }
    };

    public void startTimer() {
        timer.scheduleAtFixedRate(task, timeBetweenMovements, timeBetweenMovements);
        timer.scheduleAtFixedRate(changePosition, timeBetweenMovements, 80);
    }


    public void regenerateMap() {
        hero.setKeyToFalse();
        hero.setToStart();
        hero.regenHP();
        keyStrokeCounter = 0;
        doctorUsed = false;
        map = new Map();
        currentLevel++;
        Matrix.clearMatrix();
        Matrix.generateMatrix(0,0);
        doctor = new Doctor();
        monsters = new ArrayList<>();
        monsters.add(new Boss(currentLevel + (int) (Math.random() * currentLevel*3)));
        for (int i = 0; i < (int) (Math.random()*currentLevel*currentLevel+5); i++) {
            monsters.add(new Skeleton(currentLevel + (int) (Math.random() * currentLevel*currentLevel)));
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
                if (Math.abs(monster.posX - hero.posX) < Map.getFieldSize() / 2 && Math.abs(monster.posY - hero.posY) < Map.getFieldSize() / 2) {
                    monsterCounter++;
                    if (monsterCounter == 1) {
                        stringPositionY += 40;
                        graphics.drawString("To battle press SPACE", Map.getMapSize() + 50, stringPositionY);
                    }
                    stringPositionY += 60;
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
            ArrayList <Monster> monsttersToRemove = new ArrayList<>();
            for (Monster monster : monsters) {
                if (Math.abs(monster.posX - hero.posX) < Map.getFieldSize() / 2 && Math.abs(monster.posY - hero.posY) < Map.getFieldSize() / 2) {
                    hero.battle(monster);
                    if (monster.currentHP <= 0) {
                        monsttersToRemove.add(monster);
                    }
                }
            }
            for (Monster monsterDelete:monsttersToRemove){
                if (monsterDelete.hasKey()) {
                    hero.setKeyToTrue();
                }
                monsters.remove(monsterDelete);
                hero.levelUp();
            }
        }
        // and redraw to have a new picture with the new coordinates
        repaint();
    }
}

