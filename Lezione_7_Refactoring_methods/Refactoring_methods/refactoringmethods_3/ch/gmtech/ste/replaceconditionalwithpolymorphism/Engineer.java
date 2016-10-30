package ch.gmtech.ste.replaceconditionalwithpolymorphism;

public class Engineer extends EmployeeType {
	
	int getType(){
		return Employee.ENGINEER;
	}

	int payAmount(Employee emp) {
			return emp.getSalary();
	}
}
