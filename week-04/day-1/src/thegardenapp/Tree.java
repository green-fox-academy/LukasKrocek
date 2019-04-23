package thegardenapp;

public class Tree extends Plant {

    Tree(String color) {
        super(color);
        waterNeed = 10;
    }

    @Override
    public void watering (int amountOfWater){
        currentWater+=amountOfWater*0.4;
    }


}
