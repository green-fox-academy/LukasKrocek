package thegardenapp;

public class Main {
    /*
    The task is to create a garden application, so in your main method you should create a garden with
     flowers and trees. The program should demonstrate an example garden with two flowers (yellow and blue)
      and two trees (purple and orange). In the example after creating them you should show the user, how the garden
       looks like. After that the program should water the garden twice, first with the amount of 40 then with 70.
        And after every watering the user should see the state of the garden as you can see in the output.
     */



    public static void main(String[] args) {
        Garden garden = new Garden();
        Flower yellowFlower = new Flower("yellow");
        Flower blueFlower = new Flower("blue");
        Tree purpleTree = new Tree ("purple");
        Tree orangeTree = new Tree ("orange");

        garden.treesAndFlowers.add(yellowFlower);
        garden.treesAndFlowers.add(blueFlower);
        garden.treesAndFlowers.add(purpleTree);
        garden.treesAndFlowers.add(orangeTree);

        garden.watering(40);
        garden.watering(70);





    }

}
