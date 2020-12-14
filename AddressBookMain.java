package addressBook;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
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
						String fileName=addressDatabaseName+".json";
						JSONArray contactList = new JSONArray();
						
						 
						int ch = 0;
						while (ch != 8) {
							System.out.println("Enter your choice");
							System.out.println("1. Add contact to Address Book");
							System.out.println("2. Modify contact in Address Book");
							System.out.println("3. Delete contact in Address Book");
							System.out.println("4. Sort contact by First Name");
							System.out.println("5. Sort contact by City");
							System.out.println("6. Sort contact by State");
							System.out.println("7. Sort contact by Zip");
							System.out.println("8. Exit");
							JSONObject contactDetails = new JSONObject();
							ch = sc.nextInt();
							sc.nextLine();
							switch (ch) {
								case 1:
									int store = 1;
									System.out.println("Enter the first name of contact: ");
									String firstName = sc.nextLine();
									System.out.println("Enter the last name of contact: ");
									String lastName = sc.nextLine();
									if (AD.getDatabase().size() != 0) {
										for (Contacts c1: AD.getDatabase()) {
											if (c1.getFirstName().equals(firstName) && c1.getLastName().equals(lastName)) {
												System.out.println("The given contact is already present in the AddressBook: " + addressDatabaseName);
												store = 0;
												break;
											}
										}
										if (store == 1) {
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
											
											contactDetails.put("FirstName", firstName);
									        contactDetails.put("LastName", lastName);
									        contactDetails.put("Address", address);
									        contactDetails.put("City", city);
									        contactDetails.put("State", state);
									        contactDetails.put("Zip", zip);
									        contactDetails.put("PhoneNo", phoneNumber);
									        contactDetails.put("Email", email);
									        JSONObject contactObject = new JSONObject(); 
									        contactObject.put("contact", contactDetails);
											
									        contactList.put(contactObject);
									         
											AD.getDatabase().add(c);
										} else
											break;
									} else {
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
										contactDetails.put("FirstName", firstName);
								        contactDetails.put("LastName", lastName);
								        contactDetails.put("Address", address);
								        contactDetails.put("City", city);
								        contactDetails.put("State", state);
								        contactDetails.put("Zip", zip);
								        contactDetails.put("PhoneNo", phoneNumber);
								        contactDetails.put("Email", email);
								        JSONObject contactObject = new JSONObject(); 
								        contactObject.put("contact", contactDetails);
								        contactList.put(contactObject);
										AD.getDatabase().add(c);
										
									}

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
								case 4: List<Contacts> list1=(AD.getDatabase()).stream().sorted(Comparator.comparing(Contacts::getFirstName)).collect(Collectors.toList());
								        if(list1.size()==0) {
								        	System.out.println("No contact present in the address book: "+AD.getAddressDatabaseName());
								        	break;
								        }
								        else {
								        	for(Contacts c1:list1) {
								        		System.out.println("FirstName: " + c1.getFirstName() + " LastName: " + c1.getLastName() + " City: " + c1.getCity() + " State: " + c1.getState() +
														" Zip: " + c1.getZip() + " Phone: " + c1.getPhoneNumber() + " email: " + c1.getEmail());
								        	}
								        }
								        break;
								case 5: List<Contacts> list2=(AD.getDatabase()).stream().sorted(Comparator.comparing(Contacts::getCity)).collect(Collectors.toList());
						                if(list2.size()==0) {
						        	        System.out.println("No contact present in the address book: "+AD.getAddressDatabaseName());
						                }
						                else {
						        	        for(Contacts c1:list2) {
						        		        System.out.println("FirstName: " + c1.getFirstName() + " LastName: " + c1.getLastName() + " City: " + c1.getCity() + " State: " + c1.getState() +
												        " Zip: " + c1.getZip() + " Phone: " + c1.getPhoneNumber() + " email: " + c1.getEmail());
						        	        }
						                }
						                break;
								case 6: List<Contacts> list3=(AD.getDatabase()).stream().sorted(Comparator.comparing(Contacts::getState)).collect(Collectors.toList());
						                if(list3.size()==0) {
						        	        System.out.println("No contact present in the address book: "+AD.getAddressDatabaseName());
						                }
						                else {
						        	        for(Contacts c1:list3) {
						        		        System.out.println("FirstName: " + c1.getFirstName() + " LastName: " + c1.getLastName() + " City: " + c1.getCity() + " State: " + c1.getState() +
												        " Zip: " + c1.getZip() + " Phone: " + c1.getPhoneNumber() + " email: " + c1.getEmail());
						        	        }
						                }
						                break;
								case 7: List<Contacts> list=(AD.getDatabase()).stream().sorted(Comparator.comparing(Contacts::getZip)).collect(Collectors.toList());
						                if(list.size()==0) {
						        	        System.out.println("No contact present in the address book: "+AD.getAddressDatabaseName());
						                }
						                else {
						        	        for(Contacts c1:list) {
						        		    System.out.println("FirstName: " + c1.getFirstName() + " LastName: " + c1.getLastName() + " City: " + c1.getCity() + " State: " + c1.getState() +
												    " Zip: " + c1.getZip() + " Phone: " + c1.getPhoneNumber() + " email: " + c1.getEmail());
						        	        }
						                }
						                break;
								default:
									break;
								

							}
							
							

						}
						try (FileWriter file = new FileWriter(fileName)) {
				        	 
				            file.write(contactList.toString());
				 
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
						ABD.addAddressBook(AD);
						
						
				        

						ABD.printAddressBooks();

					}
					flag = 1;

				} else {
					ArrayList<Contacts> contactsStore = new ArrayList<Contacts> ();
					AddressDatabase AD = new AddressDatabase(contactsStore, addressDatabaseName);
					String fileName=addressDatabaseName+".json";
					JSONArray contactList = new JSONArray();
					
					int ch = 0;
					while (ch != 8) {
						System.out.println("Enter your choice");
						System.out.println("1. Add contact to Address Book");
						System.out.println("2. Modify contact in Address Book");
						System.out.println("3. Delete contact in Address Book");
						System.out.println("4. Sort contact by First Name");
						System.out.println("5. Sort contact by City");
						System.out.println("6. Sort contact by State");
						System.out.println("7. Sort contact by Zip");
						System.out.println("8. Exit");
						ch = sc.nextInt();
						sc.nextLine();
						JSONObject contactDetails = new JSONObject();
						switch (ch) {
							case 1:
								int store = 1;
								System.out.println("Enter the first name of contact: ");
								String firstName = sc.nextLine();
								System.out.println("Enter the last name of contact: ");
								String lastName = sc.nextLine();
								if (AD.getDatabase().size() != 0) {
									for (Contacts c1: AD.getDatabase()) {
										if (c1.getFirstName().equals(firstName) && c1.getLastName().equals(lastName)) {
											System.out.println("The given contact is already present in the AddressBook: " + addressDatabaseName);
											store = 0;
											break;
										}
									}
									if (store == 1) {
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
										contactDetails.put("FirstName", firstName);
								        contactDetails.put("LastName", lastName);
								        contactDetails.put("Address", address);
								        contactDetails.put("City", city);
								        contactDetails.put("State", state);
								        contactDetails.put("Zip", zip);
								        contactDetails.put("PhoneNo", phoneNumber);
								        contactDetails.put("Email", email);
								        JSONObject contactObject = new JSONObject(); 
								        contactObject.put("contact", contactDetails);
								        contactList.put(contactObject);
										AD.getDatabase().add(c);
									} else
										break;
								} else {
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
									contactDetails.put("FirstName", firstName);
							        contactDetails.put("LastName", lastName);
							        contactDetails.put("Address", address);
							        contactDetails.put("City", city);
							        contactDetails.put("State", state);
							        contactDetails.put("Zip", zip);
							        contactDetails.put("PhoneNo", phoneNumber);
							        contactDetails.put("Email", email);
							        JSONObject contactObject = new JSONObject(); 
							        contactObject.put("contact", contactDetails);
							        contactList.put(contactObject);
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
							case 4: List<Contacts> list1=(AD.getDatabase()).stream().sorted(Comparator.comparing(Contacts::getFirstName)).collect(Collectors.toList());
					                if(list1.size()==0) {
					        	        System.out.println("No contact present in the address book: "+AD.getAddressDatabaseName());
					                }
					                else {
					        	        for(Contacts c1:list1) {
					        		        System.out.println("FirstName: " + c1.getFirstName() + " LastName: " + c1.getLastName() + " City: " + c1.getCity() + " State: " + c1.getState() +
											        " Zip: " + c1.getZip() + " Phone: " + c1.getPhoneNumber() + " email: " + c1.getEmail());
					        	        }
					                }
					                break;
							case 5: List<Contacts> list2=(AD.getDatabase()).stream().sorted(Comparator.comparing(Contacts::getCity)).collect(Collectors.toList());
					                if(list2.size()==0) {
					        	        System.out.println("No contact present in the address book: "+AD.getAddressDatabaseName());
					                }
					                else {
					        	        for(Contacts c1:list2) {
					        		        System.out.println("FirstName: " + c1.getFirstName() + " LastName: " + c1.getLastName() + " City: " + c1.getCity() + " State: " + c1.getState() +
											        " Zip: " + c1.getZip() + " Phone: " + c1.getPhoneNumber() + " email: " + c1.getEmail());
					        	        }
					                }
					                break;
							case 6: List<Contacts> list3=(AD.getDatabase()).stream().sorted(Comparator.comparing(Contacts::getState)).collect(Collectors.toList());
					                if(list3.size()==0) {
					        	        System.out.println("No contact present in the address book: "+AD.getAddressDatabaseName());
					                }
					                else {
					        	        for(Contacts c1:list3) {
					        		        System.out.println("FirstName: " + c1.getFirstName() + " LastName: " + c1.getLastName() + " City: " + c1.getCity() + " State: " + c1.getState() +
											        " Zip: " + c1.getZip() + " Phone: " + c1.getPhoneNumber() + " email: " + c1.getEmail());
					        	        }
					                }
					                break;
							case 7: List<Contacts> list=(AD.getDatabase()).stream().sorted(Comparator.comparing(Contacts::getZip)).collect(Collectors.toList());
					                if(list.size()==0) {
					        	        System.out.println("No contact present in the address book: "+AD.getAddressDatabaseName());
					                }
					                else {
					        	        for(Contacts c1:list) {
					        		        System.out.println("FirstName: " + c1.getFirstName() + " LastName: " + c1.getLastName() + " City: " + c1.getCity() + " State: " + c1.getState() +
											        " Zip: " + c1.getZip() + " Phone: " + c1.getPhoneNumber() + " email: " + c1.getEmail());
					        	        }
					                }
					                break;
							default:
								break;

						}

					}
					ABD.addAddressBook(AD);
					try (FileWriter file = new FileWriter(fileName)) {
			        	 
			            file.write(contactList.toString());
			 
			        } catch (IOException e) {
			            e.printStackTrace();
			        }

					ABD.printAddressBooks();
					flag = 1;

				}

			} else if (ch1 == 2) {
				if (ABD.getMegaDatabase().size() == 0) {
					System.out.println("No Address Book are present!");
					continue;
				}
				
				System.out.println("Enter the name of the City where you want to search the person: ");
				String city = sc.nextLine();
				for (AddressDatabase a: ABD.getMegaDatabase()) {
					List<Contacts> list=(a.getDatabase()).stream().filter(user->city.equals(user.getCity())).collect(Collectors.toList());
					if(list.size()==0) {
						System.out.println("No contact found in city: "+city);
					}
					else {
						for(Contacts c:list) {
							System.out.println("FirstName: " + c.getFirstName() + " LastName: " + c.getLastName() + " City: " + c.getCity() + " State: " + c.getState() +
									" Zip: " + c.getZip() + " Phone: " + c.getPhoneNumber() + " email: " + c.getEmail());
						}
					}
				}
			} else if (ch1 == 3) {
				if (ABD.getMegaDatabase().size() == 0) {
					System.out.println("No Address Book are present!");
					continue;
				}
				System.out.println("Enter the name of the State where you want to search the person: ");
				String state = sc.nextLine();
				for (AddressDatabase a: ABD.getMegaDatabase()) {
					List<Contacts> list=(a.getDatabase()).stream().filter(user->state.equals(user.getState())).collect(Collectors.toList());
					if(list.size()==0) {
						System.out.println("No contact found in city: "+state);
					}
					else {
						for(Contacts c:list) {
							System.out.println("FirstName: " + c.getFirstName() + " LastName: " + c.getLastName() + " City: " + c.getCity() + " State: " + c.getState() +
									" Zip: " + c.getZip() + " Phone: " + c.getPhoneNumber() + " email: " + c.getEmail());
						}
					}
				}
			} else if (ch1 == 4) {
				if (ABD.getMegaDatabase().size() == 0) {
					System.out.println("No Address Book are present!");
					continue;
				}
				System.out.println("Enter the name of the city: ");
				String city = sc.nextLine();
				for (AddressDatabase a: ABD.getMegaDatabase()) {
					List<Contacts> list=(a.getDatabase()).stream().filter(user->city.equals(user.getCity())).collect(Collectors.toList());
					if(list.size()==0) {
						System.out.println("No contact found in city: "+city);
					}
					else {
						for(Contacts c:list) {
							System.out.println("FirstName: " + c.getFirstName() + " LastName: " + c.getLastName() + " City: " + c.getCity() + " State: " + c.getState() +
									" Zip: " + c.getZip() + " Phone: " + c.getPhoneNumber() + " email: " + c.getEmail());
						}
						System.out.println("Total no of person's in city "+city+": "+list.size());
					}
				}
			} else if (ch1 == 5) {
				if (ABD.getMegaDatabase().size() == 0) {
					System.out.println("No Address Book are present!");
					continue;
				}
				System.out.println("Enter the name of the State: ");
				String state = sc.nextLine();
				for (AddressDatabase a: ABD.getMegaDatabase()) {
					List<Contacts> list=(a.getDatabase()).stream().filter(user->state.equals(user.getState())).collect(Collectors.toList());
					if(list.size()==0) {
						System.out.println("No contact found in city: "+state);
					}
					else {
						for(Contacts c:list) {
							System.out.println("FirstName: " + c.getFirstName() + " LastName: " + c.getLastName() + " City: " + c.getCity() + " State: " + c.getState() +
									" Zip: " + c.getZip() + " Phone: " + c.getPhoneNumber() + " email: " + c.getEmail());
						}
						System.out.println("Total no of person's in "+state+": "+list.size());
					}
				}
			}
		}
		System.out.println("Thank you for using our Address Book");
	}
}