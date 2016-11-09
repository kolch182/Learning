package ch.gmtech.ste.changebidirectionaltounidirectional;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class Customer {

	private Set<Order> _orders = new HashSet<Order>();

	void addOrder(Order arg) {
		arg.setCustomer(this);
	}

	double getPriceFor(Order order) {
		Assert.assertTrue(_orders.contains(order)); // see Introduce
		return order.getDiscountedPrice(this);
	}

	public Set<Order> friendOrders() {
		/** should only be used by Order */
		return _orders;
	}

	public int getDiscount() {
		return 5;
	}
}
