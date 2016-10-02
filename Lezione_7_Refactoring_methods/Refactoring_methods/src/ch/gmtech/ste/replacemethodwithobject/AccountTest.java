package ch.gmtech.ste.replacemethodwithobject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AccountTest {

	@Test
	public void gamma() {
		Account account = new Account();
		
		int gamma = account.gamma(9, 2, 2016);
		
		assertEquals(127526, gamma);
	}

}
