
import java.util.ArrayList;

public class ProductRegister {
	private ArrayList<Product> products= new ArrayList<Product>();

	public ArrayList<Product> getProdukter() {
		return products;
	}

	public void setProdukter(ArrayList<Product> produkter) {
		this.products = produkter;
	}

	public void add(Product newProduct){
		products.add(newProduct);
	}
	public void delete(String name){
		Product p = find(name);
		if(p != null){
			products.remove(p);
		}
	}
	public Product find(String name){
		for(Product p : products){
			if(p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}

	public void setProductName(String productName, String newName) { 
		Product p = this.find(productName);
		if (p != null) {
	        p.setName(newName);
		}
	}
	public void setProductPrice(String productName, double newPrice) { 
		Product p = this.find(productName);
		if (p != null) {
			p.setPrice(newPrice);
		}
	}
}
