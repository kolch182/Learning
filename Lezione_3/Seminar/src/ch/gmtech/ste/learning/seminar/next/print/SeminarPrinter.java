package ch.gmtech.ste.learning.seminar.next.print;

import ch.gmtech.ste.learning.seminar.next.Seminar;
import ch.gmtech.ste.learning.seminar.next.Student;

public abstract class SeminarPrinter {

	public String print(Seminar seminar) {
		String result = header(seminar);

		for (Student student : seminar.students()) {
			result += render(student);
		}

		result += footer();

		return result;
	}

	public abstract String header(Seminar seminar);
	public abstract String render(Student student);
	public abstract String footer();
}
