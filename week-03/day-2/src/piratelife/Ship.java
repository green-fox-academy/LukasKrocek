package piratelife;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    List<Pirate> crew = new ArrayList<>();
    Pirate captain;
    int numberOfCrewMembers;



    public int getRandom(int maximumPirates) {
        int randomNumber = (int) (Math.random() * maximumPirates);
        return randomNumber;
    }

    public void fillShip() {
        Pirate barbosa = new Pirate("Barbosa", 40);
        captain = barbosa;
        int numberOfPirates = getRandom(30);
        for (int i = 0; i < numberOfPirates; i++) {
            Pirate jack = new Pirate("Jack", 20 + i);
            this.crew.add(jack);
        }
    }


}
