
import java.util.ArrayList;


public class ProductRegister {
	private ArrayList<Product> produkter= new ArrayList<Product>();

	public ArrayList<Product> getProdukter() {
		return produkter;
	}

	public void setProdukter(ArrayList<Product> produkter) {
		this.produkter = produkter;
	}

	public void add(Product newProduct){
		produkter.add(newProduct);
	}
	public void delete(String name){
		Product p = find(name);
		if(p != null){
			produkter.remove(p);
		}
	}
	public Product find(String name){
		for(Product p : produkter){
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
