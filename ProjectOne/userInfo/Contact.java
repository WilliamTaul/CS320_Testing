package userInfo;


public class Contact {

	private final String ID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String ID, String firstName,
			String lastName, String phone, String address) {
		
		if(ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		this.ID = ID;
		
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	

	
	public String getID() {
		return this.ID;
	}
	
	public void setFirstName(String firstName) {
		
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;	
	}
	
	public void setLastName(String lastName) {
		
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setPhone(String phone) {
		
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone");
		}
		
		if (containsNonDigit(phone)) {
			throw new IllegalArgumentException("Phone number must be digits");
		}
		
		this.phone = phone;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setAddress(String address) {
		
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public static boolean containsNonDigit(String phone) {
		// This method will return false if the string passed
		// contains any non digit. This is to verify phone numbers
		
		for (char ch : phone.toCharArray() ) {
			if (!Character.isDigit(ch)) {
				return true;
			}
		}
		
		return false;
	}
}
