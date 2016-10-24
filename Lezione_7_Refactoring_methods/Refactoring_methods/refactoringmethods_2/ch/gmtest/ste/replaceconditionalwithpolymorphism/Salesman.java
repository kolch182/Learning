package ch.gmtest.ste.replaceconditionalwithpolymorphism;

public class Salesman extends EmployeeType {
	
	private final int _monthlySalary = 4000;
	private int _commission = 500;

	int getType(){
		return Employee.SALESMAN;
	}

	int payAmount() {
		return _monthlySalary + _commission;
	}
}
