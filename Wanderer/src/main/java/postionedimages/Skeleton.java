package postionedimages;

public class Skeleton extends Monster{
    private static String filename = "skeleton.png";
    public Skeleton (int level) {
        super(filename,level);
        maxHP = 2*level*rollDice();
        currentHP = maxHP;
        defendPoint = (int)(level*0.5*rollDice());
        strikePoint = level*rollDice();
    }
}
