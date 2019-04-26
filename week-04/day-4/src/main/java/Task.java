import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Task {
    private String taskToDo;
    private boolean done;

    Task(String taskToDo) {
        this.taskToDo = taskToDo;
        done = false;
    }

    public String getStatus() {
        return doneOfNot() + " " + taskToDo;
    }

    private String doneOfNot() {
        if (done) {
            return "[x]";
        }
        return "[ ]";
    }

    public void makeTaskDone() {
        done = true;
    }


}
