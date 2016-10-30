package ch.gmtech.ste.inlineclass;


public class Person {
	private String _name;
	private String _number;
	private String _areaCode;

	
	public String getName() {
		return _name;
	}

	public String getTelephoneNumber() {
		return ("(" + _areaCode + ") " + _number);
	}

	String getAreaCode() {
		return _areaCode;
	}

	void setAreaCode(String arg) {
		_areaCode = arg;
	}

	String getNumber() {
		return _number;
	}
	
	void setNumber(String arg) {
		_number = arg;
	}

}
