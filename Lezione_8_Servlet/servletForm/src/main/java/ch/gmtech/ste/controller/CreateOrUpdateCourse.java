package ch.gmtech.ste.controller;

import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.Servlet;

import ch.gmtech.ste.checker.Checker;
import ch.gmtech.ste.database.CourseDatabase;
import ch.gmtech.ste.seminar.Course;
import ch.gmtech.ste.view.HtmlPage;

public class CreateOrUpdateCourse implements Controller{

	private final HttpServletRequest _request;
	private final HttpServletResponse _response;
	private final HtmlPage _view = new HtmlPage();
	private Connection _connection;
	private String queryCourseId = null;

	public CreateOrUpdateCourse(HttpServletRequest request, HttpServletResponse response) {
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
			queryCourseId = _request.getRequestURI().substring(_request.getRequestURI().lastIndexOf("/") + 1);
			
			if(isUpdate(queryCourseId)){
				HashMap<String, String> row = new CourseDatabase(_connection).findById(queryCourseId);
				if(row.isEmpty()) _response.sendError(HttpServletResponse.SC_NOT_FOUND);
				_response.setStatus(HttpServletResponse.SC_OK);
				_response.getWriter().write(_view.updateCourse(row));
			}else {
				_response.setStatus(HttpServletResponse.SC_OK);
				_response.getWriter().write(_view.showForm());
			}
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
			String queryCourseId = _request.getRequestURI().substring(_request.getRequestURI().lastIndexOf("/") + 1);

			new CourseDatabase(_connection).insertOrUpdate(isUpdate(queryCourseId) ? queryCourseId : null, courseName, courseTotalSeats, courseLocation, courseDescription, courseStartDate);

			_response.sendRedirect(Servlet.SHOW_COURSES);
		}else{
			_response.getWriter().write(_view.showForm(checker));
		}

	}

	private boolean isUpdate(String urlLastPathElement){
		return StringUtils.isNumeric(urlLastPathElement);
	}
}
