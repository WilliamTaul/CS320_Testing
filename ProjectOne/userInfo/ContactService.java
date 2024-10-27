package userInfo;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContactService {
	
	private Map<String, Contact> contacts;
	
	
	public ContactService() {
		this.contacts = new HashMap<>();
		
	}
	
	public String generateUniqueID() {
		
	    String ID;
	    do {
	        ID = UUID.randomUUID().toString().replace("-", "").substring(0, 10); // Generate ID and take the first 10 characters
	    } while(contacts.containsKey(ID));
	    
	    return ID;
	}
	
	public void addContact(String firstName, String lastName,
			String phone, String address) {
		
		String uniqueID = generateUniqueID();
		Contact newContact = new Contact(uniqueID, firstName,
				lastName, phone, address);
		contacts.put(uniqueID, newContact);				
	}
	
	public void addContact(String ID, String firstName, String lastName,
			String phone, String address) {
		// Overload function for testing
		
		if (contacts.containsKey(ID)) {
			throw new IllegalArgumentException("ID taken");
		}
		Contact newContact = new Contact(ID, firstName,
				lastName, phone, address);
		contacts.put(ID, newContact);				
	}
 	
	public void deleteContact(String ID) {
		
		if(contacts.containsKey(ID)) {
			contacts.remove(ID);
		}
		else {
			throw new IllegalArgumentException("Invalid ID provided");
		}
		
	}
	
	public void updateContactFirstName(String ID, String firstName) {
				
		if (contacts.containsKey(ID)) {
			contacts.get(ID).setFirstName(firstName);
		}
		
		else {
			throw new IllegalArgumentException("Invalid ID provided");
		}
	}
	
	public void updateContactLastName(String ID, String lastName) {
				
		if (contacts.containsKey(ID)) {
			contacts.get(ID).setLastName(lastName);
		}
		
		else {
			throw new IllegalArgumentException("Invalid ID provided");
		}
	}
	
	public void updateContactPhone(String ID, String phone) {
				
		if (contacts.containsKey(ID)) {
			contacts.get(ID).setPhone(phone);
		}
		
		else {
			throw new IllegalArgumentException("Invalid ID provided");
		}
	}
	
	public void updateContactAddress(String ID, String address) {
		
		if (contacts.containsKey(ID)) {
			contacts.get(ID).setAddress(address);
		}
		
		else {
			throw new IllegalArgumentException("Invalid ID provided");
		}
	}
	

	
	public Map<String, Contact> getContacts(){
		return contacts;
	}
	
}
