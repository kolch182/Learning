package ch.gmtech.ste.formtemplate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FormTemplateTest {
	
	@Test
	public void printStatement() {
		FormTemplate formtemplate = new FormTemplate();
		String expected = "Rental Record for Stefano\n" +
				"	Back to the future	9.0\n" +
				"	Save private Ryan	3.0\n" +
				"Amount owed is 12.0\n" +
				"You earned 3 frequent renter points";
		
		String statement = formtemplate.statement();
	
		assertEquals(expected, statement);
	}
	
	@Test
	public void printHtmlStatement(){
		FormTemplate formtemplate = new FormTemplate();
		String expected = "<H1>Rentals for <EM>Stefano</EM></H1><P>\n" +
				"Back to the future: 9.0<BR>\n" +
				"Save private Ryan: 3.0<BR>\n" +
				"<P>You owe <EM>12.0</EM><P>\n" +
				"On this rental you earned <EM>3</EM> frequent renter points<P>";
		
		String statement = formtemplate.htmlStatement();

		assertEquals(expected, statement);
	}

}
