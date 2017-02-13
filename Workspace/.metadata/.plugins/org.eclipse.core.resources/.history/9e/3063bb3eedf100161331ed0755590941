package ch.gmtech.ste.learning.html;

import ch.gmtech.ste.learning.html.Div.TypeEnum;

public class Form{

	public String show(){
		return header() + render() + footer();
	}
	
	private String header() {
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
			    "				<form id= 'courseForm' class='form-horizontal' role='form' method='post' action='/try/me'>                                                      		 ";
	}
	
	private String render() {
		String nameDiv = new Div("courseName", "name", TypeEnum.text).create();
		String numberDiv = new Div("number", "number", TypeEnum.number).create();
		String locationDiv = new Div("location", "location", TypeEnum.text).create();
		String seatsDiv = new Div("seats", "seats", TypeEnum.number).create();
		String startDiv = new Div("startdate", "startDate", TypeEnum.date).create();
		
		return nameDiv + numberDiv + locationDiv + seatsDiv + startDiv;
	}

	private String footer() {
		return  "<div class='form-group'>                                                                                                     " +
				"						<div class='col-sm-10 col-sm-offset-2'>                                                                                  " +
				"							<input id='submit' name='submit' type='submit' value='Send' class='btn btn-primary'>                                 " +
				"						</div>                                                                                                                   " +
				"				</form>                                                                                                                          " +
			    "			</div>                                                                                                                               " +
			    "		</div>                                                                                                                                   " +
			    "	</div>                                                                                                                                       " +
			    "    <script src='/js/jquery.min.js'></script>                                                   												 " +
			    "    <script src='/js/bootstrap.min.js'></script>                                                 												 " +
			    "</body> ";
	}
}
