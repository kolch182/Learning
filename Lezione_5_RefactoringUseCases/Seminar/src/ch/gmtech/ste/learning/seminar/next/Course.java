package ch.gmtech.ste.learning.seminar.next;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Course {
	
	private final String _name;
	private final Integer _number;
	private final String _description;
	private final Date _startDate;

	public Course(String courseName, Integer courseNumber, String description, Date startDate) {
		_name = courseName;
		_number = courseNumber;
		_description = description;
		_startDate = startDate;
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
	
	public String getStartDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return sdf.format(_startDate); 
	}
}
