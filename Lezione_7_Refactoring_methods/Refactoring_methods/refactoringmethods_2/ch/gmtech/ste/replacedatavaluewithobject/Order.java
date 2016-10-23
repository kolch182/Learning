package ch.gmtech.ste.replacedatavaluewithobject;

public class Order {
	private Customer _customer;

	public Order (String customer) {
		_customer = new Customer(customer);
	}

	public String getCustomerName() {
		return _customer.getCustomer();
	}

	public void setCustomer(String customerName) {
		_customer = new Customer(customerName);
	}
}
