package ch.gmtech.ste.replacetempwithquery;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReplaceTempWithQueryTest {

	@Test
	public void getPrice() {
		ReplaceTempWithQuery replacetempwithquery = new ReplaceTempWithQuery();
		
		double price = replacetempwithquery.getPrice();
		
		assertEquals(245.0, price, 0.0);
	}
}
