package ch.gmtech.ste.replaceconditionalwithpolymorphism;

public class Salesman extends EmployeeType {
	
	int getType(){
		return Employee.SALESMAN;
	}

	int payAmount(Employee emp) {
		return emp.getSalary() + emp.getCommission();
	}
}
