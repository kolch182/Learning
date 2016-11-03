package ch.gmtech.ste.replaceconditionalwithpolymorphism;

public abstract class EmployeeType {

	abstract int getTypeCode();
	abstract int payAmount(Employee employee);
}
