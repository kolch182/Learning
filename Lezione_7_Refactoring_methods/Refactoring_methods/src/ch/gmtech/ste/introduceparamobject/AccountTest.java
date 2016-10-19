package ch.gmtech.ste.introduceparamobject;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.junit.Test;

public class AccountTest {

	@Test
	public void getFlowBetween() throws ParseException {
		Vector<Entry> entries = new Vector<Entry>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date myStartDate = sdf.parse("01.08.2016");
		Date myEndDate = sdf.parse("07.08.2016");
		Date start = sdf.parse("01.08.2016");
		Date end = sdf.parse("01.09.2016");

		entries.add(new Entry(5, new Date()));
		entries.add(new Entry(6, myStartDate));
		entries.add(new Entry(7, myEndDate));
		
		Account account = new Account(entries);
				
		
		double flowBetween = account.getFlowBetween(new DateRange(start, end));
		
		assertEquals(13.0, flowBetween, 0);
	}

}
