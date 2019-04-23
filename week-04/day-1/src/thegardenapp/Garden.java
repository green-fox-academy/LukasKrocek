package thegardenapp;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    List<Plant> treesAndFlowers = new ArrayList<>();

    public void watering(int amountOfwater) {
        System.out.println("Watering with " + amountOfwater);
        int waterPerPlant = amountOfwater / getNumberOfThirsty();//dividing water between thirsty plants
        for (Integer index : getThirstyIndexes()) { //watering thirsty plants
            treesAndFlowers.get(index).watering(waterPerPlant);
        }
        printNeeds();
    }

    public void printNeeds() {
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
