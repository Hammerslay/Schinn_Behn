import java.util.ArrayList;

public class Lager {

	private String adress;
	private ArrayList<Produkt> Lagerprodukter= new ArrayList<Produkt>();

	
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}


	public ArrayList<Produkt> getLagerprodukter() {
		return Lagerprodukter;
	}

	public void setLagerprodukter(ArrayList<Produkt> lagerprodukter) {
		Lagerprodukter = lagerprodukter;
	}
}
