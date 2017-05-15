package ch.gmtech.ste.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.gmtech.ste.checker.Checker;
import ch.gmtech.ste.seminar.Course;
import ch.gmtech.ste.view.HtmlPage;

public class CreateCourse implements Controller{

	private final HttpServletRequest _request;
	private final HttpServletResponse _response;
	private final ArrayList<Course> _courses;
	private final HtmlPage _view = new HtmlPage();
	private Connection _connection;

	public CreateCourse(HttpServletRequest request, HttpServletResponse response, ArrayList<Course> courses) {
		_request = request;
		_response = response;
		_courses = courses;
	}

	@Override
	public void execute(Connection connection) throws Exception {
		_connection = connection;
		if ("POST".equals(_request.getMethod())) {
			action();
		}
		if ("GET".equals(_request.getMethod())) {
			_response.setStatus(HttpServletResponse.SC_OK);
			_response.getWriter().write(_view.showForm());
		}

	}

	private void action() throws IOException {

		Checker checker = new Checker(Course.rules(), _request);

		if(checker.isValid()){
			String courseName = _request.getParameter(Course.NAME);
			String courseStartDate = _request.getParameter(Course.START);
			String courseLocation = _request.getParameter(Course.LOCATION);
			String courseTotalSeats = _request.getParameter(Course.TOTAL_SEATS).isEmpty() ? "0" : _request.getParameter(Course.TOTAL_SEATS);
			String courseDescription = _request.getParameter(Course.DESCRIPTION);

			_response.getWriter().write(createCourse(courseName, courseTotalSeats, courseLocation, courseDescription, courseStartDate));
		}else{
			_response.getWriter().write(_view.showForm(checker));
		}

	}

	private String createCourse(String name, String seats, String location, String description, String startDate) {

		HtmlPage htmlPage = new HtmlPage();
		
		try {
			Statement statement = _connection.createStatement();

			statement.executeUpdate("insert into Course values(null, '" + name + "', '" + description + "', '" + location + 
					"', '" + Integer.valueOf(seats) + "', '" + startDate + "')");

			_courses.add(new Course(name, description, new SimpleDateFormat("dd.mm.yyyy").parse(startDate), location, Integer.valueOf(seats)));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
			catch (SQLException e) {
			e.printStackTrace();
		}

		return htmlPage.showCourses(_connection);
	}

}
