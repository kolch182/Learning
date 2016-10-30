package ch.gmtech.ste.movefield;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test
	public void interestForAmount_days() {
		Account account = new Account();
		account.getType().setInterestRate(10);
		
		double interestForAmount_days = account.interestForAmount_days(5, 20);
		
		assertEquals(2.7, interestForAmount_days, 0.05);
	}

}
