package postionedimages;

import map.Map;
import map.Matrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Hero extends CharacterOnMap {
    public String filename = "hero-down.png";


    public Hero(String filename, int posX, int posY) {
        super(filename, posX, posY);
        this.posX = indexX * Map.getFieldSize();
        this.posY = indexY * Map.getFieldSize();
        level = 1;
        maxHP = 20 + 3 * rollDice();
        currentHP = maxHP;
        defendPoint = 2 * rollDice();
        strikePoint = 5 + rollDice();
    }

    public void regenHP() {
        int options = (int) (Math.random() * 10);
        if (options < 4) {  //40%
            currentHP += maxHP / 3;
        } else if (options == 4) { //10%
            currentHP = maxHP;
        } else { //50%
            currentHP += maxHP / 10;
        }
        if (currentHP > maxHP) {
            currentHP = maxHP;
        }
    }

    public boolean isAlive() {
        return (currentHP > 0);
    }

    public void setToStart() {
        this.posX = 0;
        this.posY = 0;
        this.indexX = 0;
        this.indexY = 0;
    }

    public void moveUp() {

        if (indexY > 0 && isItFloor(getIndexX(), getIndexY() - 1)) {//up
            indexY--;
            targetPosY = posY - Map.getFieldSize();
            posY -= Map.getFieldSize();
            move = true;
            direction = 0;
        } else {
            move = false;
        }
    }

    public void moveDown() {
        if (indexY < Matrix.matrixSize - 1 && isItFloor(getIndexX(), getIndexY() + 1)) {//down
            indexY++;
            targetPosY = posY + Map.getFieldSize();
            posY += Map.getFieldSize();
            move = true;
            direction = 1;
        } else {
            move = false;
        }
    }

    public void moveRight() {
        if (indexX < Matrix.matrixSize - 1 && isItFloor(getIndexX() + 1, getIndexY())) {//right
            indexX++;
            targetPosX = posX + Map.getFieldSize();
            move = true;
            direction = 2;
            posX += Map.getFieldSize();
        } else {
            move = false;
        }
    }

    public void moveLeft() {
        if (indexX > 0 && isItFloor(getIndexX() - 1, getIndexY())) {//left
            indexX--;
            targetPosX = posX - Map.getFieldSize();
            posX -= Map.getFieldSize();
            move = true;
            direction = 3;
        } else {
            move = false;
        }
    }

    @Override
    public void draw(Graphics graphics) {
        try {
            this.image = ImageIO.read(new File(this.filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (image != null) {
            graphics.drawImage(this.image, this.posX, this.posY, null);
        }
    }
}
