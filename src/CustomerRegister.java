import java.util.ArrayList;

public class CustomerRegister {
	private ArrayList<Customer> customers= new ArrayList<Customer>();

	public CustomerRegister(){
		this.addCustomer(new Customer("1234", "Anna", "Andersson", "1111111111", "Storgatan 1"));
		this.addCustomer(new Customer("5678", "Sven", "Svensson", "2222222222", "Storgatan 2"));
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public void addCustomer(Customer newCustomer){
		customers.add(newCustomer);
	}
	public void deleteCustomer(String customerNumber){
		Customer c = findCustomer(customerNumber);
		if(c != null){
			customers.remove(c);
		}
		
	}
	public Customer findCustomer(String customerNumber){
		for(Customer c: customers){
			if(c.getCustomerNumber().equals(customerNumber)){
				return c;
			}
		}
		return null;
	}
	public void setCustomer(String customerNumber, String newFirstName, String newLastName, String newPhoneNumber, String newDeliveryAddress) { 
		Customer c = this.findCustomer(customerNumber);
		if (c != null) {
	           c.setFirstName(newFirstName);
	           c.setLastName(newLastName);
	           c.setPhoneNumber(newPhoneNumber);
	           c.setDeliveryAddress(newDeliveryAddress);
	    
	         }
	}
	public void changeCustomerDAddress(String customerNumber, String newDAddress) { 
		Customer c = this.findCustomer(customerNumber);
		if (c != null) {
	           c.setDeliveryAddress(newDAddress);
	    
	         }
	}
}
