package addressBook;
import java.util.Scanner;
import java.util.ArrayList;
public class AddressBookMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("******* Welcome to Address Book Program ********");
		int ch=0;
		int flag=1;
		AddressBookDatabase ABD=new AddressBookDatabase();
		while(ch!=2) {
			System.out.println("1. Create new Address Book");
			System.out.println("2. Exit");
			System.out.println("Enter your Choice: ");
			ch=sc.nextInt();
			sc.nextLine();
			
			if(ch==1) {
				
		        System.out.println("Enter the Address Book Name: ");
		        String addressDatabaseName=sc.nextLine();
		        if(ABD.getMegaDatabase().size()!=0) {
			        for(AddressDatabase ad:ABD.getMegaDatabase()) {
				        if(ad.getAddressDatabaseName().equals(addressDatabaseName)) {
					        System.out.println("Address Book Already Exist! Choose a different name");
					        flag=0;
					        break;
				        }
			        }
			        if(flag==1) {
			        	ArrayList<Contacts> contactsStore=new ArrayList<Contacts>();
		                AddressDatabase AD=new AddressDatabase(contactsStore,addressDatabaseName);
		                ABD.addAddressBook(AD);
		                
			        }
		        }
		        else {
		    	    ArrayList<Contacts> contactsStore=new ArrayList<Contacts>();
		            AddressDatabase AD=new AddressDatabase(contactsStore,addressDatabaseName);
		            ABD.addAddressBook(AD);
		        }
		        flag=1;
		        ABD.printAddressBooks();
		        
			}
        
		}
	}
}
