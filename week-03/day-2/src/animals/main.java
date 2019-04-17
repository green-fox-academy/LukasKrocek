package animals;

public class main {
    public static void main(String[] args) {
        // creating farm with 3 slots
        Farm slaughterHouse = new Farm(3);
        //adding animals to the farm
        slaughterHouse.breed(new Animal("Pig"));
        slaughterHouse.breed(new Animal("Cow"));
        slaughterHouse.breed(new Animal("Chicken"));
        //all slots taken - should print
        slaughterHouse.breed(new Animal("Horse"));
        System.out.println("--------------------");
        //prints the list of animals, their hunger and thirst
        System.out.println(slaughterHouse);
        System.out.println("--------------------");
        //slaughter all animals in farm, ascending by hunger
        slaughterHouse.slaughter();
        slaughterHouse.slaughter();
        slaughterHouse.slaughter();
        //all animals killed - should print, there is no more
        slaughterHouse.slaughter();


    }
}
