package stefano.seminar;

public class Course {
	
	private String _name;
	private Integer _number;
	private String _description;

	public Course(String courseName, Integer courseNumber, String description) {
		_name = courseName;
		_number = courseNumber;
		_description = description;
	}

	public String getDescription(){
		return _description;
	}

	public String getDetails() {
		return _name + " (" + _number + ")";
	}

}
