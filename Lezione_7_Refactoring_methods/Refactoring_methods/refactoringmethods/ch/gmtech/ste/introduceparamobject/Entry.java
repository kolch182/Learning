package ch.gmtech.ste.introduceparamobject;

import java.util.Date;

public class Entry {

	Entry (double value, Date chargeDate) {
		_value = value;
		_chargeDate = chargeDate;
	}
	
	Date getDate(){
		return _chargeDate;
	}
	
	double getValue(){
		return _value;
	}
	
	private Date _chargeDate;
	private double _value;
}
