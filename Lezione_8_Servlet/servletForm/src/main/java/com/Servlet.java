package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import ch.gmtech.ste.controller.Controller;
import ch.gmtech.ste.controller.CreateOrUpdateCourse;
import ch.gmtech.ste.controller.DeleteCourse;
import ch.gmtech.ste.controller.ShowCourses;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {

	private DataSource datasource;

	public static final String SHOW_COURSES = "/course";
	public static final String UPDATE_COURSE = "/course/id";
	public static final String CREATE_COURSE = "/course/create";
	public static final String DELETE_COURSE = "/course/delete/id";
	public static final String ROOT = "";

	@Override
	public void init() {
		try {
			datasource = (DataSource)new InitialContext().lookup("java:/comp/env/jdbc/seminar");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Map<String,Controller> routes = new HashMap<String, Controller>();
		routes.put(CREATE_COURSE, new CreateOrUpdateCourse(req, resp));
		routes.put(SHOW_COURSES, new ShowCourses(resp));
		routes.put(UPDATE_COURSE, new CreateOrUpdateCourse(req, resp));
		routes.put(DELETE_COURSE, new DeleteCourse(resp, req));
		routes.put(ROOT, new ShowCourses(resp));
		String requestURI = StringUtils.removeEnd(req.getRequestURI(), "/").replaceAll("\\d+", "id");

		Connection connection=null;
		try {
			connection = datasource.getConnection();
			if (routes.containsKey(requestURI)) {
				try {
					connection.setAutoCommit(false);
					routes.get(requestURI).execute(connection);
					connection.commit();
				} catch (Exception e) {
					resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
					connection.rollback();
				}
			} else {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		} 
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		finally {
			if (connection != null) 
				try {connection.close();} catch (SQLException e) {}
		}
	}

}
