package ch.gmtech.ste.replacetypecodewithclass;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void getBloodGroup() {
		Person personGroupA = new Person(BloodGroup.A);
		Person personGroupB = new Person(BloodGroup.B);
		
		assertEquals(1, personGroupA.getBloodGroup().getCode());
		assertEquals(2, personGroupB.getBloodGroup().getCode());
	}

}
