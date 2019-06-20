package thegardenapp;

abstract class Plant {

    protected double waterNeed;
    protected double currentWater;

    public String color;

    Plant(String color) {
        this.color = color;
        currentWater = 0;
    }

    public boolean setNeedsWater() {
        return (currentWater < waterNeed);
    }

    public abstract void watering(int amountOfWater);

}
