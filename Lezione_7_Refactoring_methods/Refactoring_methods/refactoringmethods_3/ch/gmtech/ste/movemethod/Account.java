package ch.gmtech.ste.movemethod;

public class Account {
	private AccountType _type = new AccountType();
	private int _daysOverdrawn;

	double bankCharge() {
		double result = 4.5;
		if (getDaysOverdrawn() > 0) result += _type.overdraftCharge(this);
		return result;
	}

	public int getDaysOverdrawn() {
		return _daysOverdrawn;
	}

	public void setDaysOverdrawn(int _daysOverdrawn) {
		this._daysOverdrawn = _daysOverdrawn;
	}

	public AccountType getType() {
		return _type;
	}

	public void setType(AccountType type) {
		_type = type;
	}
}
