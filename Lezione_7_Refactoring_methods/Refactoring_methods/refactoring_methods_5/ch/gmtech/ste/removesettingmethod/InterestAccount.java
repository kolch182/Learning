package ch.gmtech.ste.removesettingmethod;

public class InterestAccount extends AccountVariation{

	InterestAccount(String id) {
		super(id);
	}
	
	InterestAccount(String id, double rate) {
		initializeId(id);
		_interestRate = rate;
	}

	private double _interestRate;

	
	

}
