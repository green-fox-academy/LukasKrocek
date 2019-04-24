package zoo;
import flyable.*;

public class Bird extends Animal implements Flyable{

    public Bird(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "laying eggs";
    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void takeOff() {

    }
}
