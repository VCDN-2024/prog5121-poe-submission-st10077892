package st10077892prog5121poepartthree;

import javax.swing.JOptionPane;
import java.util.List;

public class ST10077892PROG5121POEPARTTHREE {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        
        taskManager.addTask("Create Login", "Mike Smith", 5, "To Do");
        taskManager.addTask("Create Add Features", "Edward Harrison", 8, "Doing");
        taskManager.addTask("Create Reports", "Samantha Paulson", 2, "Done");
        taskManager.addTask("Add Arrays", "Glenda Oberholzer", 11, "To Do");

        
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        
        while (true) {
            String[] options = {"Add tasks", "Display task with longest duration", "Search tasks by developer",
                                "Display task report", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Menu", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    
                    String taskName = JOptionPane.showInputDialog("Enter task name:");
                    String developer = JOptionPane.showInputDialog("Enter developer name:");
                    int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
                    String status = JOptionPane.showInputDialog("Enter task status:");

                    taskManager.addTask(taskName, developer, duration, status);
                    JOptionPane.showMessageDialog(null, "Task added successfully.");
                    break;

                case 1:
                    
                    Task longestTask = taskManager.getTaskWithLongestDuration();
                    if (longestTask != null) {
                        JOptionPane.showMessageDialog(null, "Task with longest duration:\n" + longestTask.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "No tasks found.");
                    }
                    break;

                case 2:
                    
                    String searchDeveloper = JOptionPane.showInputDialog("Enter developer name to search tasks:");
                    List<Task> tasksByDeveloper = taskManager.searchTasksByDeveloper(searchDeveloper);
                    if (!tasksByDeveloper.isEmpty()) {
                        StringBuilder developerTasks = new StringBuilder();
                        developerTasks.append("Tasks assigned to ").append(searchDeveloper).append(":\n");
                        for (Task task : tasksByDeveloper) {
                            developerTasks.append(task.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, developerTasks.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "No tasks found for developer: " + searchDeveloper);
                    }
                    break;

                case 3:
                    
                    String taskReport = taskManager.generateTaskReport();
                    JOptionPane.showMessageDialog(null, taskReport);
                    break;

                case 4:
                    
                    JOptionPane.showMessageDialog(null, "Exiting EasyKanban. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose again.");
                    break;
            }
        }
    }
}
