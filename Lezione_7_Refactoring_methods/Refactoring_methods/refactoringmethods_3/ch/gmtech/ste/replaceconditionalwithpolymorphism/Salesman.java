package ch.gmtech.ste.replaceconditionalwithpolymorphism;

public class Salesman extends EmployeeType {
	
	int getTypeCode() {
		return Employee.SALESMAN;
	}
	
	public int payAmount(Employee emp) {
		return emp.getMonthlySalary() + emp.getCommission();
	}
}
