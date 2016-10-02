package ch.gmtech.ste.extractmethod;

import java.util.Enumeration;
import java.util.Vector;

public class ExtractMethodApplied {
	Vector<Order> _orders = new Vector<Order>();
	private String _name = "Stefano";

	void printOwing() {
		Order order1 = new Order(5);
		Order order2 = new Order(10);
		_orders.add(order1);
		_orders.add(order2);

		printBanner();

		double outstanding = getOutstaning();

		printDetails(outstanding);
	}

	private double getOutstaning() {
		Enumeration<Order> orderElements = _orders.elements();
		double result = 0.0;
		
		while (orderElements.hasMoreElements()) {
			Order each = (Order) orderElements.nextElement();
			result += each.getAmount();
		}
		return result;
	}

	private void printDetails(double outstanding) {
		System.out.println ("name:" + _name);
		System.out.println ("amount" + outstanding);
	}

	private void printBanner() {
		System.out.println ("**************************");
		System.out.println ("***** Customer Owes ******");
		System.out.println ("**************************");
	}
}
