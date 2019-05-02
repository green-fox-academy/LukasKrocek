package postionedimages;

public class Boss extends Monster{
    private static String filename = "boss.png";

    public Boss(int level) {
        super(filename,level);
        maxHP = level*2*rollDice()+rollDice();
        currentHP = maxHP;
        defendPoint = (int)(level*0.5*rollDice()+rollDice()*0.5);
        strikePoint = level*rollDice() + level;
    }
}
