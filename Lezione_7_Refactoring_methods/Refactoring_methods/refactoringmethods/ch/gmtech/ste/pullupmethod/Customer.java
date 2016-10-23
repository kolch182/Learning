package ch.gmtech.ste.pullupmethod;

import java.util.Date;

public abstract class Customer {
	
	private double _total = 0.0;
	private Date _date;
	
	abstract double chargeFor(Date start, Date end);
	
	protected double addBill(Date date, double charge) {
		_total += charge;
		_date = date;
		System.out.println(_date.toString());
		return _total;
	}
	
	void createBill (Date date) {
		Date lastBillDate = new Date(15113154);
		double charge = chargeFor(lastBillDate, date);
		addBill(date, charge);
	}

}
