package ch.gmtech.ste.encapsulatecollection;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.Assert;

public class Person {

	private Set<Course> _courses = new HashSet<Course>();

	public Set<Course> getCourses() {
//		return Collections.unmodifiableSet(_courseList);
		return _courses;
	}

	public void initializeCourses(Set<Course> courses) {
		Assert.isTrue(_courses.isEmpty());
		_courses.addAll(courses);
	}

	public void addCourse(Course course) {
		_courses.add(course);
	}

	public void removeCourse(Course course) {
		_courses.remove(course);
	}

}
