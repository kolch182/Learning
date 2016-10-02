package ch.gmtech.ste.substitutemethod;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubstituteMethodTest {

	@Test
	public void foundPerson() {
		SubstituteMethod substitute = new SubstituteMethod();
		String[] person = new String[]{"Kent", "Ste", "ValentAno"};
		
		String foundPerson = substitute.foundPerson(person);
		
		assertEquals("Kent", foundPerson);
	}
	
	@Test
	public void foundPersonClearer() {
		SubstituteMethod substitute = new SubstituteMethod();
		String[] person = new String[]{"Kent", "Ste", "ValentAno"};
		
		String foundPerson = substitute.foundPersonClearer(person);
		
		assertEquals("Kent", foundPerson);
	}
	

}
