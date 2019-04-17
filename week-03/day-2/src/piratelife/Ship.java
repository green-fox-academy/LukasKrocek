package piratelife;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private List<Pirate> crew = new ArrayList<>();
    public Pirate captain;
    public String name;

    Ship(String name) {
        this.name = name;
    }

    private int getRandom(int maxRandom) {
        maxRandom = (int) ((Math.random()) * maxRandom);
        return maxRandom;
    }

    public void fillShip(int howManyPiratesCanFit) {
        captain = new Pirate("Barbosa", 40);
        int numberOfPirates = getRandom(howManyPiratesCanFit);
        for (int i = 0; i < numberOfPirates; i++) {
            Pirate jack = new Pirate("Jack" + i, 20 + i);
            this.crew.add(jack);
        }
    }

    public int countLivingPirates() {
        int numberOfLivingPirates = 0;
        for (Pirate pirate : crew) {
            if (pirate.alive) {
                numberOfLivingPirates++;
            }
        }
        return numberOfLivingPirates;
    }

    private String isCaptainAlive (Ship ship){
        if (ship.captain.alive){
            return "alive";
        } else {
            return "dead";
        }
    }


    //the ship should win if its calculated score is higher
    //calculate score: Number of Alive pirates in the crew - Number of consumed rum by the captain
    public boolean battle(Ship otherShip) {
        boolean won;
        // if this ship won, set won to true, kill pirates from other ship, this ship partyHard
        if (countLivingPirates() - captain.intoxication > otherShip.countLivingPirates() - otherShip.captain.intoxication) {
            won = true;
            removeRandomNumberOfPirates(otherShip);
            partyHard(this);

            // if other ship won, set won to false, kill pirates from this ship, Other ship partyHard
        } else {
            won = false;
            removeRandomNumberOfPirates(this);
            partyHard(otherShip);
        }
        return won;
    }

    //kill random number of ship crew, **used for ship.battle**
    private void removeRandomNumberOfPirates(Ship ship) {

        if (getRandom(6) < 2) {
            ship.captain.die();
        }
        int livingCrewSize = ship.countLivingPirates();
        int killRandomNumber = getRandom(livingCrewSize * livingCrewSize / (livingCrewSize + 1)) + 1;
        for (int i = 0; i < (livingCrewSize - killRandomNumber); i++) {
            ship.crew.remove(0);

        }
    }

    // each pirate from ship will drink random number of rums (max 20)
    private void partyHard(Ship ship) {
        for (int i = 0; i < getRandom(100); i++) {
            ship.captain.drinkSomeRum();
        }
        for (Pirate pirate : ship.crew) {
            for (int i = 0; i < getRandom(100); i++) {
                pirate.drinkSomeRum();
            }
        }
    }

    @Override
    public String toString() {
        String shipCrew = "Captain of " + name + " is " + captain.name + ". He consumed " + captain.intoxication + " rums. Captain is " + isCaptainAlive(this) + "\n";
        shipCrew += "There are " + countLivingPirates() + " living crew members on this ship";
        return shipCrew;
    }
}
