package addressBook;
import java.util.Scanner;
import java.util.ArrayList;
public class AddressBookMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("******* Welcome to Address Book Program ********");
		int ch = 0;
		int flag = 1;
		AddressBookDatabase ABD = new AddressBookDatabase();
		while (ch != 2) {
			System.out.println("1. Create new Address Book");
			System.out.println("2. Exit");
			System.out.println("Enter your Choice: ");
			ch = sc.nextInt();
			sc.nextLine();

			if (ch == 1) {

				System.out.println("Enter the Address Book Name: ");
				String addressDatabaseName = sc.nextLine();
				if (ABD.getMegaDatabase().size() != 0) {
					for (AddressDatabase ad: ABD.getMegaDatabase()) {
						if (ad.getAddressDatabaseName().equals(addressDatabaseName)) {
							System.out.println("Address Book Already Exist! Choose a different name");
							flag = 0;
							break;
						}
					}
					if (flag == 1) {
						ArrayList<Contacts> contactsStore = new ArrayList<Contacts> ();
						AddressDatabase AD = new AddressDatabase(contactsStore, addressDatabaseName);
						while (ch != 4) {
							System.out.println("Enter your choice");
							System.out.println("1. Add contact to Address Book");
							System.out.println("2. Modify contact in Address Book");
							System.out.println("3. Delete contact in Address Book");
							System.out.println("4. Exit");
							ch = sc.nextInt();
							sc.nextLine();
							switch (ch) {
								case 1:
									System.out.println("Enter the first name of contact: ");
									String firstName = sc.nextLine();
									System.out.println("Enter the last name of contact: ");
									String lastName = sc.nextLine();
									if(AD.getDatabase().size()!=0) {
										for(Contacts c1:AD.getDatabase()) {
											if(c1.getFirstName().equals(firstName) && c1.getLastName().equals(lastName)) {
												System.out.println("The given contact is already present in the AddressBook: "+addressDatabaseName);
												break;
											}
										}
									}
									    System.out.println("Enter the address of contact: ");
									    String address = sc.nextLine();
									    System.out.println("Enter the city of contact: ");
									    String city = sc.nextLine();
									    System.out.println("Enter the state of contact: ");
									    String state = sc.nextLine();
									    System.out.println("Enter the zip of contact: ");
									    long zip = sc.nextLong();
									    sc.nextLine();
									    System.out.println("Enter the phone number of contact: ");
									    String phoneNumber = sc.nextLine();
									    System.out.println("Enter the email of contact: ");
									    String email = sc.nextLine();
									
									    Contacts c = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
									    AD.getDatabase().add(c);

									    
									    AD.printDatabase();
									break;
								case 3:
									int flag1=0;
									if(AD.getDatabase().size()==0) {
										System.out.println("Address Book is empty");
										break;
									}
									System.out.println("Enter the first name of the contact to be deleted: ");
									String deletefirstName = sc.nextLine();
									System.out.println("Enter the last name of the contact to be deleted: ");
									String deletelastName = sc.nextLine();
									
									for (Contacts co: AD.getDatabase()) {
										if (co.getFirstName().equals(deletefirstName) && co.getLastName().equals(deletelastName)) {

											AD.getDatabase().remove(co);
											System.out.println("Contact Deleted Successfully!");
											flag1=1;
											break;

										}

									}
									if(flag1==0)
									    System.out.println("The given contact does not exist in the address book");
									AD.printDatabase();
									break;
								case 2:
									System.out.println("Enter the first name of the contact to be edited: ");
									String editFirstName = sc.nextLine();
									System.out.println("Enter the last name of the contact to be edited: ");
									String editLastName = sc.nextLine();
									for (Contacts co: AD.getDatabase()) {
										if (co.getFirstName().equals(editFirstName) && co.getLastName().equals(editLastName)) {

											System.out.println("Enter the new first name: ");
											String newFirstName = sc.nextLine();
											System.out.println("Enter the new last name: ");
											String newLastName = sc.nextLine();
											System.out.println("Enter the new address: ");
											String newAddress = sc.nextLine();
											System.out.println("Enter the new city: ");
											String newCity = sc.nextLine();
											System.out.println("Enter the new state: ");
											String newState = sc.nextLine();
											System.out.println("Enter the new zip: ");
											long newZip = sc.nextLong();
											sc.nextLine();
											System.out.println("Enter the new phone number: ");
											String newPhoneNumber = sc.nextLine();
											System.out.println("Enter the new email: ");
											String newEmail = sc.nextLine();
											co.setFirstName(newFirstName);
											co.setLastName(newLastName);
											co.setAddress(newAddress);
											co.setCity(newCity);
											co.setState(newState);
											co.setZip(newZip);
											co.setPhoneNumber(newPhoneNumber);
											co.setEmail(newEmail);

										}

									}
									System.out.println("The given contact does not exist in the address book");
									AD.printDatabase();
								default:
									break;

							}

						}
						ABD.addAddressBook(AD);
					}
				} else {
					ArrayList<Contacts> contactsStore = new ArrayList<Contacts> ();
					AddressDatabase AD = new AddressDatabase(contactsStore, addressDatabaseName);
					while (ch != 4) {
						System.out.println("Enter your choice");
						System.out.println("1. Add contact to Address Book");
						System.out.println("2. Modify contact in Address Book");
						System.out.println("3. Delete contact in Address Book");
						System.out.println("4. Exit");
						ch = sc.nextInt();
						sc.nextLine();
						switch (ch) {
							case 1:
								System.out.println("Enter the first name of contact: ");
								String firstName = sc.nextLine();
								System.out.println("Enter the last name of contact: ");
								String lastName = sc.nextLine();
								if(AD.getDatabase().size()!=0) {
									for(Contacts c1:AD.getDatabase()) {
										if(c1.getFirstName().equals(firstName) && c1.getLastName().equals(lastName)) {
											System.out.println("The given contact is already present in the AddressBook: "+addressDatabaseName);
											break;
										}
									}
								}
								    System.out.println("Enter the address of contact: ");
								    String address = sc.nextLine();
								    System.out.println("Enter the city of contact: ");
								    String city = sc.nextLine();
								    System.out.println("Enter the state of contact: ");
								    String state = sc.nextLine();
								    System.out.println("Enter the zip of contact: ");
								    long zip = sc.nextLong();
								    sc.nextLine();
								    System.out.println("Enter the phone number of contact: ");
								    String phoneNumber = sc.nextLine();
								    System.out.println("Enter the email of contact: ");
								    String email = sc.nextLine();
								
								    Contacts c = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
								    AD.getDatabase().add(c);

								    
								    AD.printDatabase();
								break;
							case 3:
								int flag2=0;
								if(AD.getDatabase().size()==0) {
									System.out.println("Address Book is empty");
									break;
								}
								System.out.println("Enter the first name of the contact to be deleted: ");
								String deletefirstName = sc.nextLine();
								System.out.println("Enter the last name of the contact to be deleted: ");
								String deletelastName = sc.nextLine();
								for (Contacts co: AD.getDatabase()) {
									if (co.getFirstName().equals(deletefirstName) && co.getLastName().equals(deletelastName)) {

										AD.getDatabase().remove(co);
										System.out.println("Contact Deleted Successully!");
										flag2=1;
										break;

									}

								}
								if(flag2==0)
								    System.out.println("The given contact does not exist in the address book");
								AD.printDatabase();
								break;
							case 2:
								System.out.println("Enter the first name of the contact to be edited: ");
								String editFirstName = sc.nextLine();
								System.out.println("Enter the last name of the contact to be edited: ");
								String editLastName = sc.nextLine();
								for (Contacts co: AD.getDatabase()) {
									if (co.getFirstName().equals(editFirstName) && co.getLastName().equals(editLastName)) {

										System.out.println("Enter the new first name: ");
										String newFirstName = sc.nextLine();
										System.out.println("Enter the new last name: ");
										String newLastName = sc.nextLine();
										System.out.println("Enter the new address: ");
										String newAddress = sc.nextLine();
										System.out.println("Enter the new city: ");
										String newCity = sc.nextLine();
										System.out.println("Enter the new state: ");
										String newState = sc.nextLine();
										System.out.println("Enter the new zip: ");
										long newZip = sc.nextLong();
										sc.nextLine();
										System.out.println("Enter the new phone number: ");
										String newPhoneNumber = sc.nextLine();
										System.out.println("Enter the new email: ");
										String newEmail = sc.nextLine();
										co.setFirstName(newFirstName);
										co.setLastName(newLastName);
										co.setAddress(newAddress);
										co.setCity(newCity);
										co.setState(newState);
										co.setZip(newZip);
										co.setPhoneNumber(newPhoneNumber);
										co.setEmail(newEmail);

									}

								}
								System.out.println("The given contact does not exist in the address book");
								AD.printDatabase();
							default:
								break;

						}

					}
					ABD.addAddressBook(AD);

					flag = 1;
					ABD.printAddressBooks();

				}
			}
		}
	}
}
