package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointments.AppointmentService;

class AppointmentServiceTest {
	
	private AppointmentService AppointmentService;
	private String ID1;
	private String ID2;
	private Date date1;
	private Date date2;
	private String description1;
	private String description2;
	
	@BeforeEach
	void setUp() {
		
		AppointmentService = new AppointmentService();
		ID1 = "123456789";
		ID2 = "234987";
		// Date set an hour in advance to ensure the date is in the future
		date1 = new Date(System.currentTimeMillis() + 3600 * 1000);
		date2 = new Date(System.currentTimeMillis() + 3600 * 1000);
		description1 = "Description1";
		description2 = "Description2";
	}

	@Test
	void testAppointmentServiceAddAppointment() {
		
		
		// Verifying the AppointmentService was created and that the 
		// hashmap is empty
		assertTrue(AppointmentService.getAppointments().isEmpty(), "Appointments is empty test");
		
		
		// Verifying the creation of two different 
		// Appointments and adding them
		AppointmentService.addAppointment(date1, description1);
		AppointmentService.addAppointment(date2, description2);
		
		assertEquals(2, AppointmentService.getAppointments().size(), "Appointments map should be size 2");
		
		
		// Test that the two IDs are different
		List<String> testIDList = new ArrayList<>(AppointmentService.getAppointments().keySet());
		
		assertFalse(testIDList.get(0).equals(testIDList.get(1)), 
				"Testing that the two ids are different");
		
		
		// Test that two Appointments cannot be added with the same ID
		assertThrows(IllegalArgumentException.class, ()->{
			AppointmentService.addAppointment(ID1, date1, description1);
			AppointmentService.addAppointment(ID1, date2, description2);
		}, "Adding two Appointments with same ID");
		
	}
	
	@Test
	void testAppointmentServiceDeleteAppointment() {
		
		AppointmentService.addAppointment(ID1, date1, description1);
		AppointmentService.addAppointment(ID2, date2, description2);
		
		// verify the Appointments were added 
		assertEquals(2, AppointmentService.getAppointments().size(), "Appointments map should be size 2");
	
		// Delete the first Appointment
		AppointmentService.deleteAppointment(ID1);
		assertEquals(1, AppointmentService.getAppointments().size(), "Appointments map should be size 1");
		
		
		// Verify that a Appointment cannot be deleted with ID not used
		assertThrows(IllegalArgumentException.class, ()->{
			AppointmentService.deleteAppointment("7");
		}, "Invalid delete ID");
		assertThrows(IllegalArgumentException.class, ()->{
			AppointmentService.deleteAppointment(null);
		}, "Null delete ID");
		
		// Delete second Appointment
		AppointmentService.deleteAppointment(ID2);
		assertTrue(AppointmentService.getAppointments().isEmpty());
	}
	
	

}
