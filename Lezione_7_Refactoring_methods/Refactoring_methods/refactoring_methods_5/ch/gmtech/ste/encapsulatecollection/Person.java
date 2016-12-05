package ch.gmtech.ste.encapsulatecollection;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.Assert;

public class Person {

	private Set<Course> _courseList = new HashSet<Course>();

	public Set<Course> getCourses() {
//		return Collections.unmodifiableSet(_courseList);
		return _courseList;
	}

	public void initializeCourses(Set<Course> courses) {
		Assert.isTrue(_courseList.isEmpty());
		_courseList.addAll(courses);
	}

	public void addCourse(Course course) {
		_courseList.add(course);
	}

	public void removeCourse(Course course) {
		_courseList.remove(course);
	}

}
