package ch.gmtech.ste.learning.seminar.next;

import ch.gmtech.ste.learning.seminar.next.print.Csv;
import ch.gmtech.ste.learning.seminar.next.print.Html;
import ch.gmtech.ste.learning.seminar.next.print.Plain;

public class PrintFactory {

	private final Seminar _seminar;

	public PrintFactory(Seminar seminar) {
		_seminar = seminar;
	}

	public String printPlain() {

		return new Plain().print(_seminar);

	}

	public String printHtml() {

		return new Html().print(_seminar);

	}

	public String printCsv() {
		
		return new Csv().print(_seminar);
		
	}
}
