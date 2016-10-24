package ch.gmtest.ste.replaceconditionalwithpolymorphism;

public abstract class Employee {

	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;
	abstract int payAmount();

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

}