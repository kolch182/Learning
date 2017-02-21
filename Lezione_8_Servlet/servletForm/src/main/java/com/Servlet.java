package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
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
	ArrayList<Seminar> seminars = new ArrayList<Seminar>();
	private HtmlPage htmlPage = null;

	@Override
	public void init() throws ServletException {
		super.init();
		initialize();
	}

	private void initialize(){
		Form form = new Form();
		addresses.put("/course/create", form.header() + form.renderBody());
		addresses.put("/try/me", "<h1>you did it!</h1>");
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String requestedUrl = addresses.get(req.getRequestURI()) == null ? "<h1>Page not found</h1>" : addresses.get(req.getRequestURI());
		resp.getWriter().write(requestedUrl);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Date startDate = null;
		String name = req.getParameter("name");
		Integer number = Integer.valueOf(req.getParameter("number"));
		String description = req.getParameter("description");
		String location = req.getParameter("location");
//		try {
//			startDate = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("startdate"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		Seminar seminar = new Seminar(location, new Course(name, 1, description, startDate));
		seminars.add(seminar);
		htmlPage = new HtmlPage(seminars);
		addresses.put("/course", htmlPage.header()+htmlPage.renderBody());

		resp.getWriter().write(addresses.get(req.getRequestURI()));
	}

}
