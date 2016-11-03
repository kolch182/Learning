package ch.gmtech.ste.introducenullobject;

public class Customer {
	private String _name = "Stefano";
	private PaymentHistory _history = new PaymentHistory();
	
	protected Customer() {} //needed by the NullCustomer perchè??? 

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
