package character;

import map.Map;

public class Hero extends CharacterOnMap{
    public static String filename = "hero-down.png";
    public static int indexX = 0;
    public static int indexY = 0;
    public static int posX;
    public static int posY;


    public Hero() {

        super(filename, posX, posY);
        posX = indexX * Map.getFieldSize();
        posY = indexY * Map.getFieldSize();
        level = 1;
        int levelBooster = (level-1)*(rollDice());
        maxHP = 20 + 3 * rollDice()+levelBooster;
        currentHP = maxHP;
        defendPoint = 2 * rollDice()+levelBooster;
        strikePoint = 5 + rollDice()+levelBooster;
    }

    @Override
    public String toString() {
        return "Hero (Level " + level + ") HP: " + currentHP + "/" + maxHP + " | DP: " + defendPoint + " | SP: " + strikePoint;
    }

}
