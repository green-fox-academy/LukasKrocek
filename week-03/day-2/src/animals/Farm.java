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
    int slots = 20;

    public void breed(Animal newAnimal) {
        if (slots > 0) {
            animals.add(newAnimal);
        }
        slots--;
    }

    public void slaughter() {
    }
}