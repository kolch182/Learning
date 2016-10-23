package ch.gmtech.ste.decomposeconditionals;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

public class DecomposeConditionalsTest {

	@Test
	public void test() throws ParseException {
		DecomposeConditionals decompose = new DecomposeConditionals();

		int chargeOnSeason = decompose.chargeOnSeason(5);
	
		assertEquals(27, chargeOnSeason);
	}

}
