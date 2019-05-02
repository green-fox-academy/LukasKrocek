package postionedimages;

public class Doctor extends CharacterOnMap{
    public static String filename = "doctor.png";
    public Doctor() {
        super(filename, RandomPosition.getPosX(), RandomPosition.getPosY());
        indexX = RandomPosition.getIndexX();
        indexY = RandomPosition.getIndexY();
    }

    public void heal (CharacterOnMap character){
        int maxHeal = character.maxHP - character.currentHP;
        int healingPower = (int)(Math.random()*(maxHeal));
        character.currentHP += healingPower;
    }
}
