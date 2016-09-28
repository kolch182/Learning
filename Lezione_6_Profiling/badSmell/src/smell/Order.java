package smell;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

public class Order {

	private Vector<OrderLine> _orderLineList;

	public Order(Vector<OrderLine> orderLineList) {
		_orderLineList = orderLineList;
	}

	public boolean equals(Object object) {
		if ( this == object ) return true;
		if ( !(object instanceof Order) ) return false;
		Order orderObject = (Order)object;
		return this._orderLineList.equals(orderObject._orderLineList);
	}

	public void calculateAndPrintOrderTotal(PrintWriter pw) {
		Iterator<OrderLine> orderLineIterator = _orderLineList.iterator();
		int total = 0;

		while (orderLineIterator.hasNext()) {
			OrderLine next = orderLineIterator.next();
			total += next.calculateTotalLine();
			next.PrintSingleOrderLine(pw);
		}
		pw.println("Order total = " + total);
	}
}
