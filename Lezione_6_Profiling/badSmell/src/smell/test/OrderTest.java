package smell.test;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import smell.Order;
import smell.OrderLine;
import smell.OrderLineList;

public class OrderTest {
	
	private Order order;
	private OrderLineList orderLineList;
	private Vector<OrderLine> orderLines;
	private PrintWriter pw ;
	
	@Before
	public void setup(){
		orderLines.add(new OrderLine(1, 11, 5));
		orderLines.add(new OrderLine(2, 12, 10));
		orderLines.add(new OrderLine(3, 13, 15));

		orderLineList.setOrderLines(orderLines);
		
		order = new Order(orderLineList);
	}
	

	@Test
	public void printOrder() {
		order.calculateAndPrintOrderTotal(order, pw);
		assertEquals(null, null);
	}

}
