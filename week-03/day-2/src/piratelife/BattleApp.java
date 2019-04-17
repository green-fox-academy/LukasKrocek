package piratelife;

public class BattleApp {
    public static void main(String[] args) {
        /*
        Create a BattleApp class with a main method
Create 2 ships, fill them with pirates
Have a battle!
         */
        Ship blackPearl = new Ship("Black Pearl");
        Ship flyingDutchman = new Ship("Flying Dutchman");
        blackPearl.fillShip(50);
        flyingDutchman.fillShip(50);
        System.out.println("BEFORE BATTLE");
        System.out.println(blackPearl);
        System.out.println();
        System.out.println(flyingDutchman);
        blackPearl.battle(flyingDutchman);
        System.out.println("---------------------");
        System.out.println("AFTER BATTLE");
        System.out.println(blackPearl);
        System.out.println();
        System.out.println(flyingDutchman);

    }
}
