package ch.gmtech.ste.learning.seminar.next;

import java.text.ParseException;

import ch.gmtech.ste.learning.seminar.next.print.Csv;
import ch.gmtech.ste.learning.seminar.next.print.Html;
import ch.gmtech.ste.learning.seminar.next.print.Plain;

public class PrintFactory {

	private final Seminar _seminar;

	public PrintFactory(Seminar seminar) {
		_seminar = seminar;
	}

	public String printPlain() throws ParseException {

		return new Plain().print(_seminar);

	}

	public String printHtml() throws ParseException {

		return new Html().print(_seminar);

	}

	public String printCsv() throws ParseException {
		
		return new Csv().print(_seminar);
		
	}
}
