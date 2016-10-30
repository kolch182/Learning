package ch.gmtech.ste.movemethod;


public class AccountType {
	
	private boolean _role = false;

	
	double overdraftCharge(Account account) {
			return isPremium() ? premiumCharge(account): notPremiumCharge(account);
	}

	private double notPremiumCharge(Account account) {
		return account.getDaysOverdrawn() * 1.75;
	}

	private double premiumCharge(Account account) {
		return account.getDaysOverdrawn() > 7 ? 10 + ((account.getDaysOverdrawn() - 7) * 0.85) : 10;
	}
	
	public boolean isPremium() {
		return _role;
	}

	public void setPremium(){
		_role = true;
	}

}
