package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Checker {

	private String _courseName;
	private String _startDate = null;
	private String _id;
	private String _description;
	private String _location;
	private String _seats;
	private String _message;

	public Checker(String name, String courseId, String courseTotalSeats, String location, String description, String startDate)  {
		_courseName = name;
		_id = courseId;
		_seats = courseTotalSeats;
		_location = location;
		_description = description;
		_startDate = startDate;
		_message = "";
	}
	
	public boolean check() {
		return checkCourseName().isEmpty() && checkStartDate().isEmpty() && checkLocation().isEmpty() 
				&& checkTotalSeats().isEmpty() && checkCourseId().isEmpty() && checkDescription().isEmpty();
	}
	
	public String checkStartDate() {
		
		if(_startDate.toString().isEmpty()) return "Can't be empty, insert a valid date! ";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
	    Date date = new Date();
		try {
			date = sdf.parse(_startDate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    if (!_startDate.equals(sdf.format(date))) {
	        return "The right format is: dd.mm.yyyy ";
	    }
		
		return "";
	}

	public String checkDescription() {
		return "";
	}
	
	public String checkCourseName() {
		verifyEmptyAndWarning(_courseName);
		System.out.println("COURSE " + _courseName.length());
		_message += _courseName.length() > 15 ? "The maximum lenght for the course name is 15! " : "";
		return _message;
	}
	
	public String checkLocation() {
		verifyEmptyAndWarning(_location);
		_message += _location.length() > 20 ? "The maximum lenght for the course name is 20! " : "";
		return _message;
	}
	
	public String checkTotalSeats() {
		verifyEmptyAndWarning(_seats);
		_message = _seats.matches("^\\d{1,3}$") == true ? "" : "The number must have no more than 3 digits! ";
		_message += (_seats.matches("[1-9][0-9]*") == true && Integer.valueOf(_seats) < 100) ? "" : "Insert a valid number lower than 100! ";
		return _message;
	}

	public String checkCourseId() {
		_message = !_id.isEmpty() == true ? "" : "Can't be empty! ";
		_message += _id.matches("[1-9][0-9]*") == true ? "" : "Insert a number value! ";
		return _message ;
	}

	private void verifyEmptyAndWarning(String input) {
		_message = !input.isEmpty() == true ? "" : "Can't be empty! ";
	}

	public String getLocation() {
		return _location;
	}

	public String getTotalSeats() {
		return _seats;
	}

	public String getCourseId() {
		return _id;
	}

	public String getDescritpion() {
		return _description;
	}
	
	public String getCourseName() {
		return _courseName;
	}
	
	public String getStartDate() {
		return _startDate;
	}
}