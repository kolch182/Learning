package ch.gmtech.ste.introduceparamobject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class Account {

	double getFlowBetween (DateRange range) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date date = sdf.parse("01.08.2016");
		Date date2 = sdf.parse("07.08.2016");
		_entries.add(new Entry(5, new Date()));
		_entries.add(new Entry(6, date));
		_entries.add(new Entry(7, date2));
		double result = 0;
		
		Enumeration<Entry> e = _entries.elements();
		while (e.hasMoreElements()) {
			Entry each = (Entry) e.nextElement();
			if (range.includes(each.getDate()))
			{
				result += each.getValue();
			}
		}
		return result;
	}

	private Vector<Entry> _entries = new Vector<Entry>();
}
