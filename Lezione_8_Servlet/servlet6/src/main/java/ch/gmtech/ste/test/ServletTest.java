package ch.gmtech.ste.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ServletTest {

	WebClient webClient = new WebClient();
	
	@Test
	public void html() throws Exception {
		HtmlPage page = webClient.getPage("http://localhost:8080/html");

		assertEquals("Computer science", page.getTitleText());
	}

	@Test
	public void plain() throws Exception {
		String expected = "***************************************************************************************************************\n" +
				"Seminario di Computer science (1) su Lorem ipsum dolor sit amet iniziera' il 01.10.2016\n" +
				"Il seminario si terra' presso Zurich e al momento ci sono ancora 18 posti disponibili\n" +
				"***************************************************************************************************************\n\n" +
				"Gli studenti attualmente iscritti sono: \n" +
				"			** Ugo Campione ** \n" +
				"			** Sandra Bach ** \n";
		TextPage page = webClient.getPage("http://localhost:8080/plain");

		assertEquals(expected, page.getContent());
	}

	@Test
	public void csv() throws Exception {
		String expected = "\"1\";\"Computer science\";\"Lorem ipsum dolor sit amet\";\"01.10.2016\";\"Zurich\";\"18\"\n" +
				"\"Ugo\";\"Campione\"\n" +
				"\"Sandra\";\"Bach\"\n";
		TextPage page = webClient.getPage("http://localhost:8080/csv");
		
		assertEquals(expected, page.getContent());
	}
}
