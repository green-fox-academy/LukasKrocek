package zoo;

import interfaces.Flyable;

public class Bird extends Animal implements Flyable {

    public Bird(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "laying eggs";
    }

    @Override
    public void land() {
        System.out.println("ku ku");
    }

    @Override
    public void fly() {

    }

    @Override
    public void takeOff() {

    }
}
