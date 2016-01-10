
import java.util.ArrayList;

import javax.swing.JFrame;

public class Controller {
	CustomerRegister customerRegister;
	ProductRegister productRegister; //Jakob la till
	OrderRegister orderRegister; //Jakob la till;
	
	private ArrayList<String> orderNumbers = new ArrayList<String>();
	private ArrayList<String> customerNumbers = new ArrayList<String>();
	private final int ORDER_LIMIT = 1000000;
	private final int CUSTOMER_LIMIT = 1000;

	JFrame customerFrame;
	
	public Controller(CustomerRegister customerReg, ProductRegister productReg, OrderRegister orderRegister, JFrame customerFrame){
		this.customerRegister = customerReg;
		this.productRegister = productReg; //Jakob la till
		this.orderRegister = orderRegister; //Jakob la till
		this.customerFrame = customerFrame;
		
		for(int i = ORDER_LIMIT; i > 1000; i--){
			orderNumbers.add(Integer.toString(i));
		}
		for(int i = CUSTOMER_LIMIT ; i > 0; i--){
			customerNumbers.add(Integer.toString(i));
		}
		
		productRegister.add(new Product("Prinskorv 250g", 234));
		productRegister.add(new Product("Offerlamm 500g", 546));
		productRegister.add(new Product("Leverkorv 350g", 300));
		productRegister.add(new Product("", 0));
	}
	
	public String generateNewOrderNumber(){
		String tmpOrderNumber = orderNumbers.get(orderNumbers.size()-1);
		orderNumbers.remove(orderNumbers.size()-1);
		return tmpOrderNumber;
	}
	
	public String generateNewCustomerNumber(){
		String tmpCustomerNumber = customerNumbers.get(customerNumbers.size()-1);
		customerNumbers.remove(customerNumbers.size()-1);
		return tmpCustomerNumber;
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
	/*public String[] returnCustomerInfo(String customerNumberFind){ //B�r inte den h�r funktionen returnera instansen och inte en array?
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
	}*/
	
	/*public String[] returnCustomerByOrderNumber(String orderNumberFind){
		Order o;
		String[] aOrd=null;
		o=orderRegister.findOrder(orderNumberFind);
		
		if(o != null){
			aOrd= new String[6];
			aOrd[0]=o.getOrderNumber();
			aOrd[1]=o.getBelongsTo().getCustomerNumber();
			aOrd[2]=o.getBelongsTo().getFirstName();
			aOrd[3]=o.getBelongsTo().getLastName();
			aOrd[4]=o.getBelongsTo().getPhoneNumber();
			aOrd[5]=o.getBelongsTo().getDeliveryAddress();
		}
		return aOrd;
	}*/
	public void updateCustomer(String cNumber, String newFirstName, String newLastName, String newPhoneNumber, String newDeliveryAddress){
		customerRegister.setCustomer(cNumber, newFirstName, newLastName, newPhoneNumber, newDeliveryAddress);
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
