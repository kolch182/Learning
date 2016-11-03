package ch.gmtech.ste.replaceconditionalwithpolymorphism;

public class Employee {
	
	public static final int ENGINEER = 0;
	public static final int SALESMAN = 1;
	public static final int MANAGER = 2;

	private EmployeeType _type;
	private int _monthlySalary = 4000;
	private int _commission = 500;
	private int _bonus = 1000;
	
	public int payAmount() {
		_type.payAmount(this);
	}

	private int getType() {
		return _type.getTypeCode();
	}

	public int getMonthlySalary() {
		return _monthlySalary;
	}

	public int getCommission() {
		return _commission;
	}

	public int getBonus() {
		return _bonus;
	}

}