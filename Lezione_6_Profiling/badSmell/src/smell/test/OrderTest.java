package smell.test;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import smell.Order;
import smell.OrderLine;

public class OrderTest {
	
	private Vector<OrderLine> orderLineList = new Vector<OrderLine>();
	private Order order;
	
	@Before
	public void setup(){
		OrderLine firstLineItem = new OrderLine(1, 11, 5, 5);
		orderLineList.add(firstLineItem);
		OrderLine secondLineItem = new OrderLine(2, 12, 10, 10);
		orderLineList.add(secondLineItem);

		order = new Order(orderLineList);
	}
	

	@Test
	public void calculateAndPrintOrderTotal() {
		StringWriter out = new StringWriter();
		PrintWriter pw = new PrintWriter(out);
		String expected = "Begin Line Item\n"
				+ "Product = 1\n"
				+ "Image = 11\n"
				+ "Quantity = 5\n"
				+ "Total = 25\n"
				+ "End Line Item\n"
				+ "Begin Line Item\n"
				+ "Product = 2\n"
				+ "Image = 12\n"
				+ "Quantity = 10\n"
				+ "Total = 100\n"
				+ "End Line Item\n"
				+ "Order total = 125\n";
		
		order.calculateAndPrintOrderTotal(pw);

		assertEquals(expected, out.toString());
	}
	
	@Test
	public void equals() {
		Object object = new Object();
		Order orderOne = new Order(orderLineList);
		Order orderTwo = new Order(orderLineList);
		String stringObject = new String("");
		
		assertFalse(orderOne.equals(object));
		assertTrue(orderOne.equals(orderOne));
		assertTrue(orderOne.equals(orderTwo));
		assertFalse(orderOne.equals(null));
		assertFalse(orderOne.equals(stringObject));
	}
	
}
