package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointments.Appointment;

class AppointmentTest {
	
	private Appointment correctAppointment;
	private String ID = "1234567890";
	private Date date;
	String description = "description";
	
	@BeforeEach
	void setUp() {
		
		date = new Date();
		correctAppointment = new Appointment(ID, date, description);
	}

	@Test
	void testConstructor() {
		
		Date ndate = new Date();
		
		assertEquals(ID, correctAppointment.getID());
		assertEquals(date, correctAppointment.getDate());
		assertEquals(description, correctAppointment.getDescription());
		
		
		assertThrows(IllegalArgumentException.class, ()->{
			// Null ID exception should throw
			Appointment newAppointment = new Appointment(null, ndate, description);
		}, "Null ID test");
		assertThrows(IllegalArgumentException.class, ()->{
			// ID too long exception should throw
			Appointment newAppointment = new Appointment("12345678901", ndate, description);
		}, "ID too long test");
	
	}
	
	@Test
	void testSetDate() {
		// Creating a past date to properly test that a date cannot
		// be passed as an argument if it is in the past
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1977,Calendar.MAY, 25);
		Date pastDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class, ()->{
			correctAppointment.setDate(pastDate);
		}, "Past date test");
		
		assertThrows(IllegalArgumentException.class, ()->{
			// Null date exception should throw
			Appointment newAppointment = new Appointment(ID, null, description);
		}, "Null date test");
		
	}

	@Test
	void testSetDescription() {
		
		Date ndate = new Date();
		
		assertThrows(IllegalArgumentException.class, ()->{
			// Null description exception should throw
			Appointment newAppointment = new Appointment(ID, ndate, null);
		}, "Null description test");
		assertThrows(IllegalArgumentException.class, ()->{
			// Description too long exception should throw
			Appointment newAppointment = new Appointment(ID, ndate, "123456789012345678901234567890123456789012345678901");
		}, "Description too long test");
	}
	
}