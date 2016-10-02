package ch.gmtech.ste.formtemplate;

import java.util.Enumeration;
import java.util.Vector;

class CustomerFormTemplateApplied {
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();

	public CustomerFormTemplateApplied (String name){
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName (){
		return _name;
	}

	public String statement() {
		return new TextStatement().value(this);
	}

	public String htmlStatement() {
		return new HtmlStatement().value(this);
	}
	
	public double getTotalCharge() {
		double result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	
	public int getTotalFrequentRenterPoints(){
		int result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints(4);
		}
		return result;
	}
	
	public Enumeration<Rental> getRentals() {
		return _rentals.elements();
	}
}