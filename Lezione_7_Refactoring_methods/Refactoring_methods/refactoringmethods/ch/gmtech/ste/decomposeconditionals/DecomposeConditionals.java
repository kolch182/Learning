package ch.gmtech.ste.decomposeconditionals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DecomposeConditionals {

	private static Date SUMMER_START;
	private static Date SUMMER_END;
	private int _winterRate = 5;
	private int _winterServiceCharge = 2;
	private int _summerRate = 10;

	public int chargeOnSeason(int quantity) throws ParseException{
		
		SUMMER_START = new SimpleDateFormat("dd.MM.yyyy").parse("01.06.2016");
		SUMMER_END = new SimpleDateFormat("dd.MM.yyyy").parse("01.10.2016");
		int result;
		Date date = new Date();

		if (notSummer(date))
			result = winterCharge(quantity);
		else
			result = summerCharge(quantity);

		return result;
	}

	private int summerCharge(int quantity) {
		int result;
		result = quantity * _summerRate;
		return result;
	}

	private int winterCharge(int quantity) {
		int result;
		result = quantity * _winterRate + _winterServiceCharge;
		return result;
	}

	private boolean notSummer(Date date) {
		return date .before (SUMMER_START) || date.after(SUMMER_END);
	}

}
