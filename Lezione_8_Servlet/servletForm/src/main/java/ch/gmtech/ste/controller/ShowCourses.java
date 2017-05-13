package ch.gmtech.ste.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletResponse;

import ch.gmtech.ste.view.HtmlPage;

public class ShowCourses implements Controller{
	
	private final HttpServletResponse _response;
	private final HtmlPage _view = new HtmlPage();
	
	public ShowCourses(HttpServletResponse response) {
		_response = response;
	}

	@Override
	public void execute(Connection connection) throws Exception {
		_response.setStatus(HttpServletResponse.SC_OK);
		_response.getWriter().write(_view.showCourses(connection));
	}

}
