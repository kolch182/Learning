package ch.gmtech.ste.replacetypecodewithstate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void preRefactoring() {
		Employee engineer = new Employee(Employee.ENGINEER);
		Employee salesman = new Employee(Employee.SALESMAN);
		Employee manager = new Employee(Employee.MANAGER);
		
		int engineerAmount = engineer.payAmount();
		int salesmanAmount = salesman.payAmount();
		int managerAmount = manager.payAmount();
		
		assertEquals(4000, engineerAmount);
		assertEquals(4500, salesmanAmount);
		assertEquals(5000, managerAmount);
	}

}
