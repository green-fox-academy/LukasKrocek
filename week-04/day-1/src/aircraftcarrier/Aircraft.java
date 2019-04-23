package aircraftcarrier;

abstract class Aircraft {
    int maxAmmo;
    int baseDamage;
    int ammoStorage = 0;
    boolean priority;


    public int fight() {
        int causedDamage;
        causedDamage = ammoStorage * baseDamage;
        ammoStorage = 0;
        return causedDamage;
    }

    public int refill(int numberOfAmmo) {
        int remainingAmmo = 0;
        int ammoNeeded = maxAmmo - ammoStorage;
        if (ammoNeeded < numberOfAmmo) {
            remainingAmmo = numberOfAmmo - ammoNeeded; //decreasing numberOfAmmo by ammoNeeded
            ammoStorage += ammoNeeded; //adding Max if numberOfAmmo bigger than max storage
        } else {
            ammoStorage += numberOfAmmo; //if numberOfAmmo smaller than needed, adding the rest and decreasing remainder to 0
            remainingAmmo = 0;
        }
        return remainingAmmo;
    }

    public String getType() {
        return getClass().getSimpleName();
    }

    public String getStatus() {
        return "Type " + getClass().getSimpleName() + ", Ammo: " + ammoStorage + ", Base Damage: " + baseDamage +
                ", All Damage: " + (ammoStorage * baseDamage);
    }

    public boolean isPriority() {
        return priority;
    }
}