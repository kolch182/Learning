package ch.gmtech.ste.extractsubclass;

import static org.junit.Assert.*;

import org.junit.Test;

public class JobItemTest {

	@Test
	public void getTotalPriceNotLabor() {
		JobItem jobItem = new JobItem (10, 15);
		
		int totalPrice = jobItem.getTotalPrice();
		
		assertEquals(150, totalPrice);
	}

	@Test
	public void getTotalPriceLabor() {
		JobItem jobItem = new LaborItem(6, new Employee(2));
		
		int totalPrice = jobItem.getTotalPrice();
		
		assertEquals(12, totalPrice);
	}

}
