package ch.gmtech.ste.learning.seminar.next;

public class Course {
	
	private final String _name;
	private final Integer _number;
	private final String _description;

	public Course(String courseName, Integer courseNumber, String description) {
		_name = courseName;
		_number = courseNumber;
		_description = description;
	}

	public String description(){
		return _description;
	}

	public String name() {
		return _name;
	}

	public Integer number() {
		return _number;
	}
}
