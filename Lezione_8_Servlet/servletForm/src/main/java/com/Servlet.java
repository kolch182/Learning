package com;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.gmtech.ste.learning.html.Form;
import ch.gmtech.ste.learning.html.HtmlPage;
import ch.gmtech.ste.learning.seminar.Course;
import ch.gmtech.ste.learning.seminar.Seminar;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {

	private Map<String,String> addresses = new HashMap<String,String>();
	private ArrayList<Seminar> seminars = new ArrayList<Seminar>();

	@Override
	public void init() {
		initialize();
	}

	private void initialize(){
		Form form = new Form();
		addresses.put("/course/create", form.header() + form.renderBody());
		addresses.put("/try/me", "<h1>you did it!</h1>");
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String requestedUrl = addresses.get(normalizeUrl(req.getRequestURI())) == null ? "<h1>Page not found</h1>" : addresses.get(normalizeUrl(req.getRequestURI()));
		resp.getWriter().write(requestedUrl);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		createSeminar(req);
		resp.getWriter().write(addresses.get(req.getRequestURI()));
	}

	private String normalizeUrl(String path) {
		if(path.charAt(path.length()-1) == File.separatorChar){
			path = path.substring(0, path.length() - 1);
			System.out.println("PATH ----> " + path);
		}
		return path;
	}


	private void createSeminar(HttpServletRequest req) {
		Date startDate = null;
		String name = req.getParameter("name");
		Integer number = Integer.valueOf(req.getParameter("number"));
		String description = req.getParameter("description");
		String location = req.getParameter("location");
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("startdate"));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		
		seminars.add(new Seminar(location, new Course(name, number, description, startDate)));
		HtmlPage htmlPage = new HtmlPage();
		String body = "";
		
		for(Seminar seminarToRender : seminars) {
			body += htmlPage.renderBody(seminarToRender);
		}
		
		addresses.put("/course", htmlPage.header() + body);
	}

}
