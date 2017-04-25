package checker;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.gmtech.ste.checker.NotEmptyRule;

public class NotEmptyRuleTest {

	@Test
	public void notEmpty() {
		NotEmptyRule rule = new NotEmptyRule();
		
		assertFalse(rule.applyOn(""));
		assertFalse(rule.applyOn(null));
		assertTrue(rule.applyOn("ciao"));
	}

}
