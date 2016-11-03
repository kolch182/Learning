package ch.gmtech.ste.replaceconditionalwithpolymorphism;

public class Manager extends EmployeeType {
	
	int getTypeCode() {
		return Employee.MANAGER;
	}
	
	public int payAmount(Employee emp) {
		return emp.getMonthlySalary() + emp.getBonus();
	}
}
