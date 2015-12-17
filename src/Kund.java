//hej
import java.util.ArrayList;

public class Kund {
//chaima
	private String namn;
	private String kundnr;
	private String efternamn;
	private String fakturaadress;
	private String emailadress;
	private String telefonnr;
	private ArrayList<Order> ordrar = new ArrayList<Order>();
	
	public String getNamn() {
		return namn;
	}
	public void setNamn(String namn) {
		this.namn = namn;
	}
	public String getKundnr() {
		return kundnr;
	}
	public void setKundnr(String kundnr) {
		this.kundnr = kundnr;
	}
	public String getEfternamn() {
		return efternamn;
	}
	public void setEfternamn(String efternamn) {
		this.efternamn = efternamn;
	}
	public String getFakturaadress() {
		return fakturaadress;
	}
	public void setFakturaadress(String fakturaadress) {
		this.fakturaadress = fakturaadress;
	}
	public String getEmailadress() {
		return emailadress;
	}
	public void setEmailadress(String emailadress) {
		this.emailadress = emailadress;
	}
	public String getTelefonnr() {
		return telefonnr;
	}
	public void setTelefonnr(String telefonnr) {
		this.telefonnr = telefonnr;
	}
	public ArrayList<Order> getOrdrar() {
		return ordrar;
	}
	public void setOrdrar(ArrayList<Order> ordrar) {
		this.ordrar = ordrar;
	}
}
