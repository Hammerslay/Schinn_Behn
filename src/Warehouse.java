import java.util.HashMap;

public class Warehouse {
	private String address;
	private HashMap<String, Product> warehouseProducts = new HashMap<String, Product>();
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public HashMap<String, Product> getWarehouseProducts() {
		return warehouseProducts;
	}
	public void setWarehouseProducts(HashMap<String, Product> warehouseProducts) {
		this.warehouseProducts = warehouseProducts;
	}

}
