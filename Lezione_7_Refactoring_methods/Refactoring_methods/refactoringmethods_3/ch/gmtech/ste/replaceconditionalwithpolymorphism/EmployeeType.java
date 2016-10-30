package ch.gmtech.ste.replaceconditionalwithpolymorphism;

public abstract class EmployeeType {

	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;
	abstract int getType();
	abstract int payAmount(Employee emp);

	static EmployeeType newType(int code) {
		switch (code) {
		case ENGINEER:
			return new Engineer();
		case SALESMAN:
			return new Salesman();
		case MANAGER:
			return new Manager();
		default:
			throw new IllegalArgumentException("Incorrect Employee Code");
		}
	}

}
