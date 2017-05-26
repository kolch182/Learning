package ch.gmtech.ste.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Servlet;

import ch.gmtech.ste.checker.Checker;
import ch.gmtech.ste.database.CourseDatabase;
import ch.gmtech.ste.seminar.Course;
import ch.gmtech.ste.view.HtmlPage;

public class UpdateCourse implements Controller{

	private final HttpServletResponse _response;
	private final HttpServletRequest _request;
	private final HtmlPage _view = new HtmlPage();
	private Connection _connection;

	public UpdateCourse(HttpServletResponse response, HttpServletRequest request) {
		_response = response;
		_request = request;
	}

	@Override
	public void execute(Connection connection) throws Exception {

		_connection = connection;

		if ("GET".equals(_request.getMethod())) {
			String queryCourseId = _request.getRequestURI().substring(_request.getRequestURI().lastIndexOf("/") + 1);
			HashMap<String, String> row = new CourseDatabase(_connection).findById(queryCourseId);

			_response.setStatus(HttpServletResponse.SC_OK);
			_response.getWriter().write(_view.updateCourse(row));
		}

		if ("POST".equals(_request.getMethod())) {
			Checker checker = new Checker(Course.rules(), _request);
			evaluateInsertedData(checker, _request);
		}
	}

	private void evaluateInsertedData(Checker checker, HttpServletRequest _request) throws Exception {

		if(checker.isValid()){
			String courseId = _request.getRequestURI().substring(_request.getRequestURI().lastIndexOf("/") + 1);
			String courseName = _request.getParameter(Course.NAME);
			String courseStartDate = _request.getParameter(Course.START);
			String courseLocation = _request.getParameter(Course.LOCATION);
			String courseTotalSeats = _request.getParameter(Course.TOTAL_SEATS).isEmpty() ? "0" : _request.getParameter(Course.TOTAL_SEATS);
			String courseDescription = _request.getParameter(Course.DESCRIPTION);

			updateCourse(courseId, courseName, courseTotalSeats, courseLocation, courseDescription, courseStartDate);

			_response.sendRedirect(Servlet.SHOW_COURSES);
		}else{
			_response.getWriter().write(_view.showForm(checker));
		}

	}

	private void updateCourse(String courseId, String name, String seats, String location, String description, String startDate) {

		try {
			Statement statement = _connection.createStatement();

			statement.executeUpdate("update Course set name = '" + name + "', description = '" + description + "', location = '" + location + 
					"', totalSeats = " + Integer.valueOf(seats) + ", start = '" + startDate + "' where id = " + Integer.valueOf(courseId));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
