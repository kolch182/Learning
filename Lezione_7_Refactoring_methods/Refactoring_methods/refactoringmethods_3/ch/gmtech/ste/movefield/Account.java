package ch.gmtech.ste.movefield;

public class Account {
	private AccountType _type = new AccountType();

	double interestForAmount_days (double amount, int days) {
		return _type.getInterestRate() * amount * days / 365;
	}

	public AccountType getType() {
		return _type;
	}

//	nel caso in cui getInterestRate sia usato da vari metodi
//	double interestForAmount_days (double amount, int days) {
//		return _type.getInterestRate() * amount * days / 365;
//	}
//	
//	private void setInterestRate (double arg) {
//		_type.setInterestRate(arg);
//	}
//	
//	private double getInterestRate () {
//		return _type.getInterestRate();
//	}
}
