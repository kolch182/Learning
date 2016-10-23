package ch.gmtech.ste.replacetypecodewithstate;

public class Employee {

	private final int _monthlySalary = 4000;
	private int _commission = 500;
	private int _bonus = 1000;
	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;

	private EmployeeType _type;

	Employee (int type) {
		setType (type);
	}

	int getType() {
		return _type.getType();
	}

	void setType(int arg) {
		_type = EmployeeType.newType(arg);
	}

	public int payAmount() {
		switch (getType()) {
		case EmployeeType.ENGINEER:
			return _monthlySalary;
		case EmployeeType.SALESMAN:
			return _monthlySalary + _commission;
		case EmployeeType.MANAGER:
			return _monthlySalary + _bonus;
		default:
			throw new RuntimeException("Incorrect Employee");
		}
	}
}