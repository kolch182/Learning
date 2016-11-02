package ch.gmtech.ste.introducenullobject;

public class NullCustomer extends Customer {
	
	private String _plan;
	
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
		_plan = "basic";
		return _plan;
	}
}
