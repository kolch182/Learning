package ch.gmtech.ste.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import ch.gmtech.ste.seminar.Course;
import ch.gmtech.ste.view.HtmlPage;

public class ShowCourses implements Controller{

	private final HttpServletResponse _response;
	private final HtmlPage _view = new HtmlPage();

	public ShowCourses(HttpServletResponse response) {
		_response = response;
	}

	@Override
	public void execute(Connection connection) throws Exception {
		final ArrayList<Course> _courses = new ArrayList<Course>();
		Statement statement;
		
		try {
			statement = connection.createStatement();
			String query = "SELECT * FROM Course";
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {

				_courses.add(new Course(result.getInt(1), result.getString(2),result.getString(3),  
							 new SimpleDateFormat("dd.mm.yyyy").parse(result.getString(6)), result.getString(4), result.getInt(5)));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		_response.setStatus(HttpServletResponse.SC_OK);
		_response.getWriter().write(_view.showCourses(_courses));
	}

}
