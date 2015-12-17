import java.util.HashMap;

public class CustomerRegister {
	
	private HashMap<String, Customer> holders= new HashMap<String,Customer>();

	public HashMap<String, Customer> getHolders() {
		return holders;
	}

	public void setHolders(HashMap<String, Customer> holders) {
		this.holders = holders;
	}

}
