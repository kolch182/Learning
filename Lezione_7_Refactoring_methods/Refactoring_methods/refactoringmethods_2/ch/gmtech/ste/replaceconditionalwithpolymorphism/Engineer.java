package ch.gmtech.ste.replaceconditionalwithpolymorphism;

public class Engineer extends EmployeeType {
	
	private final int _monthlySalary = 4000;

	int getType(){
		return Employee.ENGINEER;
	}

	int payAmount() {
			return _monthlySalary;
	}
}
