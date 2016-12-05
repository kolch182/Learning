package ch.gmtech.ste.introducelocalextension;

import java.util.Date;

public class MfDateWrapper {

	private Date _original;

	public MfDateWrapper(String dateString) {
		_original = new Date(dateString);
	};

	public MfDateWrapper(Date arg) {
		_original = arg;
	}

	public int getYear() {
		return _original.getYear();
	}
	
	public int getMonth() {
		return _original.getMonth();
	}
	
	public int getDate() {
		return _original.getDate();
	}

	Date nextDay() {
		return new Date (getYear(),getMonth(), getDate() + 1);
	}
}
