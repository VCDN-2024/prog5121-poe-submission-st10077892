package st10077892prog5121poepartthree;

public class Task {
    private String taskName;
    private String developer;
    private int taskNumber;
    private String taskDescription;
    private int duration;
    private String taskID;
    private String status;

  
    public Task(String taskName, String developer, int taskNumber, String taskDescription, int duration, String taskID, String status) {
        this.taskName = taskName;
        this.developer = developer;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.duration = duration;
        this.taskID = taskID;
        this.status = status;
    }

    
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task Name: " + taskName + "\n" +
               "Developer: " + developer + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Duration: " + duration + " hours\n" +
               "Task ID: " + taskID + "\n" +
               "Status: " + status;
    }
}
