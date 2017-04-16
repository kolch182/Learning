package ch.gmtech.ste.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import ch.gmtech.ste.seminar.Course;
import ch.gmtech.ste.view.HtmlPage;

public class ShowCourses implements Controller{
	
	private final ArrayList<Course> _courses;
	private final HttpServletResponse _response;
	private final HtmlPage _view = new HtmlPage();
	
	public ShowCourses(ArrayList<Course> courses, HttpServletResponse response) {
		_courses = courses;
		_response = response;
	}

	@Override
	public void execute() throws Exception {
		_response.setStatus(HttpServletResponse.SC_OK);
		_response.getWriter().write(_view.showCourses(_courses));
	}

}
