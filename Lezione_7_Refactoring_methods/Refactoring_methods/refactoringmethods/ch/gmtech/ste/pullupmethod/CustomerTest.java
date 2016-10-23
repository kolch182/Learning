package ch.gmtech.ste.pullupmethod;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void chargeForRegular() {
		RegularCustomer regCustomer = new RegularCustomer();
		Date lastBillDate = new Date(1472680800);
		Date date = new Date(1472680900);
		
		double chargeFor = regCustomer.chargeFor(lastBillDate, date);
		
		assertEquals(5.0, chargeFor, 0.0);
	}

	@Test
	public void chargeForPreferred() {
		PreferredCustomer regCustomer = new PreferredCustomer();
		Date lastBillDate = new Date(1472680800);
		Date date = new Date(1472680900);
		
		double chargeFor = regCustomer.chargeFor(lastBillDate, date);
		
		assertEquals(3.0, chargeFor, 0.0);
	}

}
