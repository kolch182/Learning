package ch.gmtech.ste.introducenullobject;

public class Sites {
	
	private Customer _customer;
	
	public void initCustomer(){
		_customer = new Customer();
	}

	public Customer getCustomer() {
		return (_customer == null) ? Customer.newNull(): _customer;
	}
}
