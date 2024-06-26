package st10077892prog5121poepartthree;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    
    public void addTask(String taskName, String developer, int duration, String status) {
        int taskNumber = tasks.size(); 
        String taskID = generateTaskID(taskName, taskNumber, developer);
        Task task = new Task(taskName, developer, taskNumber, "", duration, taskID, status);
        tasks.add(task);
    }

    
    private String generateTaskID(String taskName, int taskNumber, String developer) {
        String prefix = taskName.substring(0, 2).toUpperCase();
        String middle = String.valueOf(taskNumber);
        String suffix = developer.substring(developer.length() - 3).toUpperCase();
        return prefix + ":" + middle + ":" + suffix;
    }

   
    public Task getTaskWithLongestDuration() {
        if (tasks.isEmpty()) {
            return null;
        }
        Task longestTask = tasks.get(0);
        for (Task task : tasks) {
            if (task.getDuration() > longestTask.getDuration()) {
                longestTask = task;
            }
        }
        return longestTask;
    }

    
    public List<Task> searchTasksByDeveloper(String developer) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDeveloper().equalsIgnoreCase(developer)) {
                result.add(task);
            }
        }
        return result;
    }

    
    public String generateTaskReport() {
        StringBuilder report = new StringBuilder();
        report.append("Task Report:\n");
        for (Task task : tasks) {
            report.append(task.toString()).append("\n\n");
        }
        return report.toString();
    }
}


