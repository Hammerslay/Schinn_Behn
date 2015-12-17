import java.util.HashMap;

public class ProductRegister {
	private HashMap<String, Product> productsRegister= new HashMap<String,Product>();

	public HashMap<String, Product> getProductsRegister() {
		return productsRegister;
	}

	public void setProductsRegister(HashMap<String, Product> productsRegister) {
		this.productsRegister = productsRegister;
	}

}
