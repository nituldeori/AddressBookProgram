package addressBook;

public class Contacts {
	private String firstName;
	private String lastName;
    private String address;
    private String city;
    private String state;
    private long zip;
    private String phoneNumber;
    private String email;
    public Contacts(String firstName,String lastName,String address,String city,String state,long zip,String phoneNumber,String email) {
    	this.firstName=firstName;
    	this.lastName=lastName;
    	this.address=address;
    	this.city=city;
    	this.state=state;
    	this.zip=zip;
    	this.phoneNumber=phoneNumber;
    	this.email=email;
    }
    public String getFirstName() {
    	return firstName;
    }
    public String getLastName() {
    	return lastName;
    }
    public String getAddress() {
    	return address;
    }
    public String getCity() {
    	return city;
    }
    public String getState() {
    	return state;
    }
    public long getZip() {
    	return zip;
    }
    public String getPhoneNumber() {
    	return phoneNumber;
    }
    public String getEmail() {
    	return email;
    }
    public void setFirstName(String firstName) {
    	this.firstName=firstName;
    }
    public void setLastName(String lastName) {
    	this.lastName=lastName;
    }
    public void setAddress(String address) {
    	this.address=address;
    }
    public void setCity(String city) {
    	this.city=city;
    }
    public void setState(String state) {
    	this.state=state;
    }
    public void setZip(long zip) {
    	this.zip=zip;
    }
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber=phoneNumber;
    }
    public void setEmail(String email) {
    	this.email=email;
    }
    public void printDetails() {
    	System.out.println("First Name: "+firstName);
    	System.out.println("Last Name: "+lastName);
    	System.out.println("Address: "+address);
    	System.out.println("City: "+city);
    	System.out.println("State: "+state);
    	System.out.println("Zip: "+zip);
    	System.out.println("PhoneNumber: "+phoneNumber);
    	System.out.println("Email: "+email);
    }
}
