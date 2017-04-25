package ch.gmtech.ste.checker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeFormatRule implements Rule {

	private final String _format;

	public TimeFormatRule(String format) {
		_format = format;
	}

	@Override
	public boolean applyOn(String what) {
		try {
			DateFormat date = new SimpleDateFormat(_format);
			date.setLenient(false);
			date.parse(what);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String message() {
		return "must have " + _format + " format";
	}
}
