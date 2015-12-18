import java.util.HashMap;

public class CustomerRegister {
	
	private HashMap<String, Customer> customers= new HashMap<String,Customer>();

	public HashMap<String, Customer> getCustomers() {
		return customers;
	}

	public void setHolders(HashMap<String, Customer> customers) {
		this.customers = customers;
	}
	public Customer findCustomer(String customerNumber){
		return customers.get(customerNumber);
	}
	
	public void deleteCustomer(String customerNumber){
		Customer c = findCustomer(customerNumber);
		if(c != null){
			customers.remove(c);
		}
	}
	public void addCustomer(Customer c ){
		customers.put(c.getCustomerNumber(), c);
	}
}
