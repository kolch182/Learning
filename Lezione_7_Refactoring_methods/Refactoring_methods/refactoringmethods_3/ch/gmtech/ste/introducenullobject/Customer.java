package ch.gmtech.ste.introducenullobject;

public class Customer {
	private String _name = "Stefano";
	private String _plan;
	private PaymentHistory _history = new PaymentHistory();
	
	protected Customer() {} //needed by the NullCustomer perchè??? 

	static Customer newNull() {
		return new NullCustomer();
	}

	public String getName() {
		return _name;
	}

	public String setPlan() {
		_plan = BillingPlan.special(); 
		return _plan;
	}
	
	public PaymentHistory getHistory() {
		return _history;
	}
	
	public boolean isNull() {
		return false;
	}
}
