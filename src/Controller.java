
import javax.swing.JFrame;

public class Controller {
	CustomerRegister customers;
	ProductRegister products; //Jakob la till
	JFrame customerFrame;
	
	public CustomerRegister getCustomers() {
		return customers;
	}

	public void setCustomers(CustomerRegister customers) {
		this.customers = customers;
	}

	public ProductRegister getProducts() {
		return products;
	}

	public void setProducts(ProductRegister products) {
		this.products = products;
	}

	public Controller(CustomerRegister customerReg, ProductRegister productReg, JFrame customerFrame){
		this.customers = customerReg;
		this.products = productReg; //Jakob la till
		this.customerFrame = customerFrame;
	}
	
	//Kanske skicka in en string-array här istället?
	public void addCustomer(String customerNumber, String firstName, String lastName, String phoneNumber, String deliveryAddress){
		Customer tmpCustomer = new Customer(customerNumber,firstName,lastName,phoneNumber,deliveryAddress);
		customers.addCustomer(tmpCustomer);
	}
	
	public void deleteCustomer(String customerNumberDelete){
		customers.deleteCustomer(customerNumberDelete);
	}
	public String[] findCustomer(String customerNumberFind){ //Bör inte den här funktionen returnera instansen och inte en array?
		Customer c;
		String[] aCust= null;
		c= customers.findCustomer(customerNumberFind);
		
		if(c != null){
			aCust= new String[5];
			aCust[0]= c.getCustomerNumber();
			aCust[1]= c.getFirstName();
			aCust[2]=c.getLastName();
			aCust[3]=c.getPhoneNumber();
			aCust[4]=c.getDeliveryAddress();
		}
		return aCust;
	}
	public void updateCustomer(String cNumber, String newFirstName, String newLastName, String newPhoneNumber, String newDeliveryAddress){
		customers.setCustomer(cNumber, newFirstName, newLastName, newPhoneNumber, newDeliveryAddress);
	}
	public void reset(){
		
	}
}
