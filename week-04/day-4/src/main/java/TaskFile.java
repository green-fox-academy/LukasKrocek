import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TaskFile {
    public static Path path = Paths.get("Tasks.txt");
    public static List<String> taskStatuses;


    public static void removeLine(int index) {
        fileToStatusesList();
        taskStatuses.remove(index);
        StatusesListToFile();
        System.out.println("Task removed");
    }

    public static void add(Task task) {
        fileToStatusesList();
        taskStatuses.add(task.getStatus());
        StatusesListToFile();
        System.out.println("Task added");
    }

    public static void print() {
        fileToStatusesList();
        int taskCounter = 1;
        for (String taskStatus : taskStatuses) {
            System.out.print(taskCounter + " - ");
            System.out.println(taskStatus);
            taskCounter++;

        }
    }

    private static void fileToStatusesList() {
        try {
            taskStatuses = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private static void StatusesListToFile() {
        try {
            Files.write(path, taskStatuses);
        } catch (IOException e) {
            System.out.println("Task not added");
        }
    }
}
