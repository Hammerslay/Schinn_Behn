import java.util.ArrayList;

public class Kundregister {
	
	private ArrayList<Kund> kunder = new ArrayList<Kund>();
	
	public void setCustomer(ArrayList<Kund> kunder){
		this.kunder=kunder;
	}
		
	public ArrayList<Kund> getKunder(){
		return kunder;
	}
		
	

}
