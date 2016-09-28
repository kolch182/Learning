package profile;

public class Profile {


	public int sumTo(int limit) {
	
		int sum = 0;
		
		for (int value = 0; value <= limit; value++) {
			sum += value;
		}
		
		return sum;
	}
}
