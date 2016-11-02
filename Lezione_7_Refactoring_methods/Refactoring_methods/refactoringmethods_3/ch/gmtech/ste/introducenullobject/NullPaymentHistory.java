package ch.gmtech.ste.introducenullobject;

public class NullPaymentHistory extends PaymentHistory {
	
	public boolean isNull() {
		return true;
	}
	
	public int getWeeksDelinquentInLastYear(){
		return 0;		
	}

}
