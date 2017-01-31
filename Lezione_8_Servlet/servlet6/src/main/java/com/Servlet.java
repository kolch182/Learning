package com;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.gmtech.ste.learning.seminar.next.Course;
import ch.gmtech.ste.learning.seminar.next.PrintFactory;
import ch.gmtech.ste.learning.seminar.next.Seminar;
import ch.gmtech.ste.learning.seminar.next.Student;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {

	private PrintFactory _printFactory;
	private Map<String,String> addresses = new HashMap<String,String>();
	
	private void initialize(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date startDate;
		try {
			startDate = sdf.parse("01.10.2016");
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		Seminar seminar = new Seminar("Zurich", new Course("Computer science", 1, "Lorem ipsum dolor sit amet", startDate));
		seminar.enroll(new Student("Ugo", "Campione"));
		seminar.enroll(new Student("Sandra", "Bach"));
		_printFactory = new PrintFactory(seminar);
		
		addresses.put("/html", _printFactory.printHtml());
		addresses.put("/plain", _printFactory.printPlain());
		addresses.put("/csv", _printFactory.printCsv());
		addresses.put("/try/me", "<h1>you did it!</h1>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		initialize();
		
		if(addresses.get(req.getRequestURI()) == null){
			resp.getWriter().write("<h1>Page not found</h1>");
		}else if(req.getRequestURI().contains("/csv")){
			resp.getWriter().write(addresses.get(req.getRequestURI()));
			downloadCsv(resp);
		}else{
			resp.getWriter().write(addresses.get(req.getRequestURI()));
		}
			
		
	}

	private void downloadCsv(HttpServletResponse resp) {
		resp.setContentType("text/csv");
		resp.setHeader("Content-Disposition","attachment;filename=\"seminar.csv\" ");
		try
		{
		    OutputStream outputStream = resp.getOutputStream();
		    String outputResult = _printFactory.printCsv();
		    outputStream.write(outputResult.getBytes());
		    outputStream.flush();
		    outputStream.close();
		}
		catch(Exception e)
		{
		    System.out.println(e.toString());
		}
	}

}
