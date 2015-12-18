import java.util.HashMap;

public class CustomerRegister {
	
	private HashMap<String, Customer> holders= new HashMap<String,Customer>();

	public HashMap<String, Customer> getHolders() {
		return holders;
	}

	public void setHolders(HashMap<String, Customer> holders) {
		this.holders = holders;
	}
	public Customer findCustomer(String customerNumber){
		return holders.get(customerNumber);
		
	}
	public void deleteCustomer(String customerNumber){
		Customer c = findCustomer(customerNumber);
		if(c != null){
			holders.remove(c);
		}
	}
	public void addCustomer(Customer c ){
		holders.put(c.getCustomerNumber(), c);
	}
}
