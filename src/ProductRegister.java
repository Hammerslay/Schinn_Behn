
import java.util.ArrayList;

public class ProductRegister {
	private ArrayList<Product> products= new ArrayList<Product>();

	
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> produkter) {
		this.products = produkter;
	}
	public void addProduct(Product newProduct){
		products.add(newProduct);
	}
	public void deleteProduct(String name){
		Product p = findProduct(name);
		if(p != null){
			products.remove(p);
		}
	}
	public Product findProduct(String name){
		for(Product p : products){
			if(p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}
	public void setProductName(String productName, String newName) { 
		Product p = this.findProduct(productName);
		if (p != null) {
	        p.setName(newName);
		}
	}
	public void setProductPrice(String productName, double newPrice) { 
		Product p = this.findProduct(productName);
		if (p != null) {
			p.setPrice(newPrice);
		}
	}
}