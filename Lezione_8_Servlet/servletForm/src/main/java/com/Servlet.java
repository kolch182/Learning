package com;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.gmtech.ste.learning.html.HtmlPage;
import ch.gmtech.ste.learning.seminar.Course;
import ch.gmtech.ste.learning.seminar.Seminar;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {

	private ArrayList<Seminar> seminars = new ArrayList<Seminar>();
	HtmlPage htmlPage = new HtmlPage();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		if(normalizeUrl(req.getRequestURI()).contentEquals("/course/create")){
			resp.getWriter().write(htmlPage.header() + htmlPage.renderFormBody());
		} else {
			resp.getWriter().write("<h1>Page not found</h1>");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String courseName = req.getParameter("name");
		String courseStartDate = req.getParameter("startdate");
		String courseLocation = req.getParameter("location");
		int courseTotalSeats = Integer.valueOf((req.getParameter("seats").isEmpty() ? "0" : req.getParameter("seats")));
		int courseNumber = Integer.valueOf((req.getParameter("courseid").isEmpty() ? "0" : req.getParameter("courseid")));
		String courseDescription = req.getParameter("description");
		
		Checker checker = new Checker(courseName, courseNumber, courseTotalSeats, courseLocation, courseDescription, courseStartDate);
		
		if(checker.check()){
			resp.getWriter().write(createSeminar(courseName, courseNumber, courseTotalSeats, courseLocation, courseDescription, courseStartDate));
		}else{
			resp.getWriter().write(htmlPage.header() + htmlPage.renderValidatedFormBody(checker));
		}
			
	}

	private String normalizeUrl(String path) {
		if(path.charAt(path.length()-1) == File.separatorChar){
			path = path.substring(0, path.length() - 1);
		}
		return path;
	}


	private String createSeminar(String name, Integer number, Integer seats, String location, String description, String startDate) {
		
		HtmlPage htmlPage = new HtmlPage();
		String body = "";

		try {
			seminars.add(new Seminar(location, new Course(name, number, description, new SimpleDateFormat("dd.mm.yyyy").parse(startDate))));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		
		for(Seminar seminarToRender : seminars) {
			body += htmlPage.renderBody(seminarToRender);
		}
		
		return htmlPage.header() + body;
	}

}
