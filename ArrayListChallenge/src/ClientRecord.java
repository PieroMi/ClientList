import java.util.ArrayList;

public class ClientRecord {
	private String myNumber;
	private ArrayList<Contact> myContacts;
	
	public ClientRecord(String myNumber) {
		this.myNumber = myNumber;
		this.myContacts = new ArrayList<Contact>();
	}

	public boolean addNewClient(Contact contact) {
		if(findClient(contact.getName())>=0) {
			System.out.println("Client is already on file");
			return false;
		}
		
		myContacts.add(contact);
		return true;
	}
	
	public boolean updateClient(Contact oldContact, Contact newContact) {
		int foundPosition = findClient(oldContact);
		if(foundPosition <0) {
			System.out.println(oldContact.getName() + ", was not found");
			return false;
		} else if(findClient(newContact.getName()) !=-1){ // -1 MEANS THAT IF THE NAME IS NOT -1 THEN IT IS ALREADY ON THE LIST
			System.out.println("Contact with name " + newContact.getName() + " already exists. Update was not successful");
			return false;
		}
		
		this.myContacts.set(foundPosition, newContact);
		System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
		return true;
	}
	
	public boolean removeClient(Contact contact) {
		int foundPosition = findClient(contact);
		if(foundPosition <0) {
			System.out.println(contact.getName() + ", was not found");
			return false;
		}
		
		this.myContacts.remove(foundPosition);
		System.out.println(contact.getName() + ", was deleted");
		return true;
	}
	
	private int findClient(Contact contact) {
		return this.myContacts.indexOf(contact);
	}
	
	private int findClient(String contactName) {
		for(int i=0; i <this.myContacts.size(); i++) {
			Contact contact = this.myContacts.get(i);
			if(contact.getName().equalsIgnoreCase(contactName)) {
				return i;
			}
		}
		return -1;
	}
	
	public String searchClient(Contact contact) { 
		if(findClient(contact) >= 0) {
			return contact.getName();
		}
		return null;
	}
	
	public Contact searchClient(String name) {
		int position = findClient(name);
		if(position >= 0) { // If name found is less than 0 it will return the name
			return this.myContacts.get(position);
		}
		
		return null;
	}
	
	public void printList() {
		System.out.println("Client List");
		for(int i=0; i<this.myContacts.size(); i++) { // While i remains less than the contact size it will continue to add to the list.
			System.out.println((i+1) + "." + 
										"Name:" + this.myContacts.get(i).getName() + 
										" ID:" + this.myContacts.get(i).getIdNumber() + 
										" Favorite Pizza: " + this.myContacts.get(i).getFavPizza());}
	}
	
	
	
	
	
	
	
}
