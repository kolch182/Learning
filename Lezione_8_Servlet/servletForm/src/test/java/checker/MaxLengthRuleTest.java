package checker;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.gmtech.ste.checker.MaxLengthRule;

public class MaxLengthRuleTest {

	@Test
	public void maxLentgh() {

		MaxLengthRule rule = new MaxLengthRule(2);
		
		assertFalse(rule.applyOn("lungo"));
		assertTrue(rule.applyOn("ok"));
		assertTrue(rule.applyOn("y"));
	}

}
