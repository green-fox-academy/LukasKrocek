import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printOutOptions();
        boolean continueProgram = true;
        Scanner sc = new Scanner(System.in);

        while (continueProgram) {
            System.out.println("Waiting for next command");
            String option = sc.nextLine();
            switch (option) {
                case "l":
                    TaskFile.print(); //Lists all the tasks
                    break;
                case "a":
                    System.out.println("Enter the task");
                    TaskFile.add(new Task(sc.nextLine())); //adds task
                    break;
                case "r":
                    System.out.println("Enter number of task you want to remove");
                    TaskFile.removeLine(sc.nextInt()-1); //removes task
                    break;
                case "c":
                    System.out.println("Enter number of finished task");
                    //Changes [ ] to [x] in TaskFile
                    break;
                case "q":
                    System.out.println("See you next time!");
                    continueProgram = false; //quits
                    break;
                default:
                    System.out.println("Wrong Command");
            }
        }
    }



    public static void printOutOptions() {
        System.out.println("Command Line Todo application");
        System.out.println("=============================");
        System.out.println();
        System.out.println("Command line arguments:");
        System.out.println("-l   Lists all the tasks");
        System.out.println("-a   Adds a new task");
        System.out.println("-r   Removes a task");
        System.out.println("-c   Completes a task");
        System.out.println("-q   Quits program");

    }
}
