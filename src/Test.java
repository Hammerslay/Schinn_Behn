import java.util.ArrayList;

//import Is_projekt.Order;

public class Test {

	public static void main(String[] args) {
		
		CustomerRegister customerRegister= new CustomerRegister();
		ProductRegister productRegister= new ProductRegister();
		OrderRegister orderRegister= new OrderRegister();
		
		Customer customer1 = new Customer("000001","Anna","Svensson","Storgatan 2","040567834");
		Customer customer2 = new Customer("000002","Bo","Andersson","Vindgatan 1","042674512");
		
		customerRegister.addCustomer(customer1);
		customerRegister.addCustomer(customer2);
		
		
		Product product1= new Product("Julskinka 250g",45.40);
		Product product2= new Product("Prinskorv 350g",60.50);
		Product product3= new Product("Offerlamm 450g",99.90);
		Product product4= new Product("Kalvsylta 350g", 56.90);
		
		
		productRegister.addProduct(product1);
		productRegister.addProduct(product2);
		productRegister.addProduct(product3);
		productRegister.addProduct(product4);
		
		OrderLine orderLine1 = new OrderLine("1", product4, 2);
		OrderLine orderLine2= new OrderLine("2.",product3, 4);
		OrderLine orderLine3= new OrderLine("1", product1, 3);
		OrderLine orderLine4= new OrderLine("1", product4, 34);
		Order order1 = new Order("order nr.1", customer1);
		Order order2 = new Order("order nr.2", customer1);
		Order order3 = new Order("order nr.3", customer2);
		
		order1.addOrderLine(orderLine1);
		order1.addOrderLine(orderLine2);
		order2.addOrderLine(orderLine3);
		order3.addOrderLine(orderLine4);
		
		orderRegister.addOrder(order1);
		orderRegister.addOrder(order2);
		orderRegister.addOrder(order3);
		
		customer1.addOrder(order1);
		customer1.addOrder(order2);
		customer2.addOrder(order3);
		
		/*for(Customer c:customerRegister.getCustomers()){
			System.out.println(c.getFirstName());
			System.out.println(c.getDeliveryAddress());
		}
		
		for(Product p: productRegister.getProducts()){
			System.out.println(p.getName());
		}
		
		for(Order o: orderRegister.getOrders()){
			System.out.println(o.getOrderNumber());
			System.out.println(o.getBelongsTo().getFirstName());
			
		}*/
		
		for(Order o: customer1.getOrders()){
			System.out.println(o.getOrderNumber());
			for(OrderLine ol: o.getOrderLines()){
				System.out.println("Orderrad: "+ ol.getLineNumber());
				System.out.println(ol.getProduct().getName());
				System.out.println(ol.getProduct().getPrice()+ " kr/st");
				System.out.println("Antal:" + ol.getQuantity() + "st");
				System.out.println("");
			}
			System.out.println("Totalt pris: " + o.getTotalOrderPrice() + " kr");
			System.out.println("");
		}
		
		Customer tmpCustomer = customerRegister.findCustomer("000001");
		if(tmpCustomer!=null){
			Order tmpOrder = tmpCustomer.findOrder("order nr.1");
			OrderLine tmpOrderLine = tmpOrder.findOrderLine("1");
			tmpOrderLine.setProduct(product3);
			tmpOrderLine.setQuantity(5);
			System.out.println("Totalt pris på ändrat order: " + tmpOrder.getTotalOrderPrice() + " kr");
		}
		
			
		/*for(OrderLine o: order1.getOrderrader()){
			System.out.println(o.getLineNumber());
			System.out.println(o.getProduct().getName());
			System.out.println(o.getProduct().getPrice());
			System.out.println(o.getAmount());
		}
		*/
		
		/*for(Order o: orderregister.getOrders()){
			System.out.println(o.getOrderNumber());
			System.out.println(o.getOrderDate());
			System.out.println(o.getBelongsTo().getFirstName());
			
		}
		
		/*
		System.out.println(order1.getBelongsTo().getFirstName());
		System.out.println(order1.getOrderNumber());
				
		for(OrderLine o: order1.getOrderrader()){
			System.out.println(o.getLineNumber());
			System.out.println(o.getProduct().getName());
			System.out.println(o.getProduct().getPrice());
			System.out.println(o.getAmount());
		*/
	

			
		/*
		Order o = orderregister.findOrder("order1");
		if(o != null){
			System.out.println("Hittade: " + o.getOrderNumber());
		}
		
		orderregister.deleteOrder("order1");
		Order or= orderregister.findOrder("order1");
		if(or == null){
			System.out.println("Fungerar!");
		}*/
		
		/*kundregister.changeCustomerDAddress("0001", "Marsgatan 3");
		
		for(Customer c: kundregister.getCustomers()){
			System.out.println(c.getFirstName());
			System.out.println(c.getDeliveryAddress());
			
		}*/
		/*
		produktregister.setProductName("Julskinka 250g", "Julmango");
		produktregister.setProductPrice("Kalvsylta 350g", 12.3);
		
		for(Product p: produktregister.getProdukter()){
			System.out.println(p.getName());
			System.out.println(p.getPrice());
		}
		
		/*order1.changeOrderLine("orderrad 2.", 50);
		order1.changeOrder("Orderrad 1", 34);
		
		for(OrderLine o: order1.getOrderrader()){
			System.out.println(o.getLineNumber());
			System.out.println(o.getAmount());
		}
		*/
		
		/*for(Order o: orderRegister.getOrders()){
			System.out.println(o.getOrderNumber());
			System.out.println(o.getBelongsTo().getFirstName());
			
		}
		
		//Nu g�r det fint att loopa igenom en kunds ordrar och presentera dem som nedan. /Jakob
		for(Order o: customer1.getOrders()){
			System.out.println(o.getOrderNumber());
			for(OrderLine ol: o.getOrderLines()){
				System.out.println(ol.getLineNumber());
				System.out.println(ol.getAmount());
			}
			customerRegister.setCustomer("000001", "Chaima", "Tebini", "6575", "malmö");
			
			Customer a =customerRegister.findCustomer("000001");
			System.out.println(a.getFirstName());
			System.out.println(a.getLastName());
			System.out.println(a.getDeliveryAddress());*/
		
		
		}
	}

