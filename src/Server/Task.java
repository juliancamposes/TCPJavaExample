package Server;

public class Task {
    private String taskDescription;
    private String taskStatus;

    public Task(String taskDescription, String estado) {
        this.taskDescription = taskDescription;
        this.taskStatus = estado;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
