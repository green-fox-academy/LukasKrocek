package character;

public class Boss extends Monster{
    private static String filename = "boss.png";

    public Boss() {
        super(filename);
        level = 1;
        maxHP = level*2*rollDice()+rollDice();
        currentHP = maxHP;
        defendPoint = level/2*rollDice()+rollDice()/2;
        strikePoint = level*rollDice() + level;
    }
}
