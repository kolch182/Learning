package ch.gmtech.ste.changebidirectionaltounidirectional;


public class Order {
	
	double getDiscountedPrice(Customer customer) {
		return getGrossPrice() * (1 - customer.getDiscount());
	}

	private int getGrossPrice() {
		return 10;
	}

}
