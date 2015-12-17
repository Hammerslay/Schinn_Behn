import java.util.HashMap;

public class OrderLine {
	
	private String lineNumber;
	private int amount;
	private HashMap<String, Product> products = new HashMap<String, Product>();
	
	public String getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public HashMap<String, Product> getProducts() {
		return products;
	}
	public void setProducts(HashMap<String, Product> products) {
		this.products = products;
	}

}
