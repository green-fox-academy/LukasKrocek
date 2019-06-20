package petrolstation;

public class Main {


    public static void main(String[] args) {
        Car skoda = new Car(0, 150);
        Car opel = new Car(0, 120);
        Station shell = new Station(1500);
        shell.refill(skoda);
        shell.refill(opel);

        System.out.println(skoda.gasAmount);
        System.out.println(shell.gasAmount);
    }
}
