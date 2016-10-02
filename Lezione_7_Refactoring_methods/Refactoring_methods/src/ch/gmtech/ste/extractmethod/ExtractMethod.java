package ch.gmtech.ste.extractmethod;

import java.util.Enumeration;
import java.util.Vector;

public class ExtractMethod {
	Vector<Order> _orders = new Vector<Order>();
	private String _name = "Stefano";
	
	void printOwing() {
		double outstanding = 0.0;
		Order order1 = new Order(5);
		Order order2 = new Order(10);
		_orders.add(order1);
		_orders.add(order2);
		Enumeration<Order> orderElements = _orders.elements();
		
		// print banner
		System.out.println ("**************************");
		System.out.println ("***** Customer Owes ******");
		System.out.println ("**************************");
		
		// calculate outstanding
		while (orderElements.hasMoreElements()) {
			Order each = (Order) orderElements.nextElement();
			outstanding += each.getAmount();
		}
		
		//print details
		System.out.println ("name:" + _name);
		System.out.println ("amount" + outstanding);
	}
}
