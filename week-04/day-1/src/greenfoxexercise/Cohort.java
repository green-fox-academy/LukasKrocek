package greenfoxexercise;

import java.util.ArrayList;
import java.util.List;

public class Cohort {

    /*

info(): prints out "The name cohort has students.size() students and mentors.size() mentors."
The Cohort class has the following constructors:

Cohort(name): beside the given parameter, it sets students and mentors as empty lists
     */

    private String name;
    private List<Student> students;
    private List<Mentor> mentors;

    Cohort(String name) {
        this.name = name;
        students = new ArrayList<>();
        mentors = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addMentor(Mentor mentor) {
        mentors.add(mentor);
    }

    public void info() {
        System.out.println(name + " cohort class has " + students.size() + " and " + mentors.size() + " mentors");
    }
}
