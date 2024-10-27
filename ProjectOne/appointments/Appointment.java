package appointments;

import java.util.Date;

public class Appointment {
	private final String ID;
	private Date date;
	private String description;
	
	public Appointment(String ID, Date date, String description) {
		
		if (ID == null || ID.length() > 10) { 
			throw new IllegalArgumentException("ID cannot be null and must be 10 characters or less.");
		}
		this.ID = ID;
		setDate(date);
		setDescription(description);
		
	}
	
	public void setDate(Date date) {
		Date currentDate = new Date();
		
		if (date == null || date.before(currentDate)) {
			throw new IllegalArgumentException("Date cannot be in the past");
		}
		
		this.date = date;

	}
	
	public void setDescription(String description) {
		
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description must be valid and less than 50 characters");
		}
		
		this.description = description;
	}
	
	public String getID() {
		
		return this.ID;
	}
	
	public Date getDate() {
		
		return this.date;
	}
	
	public String getDescription() {
		
		return this.description;
	}
}
