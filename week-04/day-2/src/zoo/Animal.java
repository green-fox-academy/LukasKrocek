package zoo;

public abstract class Animal {
    /*
it has getName() and breed() methods
*/

    private String name;
    int age;
    String gender;
    int numberOfLegs;
    boolean hungry;
    boolean happy;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String breed();
}
