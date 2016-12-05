package ch.gmtech.ste.introducelocalextension;

import java.util.Date;

public class MfDateWrapper {

	private Date _original;

	public MfDateWrapper (String dateString) {
		_original = new Date(dateString);
	};

	public MfDateWrapper (Date arg) {
		_original = arg;
	}
}
