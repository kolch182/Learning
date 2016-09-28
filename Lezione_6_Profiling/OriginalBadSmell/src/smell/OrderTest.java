package smell;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	private lineitemlist orderLineList = new lineitemlist();
	private Vector<lineItem> orderLines = new Vector<lineItem>();
	private Order order;
	
	@Before
	public void setup(){
		lineItem firstLineItem = new lineItem(1, 11, 5);
		firstLineItem.setUnitPrice(5);
		orderLines.add(firstLineItem);
		lineItem secondLineItem = new lineItem(2, 12, 10);
		secondLineItem.setUnitPrice(10);
		orderLines.add(secondLineItem);

		orderLineList.setLineItems(orderLines);
		
		order = new Order(orderLineList);
	}
	

	@Test
	public void writeOrder() {
		StringWriter out = new StringWriter();
		PrintWriter pw = new PrintWriter(out);
		
		order.writeOrder(order, pw);

		assertEquals("", out.toString());
	}
}
