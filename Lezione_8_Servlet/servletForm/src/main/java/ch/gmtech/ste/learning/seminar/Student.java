package ch.gmtech.ste.learning.seminar;

public class Student {

	private final String _name;
	private final String _lastname;
	
	public Student(String name, String lastname) {
		_name = name;
		_lastname = lastname;
	}

	public String name() {
		return _name;
	}
	
	public String lastname() {
		return _lastname;
	}
}
