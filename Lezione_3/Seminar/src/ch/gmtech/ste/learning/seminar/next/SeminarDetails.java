package ch.gmtech.ste.learning.seminar.next;
import java.util.Arrays;
import java.util.List;



public class SeminarDetails {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new SeminarDetails().start();
	}


	private void start() {
		Seminar matematica = new Seminar("Lugano", new Course("Fondamenti di matematica", 1, "Aritmetica di base"));
		Student stefano = new Student("Stefano", "Coluccia");
		matematica.enroll(stefano);
		matematica.enroll(new Student("ValentN-ANO", "Decarli"));
		matematica.enroll(new Student("Manlio", "VaccaLuzzo"));
		
		Seminar informatica = new Seminar("Manno", new Course("informatica", 2, "Sequence diagrams"));
		informatica.enroll(stefano);
		
		Seminar chimica = new Seminar("Bioggio", new Course("Chimica", 3, "Ossidoriduzioni"));
		
		List<Seminar> seminars = Arrays.asList(matematica, informatica, chimica);
		
		for (Seminar seminar : seminars) {
			
			System.out.println(new PrintFactory(seminar).printPlain());
			System.out.println(new PrintFactory(seminar).printHtml());
			System.out.println(new PrintFactory(seminar).printCsv());
		}
	}
}
