package st10077892prog5121poepartthree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TaskManagerTest {

    private TaskManager taskManager;

    @Before
    public void setUp() {
        taskManager = new TaskManager();
        
        taskManager.addTask("Create Login", "Mike Smith", 5, "To Do");
        taskManager.addTask("Create Add Features", "Edward Harrison", 8, "Doing");
        taskManager.addTask("Create Reports", "Samantha Paulson", 2, "Done");
        taskManager.addTask("Add Arrays", "Glenda Oberholzer", 11, "To Do");
    }

    @Test
    public void testAddTask() {
        assertEquals(4, taskManager.getAllTasks().size());
        taskManager.addTask("Test Task", "John Doe", 3, "To Do");
        assertEquals(5, taskManager.getAllTasks().size());
    }

    @Test
    public void testGetTaskWithLongestDuration() {
        Task longestTask = taskManager.getTaskWithLongestDuration();
        assertEquals("Add Arrays", longestTask.getTaskName());
        assertEquals(11, longestTask.getTaskDuration());
    }

    @Test
    public void testSearchTasksByDeveloper() {
        List<Task> tasksBySamantha = taskManager.searchTasksByDeveloper("Samantha Paulson");
        assertEquals(1, tasksBySamantha.size());
        assertEquals("Create Reports", tasksBySamantha.get(0).getTaskName());

        List<Task> tasksByJohn = taskManager.searchTasksByDeveloper("John Doe");
        assertEquals(0, tasksByJohn.size());
    }

    @Test
    public void testDeleteTaskByName() {
        assertTrue(taskManager.deleteTaskByName("Create Reports"));
        assertEquals(3, taskManager.getAllTasks().size());
        assertFalse(taskManager.deleteTaskByName("Task Does Not Exist"));
        assertEquals(3, taskManager.getAllTasks().size());
    }

    @Test
    public void testGenerateTaskReport() {
        String taskReport = taskManager.generateTaskReport();
        assertTrue(taskReport.contains("Task Name: Create Login"));
        assertTrue(taskReport.contains("Task Name: Create Add Features"));
        assertTrue(taskReport.contains("Task Name: Create Reports"));
        assertTrue(taskReport.contains("Task Name: Add Arrays"));
    }
}


