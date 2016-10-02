package ch.gmtech.ste.replacetempwithquery;

public class ReplaceTempWithQuery {

	private int _quantity = 10;
	private int _itemPrice = 25;
	
	double getPrice() {
		return getBasePrice() * getDiscountFactor();
	}

	private double getDiscountFactor() {
		final double discountFactor;
		if (getBasePrice() > 1000) discountFactor = 0.95;
		else discountFactor = 0.98;
		return discountFactor;
	}

	private int getBasePrice() {
		return _quantity * _itemPrice;
	}
}
