package ch.gmtech.ste.changebidirectionaltounidirectional;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.springframework.util.Assert;

public class Customer {

	private Set<Order> _orders = new HashSet<Order>();
	private static LinkedList<Customer> _customers = new LinkedList<Customer> ();

	void addOrder(Order order) {
		order.setCustomer(this);
	}

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

	public boolean containsOrder(Order order) {
		return _orders.contains(order);
	}

	public static LinkedList<Customer> getInstances() {
		return _customers;
	}
}
