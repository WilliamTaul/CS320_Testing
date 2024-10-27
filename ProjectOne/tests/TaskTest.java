package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasks.Task;

class TaskTest {
	
	private String ID = "1234567890";
	private String name = "name";
	private String description = "description";

	@Test
	void testConstructor() {
		
		
		
		Task correctTask = new Task(ID, name, description);
		
		assertEquals(ID, correctTask.getID());
		assertEquals(name, correctTask.getName());
		assertEquals(description, correctTask.getDescription());
	}
	
	@Test
	void testID( ) {
		
		assertThrows(IllegalArgumentException.class, ()->{
			// Null ID exception should throw
			Task newTask = new Task(null, name, description);
		}, "Null ID test");
		assertThrows(IllegalArgumentException.class, ()->{
			// ID too long exception should throw
			Task newTask = new Task("12345678901", name, description);
		}, "ID too long test");
	}
	
	@Test
	void testName() {
		
		assertThrows(IllegalArgumentException.class, ()->{
			// Null name exception should throw
			Task newTask = new Task(ID, null, description);
		}, "Null name test");
		assertThrows(IllegalArgumentException.class, ()->{
			// Name too long exception should throw
			Task newTask = new Task(ID, "123456789012345678901", description);
		}, "Name too long test");
	}
	
	@Test
	void testDescription() {
		assertThrows(IllegalArgumentException.class, ()->{
			// Null description exception should throw
			Task newTask = new Task(ID, name, null);
		}, "Null description test");
		assertThrows(IllegalArgumentException.class, ()->{
			// Description too long exception should throw
			Task newTask = new Task(ID, name, "123456789012345678901234567890123456789012345678901");
		}, "Description too long test");
	}
}
