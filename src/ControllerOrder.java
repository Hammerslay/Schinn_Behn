
import java.util.ArrayList;

import javax.swing.JFrame;

public class ControllerOrder {
	private ProductRegister productRegister;
	private OrderRegister orderRegister; 
	private JFrame frame;
	
	private ArrayList<String> orderNumbers = new ArrayList<String>();
	private final int ORDER_LIMIT = 1000;
	

	
	
	public ControllerOrder( JFrame frame){
		this.productRegister = new ProductRegister(); 
		this.orderRegister = new OrderRegister(); 
		this.frame = frame;
		
		for(int i = ORDER_LIMIT; i > 0; i--){
			orderNumbers.add(Integer.toString(i));
		}
		
		productRegister.addProduct(new Product("Prinskorv 250g", 234.90));
		productRegister.addProduct(new Product("Offerlamm 500g", 546.80));
		productRegister.addProduct(new Product("Leverkorv 350g", 160.50));
		productRegister.addProduct(new Product("", 0));
	}
	public ProductRegister getProductRegister() {
		return productRegister;
	}

	public void setProductRegister(ProductRegister products) {
		this.productRegister = products;
	}
	
	public OrderRegister getOrderRegister() {
		return orderRegister;
	}

	public void setOrderRegister(OrderRegister orderRegister) {
		this.orderRegister = orderRegister;
	}
	
	
	public Order findOrder(String orderNumber){
		return this.orderRegister.findOrder(orderNumber);
	}
	
	public String generateNewOrderNumber(){
		String tmpOrderNumber = orderNumbers.get(orderNumbers.size()-1);
		orderNumbers.remove(orderNumbers.size()-1);
		return tmpOrderNumber;
	}

	public String[] getProductNames(){
		ArrayList<String> productNames = new ArrayList<String>();
		for(Product p: this.getProductRegister().getProducts()){
			productNames.add(p.getName());
		}
		String[] listOfProducts = new String[this.getProductRegister().getProducts().size()];
		for(int i = 0; i < this.getProductRegister().getProducts().size(); i++){
			listOfProducts[i] = productNames.get(i);
		}
		return listOfProducts;
	}
	
	public ArrayList<Double> getProductPrices(){
		ArrayList<Double> productPrices = new ArrayList<Double>();
		for(Product p: this.getProductRegister().getProducts()){
			productPrices.add(p.getPrice());
		}
		return productPrices;
	}
	public double totalOrderPrice(String orderNumber){
		Order tmpOrder = findOrder(orderNumber);
		if(tmpOrder != null){
			return tmpOrder.getTotalOrderPrice();
		}
		return 0;
	}
}
