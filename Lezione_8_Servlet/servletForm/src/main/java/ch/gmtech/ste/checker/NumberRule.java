package ch.gmtech.ste.checker;

import org.apache.commons.lang3.math.NumberUtils;

public class NumberRule implements Rule {

	private final Integer _b;
	private final OPERATOR _op;

	private String _message;
	public enum OPERATOR {LESS_THAN, GREATER_THAN, GREATER_EQUAL, LESS_EQUAL}
	
	public NumberRule(OPERATOR op,  Integer b) {
		_op = op;
		_b = b;
		_message = "";
	}
	@Override
	public boolean applyOn(String what) {
		if(!NumberUtils.isCreatable(what) || _b.equals(null)){
			_message = "must be a number";
			return false;
		} else {
			Integer number = new Integer(what);
			if(_op.equals(OPERATOR.LESS_THAN) && (_b <= number)){
				_message = "must be less than " + _b;
				return false;
			}
			if(_op.equals(OPERATOR.GREATER_THAN) && (number <= _b)){
				_message = "must be greater than " + _b;
				return false;
			}
			if(_op.equals(OPERATOR.LESS_EQUAL) && (_b < number)){
				_message = "must be less than " + _b;
				return false;
			}
			if(_op.equals(OPERATOR.GREATER_EQUAL) && (number < _b)){
				_message = "must be greater than " + _b;
				return false;
			}
			return true;
		}
	}


	@Override
	public String message() {
		return _message;
	}
}
