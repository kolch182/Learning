package ch.gmtech.ste.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Servlet;

import ch.gmtech.ste.database.CourseDatabase;
import ch.gmtech.ste.seminar.Course;
import ch.gmtech.ste.view.HtmlPage;

public class DeleteCourse implements Controller {

	private final HttpServletResponse _response;
	private final HttpServletRequest _request;
	private final HtmlPage _view = new HtmlPage();
	private Connection _connection;

	public DeleteCourse(HttpServletResponse response, HttpServletRequest request) {
		_response = response;
		_request = request;
	}

	@Override
	public void execute(Connection connection) throws Exception {
		Statement statement;
		_connection = connection;
		String queryCourseId;

//		if("true".equals(_request.getParameter("confirm"))){

			try {
				queryCourseId = _request.getRequestURI().substring(_request.getRequestURI().lastIndexOf("/") + 1);
				HashMap<String, String> row = new CourseDatabase(_connection).findById(queryCourseId);
				if(row.isEmpty()) _response.sendError(HttpServletResponse.SC_NOT_FOUND);
				statement = _connection.createStatement();
				statement.executeUpdate("delete from Course where id = " + queryCourseId);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			_response.sendRedirect(Servlet.SHOW_COURSES);
//		} else {
//
//			try {
//				queryCourseId = _request.getRequestURI().substring(_request.getRequestURI().lastIndexOf("/") + 1);
//
//				statement = _connection.createStatement();
//				String query = "SELECT * FROM Course where id = " + queryCourseId;
//				ResultSet result = statement.executeQuery(query);
//
//				Course course = new Course(result.getInt(1), result.getString(2),result.getString(3),  
//						new SimpleDateFormat("dd.mm.yyyy").parse(result.getString(6)), result.getString(4), result.getInt(5));
//
//				_response.setStatus(HttpServletResponse.SC_OK);
//				_response.getWriter().write(_view.deleteCourse(course));
//
//			}catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}

}
