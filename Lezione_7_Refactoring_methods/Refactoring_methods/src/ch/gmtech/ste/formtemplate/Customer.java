package ch.gmtech.ste.formtemplate;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();

	public String statement() {
		return new TextStatement().value(this);
	}
	
	public String htmlStatement() {
		return new HtmlStatement().value(this);
	}

	public Customer (String name){
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}
	
	public Enumeration<Rental> getRentals() {
		return _rentals.elements();
	}

	public String getName (){
		return _name;
	}

	protected double getTotalCharge() {
		double result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}

	protected int getTotalFrequentRenterPoints(){
		int result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints(4);
		}
		return result;
	}
}