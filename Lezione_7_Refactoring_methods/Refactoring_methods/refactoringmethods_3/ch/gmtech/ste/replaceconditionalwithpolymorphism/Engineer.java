package ch.gmtech.ste.replaceconditionalwithpolymorphism;

public class Engineer extends EmployeeType {

	public int getTypeCode() {
		return Employee.ENGINEER;
	}

	public int payAmount(Employee emp) {
		return emp.getMonthlySalary();
	}
}
