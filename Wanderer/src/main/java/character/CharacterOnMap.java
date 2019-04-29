package character;

import painters.PositionedImage;

public abstract class CharacterOnMap extends PositionedImage {

    int level;
    int maxHP;
    int currentHP;
    int defendPoint;
    int strikePoint;

    public CharacterOnMap(String filename, int posX, int posY) {
        super(filename, posX, posY);
    }

    public void strike(CharacterOnMap monster) {
        int strikeValue = 2 * rollDice() + this.strikePoint;
        if (strikeValue > monster.defendPoint) {
            monster.currentHP -= strikeValue;
        }
    }

    public void battle(CharacterOnMap monster) {
        if (this.currentHP > 0 && monster.currentHP > 0) {
            this.strike(monster);
            monster.strike(this);
        } else if(this.currentHP>0&&monster.currentHP<0){
            this.level++;
        }
    }

    public int rollDice() {
        return (int) (Math.random() * 6 + 1);
    }
}
