package addressBook;
import java.util.ArrayList;
public class AddressDatabase {
	private ArrayList<Contacts> database=new ArrayList<Contacts>();
    String addressDatabaseName;
    public void setDatabase(ArrayList<Contacts> database) {
    	this.database=database;
    }
    public void setAddressDatabaseName(String addressDatabaseName) {
    	this.addressDatabaseName=addressDatabaseName;
    }
    public ArrayList<Contacts> getDatabase(){
    	return database;
    }
    public String getAddressDatabaseName() {
    	return addressDatabaseName;
    }
    public AddressDatabase(ArrayList<Contacts> database,String addressDatabaseName) {
    	this.database=database;
    	this.addressDatabaseName=addressDatabaseName;
    }
    public void printDatabase() {
    	if(database.size()==0) {
    		System.out.println("Address Book is empty");
    		return;
    	}
    	System.out.println("Address Book Name: "+addressDatabaseName);
    	System.out.println("Details of Contacts in the database: ");
    	for(Contacts c:database) {
    		c.printDetails();
    	}
    }
}
