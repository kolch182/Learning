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
		addresses.put("/try/bootstrap", printBoot());
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

	private String printBoot() {
		return "<!DOCTYPE html>                                                                                                                                 " +
			    "<html lang='en'>                                                                                                                                " +
			    "  <head>                                                                                                                                        " +
			    "    <meta charset='utf-8'>                                                                                                                      " +
			    "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>                                                                                       " +
			    "    <meta name='viewport' content='width=device-width, initial-scale=1'>                                                                        " +
			    "    <title>Seminar</title>                                                                                      								 " +
			    "    <link rel='stylesheet' href='/css/bootstrap.min.css'>                                        												 " +
			    "  </head>                                                                                                                                       " +
			    "  <body>                                                                                                                                        " +
			    "  	<div class='container'>                                                                                                                      " +
			    "  		<div class='row'>                                                                                                                        " +
			    "  			<div class='col-md-6 col-md-offset-3'>                                                                                               " +
			    "  				<h1 class='page-header text-center'>Course Form</h1>                                                                    " +
			    "				<form id= 'courseForm' class='form-horizontal' role='form' method='post' action='index.php'>                                                      		 " +
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='name' class='col-sm-2 control-label'>Name</label>                                                            " +
			    "						<div class='col-sm-10'>                                                                                                  " +
			    "							<input type='text' class='form-control' id='courseName' name='name' placeholder='Course Name' value='Name'>          " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='number' class='col-sm-2 control-label'>Number</label>                                                          " +
			    "						<div class='col-sm-10'>                                                                                                  " +
		        "							<input type='number' class='form-control' min='0' id='number' name='number' placeholder='Number' value='Number'>      " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='location' class='col-sm-2 control-label'>Location</label>                                                          " +
			    "						<div class='col-sm-10'>                                                                                                  " +
			    "							<input type='text' class='form-control' id='location' name='location' placeholder='Location' value='Location'>      " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='seats' class='col-sm-2 control-label'>#Seats</label>                                                          " +
			    "						<div class='col-sm-10'>                                                                                                  " +
			    "							<input type='number' class='form-control' min='0' id='seats' name='seats' placeholder='#Seats' value='Seats'>      " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='startdate' class='col-sm-2 control-label'>StartDate</label>                                                          " +
			    "						<div class='col-sm-10'>                                                                                                  " +
			    "							<input type='date' class='form-control' id='startdate' name='startdate' placeholder='StartDate'>      " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "					<div class='form-group'>                                                                                                     " +
			    "						<div class='col-sm-10 col-sm-offset-2'>                                                                                  " +
			    "							<input id='submit' name='submit' type='submit' value='Send' class='btn btn-primary'>                                 " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "				</form>                                                                                                                          " +
			    "			</div>                                                                                                                               " +
			    "		</div>                                                                                                                                   " +
			    "	</div>                                                                                                                                       " +
			    "    <script src='/js/jquery.min.js'></script>                                                   												 " +
			    "    <script src='/js/bootstrap.min.js'></script>                                                 												 " +
			    "</body> ";
	}
}
