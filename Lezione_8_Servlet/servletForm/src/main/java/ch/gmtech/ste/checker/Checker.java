package ch.gmtech.ste.checker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import ch.gmtech.ste.seminar.Course;

public class Checker {

	private final MultiValuedMap<String, Rule> _rules;
	private final Map<String, String> _requestMap;

	public Checker(MultiValuedMap<String, Rule> rules, HttpServletRequest request)  {
		_rules = rules;
		_requestMap = requestMap(request);
	}
	
	public Checker(MultiValuedMap<String, Rule> rules, HashMap<String, String> row) {
		_rules = rules;
		_requestMap = row;
	}

	public MultiValuedMap<String, String> validate(){
		MultiValuedMap<String, String> errors = new HashSetValuedHashMap<String, String>();
		for (Entry<String, Collection<Rule>> pair: new HashMap<String, Collection<Rule>>(_rules.asMap()).entrySet()) {
			Collection<Rule> rules = pair.getValue();
			for (Rule rule : rules) {
				String value = _requestMap.get(pair.getKey());
				if(!rule.applyOn(value)){
					errors.put(pair.getKey(), rule.message());
				}
			}
		}
		return errors;
	}

	public boolean isValid() {
		return validate().isEmpty();
	}
	
	private Map<String, String> requestMap(HttpServletRequest request){
		Map<String, String> convert = new HashMap<String, String>();
		for (Object key : request.getParameterMap().keySet()) {
			convert.put(key.toString(), request.getParameter(key.toString()));
		}
		return convert;
	}
	

	public String getLocation() {
		return _requestMap.get(Course.LOCATION);
	}

	public String getTotalSeats() {
		return _requestMap.get(Course.TOTAL_SEATS);
	}

	public String getDescritpion() {
		return _requestMap.get(Course.DESCRIPTION);
	}
	
	public String getCourseName() {
		return _requestMap.get(Course.NAME);
	}
	
	public String getStartDate() {
		return _requestMap.get(Course.START);
	}
}