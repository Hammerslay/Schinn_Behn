import java.util.ArrayList;

public class Product {
	private String name;
	private double price;
	private ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	public Product(String name, double price){
		this.setName(name);
		this.setPrice(price);
	}
}
