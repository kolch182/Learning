package ch.gmtech.ste.introduceparamobject;

import java.util.Date;

public class DateRange {

	DateRange (Date start, Date end) {
		_start = start;
		_end = end;
	}

	Date getStart() {
		return _start;
	}

	Date getEnd() {
		return _end;
	}

	boolean includes (Date arg) {
		return (arg.equals(_start) ||
				arg.equals(_end) ||
				(arg.after(_start) && arg.before(_end)));
	}

	private final Date _start;
	private final Date _end;
}
