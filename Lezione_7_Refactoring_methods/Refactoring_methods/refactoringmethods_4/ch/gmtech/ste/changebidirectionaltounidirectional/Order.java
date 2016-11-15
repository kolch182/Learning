package ch.gmtech.ste.changebidirectionaltounidirectional;

import java.util.LinkedList;

public class Order {
	
	private LinkedList <Customer> _customers = Customer.getInstances();

	Customer getCustomer() {
		for (Customer customer : _customers) {
			if (customer.containsOrder(this)) return customer;
		}
		return null;
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
