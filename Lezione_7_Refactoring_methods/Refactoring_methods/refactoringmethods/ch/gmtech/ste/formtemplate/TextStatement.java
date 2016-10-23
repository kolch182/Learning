package ch.gmtech.ste.formtemplate;


class TextStatement extends Statement {

	protected String footerString(Customer aCustomer) {
		return "Amount owed is " +
				String.valueOf(aCustomer.getTotalCharge()) + "\n" +
				"You earned " +
				String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
				" frequent renter points";
	}

	protected String eachRentalString(Rental each) {
		return "\t" + each.getMovie().getTitle()+ "\t" +
				String.valueOf(each.getCharge()) + "\n";
	}

	protected String headerString(Customer aCustomer) {
		return "Rental Record for " + aCustomer.getName() +
				"\n";
	}
}