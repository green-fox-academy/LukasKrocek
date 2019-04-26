import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TaskFile {
    private static Path path = Paths.get("Tasks.txt");
    private static List<String> taskStatuses;
    private static int index;

    public static void removeTask(int taskNumber) {
        fileToStatusesList();
        index = taskNumber - 1;
        taskStatuses.remove(index);
        statusesListToFile();
        System.out.println("Task removed");
    }

    public static void changeStatus(int taskNumber) {
        fileToStatusesList();
        index = taskNumber-1;
        String changeTask = taskStatuses.get(index).replace("[ ]","[x]");
        taskStatuses.set(index,changeTask);
        statusesListToFile();
        System.out.println("Task marked as done");
    }

    public static void addTask(Task task) {
        fileToStatusesList();
        taskStatuses.add(task.getStatus());
        statusesListToFile();
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

    private static void statusesListToFile() {
        try {
            Files.write(path, taskStatuses);
        } catch (IOException e) {
            System.out.println("Task not added");
        }
    }
}
