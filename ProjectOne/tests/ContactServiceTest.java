package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import userInfo.Contact;
import userInfo.ContactService;

class ContactServiceTest {
	
	public String fName1 = "fName1";
	public String fName2 = "fName2";
	public String lName1 = "lName1";
	public String lName2 = "lName2";
	public String ID = "ID";
	public String phone = "1234567890";
	public String address1 = "address1";
	public String address2 = "address2";
	
	private ContactService contactService;

	@BeforeEach
	void setup() {
		contactService = new ContactService();
	}
	
	@Test
	void testContactServiceClass() {
		
		Map<String, Contact> contacts = contactService.getContacts();
		assertNotNull(contacts, "Contacts list is null");
		assertTrue(contacts.isEmpty(), "Contact list should be empty");

	}
	
	@Test
	void testCreatingUniqueID() {
		
		String ID1 = contactService.generateUniqueID();
		String ID2 = contactService.generateUniqueID();
		
		assertNotEquals(ID1, ID2, "The two generated IDs should be different");
	}
	
	@Test
	void testCreatingContact() {
		
		contactService.addContact(fName1, lName1, phone, address1);
		
		assertFalse(contactService.getContacts().isEmpty(), "Contacts list should not be empty");
		
		contactService.addContact(fName2, fName1, phone, address2);
		
		assertTrue(contactService.getContacts().size() == 2);
		
		contactService.addContact("ID", fName2, lName1, phone, address1);
		
		// adding duplicate ID should throw argument
		assertThrows(IllegalArgumentException.class, ()-> {
			contactService.addContact("ID", fName2, lName1, phone, address1);
		});
		
	}
	
	@Test
	void testDeletingContact() {
		
		contactService.addContact("ID", "fName", "lName", "1234567890", "Address");
		
		assertFalse(contactService.getContacts().isEmpty(), "Contacts list should not be empty");
		
		contactService.deleteContact("ID");
		
		assertTrue(contactService.getContacts().isEmpty(), "Contacts list should be empty");
	}
	
	@Test
	void testingUpdates() {
		
		contactService.addContact("ID","fName", "lName", "1234567890", "Address");
		String contactID = "ID";
		
		
		assertFalse(contactService.getContacts().isEmpty(), "Contacts list should not be empty");
		
		contactService.updateContactFirstName(contactID, "newFname");
		contactService.updateContactLastName(contactID, "newLname");
		contactService.updateContactPhone(contactID, "1245678901");
		contactService.updateContactAddress(contactID, "newAddress");
		
		assertEquals("newFname", contactService.getContacts().get(contactID).getFirstName(), "Contact should have updated fname");
		assertEquals("newLname", contactService.getContacts().get(contactID).getLastName(), "Contact should have updatedlname");
		assertEquals("1245678901", contactService.getContacts().get(contactID).getPhone(), "Contact should have updated phone");
		assertEquals("newAddress", contactService.getContacts().get(contactID).getAddress(), "Contact should have updated address");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.updateContactFirstName(contactID, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.updateContactFirstName(contactID, "12345678901");
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.updateContactLastName(contactID, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.updateContactLastName(contactID, "12345678901");
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.updateContactPhone(contactID, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.updateContactPhone(contactID, "1");
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.updateContactAddress(contactID, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.updateContactAddress(contactID, "1234567890123456789012345678901");
		});
	}
}

