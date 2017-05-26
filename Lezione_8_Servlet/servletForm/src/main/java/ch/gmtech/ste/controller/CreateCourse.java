package ch.gmtech.ste.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.gmtech.ste.checker.Checker;
import ch.gmtech.ste.database.CourseDatabase;
import ch.gmtech.ste.seminar.Course;
import ch.gmtech.ste.view.HtmlPage;

public class CreateCourse implements Controller{

	private final HttpServletRequest _request;
	private final HttpServletResponse _response;
	private final HtmlPage _view = new HtmlPage();
	private Connection _connection;

	public CreateCourse(HttpServletRequest request, HttpServletResponse response) {
		_request = request;
		_response = response;
	}

	@Override
	public void execute(Connection connection) throws Exception {
		_connection = connection;
		if ("POST".equals(_request.getMethod())) {
			evaluateInsertedData();
		}
		if ("GET".equals(_request.getMethod())) {
			_response.setStatus(HttpServletResponse.SC_OK);
			_response.getWriter().write(_view.showForm());
		}

	}

	private void evaluateInsertedData() throws Exception {

		Checker checker = new Checker(Course.rules(), _request);

		if(checker.isValid()){
			String courseName = _request.getParameter(Course.NAME);
			String courseStartDate = _request.getParameter(Course.START);
			String courseLocation = _request.getParameter(Course.LOCATION);
			String courseTotalSeats = _request.getParameter(Course.TOTAL_SEATS).isEmpty() ? "0" : _request.getParameter(Course.TOTAL_SEATS);
			String courseDescription = _request.getParameter(Course.DESCRIPTION);

			new CourseDatabase(_connection).insert(courseName, courseTotalSeats, courseLocation, courseDescription, courseStartDate);
			
			new ShowCourses(_response).execute(_connection);
		}else{
			_response.getWriter().write(_view.showForm(checker));
		}

	}
}
