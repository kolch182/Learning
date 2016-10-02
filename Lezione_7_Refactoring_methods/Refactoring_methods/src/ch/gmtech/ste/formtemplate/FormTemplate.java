package ch.gmtech.ste.formtemplate;

import java.util.Enumeration;
import java.util.Vector;

public class FormTemplate {
	Vector<Rental> _rentals = new Vector<Rental>();
	Customer _customer = new Customer("Stefano");

	public String statement() {
		Movie movie1 = new Movie("Back to the future", 1);
		Movie movie2 = new Movie("Save private Ryan", 2);
		Rental rental1 = new Rental(movie1, 3);
		Rental rental2 = new Rental(movie2, 4);
		_rentals.add(rental1);
		_rentals.add(rental2);
		_customer.addRental(rental1);
		_customer.addRental(rental2);
		Enumeration<Rental> rentals = _rentals.elements();
		
		String result = "Rental Record for " + _customer.getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+ "\t" +
					String.valueOf(each.getCharge()) + "\n";
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(_customer.getTotalCharge())
				+ "\n";
		result += "You earned " +
				String.valueOf(_customer.getTotalFrequentRenterPoints()) +
				" frequent renter points";
		return result;
	}


	public String htmlStatement() {
		Movie movie1 = new Movie("Back to the future", 1);
		Movie movie2 = new Movie("Save private Ryan", 2);
		Rental rental1 = new Rental(movie1, 3);
		Rental rental2 = new Rental(movie2, 4);
		_rentals.add(rental1);
		_rentals.add(rental2);
		_customer.addRental(rental1);
		_customer.addRental(rental2);
		Enumeration<Rental> rentals = _rentals.elements();

		String result = "<H1>Rentals for <EM>" + _customer.getName() +
				"</EM></H1><P>\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			//show figures for each rental
			result += each.getMovie().getTitle()+ ": " +
					String.valueOf(each.getCharge()) + "<BR>\n";
		}
		//add footer lines
		result += "<P>You owe <EM>" + String.valueOf(_customer.getTotalCharge())
				+ "</EM><P>\n";
		result += "On this rental you earned <EM>" +
				String.valueOf(_customer.getTotalFrequentRenterPoints()) +
				"</EM> frequent renter points<P>";
		return result;
	}

}
