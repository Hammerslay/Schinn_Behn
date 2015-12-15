import java.util.ArrayList;

public class Orderrad {
	
	private String radnummer;
	private int antal;
	private ArrayList<Produkt> produkter= new ArrayList<Produkt>();
	
	
	public String getRadnummer() {
		return radnummer;
	}
	public void setRadnummer(String radnummer) {
		this.radnummer = radnummer;
	}
	public int getAntal() {
		return antal;
	}
	public void setAntal(int antal) {
		this.antal = antal;
	}
	public ArrayList<Produkt> getProdukter() {
		return produkter;
	}
	public void setProdukter(ArrayList<Produkt> produkter) {
		this.produkter = produkter;
	}

}
