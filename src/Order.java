import java.util.ArrayList;

public class Order {
	
	private String ordernr;
	private String leveransadress;
	private Kund owner;
	private ArrayList<Orderrad>orderrader= new ArrayList<Orderrad>();
	private ArrayList<Produkt> orderprodukter = new ArrayList<Produkt>();
	
	public String getOrdernr() {
		return ordernr;
	}
	public void setOrdernr(String ordernr) {
		this.ordernr = ordernr;
	}
	public String getLeveransadress() {
		return leveransadress;
	}
	public void setLeveransadress(String leveransadress) {
		this.leveransadress = leveransadress;
	}
	
	public void setOwner(Kund owner){
		this.owner= owner;
	}
	public Kund getOwner(){
		return owner;
	}
	public ArrayList<Orderrad> getOrderrader() {
		return orderrader;
	}
	public void setOrderrader(ArrayList<Orderrad> orderrader) {
		this.orderrader = orderrader;
	}
	public ArrayList<Produkt> getOrderprodukter() {
		return orderprodukter;
	}
	public void setOrderprodukter(ArrayList<Produkt> orderprodukter) {
		this.orderprodukter = orderprodukter;
	}
	

}
