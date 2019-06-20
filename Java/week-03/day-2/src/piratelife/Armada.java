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

    private void printRoundDetails(Armada winningArmada, Armada loosingArmada, int winningShipNumber, int loosingShipNumber) {
        int roundNumber = 1;
        System.out.println("Round number: " + roundNumber);
        roundNumber++;
        System.out.println(winningArmada.name + " wins, ship number: " + (winningShipNumber + 1) + " , number of living pirates: " + winningArmada.shipsList.get(winningShipNumber).countLivingPirates() + " , captain intox: " + winningArmada.shipsList.get(winningShipNumber).captain.intoxication);
        System.out.println(loosingArmada.name + " lost, ship number: " + (loosingShipNumber + 1) + " , number of living pirates: " + loosingArmada.shipsList.get(loosingShipNumber).countLivingPirates() + " , captain intox: " + loosingArmada.shipsList.get(loosingShipNumber).captain.intoxication);
        System.out.println();

    }

    private boolean thisArmadaWins(Armada anotherArmada, int thisShipNumber, int anotherShipNumber) {
        return (this.shipsList.get(thisShipNumber).countLivingPirates() - this.shipsList.get(thisShipNumber).captain.intoxication >=
                (anotherArmada.shipsList.get(anotherShipNumber)).countLivingPirates() - anotherArmada.shipsList.get(anotherShipNumber).captain.intoxication);
    }

    public boolean war(Armada anotherArmada) {
        int anotherShipNumber = 0;
        for (int thisShipNumber = 0; thisShipNumber < this.shipsList.size(); thisShipNumber++) {
            while (thisArmadaWins(anotherArmada, thisShipNumber, anotherShipNumber)) {
                //anotherArmada ship always lose in while loop
                printRoundDetails(this, anotherArmada, thisShipNumber, anotherShipNumber);
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
            printRoundDetails(anotherArmada, this, anotherShipNumber, thisShipNumber);
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

