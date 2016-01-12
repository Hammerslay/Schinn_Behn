import java.util.ArrayList;


public class Customer {
	private String customerNumber;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String deliveryAddress;
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public void addOrder(Order newOrder){
		this.orders.add(newOrder);
	}
	
	public Customer(String customerNumber, String firstname, String lastname, String deliveryAddress,String phoneNumber){
		   this.setCustomerNumber(customerNumber);
		   this.setFirstName(firstname);
		   this.setLastName(lastname);
		   this.setDeliveryAddress(deliveryAddress);
		   this.setPhoneNumber(phoneNumber);
	}
	public void deleteOrder(String orderNumber){
		Order o = findOrder(orderNumber);
		if(o != null){
			orders.remove(o);
		}
	}
	public Order findOrder(String orderNumber){
		for(Order o: orders){
			if(o.getOrderNumber().equals(orderNumber)){
				return o;
			}
		}
		return null;
	}
}
