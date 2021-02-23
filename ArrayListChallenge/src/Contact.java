
public class Contact {
	private String name;
	private String idNumber;
	private String favPizza;
	
	

	public Contact(String name, String idNumber, String favPizza) {
		this.name = name;
		this.idNumber = idNumber;
		this.favPizza = favPizza;
	}

	public String getName() {
		return name;
	}

	public String getIdNumber() {
		return idNumber;
	}
	
	public String getFavPizza() {
		return favPizza;
	}
	public static Contact createContact(String name, String idNumber, String favPizza) {
		return new Contact(name, idNumber, favPizza);
	}
}
