
import java.util.ArrayList;

public class Order {
	private String orderNumber;
	private Customer belongsTo;
	private ArrayList<OrderLine> orderLines= new ArrayList<OrderLine>();

	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Customer getBelongsTo() {
		return belongsTo;
	}
	public void setBelongsTo(Customer belongsTo) {
		this.belongsTo = belongsTo;
	}
	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(ArrayList<OrderLine> orderrader) {
		this.orderLines = orderrader;
	}
	public void addOrderLine(OrderLine newOrderLine){
		this.orderLines.add(newOrderLine);
	}
	public void deleteOrderLine(String lineNumber){
		OrderLine ol=this.findOrderLine(lineNumber);
		if(ol != null){
			this.orderLines.remove(ol);
		}
	}
	public OrderLine findOrderLine(String lineNumber){
		for(OrderLine ol: this.orderLines){
			if(ol.getLineNumber().equals(lineNumber)){
				return ol;
			}
		}
		return null;
	}
	public Order(String orderNumber, Customer belongsTo){
		this.setOrderNumber(orderNumber);
		this.setBelongsTo(belongsTo);
	}
	public void changeOrderLine(String lineNumber, int newQuantity) { 
		OrderLine o = this.findOrderLine(lineNumber);
		if (o != null) {
           o.setQuantity(newQuantity);
		}    
	}
	
	public double getTotalOrderPrice(){
		double totalPrice = 0;
		for(OrderLine o: orderLines){
			totalPrice += o.getProduct().getPrice() * o.getQuantity();
		}
		return totalPrice;
	}
}