package ch.gmtech.ste.introducenullobject;

public class NullCustomer extends Customer {
	
	public boolean isNull() {
		return true;
	}
	
	public String getName(){
		return "occupant";
	}
	
	public String setPlan() {
		return "basic";
	}
}
