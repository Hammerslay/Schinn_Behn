import java.util.ArrayList;

public class Produkt {
	
	private String namn;
	private String varumärke;
	private ArrayList<Order> ordrarprodukt= new ArrayList<Order>();
	private ArrayList<Lager> produkterLager = new ArrayList<Lager>();
	private ArrayList<ProduktSpecifikation> produktspecifikationer= new ArrayList<ProduktSpecifikation>();
	
	
	public String getNamn() {
		return namn;
	}
	public void setNamn(String namn) {
		this.namn = namn;
	}
	public String getVarumärke() {
		return varumärke;
	}
	public void setVarumärke(String varumärke) {
		this.varumärke = varumärke;
	}
	public ArrayList<Order> getOrdrarprodukt() {
		return ordrarprodukt;
	}
	public void setOrdrarprodukt(ArrayList<Order> ordrarprodukt) {
		this.ordrarprodukt = ordrarprodukt;
	}
	public ArrayList<Lager> getProdukterLager() {
		return produkterLager;
	}
	public void setProdukterLager(ArrayList<Lager> produkterLager) {
		this.produkterLager = produkterLager;
	}
	public ArrayList<ProduktSpecifikation> getProduktspecifikationer() {
		return produktspecifikationer;
	}
	public void setProduktspecifikationer(ArrayList<ProduktSpecifikation> produktspecifikationer) {
		this.produktspecifikationer = produktspecifikationer;
	}
	

}
