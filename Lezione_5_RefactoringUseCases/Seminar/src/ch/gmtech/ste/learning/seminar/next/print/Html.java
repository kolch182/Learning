package ch.gmtech.ste.learning.seminar.next.print;

import ch.gmtech.ste.learning.seminar.next.Seminar;
import ch.gmtech.ste.learning.seminar.next.Student;

public class Html extends SeminarPrinter {

	@Override
	public String header(Seminar seminar) {
		return "<html>" + "<head><title>" + seminar.course().name()
						+ "</title></head><body><div>"
						+ seminar.course().name() + ":</div><ul><li>"
						+ seminar.course().description() +  " iniziera' il " + seminar.course().getStartDate() + "</li><li>"
						+ seminar.location() + "</li><li>" + seminar.seatsLeft()
						+ "</li></ul><div>partecipanti:</div><ul>";
	}
	
	@Override
	public String render(Student student) {
		return "<li>" + student.name() + " " + student.lastname() + "</li>";
	}

	@Override
	public String footer() {
		return "</ul>" + "</body>" + "</html>";
	}
}
