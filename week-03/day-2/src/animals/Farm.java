//In Progress
package animals;

import java.util.ArrayList;

public class Farm {
    /*
    Create a Farm class
it has list of Animals
it has slots which defines the number of free places for animals
breed() -> creates a new animal if there's place for it
slaughter() -> removes the least hungry animal
     */
    ArrayList<Animal> animals = new ArrayList<>();
    int slots;


    Farm(int slots) {
        this.slots = slots;
    }

    public void breed(Animal newAnimal) {
        if (slots > 0) {
            animals.add(newAnimal);
            slots--;
        } else {
            System.out.println("No more slots");
        }
    }

    public void slaughter() {
        if (animals.size() > 0) {
            animals.remove(getLeastHungry());
            slots++;
        } else {
            System.out.println("No more animals to slaugher in this Farm");
        }
    }

    public Animal getLeastHungry() {
        Animal leastHungry = animals.get(0);
        for (Animal animal : animals) {
            if (leastHungry.hunger > animal.hunger) {
                leastHungry = animal;
            }
        }
        return leastHungry;
    }

    @Override
    public String toString() {
        String farm = "";
        for (int i = 0; i < animals.size(); i++) {
            farm += (i + 1) + ". " + animals.get(i) + "\n";
        }
        return farm;
    }
}