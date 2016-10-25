package ch.gmtech.ste.replaceconditionalwithpolymorphism;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void preRefactoring() {
		Engineer engineer = new Engineer();
		Salesman salesman = new Salesman();
		Manager manager = new Manager();
		
		int engineerAmount = engineer.payAmount();
		int salesmanAmount = salesman.payAmount();
		int managerAmount = manager.payAmount();
		
		assertEquals(4000, engineerAmount);
		assertEquals(4500, salesmanAmount);
		assertEquals(5000, managerAmount);
	}

}
