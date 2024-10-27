package tasks;

public class Task {

	private final String ID;
	private String name;
	private String description;
	
	public Task(String ID, String name, 
			String description) {
		
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("ID cannot be null or longer than 10");
		}
		this.ID = ID;
		setName(name);
		setDescription(description);
		
	}
	
	
	public void setName(String name) {
		
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Name cannot be null or longer than 20");
		}
		
		this.name = name;
		
	}
	
	public void setDescription(String description) {
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description cannot be null or longer than 50");
		}

		this.description = description;
		
	}
	
	public String getID() {
		
		return this.ID;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public String getDescription() {
		
		return this.description;
	}
	
}
