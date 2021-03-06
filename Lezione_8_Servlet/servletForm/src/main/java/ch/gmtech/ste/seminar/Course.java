package ch.gmtech.ste.seminar;

import static ch.gmtech.ste.checker.NumberRule.OPERATOR.GREATER_THAN;
import static ch.gmtech.ste.checker.NumberRule.OPERATOR.LESS_THAN;
import static java.util.Arrays.asList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import ch.gmtech.ste.checker.MaxLengthRule;
import ch.gmtech.ste.checker.NotEmptyRule;
import ch.gmtech.ste.checker.NumberRule;
import ch.gmtech.ste.checker.Rule;
import ch.gmtech.ste.checker.TimeFormatRule;

public class Course {
	
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String LOCATION = "location";
	public static final String TOTAL_SEATS = "totalSeats";
	public static final String ID = "id";
	public static final String START = "start";
	
	private final Integer _id;
	private final String _name;
	private final Integer _seats;
	private final String _description;
	private final Date _startDate;
	private final String _location;
	private final List<Student> _students = new ArrayList<Student>();

	public Course(Integer id, String courseName, String description, Date startDate, String location, Integer seats) {
		_id = id;
		_name = courseName;
		_description = description;
		_startDate = startDate;
		_location = location;
		_seats = seats;
	}
	
	public static MultiValuedMap<String, Rule> rules(){
		 return new ArrayListValuedHashMap<String, Rule>(){{
			putAll(NAME, 			  asList(new NotEmptyRule(), new MaxLengthRule(15)));
			putAll(LOCATION, 	  asList(new NotEmptyRule(), new MaxLengthRule(20)));
			putAll(TOTAL_SEATS, asList(new NumberRule(GREATER_THAN, 0), new NumberRule(LESS_THAN, 100), new MaxLengthRule(3)));
			put(START, 				  new TimeFormatRule("dd.mm.yyyy"));
		}};
	}

	public String getDescription(){
		return _description;
	}

	public String getName() {
		return _name;
	}

	public String getStartDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
		return sdf.format(_startDate); 
	}
	
	public String getLocation() {
		return _location;
	}

	public Integer getSeatsLeft() {
		return _seats - _students.size();
	}

	public boolean enroll(Student student) {
		boolean add = false;
		
		if(_students.size() < _seats)
			add = _students.add(student);
		
		return add;
	}

	public List<Student> students() {
		return _students;
	}

	public Integer getId() {
		return _id;
	}
}
