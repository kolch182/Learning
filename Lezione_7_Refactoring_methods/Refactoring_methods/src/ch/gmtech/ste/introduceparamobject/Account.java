package ch.gmtech.ste.introduceparamobject;

import java.text.ParseException;
import java.util.Enumeration;
import java.util.Vector;

public class Account {
	private Vector<Entry> _entries;
	
	public Account(Vector<Entry> entries){
		_entries = entries;
	}

	double getFlowBetween (DateRange range) throws ParseException {
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

}
