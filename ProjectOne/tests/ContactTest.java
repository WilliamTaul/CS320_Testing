package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import userInfo.Contact;

class ContactTest {

	@Test
	void testContactConstructor() {
		Contact contact = new Contact("uniqueID17", "fName", "lName",
				"1234567890", "105 Street");
		assertTrue(contact.getID().equals("uniqueID17"), "ID did not match");
		assertTrue(contact.getFirstName().equals("fName"), "First name did not match");
		assertTrue(contact.getLastName().equals("lName"), "Last name did not match");
		assertTrue(contact.getPhone().equals("1234567890"), "Phone did not match");
		assertTrue(contact.getAddress().equals("105 Street"), "Address did not match");
	}
	
		
	
	@Test
	void testContactID() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact(null,"fName", "lName",
				"1234567890", "105 Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("12345678901","fName", "lName",
				"1234567890", "105 Street");
		});
	}
	

	
	@Test
	void testContactFName() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("ID", null, "lName",
			"1234567890", "105 Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("ID","12345678901", "lName",
				"1234567890", "105 Street");
		});
	}
	
	
	@Test
	void testContactLName() {
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("ID", "fName", null,
			"1234567890", "105 Street");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("ID", "fName", "lName384728",
			"1234567890", "105 Street");
		});
	}
	

	@Test
	void testContactPhone() {
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("ID", "fname", "lName",
			"2347892375897589", "105 Street");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("ID", "fname", "lName",
			null, "105 Street");
		});
		
		assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("ID", "fname", "lname", "nondigit", "ad");
		});
	}


	@Test
	void testContactAddress() {
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("ID", "fname", "lName",
			null, "105 Street25423545345345245254543535353535");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("ID", "fname", "lName",
			"1234567890", null);
		});
	}
}
