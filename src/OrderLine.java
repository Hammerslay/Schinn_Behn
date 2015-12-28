public class OrderLine {
	private String lineNumber;
	private int amount;
	private Order order;
	private Product product;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	public OrderLine(String lineNumber,Product product, int amount){
		this.setLineNumber(lineNumber);
		this.setProduct(product);
		this.setAmount(amount);
	}
	
}
