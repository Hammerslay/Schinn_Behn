import java.util.HashMap;

public class ProductRegister {
	private HashMap<String, Product> productRegister= new HashMap<String,Product>();

	public HashMap<String, Product> getProductRegister() {
		return productRegister;
	}

	public void setProductRegister(HashMap<String, Product> productRegister) {
		this.productRegister = productRegister;
	}
	
	public Product findProduct(String name) {
		return productRegister.get(name);
	}
	
	public void addProduct(String name, Product product) {
		productRegister.put(name, product);
	}
	
	public void deleteProduct(String name) {
		Product product = findProduct(name);
		if(product != null){
			productRegister.remove(product);
		}
	}
}
