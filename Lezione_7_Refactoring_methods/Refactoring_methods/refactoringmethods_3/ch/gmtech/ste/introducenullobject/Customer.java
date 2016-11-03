package ch.gmtech.ste.introducenullobject;

public class Customer {
	private String _name = "Stefano";
	private PaymentHistory _history;
	
	protected Customer() {} //needed by the NullCustomer perchè??? 

	public void initHistory(){
		_history = new PaymentHistory();
	}
	
	static Customer newNull() {
		return new NullCustomer();
	}

	public String getName() {
		return _name;
	}

	public String setPlan() {
		return BillingPlan.special();
	}
	
	public PaymentHistory getHistory() {
		return (_history == null) ? PaymentHistory.newNull(): _history;
	}
	
	public boolean isNull() {
		return false;
	}
}
