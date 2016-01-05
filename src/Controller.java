
import java.util.ArrayList;

import javax.swing.JFrame;

public class Controller {
	CustomerRegister customerRegister;
	ProductRegister productRegister; //Jakob la till
	OrderRegister orderRegister; //Jakob la till;

	JFrame customerFrame;
	
	public Controller(CustomerRegister customerReg, ProductRegister productReg, OrderRegister orderRegister, JFrame customerFrame){
		this.customerRegister = customerReg;
		this.productRegister = productReg; //Jakob la till
		this.orderRegister = orderRegister; //Jakob la till
		this.customerFrame = customerFrame;
		
		productRegister.add(new Product("Prinskorv 250g", 234));
		productRegister.add(new Product("Offerlamm 500g", 546));
		productRegister.add(new Product("Leverkorv 350g", 300));
	}
	
	public CustomerRegister getCustomers() {
		return customerRegister;
	}

	public void setCustomers(CustomerRegister customers) {
		this.customerRegister = customers;
	}

	public ProductRegister getProductRegister() {
		return productRegister;
	}

	public void setProductRegister(ProductRegister products) {
		this.productRegister = products;
	}
	
	public OrderRegister getOrderRegister() {
		return orderRegister;
	}

	public void setOrderRegister(OrderRegister orderRegister) {
		this.orderRegister = orderRegister;
	}

	//Kanske skicka in en string-array h�r ist�llet?
	public void addCustomer(String customerNumber, String firstName, String lastName, String phoneNumber, String deliveryAddress){
		Customer tmpCustomer = new Customer(customerNumber,firstName,lastName,phoneNumber,deliveryAddress);
		customerRegister.addCustomer(tmpCustomer);
	}
	
	public void deleteCustomer(String customerNumberDelete){
		customerRegister.deleteCustomer(customerNumberDelete);
	}
	public String[] returnCustomerInfo(String customerNumberFind){ //B�r inte den h�r funktionen returnera instansen och inte en array?
		Customer c;
		String[] aCust= null;
		c= customerRegister.findCustomer(customerNumberFind);
		
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
		customerRegister.setCustomer(cNumber, newFirstName, newLastName, newPhoneNumber, newDeliveryAddress);
	}
	public void reset(){
		
	}
	
	//NY METOD H�R
	public String[] getProductNames(){
		ArrayList<String> productNames = new ArrayList<String>();
		for(Product p: this.getProductRegister().getProducts()){
			productNames.add(p.getName());
		}
		String[] listOfProducts = new String[this.getProductRegister().getProducts().size()];
		for(int i = 0; i < this.getProductRegister().getProducts().size(); i++){
			listOfProducts[i] = productNames.get(i);
		}
		return listOfProducts;
	}
	
	//NY METOD H�R
	public ArrayList<Double> getProductPrices(){
		ArrayList<Double> productPrices = new ArrayList<Double>();
		for(Product p: this.getProductRegister().getProducts()){
			productPrices.add(p.getPrice());
		}
		return productPrices;
	}
	public Customer findCustomer(String customerNumber){
		return this.customerRegister.findCustomer(customerNumber);
	}
}
