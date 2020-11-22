package addressBook;
import java.util.Scanner;
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
		c.printDetails();
	}

}
