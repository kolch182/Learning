package ch.gmtech.ste.replaceconditionalwithpolymorphism;

public class Employee {

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

	public int getSalary() {
		return 4000;
	}

	public int getBonus() {
		return 1000;
	}

	public int getCommission() {
		return 500;
	}

}