package ch.gmtech.ste.learning.seminar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {
	
	private final String _name;
	private final Integer _id;
	private final Integer _seats;
	private final String _description;
	private final Date _startDate;
	private final String _location;
	private final List<Student> _students = new ArrayList<Student>();

	public Course(String courseName, Integer courseId, String description, Date startDate, String location, Integer seats) {
		_name = courseName;
		_id = courseId;
		_description = description;
		_startDate = startDate;
		_location = location;
		_seats = seats;
	}

	public String description(){
		return _description;
	}

	public String name() {
		return _name;
	}

	public Integer id() {
		return _id;
	}
	
	public String getStartDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return sdf.format(_startDate); 
	}
	
	public String location() {
		return _location;
	}

	public int seatsLeft() {
		return _seats - _students.size();
	}

	public void enroll(Student student) {
		if(_students.size() < _seats)
			_students.add(student);
	}

	public List<Student> students() {
		return _students;
	}
}
