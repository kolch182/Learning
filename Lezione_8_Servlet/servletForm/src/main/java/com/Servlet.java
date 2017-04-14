package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import ch.gmtech.ste.controller.Controller;
import ch.gmtech.ste.controller.CreateCourse;
import ch.gmtech.ste.controller.ShowCourses;
import ch.gmtech.ste.learning.html.HtmlPage;
import ch.gmtech.ste.learning.seminar.Course;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {
	
	private final HtmlPage _view = new HtmlPage();
	private ArrayList<Course> _courses;
	
	public static final String SHOW_COURSES = "/course";
	public static final String CREATE_COURSE = "/course/create";
	
	@Override
	public void init() {
		_courses = new ArrayList<Course>();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String,Controller> routes = new HashMap<String, Controller>();
		routes.put(CREATE_COURSE, new CreateCourse(req, resp, _courses));
		routes.put(SHOW_COURSES, new ShowCourses(_courses, resp));
		String requestURI = StringUtils.removeEnd(req.getRequestURI(), "/");
		if (routes.containsKey(requestURI)) {
			try {
				routes.get(requestURI).execute();
			} catch (Exception e) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
			}
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		if(normalizeUrl(req.getRequestURI()).contentEquals("/course/create")){
//			resp.getWriter().write(_view.renderFormBody());
//		} else {
//			resp.getWriter().write("<h1>Page not found</h1>");
//		}
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		String courseName = req.getParameter("name");
//		String courseStartDate = req.getParameter("startdate");
//		String courseLocation = req.getParameter("location");
//		String courseTotalSeats = req.getParameter("seats").isEmpty() ? "0" : req.getParameter("seats");
//		String courseId = req.getParameter("courseid");
//		String courseDescription = req.getParameter("description");
//		
//		Checker checker = new Checker(courseName, courseId, courseTotalSeats, courseLocation, courseDescription, courseStartDate);
//		
//		if(checker.check()){
//			resp.getWriter().write(createCourse(courseName, courseId, courseTotalSeats, courseLocation, courseDescription, courseStartDate));
//		}else{
//			resp.getWriter().write(_view.renderFormBody(checker));
//		}
//	}
//	
//	private String normalizeUrl(String path) {
//		if(path.charAt(path.length()-1) == File.separatorChar){
//			path = path.substring(0, path.length() - 1);
//		}
//		return path;
//	}
//	
//	private String createCourse(String name, String id, String seats, String location, String description, String startDate) {
//		
//		HtmlPage htmlPage = new HtmlPage();
//
//		try {
//			_courses.add(new Course(name, Integer.valueOf(id), description, new SimpleDateFormat("dd.mm.yyyy").parse(startDate), location, Integer.valueOf(seats)));
//		} catch (ParseException e) {
//			throw new RuntimeException(e);
//		}
//		
//		return htmlPage.header() + htmlPage.renderBody(_courses);
//	}

}
