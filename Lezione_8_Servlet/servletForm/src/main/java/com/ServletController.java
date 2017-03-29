package com;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.gmtech.ste.learning.html.HtmlPage;
import ch.gmtech.ste.learning.seminar.Course;

public class ServletController {
	
	private HtmlPage _view = new HtmlPage();
	private ArrayList<Course> courses = new ArrayList<Course>();
	
//	public ServletController(Course course, HtmlPage view){
//	      _model = course;
//	      _view = view;
//	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
 
		if(normalizeUrl(req.getRequestURI()).contentEquals("/course/create")){
			resp.getWriter().write(_view.renderFormBody());
		} else {
			resp.getWriter().write("<h1>Page not found</h1>");
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String courseName = req.getParameter("name");
		String courseStartDate = req.getParameter("startdate");
		String courseLocation = req.getParameter("location");
		String courseTotalSeats = req.getParameter("seats").isEmpty() ? "0" : req.getParameter("seats");
		String courseId = req.getParameter("courseid");
		String courseDescription = req.getParameter("description");
		
		Checker checker = new Checker(courseName, courseId, courseTotalSeats, courseLocation, courseDescription, courseStartDate);
		
		if(checker.check()){
			resp.getWriter().write(createCourse(courseName, courseId, courseTotalSeats, courseLocation, courseDescription, courseStartDate));
		}else{
			resp.getWriter().write(_view.renderFormBody(checker));
		}
			
	}

	private String normalizeUrl(String path) {
		if(path.charAt(path.length()-1) == File.separatorChar){
			path = path.substring(0, path.length() - 1);
		}
		return path;
	}
	
	private String createCourse(String name, String id, String seats, String location, String description, String startDate) {
		
		HtmlPage htmlPage = new HtmlPage();
		String body = "";

		try {
			courses.add(new Course(name, Integer.valueOf(id), description, new SimpleDateFormat("dd.mm.yyyy").parse(startDate), location, Integer.valueOf(seats)));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		
//		for(Course courseToRender : courses) {
//			body += htmlPage.renderBody(courseToRender);
//		}
		
		return htmlPage.header() + htmlPage.renderBody(courses);
	}
}
