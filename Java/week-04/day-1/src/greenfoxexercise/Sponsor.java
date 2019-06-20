package greenfoxexercise;

public class Sponsor extends Person {

    String company;
    int hiredStudents;

    Sponsor() {
        super();
        company = "Google";
        hiredStudents = 0;
    }

    Sponsor(String name, int age, String gender, String company) {
        super(name, age, gender);
        this.company = company;
        hiredStudents = 0;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println(" who represents " + company + " and hired " + hiredStudents + " students so far.");
    }

    public void hire() {
        hiredStudents++;
    }

    @Override
    public void getGoal() {
        System.out.println("Hire brilliant junior software developers.");
    }
}
