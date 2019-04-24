package greenfoxexercise;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Student john = new Student("John Doe", 20, "male", "BME");
        Student johnTheClone = john.clone();
        System.out.println(johnTheClone.age);
    }
}
