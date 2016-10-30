package ch.gmtech.ste.replaceconditionalwithpolymorphism;

public class Manager extends EmployeeType {
	
	int getType(){
		return Employee.MANAGER;
	}

	int payAmount(Employee emp) {
		return emp.getSalary() + emp.getBonus();
	}
}
