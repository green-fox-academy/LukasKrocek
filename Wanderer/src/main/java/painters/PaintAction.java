package painters;

import map.Map;
import postionedimages.CharacterOnMap;

import java.awt.*;


public class PaintAction {
    Graphics graphics;
    Board board;

    public PaintAction(Board board, Graphics graphics) {
        this.graphics = graphics;
        this.board = board;
    }


    public void healthBar(CharacterOnMap character, int positionX, int positionY) {
        int hpBarWidth = 130;
        int hpBarHeight = 25;
        double currentAndMaxHPRatio = (double) character.currentHP / (double) character.maxHP;

        graphics.setColor(Color.red);
        graphics.fillRect(positionX, positionY - 20, (int) (hpBarWidth * currentAndMaxHPRatio), hpBarHeight);
        graphics.setColor(Color.white);
        graphics.fillRect(positionX + (int) (hpBarWidth * currentAndMaxHPRatio), positionY - 20, hpBarWidth - (int) (hpBarWidth * currentAndMaxHPRatio), hpBarHeight);
        graphics.setColor(Color.black);
        graphics.drawString(character.currentHP + "/" + character.maxHP, positionX + 30, positionY);
    }

    public void penetrationIndicator(int positionY, CharacterOnMap monster, CharacterOnMap hero, Graphics graphics) {
        int barWidth = 25;
        int barHeight = 25;
        int positionX = Map.getMapSize()+10;
        int y = positionY+10;

        if (monster.strikePoint + 12 < hero.defendPoint) { //no chance
            graphics.setColor(Color.green);
            graphics.fillRect(positionX,y,barWidth,barHeight);
        } else if (monster.strikePoint + 8 < hero.defendPoint) { //0-50& chance
            graphics.setColor(Color.yellow);
            graphics.fillRect(positionX,y,barWidth,barHeight);
        } else if (monster.strikePoint < hero.defendPoint) { //50-83% chance
            graphics.setColor(Color.orange);
            graphics.fillRect(positionX,y,barWidth,barHeight);
        } else if (monster.strikePoint >= hero.defendPoint){ //100% chance
            graphics.setColor(Color.red);
            graphics.fillRect(positionX,y,barWidth,barHeight);
        }

        graphics.drawString("Penetration : " + monster.strikePoint + "-" + (monster.strikePoint+12),positionX + barWidth + 10,y+barHeight);
    }

    public void drawCharacterStats(CharacterOnMap character, int positionY) {
        int positionX = Map.getMapSize()+10;
        character.toString();
        healthBar(character, positionX, positionY);
        graphics.setColor(Color.white);
        graphics.drawString(character.toString(), positionX + 140, positionY);
    }
}
