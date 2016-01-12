import java.util.ArrayList;

import javax.swing.JFrame;

public class ControllerCustomer {

	private CustomerRegister customerRegister;
	private JFrame frame;
	private final int CUSTOMER_LIMIT = 1000;
	private ArrayList<String> customerNumbers = new ArrayList<String>();
	
	
	public ControllerCustomer(JFrame frame){
		this.customerRegister = new CustomerRegister();
		this.frame = frame;	
	
		for(int i = CUSTOMER_LIMIT ; i > 0; i--){
			customerNumbers.add(Integer.toString(i));

		}
	}
	public CustomerRegister getCustomers() {
		return customerRegister;
	}

	public void setCustomers(CustomerRegister customers) {
		this.customerRegister = customers;
	}
	public void addCustomer(String customerNumber, String firstName, String lastName, String phoneNumber, String deliveryAddress){
		Customer tmpCustomer = new Customer(customerNumber,firstName,lastName,phoneNumber,deliveryAddress);
		customerRegister.addCustomer(tmpCustomer);
	}
	public Customer findCustomer(String customerNumber){
		return this.customerRegister.findCustomer(customerNumber);
	}
	public void deleteCustomer(String customerNumberDelete){
		customerRegister.deleteCustomer(customerNumberDelete);
	}

	public void updateCustomer(String cNumber, String newFirstName, String newLastName, String newPhoneNumber, String newDeliveryAddress){
		customerRegister.setCustomer(cNumber, newFirstName, newLastName, newPhoneNumber, newDeliveryAddress);
	}
	public String generateNewCustomerNumber(){
		String tmpCustomerNumber = customerNumbers.get(customerNumbers.size()-1);
		customerNumbers.remove(customerNumbers.size()-1);
		return tmpCustomerNumber;
	}
	
	
}