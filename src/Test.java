//import Is_projekt.Order;

public class Test {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer("000001","Anna","Svensson","Storgatan 2","040567834");
		Customer customer2 = new Customer("000002","Bo","Andersson","Vindgatan 1","042674512");
		
		Product product1= new Product("Julskinka 250g",45.40);
		Product product2= new Product("Prinskorv 350g",60.50);
		Product product3= new Product("Offerlamm 450g",99.90);
		Product product4= new Product("Kalvsylta 350g", 56.90);
		
		CustomerRegister customerRegister= new CustomerRegister();
		ProductRegister productRegister= new ProductRegister();
		
		customerRegister.addCustomer(customer1);
		customerRegister.addCustomer(customer2);
		
		productRegister.add(product1);
		productRegister.add(product2);
		productRegister.add(product3);
		productRegister.add(product4);
		
		OrderLine orderLine2= new OrderLine("Orderrad 2.",product3, 4);
		OrderLine orderLine1 = new OrderLine("Orderrad 1", product4, 2);
		Order order1 = new Order("order nr.1");
		Order order2 = new Order("order nr.2");
		Order order3 = new Order("order nr.3");
		
		order1.addOrderLine(orderLine1);
		order1.setBelongsTo(customer1);
		order1.addOrderLine(orderLine2);
		order2.setBelongsTo(customer1);
		order3.setBelongsTo(customer1);
		
		OrderRegister orderRegister= new OrderRegister();
		
		orderRegister.addOrder(order1);
		orderRegister.addOrder(order2);
		orderRegister.addOrder(order3);
		
		//Ny metod tillagd i Order för att kunna knyta specifika ordrar till en kund. /Jakob
		customer1.addOrder(order1);
		customer1.addOrder(order2);
		customer1.addOrder(order3);
		
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
	
		/*for(Customer c:kundregister.getCustomers()){
			System.out.println(c.getFirstName());
			System.out.println(c.getDeliveryAddress());
			}
					
		for(Product p: produktregister.getProdukter()){
			System.out.println(p.getName());
						
			}		
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
			
		}*/
		
		//Nu går det fint att loopa igenom en kunds ordrar och presentera dem som nedan. /Jakob
		for(Order o: customer1.getOrders()){
			System.out.println(o.getOrderNumber());
			for(OrderLine ol: o.getOrderLines()){
				System.out.println(ol.getLineNumber());
				System.out.println(ol.getAmount());
			}
		}
	}
}
