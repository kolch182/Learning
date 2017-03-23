package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Checker {

	private String _courseName;
	private String _startDate = null;
	private Integer _number;
	private String _description;
	private String _location;
	private Integer _seats;

	public Checker(String name, int courseNumber, int courseTotalSeats, String location, String description, String startDate)  {
		_courseName = name;
		_number = courseNumber;
		_seats = courseTotalSeats;
		_location = location;
		_description = description;
		_startDate = startDate;
	}
	
	public boolean check() {
		return checkCourseName() && checkStartDate() && checkLocation() && checkTotalSeats() && checkCourseId() && checkDescription();
	}
	
	public String getCourseName() {
		return _courseName;
	}
	
	public boolean checkCourseName() {
		return !_courseName.isEmpty();
	}
	

	public String getStartDate() {
		return _startDate;
	}
	
	public boolean checkStartDate() {
		
		if(_startDate.toString().isEmpty()) return false;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
	    Date date = new Date();
		try {
			date = sdf.parse(_startDate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    if (!_startDate.equals(sdf.format(date))) {
	        return false;
	    }
		
		return true;
	}
	
	public boolean checkLocation() {
		return !_location.isEmpty();
	}
	
	public boolean checkTotalSeats() {
		return _seats > 0;
	}

	public String getLocation() {
		return _location;
	}

	public Integer getTotalSeats() {
		return _seats;
	}

	public Integer getCourseId() {
		return _number;
	}
	
	public boolean checkCourseId() {
		return _number > 0 ;
	}

	public String getDescritpion() {
		return _description;
	}
	
	public boolean checkDescription() {
		return true;
	}

	
}