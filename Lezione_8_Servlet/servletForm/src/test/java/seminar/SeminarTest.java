package seminar;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ch.gmtech.ste.seminar.Course;
import ch.gmtech.ste.seminar.Student;

public class SeminarTest {

	private Date _startDate;
	
	@Before
	public void initDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
			_startDate = sdf.parse("01.10.2016");
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}
	

	@Test
	public void testStudents() {
		Course course = new Course(1, "courseName", "description", _startDate, "Lugano", 20);
		assertEquals(0, course.students().size());

		course.enroll(new Student("Pippo", "Pluto"));
		assertEquals(1, course.students().size());
	}

	@Test
	public void dontEnrollTooMuchStudents() {
		Course course = new Course(1, "courseName", "description", _startDate, "Lugano", 1);

		assertTrue(course.enroll(new Student("Ugo", "Campione")));
		assertFalse(course.enroll(new Student("Laggard", "Guy")));
	}

}
