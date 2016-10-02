package ch.gmtech.ste.extractclass;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {

	@Test
	public void getOfficeAreaCode() {
		Person person = new Person();

		person.setOfficeAreaCode("A2");
		String officeAreaCode = person.getOfficeAreaCode();

		assertEquals("A2", officeAreaCode);
	}

	@Test
	public void getTelephoneNumber() throws Exception {
		Person person = new Person();

		person.setOfficeNumber("0836554561");
		String officeNumber = person.getOfficeNumber();

		assertEquals("0836554561", officeNumber);
	}
}
