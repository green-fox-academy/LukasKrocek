package character;

public class Skeleton extends Monster{
    private static String filename = "skeleton.png";
    public Skeleton () {
        super(filename);
        level = 1;
        maxHP = 2*level*rollDice();
        currentHP = maxHP;
        defendPoint = level/2*rollDice();
        strikePoint = level*rollDice();
    }
}
