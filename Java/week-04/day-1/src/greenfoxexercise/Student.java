package greenfoxexercise;

public class Student extends Person implements Cloneable {

    String previousOrganization;
    int skippedDays;

    Student() {
        super();
        previousOrganization = "The School of Life";
        skippedDays = 0;
    }

    Student(String name, int age, String gender, String previousOrganization) {
        super(name, age, gender);
        this.previousOrganization = previousOrganization;
        skippedDays = 0;
    }

    @Override
    public Student clone() {
        return new Student(this.name, this.age, this.gender, this.previousOrganization);
    }

    @Override
    public void getGoal() {
        System.out.println("Be a junior software developer.");
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("from " + previousOrganization + " who skipped " + skippedDays + " days from the course already.");
    }

    public void skipDays(int numberOfDays) {
        skippedDays += numberOfDays;
    }

}
