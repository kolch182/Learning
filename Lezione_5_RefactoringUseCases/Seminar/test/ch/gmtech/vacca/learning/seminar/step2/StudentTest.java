package ch.gmtech.vacca.learning.seminar.step2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StudentTest {

	@Test
	public void testGetInfo() {
		Student student = new Student("Stefano", "Coluccia");
		assertEquals("Stefano Coluccia", student.getInfo());
	}

}
