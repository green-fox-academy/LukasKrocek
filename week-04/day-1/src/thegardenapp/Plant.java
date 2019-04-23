package thegardenapp;

abstract class Plant {

    protected double waterNeed;
    protected double currentWater;
    private boolean needsWater;
    public String color;

    Plant(String color) {
        this.color = color;
        currentWater = 0;
    }

    public boolean setNeedsWater() {
        if (currentWater < waterNeed) {
            needsWater = true;
        } else {
            needsWater = false;
        }
        return needsWater;
    }

    public void watering(int amountOfWater) {
        currentWater += (amountOfWater);
    }
}
