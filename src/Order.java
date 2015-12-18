import java.util.HashMap;

public class Order {
	
	private String orderNumber;
	private String deliveryAddress;
	private String orderDate;
	private Customer customer;
	private HashMap<String, OrderLine> orderLines= new HashMap<String, OrderLine>();
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public HashMap<String, OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(HashMap<String, OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	
}
