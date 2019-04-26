public class Task {
    private String taskToDo;
    private boolean done;

    Task(String taskToDo) {
        this.taskToDo = taskToDo;
        done = false;
    }

    public String getStatus() {
        return doneOrNot() + " " + taskToDo;
    }

    private String doneOrNot() {
        if (done) {
            return "[x]";
        }
        return "[ ]";
    }
}
