package ch.gmtech.ste.formtemplate;

import java.util.Enumeration;

public class Statement {}
class TextStatement extends Statement {

	public String value(CustomerFormTemplateApplied aCustomer) {
		Enumeration<Rental> rentals = aCustomer.getRentals();
		String result = headerString(aCustomer);
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += eachRentalString(each);
		}
		result += footerString(aCustomer);
		return result;
	}

	private String footerString(CustomerFormTemplateApplied aCustomer) {
		return "Amount owed is " +
				String.valueOf(aCustomer.getTotalCharge()) + "\n" + "You earned " +
				String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + " frequent renter points";
	}

	private String eachRentalString(Rental each) {
		return "\t" + each.getMovie().getTitle()+ "\t" + String.valueOf(each.getCharge()) + "\n";
	}

	private String headerString(CustomerFormTemplateApplied aCustomer) {
		return "Rental Record for " + aCustomer.getName() + "\n";
	}}

class HtmlStatement extends Statement {
	
	public String value(CustomerFormTemplateApplied aCustomer) {
		Enumeration<Rental> rentals = aCustomer.getRentals();
		String result = headerString(aCustomer);
		while (rentals.hasMoreElements()) {
		Rental each = (Rental) rentals.nextElement();
		result += eachRentalString(each);
		}
		result += footerString(aCustomer);
		return result;
	}

	private String footerString(CustomerFormTemplateApplied aCustomer) {
		return "<P>You owe <EM>" + String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" +
		"On this rental you earned <EM>" + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
		"</EM> frequent renter points<P>";
	}

	private String eachRentalString(Rental each) {
		return each.getMovie().getTitle()+ ": " + String.valueOf(each.getCharge()) + "<BR>\n";
	}

	private String headerString(CustomerFormTemplateApplied aCustomer) {
		return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
	}
}