package piratelife;

import java.util.ArrayList;

public class Armada {
    ArrayList<Ship> shipsList = new ArrayList<>();
    private String name;

    Armada(String name) {
        this.name = name;
    }

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

    public boolean war(Armada anotherArmada) {
        int anotherShipNumber = 0;
        int roundNumber = 1;
        for (int thisShipNumber = 0; thisShipNumber < this.shipsList.size(); thisShipNumber++) {
            //while loop goes if this.Armada's ship wins
            while (this.shipsList.get(thisShipNumber).countLivingPirates() - this.shipsList.get(thisShipNumber).captain.intoxication >=
                    (anotherArmada.shipsList.get(anotherShipNumber)).countLivingPirates() - anotherArmada.shipsList.get(anotherShipNumber).captain.intoxication) {
                //anotherArmada ship always lose in while loop
                // printing round details
                System.out.println("Round number: " + roundNumber);
                roundNumber++;
                System.out.println(this.name + " wins, ship number: " + (thisShipNumber + 1) + " , number of living pirates: " + this.shipsList.get(thisShipNumber).countLivingPirates() + " , captain intox: " + this.shipsList.get(thisShipNumber).captain.intoxication);
                System.out.println(anotherArmada.name + " lost, ship number: " + (anotherShipNumber + 1) + " , number of living pirates: " + anotherArmada.shipsList.get(anotherShipNumber).countLivingPirates() + " , captain intox: " + anotherArmada.shipsList.get(anotherShipNumber).captain.intoxication);
                System.out.println();
                //initiating battle
                this.shipsList.get(thisShipNumber).battle(anotherArmada.shipsList.get(anotherShipNumber));

                //returns true if there are no more ships in another's Armada
                if (anotherShipNumber < anotherArmada.shipsList.size() - 1) {
                    anotherShipNumber++;
                } else {
                    return true;
                }
            }
            //thisArmada ship always lose here
            //printing round details
            System.out.println("Round number: " + roundNumber);
            roundNumber++;
            System.out.println("China wins, ship number: " + (anotherShipNumber + 1) + " , number of living pirates: " + anotherArmada.shipsList.get(anotherShipNumber).countLivingPirates() + " , captain intox: " + anotherArmada.shipsList.get(anotherShipNumber).captain.intoxication);
            System.out.println("USA lost, ship number: " + (thisShipNumber + 1) + " , number of living pirates: " + this.shipsList.get(thisShipNumber).countLivingPirates() + " , captain intox: " + this.shipsList.get(thisShipNumber).captain.intoxication);
            System.out.println();
            //initiating battle
            this.shipsList.get(thisShipNumber).battle(anotherArmada.shipsList.get(anotherShipNumber));

        }
        // for-loop ends = no more ships in thisArmada
        return false;
    }

    @Override
    public String toString() {
        String Armada = "";
        for (Ship ship : this.shipsList) {
            Armada += ship.name + " : " + ship.countLivingPirates() + " crew members , captain intox: " + ship.captain.intoxication + "\n";
        }
        return Armada;
    }
}

