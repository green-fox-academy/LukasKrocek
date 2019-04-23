package aircraftcarrier;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
    List<Aircraft> aircrafts = new ArrayList<>();
    int ammoStorage;
    int healthPoints;

    Carrier(int ammoStorage, int healthPoints) {
        this.ammoStorage = ammoStorage;
        this.healthPoints = healthPoints;
    }

    public void add(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public void fill() {
        if (ammoStorage <= 0) {
            throw new IllegalArgumentException("There is no ammo in this carrier!");
        }
        if (countAmmoNeeded() > ammoStorage) {
            fillByPriority();
        } else {
            fillInOrder();
        }
    }

    private int countAmmoNeeded() {
        int ammoNeeded = 0;
        for (Aircraft aircraft : aircrafts) { //counting how much ammo is needed
            ammoNeeded += (aircraft.maxAmmo - aircraft.ammoStorage);
        }
        return ammoNeeded;
    }

    private void fillByPriority() {
        for (Aircraft aircraft : aircrafts) {
            if (aircraft.isPriority()) { // first refills aircrafts with priority
                ammoStorage = aircraft.refill(ammoStorage);
            }
        }
        for (Aircraft aircraft : aircrafts) {
            if (!aircraft.isPriority()) {  // second without priority
                ammoStorage = aircraft.refill(ammoStorage);
            }
        }
    }

    private void fillInOrder() {
        for (Aircraft aircraft : aircrafts) { //if there is enough ammo refills all one by one
            ammoStorage = aircraft.refill(ammoStorage);
        }
    }

    public void fight(Carrier anotherCarrier) {
        anotherCarrier.healthPoints -= getTotalDamage();
        for (Aircraft aircraft : aircrafts) {
            aircraft.fight();
        }
    }

    public int getTotalDamage() {
        int totalDamage = 0;
        for (Aircraft aircraft : aircrafts) {
            totalDamage += (aircraft.ammoStorage * aircraft.baseDamage);
        }
        return totalDamage;
    }

    public String getStatus() {
        String status = "";
        if (healthPoints <= 0) {
            status = "It's dead Jim :(";
        } else {
            status = "HP: " + healthPoints + ", Aircraft count: " + aircrafts.size() + ", Ammo Storage: " + ammoStorage + ", Total damage: " + getTotalDamage() + "\n";
            status += "Aircrafts: \n";
            for (Aircraft aircraft : aircrafts) {
                status += aircraft.getStatus() + "\n";
            }
        }
        return status;
    }
}

