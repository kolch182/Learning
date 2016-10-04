package ch.gmtech.ste.formtemplate;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void statement() {
		Customer customer = new Customer("Stefano");
		String expected = "Rental Record for Stefano\n"
		+ "Amount owed is 0.0\n"
		+ "You earned 0 frequent renter points"
		;
		
		String statement = customer.statement();
		
		assertEquals(expected, statement);
	}

	@Test
	public void statementHtml() {
		Customer customer = new Customer("Stefano");
		String expected = "<H1>Rentals for <EM>Stefano</EM></H1><P>\n"
				+ "<P>You owe <EM>0.0</EM><P>\n"
				+ "On this rental you earned <EM>0</EM> frequent renter points<P>"
		;
		
		String statement = customer.htmlStatement();
		
		assertEquals(expected, statement);
	}
}
