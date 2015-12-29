//import Is_projekt.Order;

public class Test {

	public static void main(String[] args) {
		
		Customer kund1 = new Customer("0001","Anna","Svensson","Storgatan 2","040567834");
		Customer kund2 = new Customer("0002","Bo","Andersson","Vindgatan 1","042674512");
		
		Product p1= new Product("Julskinka 250g",45.40);
		Product p2= new Product("Prinskorv 350g",60.50);
		Product p3= new Product("Offerlamm 450g",99.90);
		Product p4= new Product("Kalvsylta 350g", 56.90);
		
		CustomerRegister kundregister= new CustomerRegister();
		ProductRegister produktregister= new ProductRegister();
		
		kundregister.addCustomer(kund1);
		kundregister.addCustomer(kund2);
		
		produktregister.add(p1);
		produktregister.add(p2);
		produktregister.add(p3);
		produktregister.add(p4);
		
		
		OrderLine orderrad2= new OrderLine("Orderrad 2.",p3, 4);
		OrderLine orderrad1 = new OrderLine("Orderrad 1", p4, 2);
		Order order1 = new Order("order nr.1");
		Order order2=new Order("order nr.2");
		Order order3=new Order("order nr.3");
		
		order1.addOrderLine(orderrad1);
		order1.setBelongsTo(kund1);
		order1.addOrderLine(orderrad2);
		order2.setBelongsTo(kund1);
		order3.setBelongsTo(kund1);
		
		OrderRegister orderregister= new OrderRegister();
		
		orderregister.addOrder(order1);
		orderregister.addOrder(order2);
		orderregister.addOrder(order3);
		
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
		
		
		
		for(Order o: orderregister.getOrders()){
			System.out.println(o.getOrderNumber());
			System.out.println(o.getBelongsTo().getFirstName());
			
		}
		for(Order o: kund1.getOrders()){
			System.out.println(o.getOrderNumber());
		}
	
	
	}}
