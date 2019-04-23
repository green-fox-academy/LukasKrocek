package thegardenapp;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    List<Plant> treesAndFlowers = new ArrayList<>();

    public void watering(int amountOfwater) {
        System.out.println("Watering with " + amountOfwater);
        int thirstyPlants = 0;
        List<Integer> thirstyPositions = new ArrayList<>();//list for storing indexes of thirsty plants
        for (Plant plant : treesAndFlowers) { // counting thirsty plants and getting there indexes
            if (plant.setNeedsWater()) {
                thirstyPlants++;
                thirstyPositions.add(treesAndFlowers.indexOf(plant));
            }
        }

        int waterPerPlant = amountOfwater / thirstyPlants;//dividing water between thirsty plants
        for (Integer position : thirstyPositions) { //watering thirsty plants
            treesAndFlowers.get(position).watering(waterPerPlant);
        }

        for (Plant plant : treesAndFlowers) { //printing needs
            if (plant.setNeedsWater()) {
                System.out.println(plant.color + " " + plant.getClass().getSimpleName() + " needs water");
            } else {
                System.out.println(plant.color + " " + plant.getClass().getSimpleName() + " doesn't need water");
            }
        }

    }


}
