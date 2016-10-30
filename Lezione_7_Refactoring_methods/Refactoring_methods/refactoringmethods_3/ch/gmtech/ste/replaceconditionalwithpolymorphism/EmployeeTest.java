package ch.gmtech.ste.replaceconditionalwithpolymorphism;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void payAmount() {
		Engineer engineer = new Engineer();
		Salesman salesman = new Salesman();
		Manager manager = new Manager();
		
		int engineerAmount = engineer.payAmount(new Employee(0));
		int salesmanAmount = salesman.payAmount(new Employee(1));
		int managerAmount = manager.payAmount(new Employee(2));
		
		assertEquals(4000, engineerAmount);
		assertEquals(4500, salesmanAmount);
		assertEquals(5000, managerAmount);
	}

}
