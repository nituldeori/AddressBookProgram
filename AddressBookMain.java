package addressBook;
import java.util.Scanner;
import java.util.ArrayList;
public class AddressBookMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("******* Welcome to Address Book Program ********");
		int ch1 = 0;
		int flag = 1;
		AddressBookDatabase ABD = new AddressBookDatabase();
		while (ch1 != 6) {
			System.out.println("1. Create new Address Book");
			System.out.println("2. Search for person in City");
			System.out.println("3. Search for person in State");
			System.out.println("4. View persons by City");
			System.out.println("5. View persons by State");
			System.out.println("6. Exit");
			System.out.println("Enter your Choice: ");
			ch1 = sc.nextInt();
			sc.nextLine();

			if (ch1 == 1) {

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
						int ch = 0;
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
									if (AD.getDatabase().size() != 0) {
										for (Contacts c1: AD.getDatabase()) {
											if (c1.getFirstName().equals(firstName) && c1.getLastName().equals(lastName)) {
												System.out.println("The given contact is already present in the AddressBook: " + addressDatabaseName);
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
									int flag1 = 0;
									if (AD.getDatabase().size() == 0) {
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
											flag1 = 1;
											break;

										}

									}
									if (flag1 == 0)
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
					int ch = 0;
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
								int store=1;
								System.out.println("Enter the first name of contact: ");
								String firstName = sc.nextLine();
								System.out.println("Enter the last name of contact: ");
								String lastName = sc.nextLine();
								if (AD.getDatabase().size() != 0) {
									for (Contacts c1: AD.getDatabase()) {
										if (c1.getFirstName().equals(firstName) && c1.getLastName().equals(lastName)) {
											System.out.println("The given contact is already present in the AddressBook: " + addressDatabaseName);
											store=0;
											break;
										}
									}
									if(store==1) {
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
									}
									else
										break;
								}
								else {
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
								}
								

								AD.printDatabase();
								break;
							case 3:
								int flag2 = 0;
								if (AD.getDatabase().size() == 0) {
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
										flag2 = 1;
										break;

									}

								}
								if (flag2 == 0)
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
			} else if (ch1 == 2) {
				if (ABD.getMegaDatabase().size() == 0) {
					System.out.println("No Address Book are present!");
					continue;
				}
				int flag3 = 0;
				System.out.println("Enter the name of the City where you want to search the person: ");
				String city = sc.nextLine();
				System.out.println("Enter the first name of the person you want to search in city " + city);
				String fName = sc.nextLine();
				System.out.println("Enter the last name of the person you want to search in city " + city);
				String lName = sc.nextLine();
				for (AddressDatabase a: ABD.getMegaDatabase()) {
					for (Contacts c: a.getDatabase()) {
						if (c.getCity().equals(city) && c.getFirstName().equals(fName) && c.getLastName().equals(lName)) {
							System.out.println("Person Found in Address Book: " + a.getAddressDatabaseName());
							System.out.println("FirstName: " + c.getFirstName() + " LastName: " + c.getLastName() + " City: " + city);
							flag3 = 1;
						}
					}
				}
				if (flag3 == 0) {
					System.out.println("No contact with that name is found in city " + city);
				}

			} else if (ch1 == 3) {
				if (ABD.getMegaDatabase().size() == 0) {
					System.out.println("No Address Book are present!");
					continue;
				}
				int flag3 = 0;
				System.out.println("Enter the name of the State where you want to search the person: ");
				String state = sc.nextLine();
				System.out.println("Enter the first name of the person you want to search in state " + state);
				String fName = sc.nextLine();
				System.out.println("Enter the last name of the person you want to search in state " + state);
				String lName = sc.nextLine();
				for (AddressDatabase a: ABD.getMegaDatabase()) {
					for (Contacts c: a.getDatabase()) {
						if (c.getState().equals(state) && c.getFirstName().equals(fName) && c.getLastName().equals(lName)) {
							System.out.println("Person Found in Address Book " + a.getAddressDatabaseName());
							System.out.println("FirstName: " + c.getFirstName() + " LastName: " + c.getLastName() + " State: " + state);
							flag3 = 1;
						}
					}
				}
				if (flag3 == 0) {
					System.out.println("No contact with that name is found in city " + state);
				}
			} else if (ch1 == 4) {
				int flag4 = 0;
				int count1 = 0;
				if (ABD.getMegaDatabase().size() == 0) {
					System.out.println("No Address Book are present!");
					continue;
				}
				System.out.println("Enter the name of the city: ");
				String city = sc.nextLine();
				for (AddressDatabase a: ABD.getMegaDatabase()) {
					for (Contacts c: a.getDatabase()) {
						if (c.getCity().equals(city)) {
							System.out.println("FirstName: " + c.getFirstName() + " LastName: " + c.getLastName() + " City: " + c.getCity() + " State: " + c.getState() +
								" Zip: " + c.getZip() + " Phone: " + c.getPhoneNumber() + " email: " + c.getEmail());
							count1++;
							flag4 = 1;
						}
					}
				}
				if (flag4 == 0) {
					System.out.println("No contact in the given city found");
				} else
					System.out.println("No of persons in city " + city + ": " + count1);
			} else if (ch1 == 5) {
				int flag5 = 0;
				int count2 = 0;
				if (ABD.getMegaDatabase().size() == 0) {
					System.out.println("No Address Book are present!");
					continue;
				}
				System.out.println("Enter the name of the state: ");
				String state = sc.nextLine();
				for (AddressDatabase a: ABD.getMegaDatabase()) {
					for (Contacts c: a.getDatabase()) {
						if (c.getState().equals(state)) {
							System.out.println("FirstName: " + c.getFirstName() + " LastName: " + c.getLastName() + " City: " + c.getCity() + " State: " + c.getState() +
								" Zip: " + c.getZip() + " Phone: " + c.getPhoneNumber() + " email: " + c.getEmail());
							count2++;
							flag5 = 1;
						}
					}
				}
				if (flag5 == 0) {
					System.out.println("No contact in the given state found");
				} else
					System.out.println("No of persons in state " + state + ": " + count2);
			}
		}
	}
}