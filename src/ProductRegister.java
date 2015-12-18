import java.util.HashMap;

public class ProductRegister {
	private HashMap<String, Product> productRegister= new HashMap<String,Product>();

	public HashMap<String, Product> getProductRegister() {
		return productRegister;
	}

	public void setProductRegister(HashMap<String, Product> productRegister) {
		this.productRegister = productRegister;
	}

}
