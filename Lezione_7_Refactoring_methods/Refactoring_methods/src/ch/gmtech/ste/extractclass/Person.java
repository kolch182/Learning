package ch.gmtech.ste.extractclass;

public class Person {
	private String _name;
	private TelephoneNumber _officeTelephone = new TelephoneNumber();
	
	public String getName() {
		return _name;
	}
	
	public String getTelephoneNumber() {
		return ("(" + getOfficeAreaCode() + ") " + getOfficeNumber());
	}
	
	String getOfficeAreaCode() {
		return _officeTelephone.getAreaCode();
	}
	
	void setOfficeAreaCode(String arg) {
		_officeTelephone.setAreaCode(arg);
	}
	
	String getOfficeNumber() {
		return _officeTelephone.getNumber();
	}
	
	void setOfficeNumber(String arg) {
		_officeTelephone.setNumber(arg);
	}
	
}
