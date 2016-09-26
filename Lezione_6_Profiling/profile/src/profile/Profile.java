package profile;

public class Profile {


	public int sumTo(int limit) {
	
		Calc calc = new Calc();
		int sum = 0;
		
		for (int value = 0; value <= limit; value++) {
			sum = calc.accumulate(sum, value);
		}
		
		return sum;
	}
}
