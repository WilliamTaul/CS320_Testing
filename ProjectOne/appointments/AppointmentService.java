package appointments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AppointmentService {

	private Map<String, Appointment> appointments;
	
	public AppointmentService() {
		this.appointments = new HashMap<>();
	}
	
	public String generateUniqueID() {
	    String ID;
	    do {
	        ID = UUID.randomUUID().toString().replace("-", "").substring(0, 10); // Generate ID and take the first 10 characters
	    } while(appointments.containsKey(ID));
	    
	    return ID;
	}
	
	public void addAppointment(Date date, String description) {
		String ID = generateUniqueID();
		
		if (appointments.containsKey(ID)) {
			throw new IllegalArgumentException("ID is already in use.");
		}
		Appointment newAppointment = new Appointment(ID, date, description);
		
		appointments.put(ID, newAppointment);
	}
	
	public void addAppointment(String ID, Date date, String description) {
		// Overloaded function designed for testing purposes only
		
		if (appointments.containsKey(ID)) {
			throw new IllegalArgumentException("ID is already in use.");
		}
		Appointment newAppointment = new Appointment(ID, date, description);
		
		appointments.put(ID, newAppointment);
	}
	
	public void deleteAppointment(String ID) {
		
		if (ID == null || !appointments.containsKey(ID)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		appointments.remove(ID);
	}
	
	public Map<String, Appointment> getAppointments(){
		
		return appointments;
	}
}
