
public class Contact {
	private String name;
	private String idNumber;
	
	public Contact(String name, String idNumber) {
		this.name = name;
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public String getIdNumber() {
		return idNumber;
	}
	
	public static Contact createContact(String name, String idNumber) {
		return new Contact(name, idNumber);
	}
}
