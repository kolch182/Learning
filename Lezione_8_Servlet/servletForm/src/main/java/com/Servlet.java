package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.gmtech.ste.learning.html.Form;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {

	private Map<String,String> addresses = new HashMap<String,String>();

	@Override
	public void init() throws ServletException {
		super.init();
		initialize();
	}

	private void initialize(){
		addresses.put("/course/create", new Form().show());
		addresses.put("/try/me", "<h1>you did it!</h1>");
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String requestedUrl = addresses.get(req.getRequestURI()) == null ? "<h1>Page not found</h1>" : addresses.get(req.getRequestURI());
		resp.getWriter().write(requestedUrl);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		resp.getWriter().write(addresses.get(req.getRequestURI()));
	}

}
