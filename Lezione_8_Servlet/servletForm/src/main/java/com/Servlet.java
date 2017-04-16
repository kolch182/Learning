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
import ch.gmtech.ste.seminar.Course;
import ch.gmtech.ste.view.HtmlPage;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {
	
	private final HtmlPage _view = new HtmlPage();
	private ArrayList<Course> _courses;
	
	public static final String SHOW_COURSES = "/course";
	public static final String CREATE_COURSE = "/course/create";
	public static final String ROOT = "";
	
	@Override
	public void init() {
		_courses = new ArrayList<Course>();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String,Controller> routes = new HashMap<String, Controller>();
		routes.put(CREATE_COURSE, new CreateCourse(req, resp, _courses));
		routes.put(SHOW_COURSES, new ShowCourses(_courses, resp));
		routes.put(ROOT, new ShowCourses(_courses, resp));
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

}
