package ch.gmtech.ste.replacemethodwithobject;

public class Account {

	int gamma (int inputVal, int quantity, int yearToDate) {
		return new Gamma(this, inputVal, quantity,
				yearToDate).compute();
	}

	int delta() {
		return 3;
	}
}
