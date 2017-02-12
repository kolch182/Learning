package ch.gmtech.ste.learning.seminar;
import java.util.ArrayList;
import java.util.List;


public class Seminar {
	
	private final Course _course;

	private final int _capacity = 20;
	private final String _location;
	private final List<Student> _students = new ArrayList<Student>();
	
	public Seminar(String location, Course course) {
		_course = course;
		_location = location;
	}

	public Course course() {
		return _course;
	}
	
	public String location() {
		return _location;
	}

	public int seatsLeft() {
		return _capacity - _students.size();
	}

	public void enroll(Student student) {
		if(_students.size() < _capacity)
			_students.add(student);
	}

	public List<Student> students() {
		return _students;
	}
}
