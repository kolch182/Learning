package ch.gmtech.ste.introduceforeignmethod;

import java.util.Date;

public class NextDay {
	
	private Date previousEnd = new Date();
	
	Date newStart = nextDay(previousEnd);
	
	public static Date nextDay(Date previous){
		return new Date (previous.getYear(), previous.getMonth(), previous.getDate() + 1);
	}

}
