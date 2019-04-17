package piratelife;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    List<Pirate> crew = new ArrayList<>();
    Pirate captain;
    String name;

    Ship(String name) {
        this.name = name;
    }

    public int getRandom(int maxRandom) {
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
            captain.die();
        }
        for (int i = 0; i < (countLivingPirates() - getRandom(countLivingPirates())); i++) {
            ship.crew.remove(i);
        }
    }

    // each pirate from ship will drink random number of rums (max 20)
    private void partyHard(Ship ship) {
        for (int i = 0; i < getRandom(20); i++) {
            ship.captain.drinkSomeRum();
        }
        for (Pirate pirate : ship.crew) {
            for (int i = 0; i < getRandom(20); i++) {
                pirate.drinkSomeRum();
            }
        }
    }

    @Override
    public String toString() {
        String shipCrew = "Captain of " + name + " is " + captain.name + ". He consumed " + captain.intoxication + " rums. Alive? " + captain.alive + "\n";
        shipCrew += "There are " + countLivingPirates() + " living crew members on this ship";
        return shipCrew;
    }
}
