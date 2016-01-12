public class OrderLine {
	private String lineNumber;
	private int quantity;
	private Product product;
	
	public String getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OrderLine(String lineNumber,Product product, int quantity){
		this.setLineNumber(lineNumber);
		this.setProduct(product);
		this.setQuantity(quantity);
	}
	
}