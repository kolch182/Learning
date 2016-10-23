package ch.gmtech.ste.replacedatavaluewithobject;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class OrderTest {
	
	@Test
	public void numberOfOrdersFor() {
		int result = 0;		
		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(new Order("Stefano"));
		orders.add(new Order("Stefano"));
		orders.add(new Order("ValentN-ANO"));

		for (Object eachOrder : orders) {
			if (((Order) eachOrder).getCustomerName().equals("Stefano")) result++;
		} 
		
		assertEquals(2, result);
	}

}
