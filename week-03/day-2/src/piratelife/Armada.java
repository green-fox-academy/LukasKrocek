package piratelife;

import java.util.ArrayList;

public class Armada {
    ArrayList<Ship> shipsList = new ArrayList<>();

    private void addShip(Ship newShip) {
        this.shipsList.add(newShip);
        //adds captain and random number of pirates
        newShip.fillShip(100);

    }

    public void addShips(int numberOfShips) {
        for (int i = 0; i < numberOfShips; i++) {
            addShip(new Ship("Ship" + (i + 1)));
        }
    }
// Bug: dead captain is drinking. Can happen with both true/false
//That can happen only if loosing ship goes to another battle and wins (never happens in BattleApp)

    public boolean war(Armada anotherArmada) {
        int j = 0;
        for (int i = 0; i < this.shipsList.size(); i++) {
            //while loop goes if this.Armada's ship wins
            while (this.shipsList.get(i).battle(anotherArmada.shipsList.get(j))) {
                //anotherArmada ship always lose in while loop
                this.shipsList.get(i).battle(anotherArmada.shipsList.get(j));
                //returns true if there are no more ships in another's Armada
                if (j < anotherArmada.shipsList.size() - 1) {
                    j++;
                } else {
                    return true;
                }
            }
            //initiate battle outside while-loop
            //thisArmada ship always lose here
            // bug is HERE?
            this.shipsList.get(i).battle(anotherArmada.shipsList.get(j));
        }
        // for-loop ends = no more ships in thisArmada
        return false;
    }

    @Override
    public String toString() {
        String Armada = "";
        for (Ship ship : this.shipsList) {
            Armada += ship.name + " : " + ship.countLivingPirates() + " crew members , captain intox: " + ship.captain.intoxication +"\n";
        }
        return Armada;
    }
}

