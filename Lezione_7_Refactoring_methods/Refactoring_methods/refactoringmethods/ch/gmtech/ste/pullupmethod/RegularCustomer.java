package ch.gmtech.ste.pullupmethod;

import java.util.Date;

public class RegularCustomer extends Customer{

	protected double chargeFor(Date lastBillDate, Date date) {
		return (date.getTime() - lastBillDate.getTime()) * 0.05;
	}
	
}
