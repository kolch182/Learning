package ch.gmtech.ste.learning.seminar.next;

import ch.gmtech.ste.learning.seminar.next.print.Csv;
import ch.gmtech.ste.learning.seminar.next.print.Html;
import ch.gmtech.ste.learning.seminar.next.print.Plain;

public class PrintFactory {

	private final Seminar _seminar;

	public PrintFactory(Seminar seminar) {
		_seminar = seminar;
	}

	public String printPlain(){

		return new Plain().print(_seminar);

	}

	public String printHtml(){

		return new Html().print(_seminar);

	}

	public String printCsv(){
		
		return new Csv().print(_seminar);
		
	}
	
	public String showForm(){
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
			    "				<form id= 'courseForm' class='form-horizontal' role='form' method='post' action='me'>                                                      		 " +
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
