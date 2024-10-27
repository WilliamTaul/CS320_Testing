package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tasks.TaskService;

class TaskServiceTest {
	
	private TaskService taskService;
	private String ID1;
	private String ID2;
	private String name1;
	private String name2;
	private String description1;
	private String description2;
	
	@BeforeEach
	void setUp() {
		
		taskService = new TaskService();
		ID1 = "123456789";
		ID2 = "234987";
		name1 = "Task1";
		name2 = "Task2";
		description1 = "Description1";
		description2 = "Description2";
	}

	@Test
	void testTaskServiceAddTask() {
		
		// Verifying the TaskService was created and that the 
		// hashmap and set are both empty
		assertTrue(taskService.getTasks().isEmpty(), "Tasks is empty test");
		
		
		// Verifying the creation of two different 
		// tasks and adding them
		taskService.addTask(name1, description1);
		taskService.addTask(name2, description2);
		
		assertEquals(2, taskService.getTasks().size(), "Tasks map should be size 2");
				
		
		// Test that two tasks cannot be added with the same ID
		assertThrows(IllegalArgumentException.class, ()->{
			taskService.addTask(ID1, name1, description1);
			taskService.addTask(ID1, name2, description2);
		}, "Adding two tasks with same ID");
		
	}
	
	@Test
	void testTaskServiceDeleteTask() {
		
		taskService.addTask(ID1, name1, description1);
		taskService.addTask(ID2, name2, description2);
		
		// verify the tasks were added 
		assertEquals(2, taskService.getTasks().size(), "Tasks map should be size 2");
			
		// Delete the first task
		taskService.deleteTask(ID1);
		assertEquals(1, taskService.getTasks().size(), "Tasks map should be size 1");
		
		
		// Verify that a task cannot be deleted with ID not used
		assertThrows(IllegalArgumentException.class, ()->{
			taskService.deleteTask("7");
		}, "Invalid delete ID");
		assertThrows(IllegalArgumentException.class, ()->{
			taskService.deleteTask(null);
		}, "Null delete ID");
		
		// Delete second task
		taskService.deleteTask(ID2);
		assertTrue(taskService.getTasks().isEmpty());
		
	}
	
	@Test
	void testTaskServiceUpdates() {
		
		taskService.addTask(ID1, name1, description1);
		assertEquals(1, taskService.getTasks().size(), "Tasks map should be size 1");
				
		// Verify the name and description is what was originally set
		assertEquals(name1, taskService.getTasks().get(ID1).getName());
		assertEquals(description1, taskService.getTasks().get(ID1).getDescription());
		
		// Update the name and description
		taskService.updateTaskDescription(ID1, description2);
		taskService.updateTaskName(ID1, name2);
		
		// Verify the update
		assertEquals(name2, taskService.getTasks().get(ID1).getName());
		assertEquals(description2, taskService.getTasks().get(ID1).getDescription());
		
		// Verify that update fails if ID argument is invalid
		assertThrows(IllegalArgumentException.class, ()->{
			taskService.updateTaskDescription(ID2, description2);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			taskService.updateTaskName(ID2, description2);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			taskService.updateTaskDescription(null, description2);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			taskService.updateTaskName(null, description2);
		});
		
	}

}
