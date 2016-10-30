package ch.gmtech.ste.introducenullobject;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void getNameNull() {
		Sites site = new Sites();
		
		Customer customer = site.getCustomer();

		String customerName = customer.getName();

		assertEquals("occupant",customerName);
	}

	@Test
	public void getName() {
		Sites site = new Sites();
		site.initCustomer();
		Customer customer = site.getCustomer();
		
		String customerName = customer.getName();
		
		assertEquals("Stefano",customerName);
	}
	
}
