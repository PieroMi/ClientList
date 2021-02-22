import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static ClientRecord clientRecord = new ClientRecord("0981 3553 19");

	public static void main(String[] args) {
		boolean quit = false;
		startList();
		printList();
		while(!quit) {
			System.out.println("\nEnter action: (6 to show available actions)");
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch(action) {
			case 0:
				System.out.println("\nShutting down...");
				quit = true;
				break;
			
			case 1:
				clientRecord.printList();
				break;
				
			case 2:
				addNewClient();
				break;
				
			case 3:
				updateClient();
				break;
			
			case 4:
				removeClient();
				break;
				
			case 5:
				searchClient();
				break;
				
			case 6:
				printList();
				break;
			}
		}

	}
	
	
	private static void addNewClient() {
		
		System.out.println("Enter new contact name: ");
		String name = scanner.nextLine();
		System.out.println("Enter ID number: ");
		String idNumber = scanner.nextLine();
		Contact newContact = Contact.createContact(name, idNumber);
		if(clientRecord.addNewClient(newContact)) {
			System.out.println("New contact added: " +  "\n" + "Name: "+ name + "\n" + "ID: " + idNumber);
		} else {
			System.out.println("Cannot add, " + name + " client is already on file");
		}
		
	}
	
	public static void updateClient() {
		System.out.println("Enter existing client name: ");
		String name = scanner.nextLine();
		Contact existingClientRecord = clientRecord.searchClient(name);
		if(existingClientRecord == null) {
			System.out.println("Contact not found.");
			return;
		}
		
		System.out.println("Enter new client name: ");
		String newName = scanner.nextLine();
		System.out.println("Enter new ID number: ");
		String newId = scanner.nextLine();
		Contact newClient  = Contact.createContact(newName, newId);
		if (clientRecord.updateClient(existingClientRecord, newClient)) {
			System.out.println("Successfully update record");
		} else {
			System.out.println("Error updating record");
		}
	}
	
	public static void removeClient() {
		System.out.println("Enter existing client name: ");
		String name = scanner.nextLine();
		Contact existingClientRecord = clientRecord.searchClient(name);
		if(existingClientRecord == null) {
			System.out.println("Contact not found.");
			return;
		}
		
		if(clientRecord.removeClient(existingClientRecord)){
			System.out.println("Succesfully deleted");
		} else {
			System.out.println("Error deleting client");
		}
	}
	
	public static void searchClient() {
		System.out.println("Enter existing client name: ");
		String name = scanner.nextLine();
		Contact existingClientRecord = clientRecord.searchClient(name);
		if(existingClientRecord == null) {
			System.out.println("Contact not found.");
			return;
		}
		
		System.out.println("Name: " + existingClientRecord.getName() + " ID number is " + existingClientRecord.getIdNumber());
		
	}
		
	private static void startList() {
		System.out.println("Initializing the list....");
	}
	
	private static void printList() {
		System.out.println("Select from the options: \nPress");
		System.out.println("0 - to shutdown\n" +
							"1 - to print client list\n" + 
							"2 - to add a new client\n" + 
							"3 - to update existing client\n" + 
							"4 - to remove and existing client\n" + 
							"5 - to search if an existing client exists\n" + 
							"6 - to print a list of available actions\n");
		System.out.println("Choose your action: ");
	}

}




// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.