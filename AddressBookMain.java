package addressBook;
import java.util.Scanner;
import java.util.ArrayList;
public class AddressBookMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("******* Welcome to Address Book Program ********");
		System.out.println("Enter the first name of contact: ");
		String firstName=sc.nextLine();
		System.out.println("Enter the last name of contact: ");
		String lastName=sc.nextLine();
		System.out.println("Enter the address of contact: ");
		String address=sc.nextLine();
		System.out.println("Enter the city of contact: ");
		String city=sc.nextLine();
		System.out.println("Enter the state of contact: ");
		String state=sc.nextLine();
		System.out.println("Enter the zip of contact: ");
		long zip=sc.nextLong();
		sc.nextLine();
		System.out.println("Enter the phone number of contact: ");
		String phoneNumber=sc.nextLine();
		System.out.println("Enter the email of contact: ");
		String email=sc.nextLine();
		Contacts c=new Contacts(firstName,lastName,address,city,state,zip,phoneNumber,email);
		System.out.println("Enter the Address Database Name: ");
		String addressDatabaseName=sc.nextLine();
		ArrayList<Contacts> contactsStore=new ArrayList<Contacts>();
		contactsStore.add(c);
		AddressDatabase AD=new AddressDatabase(contactsStore,addressDatabaseName);
		System.out.println("Enter the first name of the contact whose details you want to edit: ");
		String editfirstName=sc.nextLine();
		System.out.println("Enter the last name of the contact whose details you want to edit: ");
		String editlastName=sc.nextLine();
		for(Contacts co:AD.getDatabase()) {
			if(co.getFirstName().equals(editfirstName) && co.getLastName().equals(editlastName)) {
				System.out.println("Enter the new first name of contact: ");
				String newFirstName=sc.nextLine();
				System.out.println("Enter the new last name of contact: ");
				String newLastName=sc.nextLine();
				System.out.println("Enter the new address of contact: ");
				String newAddress=sc.nextLine();
				System.out.println("Enter the new city of contact: ");
				String newCity=sc.nextLine();
				System.out.println("Enter the new state of contact: ");
				String newState=sc.nextLine();
				System.out.println("Enter the new zip of contact: ");
				long newZip=sc.nextLong();
				sc.nextLine();
				System.out.println("Enter the new phone number of contact: ");
				String newPhoneNumber=sc.nextLine();
				System.out.println("Enter the new email of contact: ");
				String newEmail=sc.nextLine();
				co.setFirstName(newFirstName);
				co.setLastName(newLastName);
				co.setAddress(newAddress);
				co.setCity(newCity);
				co.setState(newState);
				co.setZip(newZip);
				co.setPhoneNumber(newPhoneNumber);
				co.setEmail(newEmail);
				AD.printDatabase();
				
			}
			else
				System.out.println("The given contact does not exist in the address book");
		}
	}

}
