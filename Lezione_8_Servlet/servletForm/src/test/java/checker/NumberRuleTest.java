package checker;

import org.junit.Test;
import static org.junit.Assert.*;

import ch.gmtech.ste.checker.NumberRule;
import ch.gmtech.ste.checker.NumberRule.OPERATOR;

public class NumberRuleTest {

	@Test
	public void isANumber() {
		NumberRule rule = new NumberRule(OPERATOR.GREATER_EQUAL, 0);

		assertFalse(rule.applyOn("String"));
		assertFalse(rule.applyOn(null));
		assertTrue(rule.applyOn("9"));
	}
	
	@Test
	public void lessThan() {
		NumberRule rule = new NumberRule(OPERATOR.LESS_THAN, 0);

		assertTrue(rule.applyOn("-1"));
		assertFalse(rule.applyOn("0"));
		assertFalse(rule.applyOn("1"));
	}

	@Test
	public void lessEquals() {
		NumberRule rule = new NumberRule(OPERATOR.LESS_EQUAL, 0);

		assertTrue(rule.applyOn("-1"));
		assertTrue(rule.applyOn("0"));
		assertFalse(rule.applyOn("1"));
	}


	@Test
	public void greaterEquals() {
		NumberRule rule = new NumberRule(OPERATOR.GREATER_EQUAL, 0);

		assertFalse(rule.applyOn("-1"));
		assertTrue(rule.applyOn("0"));
		assertTrue(rule.applyOn("1"));
	}

	@Test
	public void greaterThan() {
		NumberRule rule = new NumberRule(OPERATOR.GREATER_THAN, 0);

		assertFalse(rule.applyOn("-1"));
		assertFalse(rule.applyOn("0"));
		assertTrue(rule.applyOn("1"));
	}


}
