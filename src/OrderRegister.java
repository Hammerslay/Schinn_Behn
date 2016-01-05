
import java.util.ArrayList;



	public class OrderRegister {
	
	private ArrayList<Order> orders= new ArrayList<Order>();
	//private ArrayList<String> orderNumbers = new ArrayList<String>();
	/*private final int MAX_NUMBER_OF_ORDERS = 1000;

	public OrderRegister(){
		
		//Konstruktorn 
		for(int i = MAX_NUMBER_OF_ORDERS; i > 0; i--){
			orderNumbers.add(Integer.toString(i));
		}
		
	}*/
	
	//Ny metod f�r att generera ordernummer
	/*private String generateNewOrderNumber(){
		String tmpOrderNumber = orderNumbers.get(orderNumbers.size()-1);
		orderNumbers.remove(orderNumbers.size()-1);
		return tmpOrderNumber;
	}
	*/
	public void releaseOrderNumber(){
		
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public void addOrder(Order newOrder){
		
		//Tilldelar alla nya ordrar som skapas ett unikt ordernummer genom att k�ra generateNewOrderNumber-metoden.
		//newOrder.setOrderNumber(this.generateNewOrderNumber());  
		//newOrder.setOrderNumber(generateNewOrderNumber());
		orders.add(newOrder);
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