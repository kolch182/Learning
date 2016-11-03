package ch.gmtech.ste.introducenullobject;

public class NullCustomer extends Customer {
	
	public boolean isNull() {
		return true;
	}
	
	public String getName(){
		return "occupant";
	}
	
	public PaymentHistory getHistory() {
		return new NullPaymentHistory();
	}
	
	public String setPlan() {
		return "basic";
	}
}
