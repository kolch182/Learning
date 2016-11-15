package ch.gmtech.ste.changebidirectionaltounidirectional;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.Assert;

public class Customer {

	private Set<Order> _orders = new HashSet<Order>();

	double getPriceFor(Order order) {
		Assert.isTrue(_orders.contains(order)); 
		return order.getDiscountedPrice(this);
	}

	public Set<Order> friendOrders() {
		return _orders;
	}

	public int getDiscount() {
		return 5;
	}

}
