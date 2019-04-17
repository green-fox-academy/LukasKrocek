package piratelife;

public class Pirate {
    String name;
    int age;
    int intoxication = 0;
    boolean alive = true;

    public Pirate(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void drinkSomeRum() {
        if (alive == false) {
            System.out.println("This pirate is dead");
        } else {
            intoxication++;
        }
    }

    public void howsItGoingMate() {
        if (alive == false) {
            System.out.println("This pirate is dead");
        } else if (intoxication <= 4) {
            System.out.println("Pour me anudder!");
        } else {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
            sleep();
        }
    }

    public void sleep() {
        intoxication = 0;
    }

    public void die() {
        alive = false;
    }

    public int getRandom(int range) {
        int randomNumber = (int) (Math.random() * range);
        return randomNumber;
    }

    public void brawl(Pirate pirate2) {
        int brawlResult = getRandom(3);
        if (pirate2.alive && alive) {
            if (brawlResult == 0) {
                die();
                System.out.println(name + " died");
            } else if (brawlResult == 1) {
                pirate2.die();
                System.out.println(pirate2.name + " died");

            } else {
                die();
                pirate2.die();
                System.out.println("Both pirates died in combat");
            }
        } else {
            System.out.println("one of these pirates is already dead");
        }
    }

    @Override
    public String toString() {
        String pirate = "Name: " + name + " Intoxication: " + intoxication + ", alive: " + alive;

        return pirate;
    }
}