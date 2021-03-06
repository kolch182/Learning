package ch.gmtech.ste.learning.seminar.next;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class PrintTest {

	private PrintFactory _printFactory;

	@Before
	public void setUp() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date startDate = sdf.parse("01.10.2016");
		Seminar seminar = new Seminar("Zurich", new Course("Computer science", 1, "Lorem ipsum dolor sit amet", startDate));
		seminar.enroll(new Student("Ugo", "Campione"));
		seminar.enroll(new Student("Sandra", "Bach"));
		_printFactory = new PrintFactory(seminar);
	}

	@Test
	public void plain() throws ParseException {
		String expected = "***************************************************************************************************************\n" +
				"Seminario di Computer science (1) su Lorem ipsum dolor sit amet iniziera' il 01.10.2016\n" +
				"Il seminario si terra' presso Zurich e al momento ci sono ancora 18 posti disponibili\n" +
				"***************************************************************************************************************\n\n" +
				"Gli studenti attualmente iscritti sono: \n" +
				"			** Ugo Campione ** \n" +
				"			** Sandra Bach ** \n";
		assertEquals(expected, _printFactory.printPlain());
	}

	@Test
	public void html() throws ParseException {
		String expected = "<html>"+
				"<head>"+
				"<title>Computer science</title>"+
				"</head>"+
				"<body>"+
				"<div>Computer science:</div>"+
				"<ul>"+
				"<li>Lorem ipsum dolor sit amet iniziera' il 01.10.2016</li>"+
				"<li>Zurich</li>"+
				"<li>18</li>"+
				"</ul>"+
				"<div>partecipanti:</div>"+
				"<ul>"+
				"<li>Ugo Campione</li>"+
				"<li>Sandra Bach</li>"+
				"</ul>"+
				"</body>"+
				"</html>";
		assertEquals(expected, _printFactory.printHtml());
	}

	@Test
	public void csv() throws ParseException {
		String expected = "\"1\";\"Computer science\";\"Lorem ipsum dolor sit amet\";\"01.10.2016\";\"Zurich\";\"18\"\n" +
				"\"Ugo\";\"Campione\"\n" +
				"\"Sandra\";\"Bach\"\n";
		assertEquals(expected, _printFactory.printCsv());
	}
}
