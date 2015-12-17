import java.util.HashMap;

public class Order {
	
	private String orderNumber;
	private String deliveryAdress;
	private String orderDate;
	private Customer holder;
	private HashMap<String, OrderLine> orderlines= new HashMap<String, OrderLine>();
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getDeliveryAdress() {
		return deliveryAdress;
	}
	public void setDeliveryAdress(String deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Customer getHolder() {
		return holder;
	}
	public void setHolder(Customer holder) {
		this.holder = holder;
	}
	public HashMap<String, OrderLine> getOrderlines() {
		return orderlines;
	}
	public void setOrderlines(HashMap<String, OrderLine> orderlines) {
		this.orderlines = orderlines;
	}
	
	
}
