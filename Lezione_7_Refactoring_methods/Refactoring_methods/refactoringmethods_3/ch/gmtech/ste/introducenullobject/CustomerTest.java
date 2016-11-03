package ch.gmtech.ste.introducenullobject;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void getNull() {
		Sites site = new Sites();
		
		Customer customer = site.getCustomer();

		String customerName = customer.getName();
		String setPlan = customer.setPlan();
		int weeksDelinquentInLastYear = customer.getHistory().getWeeksDelinquentInLastYear();

		assertEquals("occupant",customerName);
		assertEquals("basic",setPlan);
		assertEquals(0,weeksDelinquentInLastYear);
	}

	@Test
	public void getNotNull() {
		Sites site = new Sites();
		site.initCustomer();
		Customer customer = site.getCustomer();
		customer.initHistory();
		
		String customerName = customer.getName();
		String setPlan = customer.setPlan();
		int weeksDelinquentInLastYear = customer.getHistory().getWeeksDelinquentInLastYear();
		
		assertEquals("Stefano",customerName);
		assertEquals("special",setPlan);
		assertEquals(10,weeksDelinquentInLastYear);
	}
	
}
