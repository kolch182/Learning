package ch.gmtech.ste.introducenullobject;

public class PaymentHistory {
	
	protected PaymentHistory() {}
	
	static PaymentHistory newNull() {
		return new NullPaymentHistory();
	}
	
	public int getWeeksDelinquentInLastYear(){
		return 10;		
	}
	
	public boolean isNull() {
		return false;
	}

}
