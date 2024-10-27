package tasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class TaskService {
	

	private Map<String, Task> tasks;
	
	public TaskService() {
		
		this.tasks = new HashMap<>();
	}
	
	
	public String generateUniqueID() {
	    String ID;
	    do {
	        ID = UUID.randomUUID().toString().replace("-", "").substring(0, 10); // Generate ID and take the first 10 characters
	    } while(tasks.containsKey(ID));
	    
	    return ID;
	}
	
	public void addTask(String name, String description) {
		// This function will be the one used. Passes into the
		// overloaded function for verification
		
		String ID = generateUniqueID();
		addTask(ID, name, description);
		
	}
	
	public void addTask(String ID, String name, String description) {
		// Overloaded function for testing purposes. Allows for
		// manual passing of IDs.
		
		if (tasks.containsKey(ID)) {
			throw new IllegalArgumentException("ID already exists");
		}
		
		Task newTask = new Task(ID, name, description);
		tasks.put(ID, newTask);
	}
	
	public void deleteTask(String ID) {
		
		if (ID == null || !tasks.containsKey(ID)) {
			throw new IllegalArgumentException("ID is not valid");
		}
		tasks.remove(ID);

	}
	
	public void updateTaskName(String ID, String newName) {
		if (ID == null || !tasks.containsKey(ID)) {
			throw new IllegalArgumentException("ID is not valid");
		}
		tasks.get(ID).setName(newName);
	}
	
	public void updateTaskDescription(String ID, String newDescription) {
		if (ID == null || !tasks.containsKey(ID)) {
			throw new IllegalArgumentException("ID is not valid");
		}
		tasks.get(ID).setDescription(newDescription);
	}
	
	public Map<String, Task> getTasks() {
		return tasks;
	}
	
	
}
