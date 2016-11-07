package ch.gmtech.ste.hidedelegate;

public class Person {

	Department _department;
	
	public void setDepartment(Department arg) {
		_department = arg;
	}

	public Person getManager() {
		return _department.getManager();
	}
}
