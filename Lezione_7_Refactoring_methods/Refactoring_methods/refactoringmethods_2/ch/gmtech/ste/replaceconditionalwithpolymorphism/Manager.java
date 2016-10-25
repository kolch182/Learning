package ch.gmtech.ste.replaceconditionalwithpolymorphism;

public class Manager extends EmployeeType {
	
	private final int _monthlySalary = 4000;
	private int _bonus = 1000;

	int getType(){
		return Employee.MANAGER;
	}

	int payAmount() {
		return _monthlySalary + _bonus;
	}
}
