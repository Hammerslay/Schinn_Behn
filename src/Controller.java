
import javax.swing.JFrame;

public class Controller {
	CustomerRegister customers;
	JFrame customerFrame;
	
		public Controller(CustomerRegister customerReg,JFrame customerFrame){
			this.customers = customerReg;
			this.customerFrame = customerFrame;
		}
		
		//Kanske skicka in en string array h�r ist�llet?
		public void addCustomer(String customerNumber, String firstName, String lastName, String phoneNumber, String deliveryAddress){
			Customer tmpCustomer = new Customer(customerNumber,firstName,lastName,phoneNumber,deliveryAddress);
			customers.addCustomer(tmpCustomer);
		}
		
		public void deleteCustomer(String customerNumberDelete){
			customers.deleteCustomer(customerNumberDelete);
		}
		public String[] findCustomer(String customerNumberFind){ //B�r inte den h�r funktionen returnera instansen och inte en array?
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
