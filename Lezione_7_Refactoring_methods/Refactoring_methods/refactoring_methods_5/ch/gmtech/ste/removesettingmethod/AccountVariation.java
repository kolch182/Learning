package ch.gmtech.ste.removesettingmethod;

public class AccountVariation {

	private String _id;

	AccountVariation(String id) {
		initializeId(id);
	}

	void initializeId (String arg) {
		_id = "ZZ" + arg;
	}

}
