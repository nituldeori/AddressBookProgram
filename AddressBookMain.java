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
		System.out.println("Enter the first name of the contact to be deleted: ");
		String deletefirstName=sc.nextLine();
		System.out.println("Enter the last name of the contact to be deleted: ");
		String deletelastName=sc.nextLine();
		for(Contacts co:AD.getDatabase()) {
			if(co.getFirstName().equals(deletefirstName) && co.getLastName().equals(deletelastName)) {
				
				AD.getDatabase().remove(co);
				AD.printDatabase();
				
			}
			else
				System.out.println("The given contact does not exist in the address book");
		}
	}

}
