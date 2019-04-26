import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TaskFile {
    private static Path path = Paths.get("C:\\Users\\kroce\\greenfox\\LukasKrocek\\week-04\\day-4\\tasks.txt");
    private static List<String> tasks;

    public static void removeTask(int taskNumber) {
        fileToTaskList();
        checkTaskNumber(taskNumber);
        tasks.remove(taskNumber - 1);
        taskListToFile();
        System.out.println("Task removed");
    }

    public static void changeStatus(int taskNumber) {
        fileToTaskList();
        checkTaskNumber(taskNumber);
        changeIt(taskNumber);
        taskListToFile();
        System.out.println("Task marked as done");
    }

    public static void addTask(Task task) {
        fileToTaskList();
        tasks.add(task.getStatus());
        taskListToFile();
        System.out.println("Task added");
    }

    public static void print() {
        fileToTaskList();
        if (tasks.size() == 0) {
            System.out.println("No tasks in the list");
            return;
        }
        int taskCounter = 1;
        for (String task : tasks) {
            System.out.print(taskCounter + " - ");
            System.out.println(task);
            taskCounter++;

        }
    }

    private static void changeIt(int taskNumber) {
        int index = taskNumber - 1;
        String changeTask = tasks.get(index).replace("[ ]", "[x]");
        tasks.set(index, changeTask);
    }

    private static void checkTaskNumber(int taskNumber) {
        int index = taskNumber - 1;
        if (index >= tasks.size()) {
            System.out.println("No task with this number");
            System.out.println();
            return;
        }
    }

    private static void fileToTaskList() {
        try {
            tasks = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("File not readable");
        }
    }

    private static void taskListToFile() {
        try {
            Files.write(path, tasks);
        } catch (IOException e) {
            System.out.println("File not writable");
        }
    }
}
