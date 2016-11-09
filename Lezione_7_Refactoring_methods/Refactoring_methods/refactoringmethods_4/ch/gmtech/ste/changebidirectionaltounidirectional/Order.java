package ch.gmtech.ste.changebidirectionaltounidirectional;

public class Order {

	Customer getCustomer() {
		return _customer;
	}

	void setCustomer(Customer customer) {
		if (_customer != null)
			_customer.friendOrders().remove(this);
		_customer = customer;
		if (_customer != null)
			_customer.friendOrders().add(this);
	}

	double getDiscountedPrice(Customer customer) {
		return getGrossPrice() * (1 - customer.getDiscount());
	}

	private int getGrossPrice() {
		return 10;
	}

	private Customer _customer;

}
