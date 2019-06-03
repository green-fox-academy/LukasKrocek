package thegardenapp;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    private List<Plant> treesAndFlowers = new ArrayList<>();

    public void add(Plant plant) {
        treesAndFlowers.add(plant);
    }

    public void watering(int amountOfwater) {
        System.out.println("Watering with " + amountOfwater);
        for (Integer index : getThirstyIndexes()) { //watering thirsty plants
            treesAndFlowers.get(index).watering(divideWaterPerPlant(amountOfwater));
        }
        printStatus();
    }

    private int divideWaterPerPlant(int amountOfwater) {
        return amountOfwater / getNumberOfThirsty();
    }

    public void printStatus() {
        for (Plant plant : treesAndFlowers) {
            if (plant.setNeedsWater()) {
                System.out.println(plant.color + " " + plant.getClass().getSimpleName() + " needs water");
            } else {
                System.out.println(plant.color + " " + plant.getClass().getSimpleName() + " doesn't need water");
            }
        }
    }

    private List<Integer> getThirstyIndexes() {
        List<Integer> thirstyPositions = new ArrayList<>();
        for (Plant plant : treesAndFlowers) {
            if (plant.setNeedsWater()) {
                thirstyPositions.add(treesAndFlowers.indexOf(plant));
            }
        }
        return thirstyPositions;
    }

    private int getNumberOfThirsty() {
        int thirstyPlants = 0;
        for (Plant plant : treesAndFlowers) {
            if (plant.setNeedsWater()) {
                thirstyPlants++;
            }
        }
        return thirstyPlants;
    }
}
