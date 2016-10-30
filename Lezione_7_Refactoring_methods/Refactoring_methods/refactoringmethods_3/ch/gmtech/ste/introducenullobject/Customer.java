package ch.gmtech.ste.introducenullobject;

public class Customer {
	private String _name = "Stefano";

	static Customer newNull() {
		return new NullCustomer();
	}

	public String getName() {
		return _name;
	}

	public boolean isNull() {
		return false;
	}
}
