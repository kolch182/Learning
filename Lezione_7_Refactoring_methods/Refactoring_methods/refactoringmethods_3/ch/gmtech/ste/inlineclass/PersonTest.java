package ch.gmtech.ste.inlineclass;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void getTelephoneNumber() {
		Person person = new Person();
		person.setAreaCode("A2");
		
		person.setNumber("0836554561");
		String officeNumber = person.getTelephoneNumber();

		assertEquals("(A2) 0836554561", officeNumber);
	}
}
