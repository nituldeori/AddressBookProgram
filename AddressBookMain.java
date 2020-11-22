package addressBook;
import java.util.Scanner;
import java.util.ArrayList;
public class AddressBookMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("******* Welcome to Address Book Program ********");
		int ch=0;
		System.out.println("Enter the Address Database Name: ");
        String addressDatabaseName=sc.nextLine();
        ArrayList<Contacts> contactsStore=new ArrayList<Contacts>();
        AddressDatabase AD=new AddressDatabase(contactsStore,addressDatabaseName);
		while(ch!=4) {
			System.out.println("Enter your choice");
			System.out.println("1. Add contact to Address Book");
			System.out.println("2. Modify contact in Address Book");
			System.out.println("3. Delete contact in Address Book");
			System.out.println("4. Exit");
			ch=sc.nextInt();
			sc.nextLine();
			switch(ch) {
			    case 1: System.out.println("Enter the first name of contact: ");
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
			            
			            AD.getDatabase().add(c);
			            AD.printDatabase();
			            break;
			    case 3: System.out.println("Enter the first name of the contact to be deleted: ");
				        String deletefirstName=sc.nextLine();
				        System.out.println("Enter the last name of the contact to be deleted: ");
				        String deletelastName=sc.nextLine();
				        for(Contacts co:AD.getDatabase()) {
					        if(co.getFirstName().equals(deletefirstName) && co.getLastName().equals(deletelastName)) {
						
						        AD.getDatabase().remove(co);
						
					        }
					        else
						        System.out.println("The given contact does not exist in the address book");
					        AD.printDatabase();
					       
				        }
				        break;
			    case 2: System.out.println("Enter the first name of the contact to be edited: ");
			            String editFirstName=sc.nextLine();
			            System.out.println("Enter the last name of the contact to be edited: ");
			            String editLastName=sc.nextLine();
			            for(Contacts co:AD.getDatabase()) {
					        if(co.getFirstName().equals(editFirstName) && co.getLastName().equals(editLastName)) {
						
						        System.out.println("Enter the new first name: ");
						        String newFirstName=sc.nextLine();
						        System.out.println("Enter the new last name: ");
						        String newLastName=sc.nextLine();
						        System.out.println("Enter the new address: ");
						        String newAddress=sc.nextLine();
						        System.out.println("Enter the new city: ");
						        String newCity=sc.nextLine();
						        System.out.println("Enter the new state: ");
						        String newState=sc.nextLine();
						        System.out.println("Enter the new zip: ");
						        long newZip=sc.nextLong();
						        sc.nextLine();
						        System.out.println("Enter the new phone number: ");
						        String newPhoneNumber=sc.nextLine();
						        System.out.println("Enter the new email: ");
						        String newEmail=sc.nextLine();
						        co.setFirstName(newFirstName);
						        co.setLastName(newLastName);
						        co.setAddress(newAddress);
						        co.setCity(newCity);
						        co.setState(newState);
						        co.setZip(newZip);
						        co.setPhoneNumber(newPhoneNumber);
						        co.setEmail(newEmail);
						        
						
					        }
					        else
						        System.out.println("The given contact does not exist in the address book");
					        AD.printDatabase();
					       
				        }
			    default: break;
			    	
			    }
		}
		
		
	}

}
