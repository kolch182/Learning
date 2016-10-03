package ch.gmtech.ste.introduceparamobject;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class AccountTest {

	@Test
	public void getFlowBetween() throws ParseException {
		Account account = new Account();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date start = sdf.parse("01.08.2016");
		Date end = sdf.parse("01.09.2016");
		
		
		double flowBetween = account.getFlowBetween(new DateRange(start, end));
		
		assertEquals(13.0, flowBetween, 0);
	}

}
