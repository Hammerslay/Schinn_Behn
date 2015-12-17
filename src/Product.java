import java.util.HashMap;

public class Product {
	private String name;
	private String brand;
	private int price;
	private int amount;
	private String ingredients;
	private String manufacturingMethod;
	private HashMap<String, Order> productOrders= new HashMap<String, Order>();
	private HashMap<String, Warehouse> warehouses= new HashMap<String, Warehouse>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getManufacturingMethod() {
		return manufacturingMethod;
	}
	public void setManufacturingMethod(String manufacturingMethod) {
		this.manufacturingMethod = manufacturingMethod;
	}
	public HashMap<String, Order> getProductOrders() {
		return productOrders;
	}
	public void setProductOrders(HashMap<String, Order> productOrders) {
		this.productOrders = productOrders;
	}
	public HashMap<String, Warehouse> getWarehouses() {
		return warehouses;
	}
	public void setWarehouses(HashMap<String, Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

}
