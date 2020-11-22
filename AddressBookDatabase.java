package addressBook;
import java.util.ArrayList;
public class AddressBookDatabase {
	private ArrayList<AddressDatabase> MegaDatabase=new ArrayList<AddressDatabase>();
	public void setMegaDatabase(ArrayList<AddressDatabase> MegaDatabase) {
		this.MegaDatabase=MegaDatabase;
	}
	public ArrayList<AddressDatabase> getMegaDatabase(){
		return MegaDatabase;
	}
	public void printAddressBooks() {
		System.out.println("The Address Books in the Mega Database are: ");
		for(AddressDatabase ad:MegaDatabase) {
			
			System.out.println(ad.getAddressDatabaseName());
		}
	}
	public void addAddressBook(AddressDatabase AD) {
		MegaDatabase.add(AD);
	}

}
