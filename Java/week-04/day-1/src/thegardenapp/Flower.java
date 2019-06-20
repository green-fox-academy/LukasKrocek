package thegardenapp;

public class Flower extends Plant {
    Flower(String color) {
        super(color);
        waterNeed = 5;
    }

    @Override
    public void watering(int amountOfWater) {
        currentWater += (amountOfWater * 0.75);
    }
}
