package replacedelegationwithinheritance.copy;

public class Person {
	String _name;

	public String getName() {
		return _name;
	}

	public void setName(String arg) {
		_name = arg;
	}

	public String getLastName() {
		return _name.substring(_name.indexOf(' ') + 1);
	}
}
