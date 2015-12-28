import java.util.ArrayList;

public class Order {
	private String orderNumber;
	//private String orderDate;
	private Customer belongsTo;
	private ArrayList<OrderLine> orderrader= new ArrayList<OrderLine>();
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	/*public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}*/
	public Customer getBelongsTo() {
		return belongsTo;
	}
	public void setBelongsTo(Customer belongsTo) {
		this.belongsTo = belongsTo;
	}
	public ArrayList<OrderLine> getOrderrader() {
		return orderrader;
	}
	public void setOrderrader(ArrayList<OrderLine> orderrader) {
		this.orderrader = orderrader;
	}
	public void addOrderLine(OrderLine newOrderLine){
		this.orderrader.add(newOrderLine);
	}
	
	public void deleteOrderLine(String lineNumber){
		OrderLine ol=this.findOrderLine(lineNumber);
		if(ol != null){
			this.orderrader.remove(ol);
		}
	}
	public OrderLine findOrderLine(String lineNumber){
		for(OrderLine ol: this.orderrader){
			if(ol.getLineNumber().equals(lineNumber)){
				return ol;
			}
		}
		return null;
	}
	public Order(String orderNumber){
		this.setOrderNumber(orderNumber);
		//this.setOrderDate(orderDate);
		
	}
	
	/*public void changeOrderLine(String lineNumber, int newAmount) { 
		
		OrderLine o = this.findOrderLine(lineNumber);
		if (o != null) {
			
           o.setAmount(newAmount);
    
		}    
	}*/
		public void changeOrder(String lineNumber, int newAmount) { 
			
			OrderLine o = this.findOrderLine(lineNumber);
			if (o != null) {
				
	           o.setAmount(newAmount);
	    
			}    
}
}

