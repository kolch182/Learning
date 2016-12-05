package ch.gmtech.ste.encapsulatecollection;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void addAndRemove() {
		Person kent = new Person();
//		Set<Course> s = new HashSet<Course>();
		kent.addCourse(new Course("Smalltalk Programming", false));
		kent.addCourse(new Course("Appreciating Single Malts", true));
//		kent.initializeCourses(s);
		assertEquals(2, kent.getCourses().size());

		Course refact = new Course("Refactoring", true);
		kent.addCourse(refact);
		kent.addCourse(new Course("Brutal Sarcasm", false));
		assertEquals(4, kent.getCourses().size());

		kent.getCourses().remove(refact);
		assertEquals(3, kent.getCourses().size());
	}

	@Test
	public void numberOfAdvancedCourses() {
		Person kent = new Person();
		kent.addCourse(new Course("Smalltalk Programming", false));
		kent.addCourse(new Course("Appreciating Single Malts", true));		

		int count = 0;	
		for (Course course : kent.getCourses()) {
			if (course.isAdvanced())
				count++;
		}
		
		assertEquals(1, count);
	}
}
