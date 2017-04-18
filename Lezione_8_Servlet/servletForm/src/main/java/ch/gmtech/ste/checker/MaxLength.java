package ch.gmtech.ste.checker;

public class MaxLength implements Rule {
	
	private final int _length;

	public MaxLength(int length) {
		_length = length;
	}

	@Override
	public boolean applyOn(String what) {
		return what != null && what.length() <= _length;
	}

	@Override
	public String message() {
		

		return "The maximum lenght for the course name is " + _length + "!";
	}

}
