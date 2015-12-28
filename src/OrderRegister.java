
import java.util.ArrayList;

	public class OrderRegister {
	
	private ArrayList<Order> orders= new ArrayList<Order>();

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public void addOrder(Order newOrder){
		orders.add(newOrder);
	}
	public void deleteOrder(String orderNumber){
		Order o = findOrder(orderNumber);
		if(o != null){
			orders.remove(o);
		}
	}
	public Order findOrder(String orderNumber){
		for(Order o: this.orders){
			if(o != null){
				return o;
			}
		}
		return null;
	}
	
    
}    