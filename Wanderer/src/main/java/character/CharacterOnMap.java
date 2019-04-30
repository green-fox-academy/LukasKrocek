package character;

import painters.PositionedImage;

public abstract class CharacterOnMap extends PositionedImage {

    public int level;
    public int maxHP;
    public int currentHP;
    public int defendPoint;
    public int strikePoint;
    boolean hasKey = false;

    public CharacterOnMap(String filename, int posX, int posY) {
        super(filename, posX, posY);
    }

    public void levelUp() {
        level++;
        int levelBooster = (rollDice());
        maxHP += levelBooster;
        defendPoint += +levelBooster;
        strikePoint += levelBooster;
    }

    public void strike(CharacterOnMap defender) {
        int strikeValue = 2 * rollDice() + this.strikePoint;
        if (strikeValue > defender.defendPoint) {
            defender.currentHP -= strikeValue;
        }
    }

    public void battle(CharacterOnMap monster) {
        if (this.currentHP > 0 && monster.currentHP > 0) {
            this.strike(monster);
            monster.strike(this);
        }
    }

    public void setKeyToTrue (){
        this.hasKey = true;
    }

    public void setKeyToFalse (){
        this.hasKey = false;
    }

    public boolean hasKey (){
       return this.hasKey;
    }

    public int rollDice() {
        return (int) (Math.random() * 6 + 1);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (Level " + level + ") HP: " + currentHP + "/" + maxHP + " | DEF: " + defendPoint + " | DMG: " + strikePoint;
    }
}
