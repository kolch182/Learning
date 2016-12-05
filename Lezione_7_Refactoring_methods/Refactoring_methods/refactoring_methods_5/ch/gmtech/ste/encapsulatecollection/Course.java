package ch.gmtech.ste.encapsulatecollection;

public class Course {

	private boolean _isAdvanced;
	private String _name;

	public Course(String name, boolean isAdvanced) {
		_name = name;
		_isAdvanced = isAdvanced;
	};

	public boolean isAdvanced() {
		return _isAdvanced;
	};

	public String getName() {
		return _name;
	}
	
}
