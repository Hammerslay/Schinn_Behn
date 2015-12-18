import java.util.HashMap;

public class Customer {
	
	private String customerNumber;
	private String firstName;
	private String lastName;
	private String billingAddress;
	private String emailAddress;
	private String phoneNumber;
	private HashMap<String, Order> orders = new HashMap<String, Order>();
	
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String name) {
		this.firstName = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public HashMap<String, Order> getOrders() {
		return orders;
	}
	public void setOrders(HashMap<String, Order> orders) {
		this.orders = orders;
	}
}
