package checker;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.gmtech.ste.checker.TimeFormatRule;

public class TimeFormatRuleTest {

	@Test
	public void date() {
		TimeFormatRule rule = new TimeFormatRule("dd.mm.YYYY");
		
		assertFalse(rule.applyOn("26/05/1983"));
		assertTrue(rule.applyOn("26.05.1983"));
		assertFalse(rule.applyOn("26.05.19835646546"));
	}

}
