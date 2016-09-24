package stefano.seminar;
import java.util.ArrayList;
import java.util.List;


public class Seminar {
	
	private Course _course;

	private int _seatsLeft = 20;
	private String _location;
	private List<Student> _students = new ArrayList<Student>();
	
	public Seminar(String location, Course course) {
		_course = course;
		_location = location;
	}

	public Course getCourse() {
		return _course;
	}
	
	public String getLocation(){
		return _location;
	}

	public int getSeatsLeft(){
		return _seatsLeft - _students.size();
	}

	public void enroll(Student student) {
		_students.add(student);
	}

	public List<Student> students() {
		return _students;
	}
}
