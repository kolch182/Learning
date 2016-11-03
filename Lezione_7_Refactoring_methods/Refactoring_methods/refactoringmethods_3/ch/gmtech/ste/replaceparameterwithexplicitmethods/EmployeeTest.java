package ch.gmtech.ste.replaceparameterwithexplicitmethods;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void test() {
		Engineer engineer = (Engineer) Employee.createEngineer();
		
		int type = engineer.getType();
		
		assertEquals(0, type);
	}

}
